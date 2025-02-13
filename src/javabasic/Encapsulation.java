package javabasic;

public class Encapsulation {

    public static void main(String[] args){

        Family family = new Family();
        family.setFirstName("Abhishek");
        String name = family.getFullName();
        System.out.println(name);

    }
}

class Family{
    private String firstName;
    private String lastName = "Chandra";

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
