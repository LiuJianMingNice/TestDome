package com.example.javaprogrammingideas.test;

/**
 * ClassName:PirvateOverride
 * Package:com.example.javaprogrammingideas.test
 * Description:
 *
 * @date:21-4-1 下午2:52
 * @author:liujianming
 */
public class PrivateOverride {
    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args){
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {
    public void f(){
        System.out.println("public f()");
    }


}
