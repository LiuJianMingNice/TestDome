package com.example.liujianming.testdemo1.掘金demo.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    public ThreadUtils() {

    }

    //判断当前线程是否在主线程
    public static void checkIsOnMainThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    //执行不中断的线程
    public static void executeUninterrupttibly(ThreadUtils.BlockingOperation operation) {
        boolean wasInterrupted = false;

        while(true) {
            try {
                operation.run();
                break;
            } catch (InterruptedException e) {
                wasInterrupted = true;
            }
        }
        if (wasInterrupted) {
            Thread.currentThread().interrupt();
        }
    }

    //执行间隔时间内不中断的线程
    public static boolean joinUninterruptibly(Thread thread, long timeoutMs) {
        long startTimeMs = SystemClock.elapsedRealtime();
        long timeRemainingMs = timeoutMs;
        boolean wasInterrupted = false;

        while(timeRemainingMs > 0L) {
            try {
                thread.join(timeRemainingMs);
                break;
            } catch (InterruptedException e) {
                wasInterrupted = true;
                long elapsedTimeMs = SystemClock.elapsedRealtime() - startTimeMs;
                timeRemainingMs = timeoutMs - elapsedTimeMs;
            }
        }
        if (wasInterrupted) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static void joinUninterruptibly(final Thread thread) {
        executeUninterrupttibly(new BlockingOperation() {
            @Override
            public void run() throws InterruptedException {
                thread.join();
            }
        });
    }

    public static void awaitUniterruptibly(final CountDownLatch latch) {
        executeUninterrupttibly(new BlockingOperation() {
            @Override
            public void run() throws InterruptedException {
                latch.await();
            }
        });
    }

    public static boolean awaitUniterruptibly(CountDownLatch barrier, long timeoutMs) {
        long startTimeMs = SystemClock.elapsedRealtime();
        long timeRemainingMs = timeoutMs;
        boolean wasInterrupted = false;
        boolean result = false;

        while (true) {
            try {
                result = barrier.await(timeRemainingMs, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e) {
                wasInterrupted = true;
                long elapsedTimeMs = SystemClock.elapsedRealtime() - startTimeMs;
                timeRemainingMs = timeoutMs - elapsedTimeMs;
                if (timeRemainingMs <= 0L) {
                    break;
                }
            }
        }
        if (wasInterrupted) {
            Thread.currentThread().interrupt();
        }
        return result;
    }

    public static void waitUniterruptibly(final Object object) {
        executeUninterrupttibly(new BlockingOperation() {
            @Override
            public void run() throws InterruptedException {
                object.wait();
            }
        });
    }

    public static <V> V invokeAtFrontUniterruptibly(Handler handler, final Callable<V> c) {
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            try {
                return c.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            class Result {
                public V value;

                Result() {
                }
            }
            final Result result = new Result();

            class CauhtException {
                Exception e;

                CauhtException() {
                }
            }

            final CauhtException caughtException = new CauhtException();
            final CountDownLatch barrier = new CountDownLatch(1);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        result.value = c.call();
                    } catch (Exception e) {
                        caughtException.e = e;
                    }
                    barrier.countDown();
                }
            });
            awaitUniterruptibly(barrier);
            if (caughtException.e != null) {
                RuntimeException runtimeException = new RuntimeException(caughtException.e);
                runtimeException.setStackTrace(concatStackTraces(caughtException.e.getStackTrace(), runtimeException.getStackTrace()));
                throw runtimeException;
            } else {
                return result.value;
            }
        }
    }

    public static void invokeAtFrontUniterruptibly(Handler handler, final Runnable runnable) {
        invokeAtFrontUniterruptibly(handler, new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public static StackTraceElement[] concatStackTraces(StackTraceElement[] inner, StackTraceElement[] outer) {
        StackTraceElement[] combiend = new StackTraceElement[inner.length + outer.length];
        System.arraycopy(inner, 0, combiend, 0, inner.length);
        System.arraycopy(outer, 0, combiend, inner.length, outer.length);
        return combiend;
    }

    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    public static class ThreadChecker {
        private Thread thread = Thread.currentThread();

        public ThreadChecker() {
        }

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }

            if (Thread.currentThread() != this.thread) {
                throw new IllegalStateException("Wrong thread");
            }
        }
        public void detachThread() {
            this.thread = null;
        }
    }
}
