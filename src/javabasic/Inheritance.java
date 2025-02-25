package javabasic;

import java.lang.Override;

/** Inheritance is when a properties or methods of base class are passed on to a derived class.*/
public class Inheritance {

    public static void main(String[] args){
        Fish fish = new Fish();
        fish.eat();
    }
}

class Anima{
    void eat(){
        System.out.println("Animal Can Eat..");
    }

    void breath(){
        System.out.println("Animal Can Breath..");
    }
}

class Fish extends Anima{
    @Override
    void eat() {
        super.eat();
        System.out.println("Fish Can Eat..");
    }
}
