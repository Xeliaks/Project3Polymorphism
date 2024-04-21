package com.example.project3;

class Superclass {

    public void theMethod() {
        System.out.println("Method from Superclass");
    }
}


class Subclass extends Superclass {

    @Override
    public void theMethod() {
        System.out.println("Method from Subclass");
    }
}

public class Part11 {
    public static void main(String[] args) {

        Superclass a = new Subclass();


        a.theMethod();
    }
}

