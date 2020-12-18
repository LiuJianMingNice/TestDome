package com.example.liujianming.testdemo1.test.architect.generic;

public class Test {

    public static void main(String[] args) {

//        //将泛型声明在接口上或声明在类上
//        Observable<Student> observable = new ImplObservable<Student>();
//        Student student = observable.call();
//
//        //将泛型声明在方法上
//        ImplObservable2 observable2 = new ImplObservable2();
//        Student student2 = observable2.call(new Student());

        Student student = new Student();

        System.out.println("创建好student:" + student);
        final Teacher teacher = new Teacher();

        System.out.println("创建好teacher: " + teacher);

        ImplObservable.create(student)
                .map(new Func1<Student, Teacher>() {
                    @Override
                    public Teacher call(Student student) {
                        System.out.println("student hashcode: " + student);
                        System.out.println("teacher hashcode: " + teacher);
                        return teacher;
                    }
                }).doOnNext(new Action<Teacher>() {
            @Override
            public void callAction(Teacher teacher) {
                System.out.println("teacher hashcode2: " + teacher);
            }
        });
    }
}
