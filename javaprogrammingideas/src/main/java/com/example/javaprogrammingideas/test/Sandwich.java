package com.example.javaprogrammingideas.test;

/**
 * ClassName:Sandwich
 * Package:com.example.javaprogrammingideas.test
 * Description:
 *
 * @date:21-4-1 下午3:58
 * @author:liujianming
 */
class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    Lunch(){
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch(){
        System.out.println("PortableLunch()");
    }
}
public class Sandwich extends PortableLunch{
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();
    public Sandwich() {
        System.out.println("Sandwich()");
    }
    public static void main(String[] args) {
        new Sandwich();
    }
}
