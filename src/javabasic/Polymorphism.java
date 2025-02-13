package javabasic;

import java.lang.Override;

public class Polymorphism {

    public static void main(String[] args){
     Person person = new Father();
     person.role();
    }
}

class Person {
    void role(){
        System.out.println("I am Person....");
    }
}

class Father extends Person {
    @Override
    void role() {
        System.out.println("I am Father....");
    }
}
