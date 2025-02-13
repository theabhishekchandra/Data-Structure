package javabasic;

import java.lang.Override;

public class Abstraction {
    public static void main(String[] args){
        TV tv = new TV();
        tv.cellIsInserted();
//        tv.turnOn();

    }
}
abstract class Button{
    abstract void turnOn();
    abstract void turnOff();
    void cellIsInserted(){
        System.out.println("Cell is Inserted.");
        turnOff();
    }
}

class TV extends Button{

    @Override
    void turnOn() {
        System.out.println("TV Turn On...");
    }

    @Override
    void turnOff() {
        System.out.println(" TV turn Off...");
    }

    @Override
    void cellIsInserted() {
        super.cellIsInserted();
    }
}
