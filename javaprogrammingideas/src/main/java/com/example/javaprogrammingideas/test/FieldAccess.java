package com.example.javaprogrammingideas.test;

/**
 * ClassName:FieldAccess
 * Package:com.example.javaprogrammingideas.test
 * Description:
 *
 * @date:21-4-1 下午3:19
 * @author:liujianming
 */
class Super {
    public int field = 0;
    public int getField() {
        return field;
    }
}
class Sub extends Super {
    public int field = 1;
    public int getField() {
        return field;
    }
    public int getSuperField() {
        return super.field;
    }
}
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        //1 ,1
        System.out.println("sup.field = " + sup.field + "" +
                ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        //1,1,0
        System.out.println("sub.field = " + sub.field +
                ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());
    }
}
