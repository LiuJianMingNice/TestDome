package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.util.concurrent.locks.StampedLock;

import androidx.annotation.RequiresApi;

/**
 * ClassName:Point
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-20
 * @author:liujianming
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class Point {
    private final StampedLock stampedLock = new StampedLock();

    private  double x;
    private double y;

    public void remove(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();  //获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead(); //获得一个乐观读锁
        //注意下面两行代码不是原子操作
        //假设x,y = (100,,200)
        double currentX = x;
        //此处已读取到y,如果没有写入，读取是正确的
        //如果有写入,读取是错误的(100,400)
        double currentY = y;
        if (stampedLock.validate(stamp)) {  //检查乐观读锁后是否有其他写锁发生
            stamp = stampedLock.readLock();  //获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
