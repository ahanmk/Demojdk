package model;

public class Student extends Person {
    private int marks;

    public Student(String name, int marks) {
        super(name);                   // calls the parent constructor
        this.marks = marks;
    }

    public int getMarks() { return marks; }

    @Override
    public String getDetails() {       // polymorphism: overriding
        return getName() + " - Marks: " + marks;
    }
}