package com.example.liujianming.testdemo1.test.architect.generic;

public class TestGC {

    public static TestGC testGC;

    public void isAlive() {
        System.out.println("I am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        testGC = this;
    }

    public static void main(String[] args) throws Exception{
        testGC = new TestGC();
        testGC = null;
        System.gc();
        Thread.sleep(500);
        if (testGC != null) {
            testGC.isAlive();
        } else {
            System.out.println("no,I am dead :(");
        }

        //下面代码与上面完全一致，但是此次自救失败

        testGC = null;
        System.gc();
        Thread.sleep(500);

        if (testGC != null) {
            testGC.isAlive();
        } else {
            System.out.println("no,I am dead:(");
        }
    }
}
