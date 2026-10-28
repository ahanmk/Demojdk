package service;

import model.Student;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public ArrayList<Student> getAll() {
        return students;
    }
}