package com.example.project3;

import java.util.ArrayList;


abstract class Animal {

    public abstract void makeSound();
}


class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}


class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}


class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Moo");
    }
}


class Pig extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Oink");
    }
}

public class Part12 {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();


        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());
        animals.add(new Pig());


        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}


