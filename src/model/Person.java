package model;

public abstract class Person {
    private String name;               // private = encapsulation

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract String getDetails();   // child classes must implement this
}