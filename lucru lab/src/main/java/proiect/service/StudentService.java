package main.java.proiect.service;

import main.java.proiect.entity.person.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
    public List<Student> students;

    public StudentService(){
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student){
        this.students.add(student);
    }

    public void getDummyStudents(){
        this.students.add(new Student("1234567890123", "John", "Doe", "Strada X, nr. 1", "0722222222", 1, "123", "Informatica"));
        this.students.add(new Student("1234567890123", "John", "Doe", "Strada X, nr. 1", "0722222222", 1, "123", "Informatica"));
        this.students.add(new Student("1234567890124", "Xane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
        this.students.add(new Student("1234567890135", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
        this.students.add(new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
        this.students.add(new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
    }
    public List<Student> getStudents(){
        return this.students;
    }
}
