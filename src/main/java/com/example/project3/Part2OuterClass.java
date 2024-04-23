package com.example.project3;

public class Part2OuterClass {

    public int outerVar = 10;


    public class InnerClass {
        public void display() {
            System.out.println("InnerClass: outerVar = " + outerVar);
        }
    }


    public void localClassExample() {
        int localVar = 100;

        class LocalClass {
            public void display() {
                System.out.println("LocalClass: localVar = " + localVar);
            }
        }

        LocalClass lc = new LocalClass();
        lc.display();
    }


    public void anonymousClassExample() {
        Runnable r = () -> System.out.println("AnonymousClass: outerVar = " + outerVar);

        Thread t = new Thread(r);
        t.start();
    }

    public static void main(String[] args) {

        Part2OuterClass outer = new Part2OuterClass();
        Part2OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        outer.localClassExample();
        outer.anonymousClassExample();
    }
}
