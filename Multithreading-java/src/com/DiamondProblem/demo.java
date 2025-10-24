package com.DiamondProblem;

//multiple inheritance using interfaces with default methods
interface A {
    default void greet() { System.out.println("Hello from A"); }
}
interface B {
    default void greet() { System.out.println("Hello from B"); }
}
class MyClass implements A, B {
    // resolved conflicts
    @Override
    public void greet() {
        A.super.greet(); // or B.super.greet()
        System.out.println("Hello from MyClass");
    }
}
public class demo {
    public static void main(String[] args) {
        new MyClass().greet();
    }
}
