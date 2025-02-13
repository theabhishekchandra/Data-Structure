package javabasic;

public class Override {
/** Override method Chilled can assess and override the parent class function.
 * </p>
 * If you want to use parent function in chilled class, they should need to use super method.
 * */
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.eat();
        dog.move();
        dog.bark();
    }
}


class Animal{

    void eat(){
        System.out.println("Animal can Eat");
    }

    void move(){
        System.out.println("Animal can Move");
    }
}

/** Dog Class inherit Animal Parent class property's.*/

class Dog extends Animal{

    @java.lang.Override
    void move() {
        System.out.println("Dog is Moving.");
    }

    void bark(){
        System.out.println("Dog is barking.");
    }
}