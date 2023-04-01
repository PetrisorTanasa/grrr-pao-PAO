package main.java.proiect.service;

import main.java.proiect.entity.person.Student;

public class StudentService {
    /*
    Define me dummy StudenetService class instances and make a getter for that information
     */
    public Student[] getStudents(){
        Student[] Students = new Student[5];

        Students[0] = new Student("1234567890123", "John", "Doe", "Strada X, nr. 1", "0722222222", 1, "123", "Informatica");
        Students[1] = new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica");
        Students[2] = new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica");
        Students[3] = new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica");
        Students[4] = new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica");

        return Students;
    }
}
