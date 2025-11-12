package Contact_Book;

import javax.swing.JOptionPane;

public class Person {

    // ! Main Private Variables
    private String name;
    private String number;
    private String address;

    // ! Default Constructor
    public Person() {
        this.name = "unknown";
        this.number = "0";
        this.address = "not set";
    }

    // ! Parameterized Constructor
    public Person(String n, String num, String adrs) {
        this.name = n;
        this.number = num;
        this.address = adrs;
    }

    // ? Getters
    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public String getAddress() {
        return this.address;
    }

    // ? Setters
    public void setName(String n) {
        this.name = n;
    }

    public void setNumber(String num) {
        this.number = num;
    }

    public void setAddress(String adrs) {
        this.address = adrs;
    }

    // ! Other Methods
    public void printPersonInfo() {
        System.out.println("Person Information");
        System.out.println(
                "[NAME] " + this.getName() + " [NUMBER] " + this.getNumber() + " [ADDRESS] " + this.getAddress());
    }

    public void printPersonInfoUI() {
        JOptionPane.showMessageDialog(null,
                "Name: " + this.getName() + "\nPhone: " + this.getNumber() + "\nAddress: " + this.getAddress());
    }
}
