package basic;

public class Calculator {
    private int first;
    private int second;

    Calculator(){

    }
    Calculator(int first , int second){
        this.first = first;
        this.second = second;
    }

    int sum(){
        return first +second;
    }

    int subtract(){
        return first - second;
    }

    int multi(){
        return first * second;
    }
    int divide(){
        return first/ second;
    }


}
