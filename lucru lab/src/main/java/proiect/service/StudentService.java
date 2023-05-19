package main.java.proiect.service;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Student;
import main.java.proiect.persistence.StudentRepository;

import java.util.*;

public class StudentService {
    public List<Student> students;

    public Scanner scanner = new Scanner(System.in);

    public StudentRepository studentsRepository = StudentRepository.getInstance();
//
//    public StudentService(){
//        this.students = new ArrayList<>();
//    }
//    public void addStudent(Student student){
//        this.students.add(student);
//    }
//
//    public void removeStudent(Student student){
//        this.students.remove(student);
//    }

//    public void updateStudent(Student student){
//        for(Student s : this.students){
//            if(s.equals(student)){
//                s.setCnp(student.getCnp());
//                s.setName(student.getName());
//                s.setSurname(student.getSurname());
//                s.setAddress(student.getAddress());
//                s.setPhoneNumber(student.getPhoneNumber());
//                s.setYear(student.getYear());
//                s.setGroup(student.getGroup());
//                s.setSpecialization(student.getSpecialization());
//            }
//        }
//    }

//    public void getDummyStudents(){
//        this.students.add(new Student("1234567890123", "John", "Doe", "Strada X, nr. 1", "0722222222", 1, "123", "Informatica"));
//        this.students.add(new Student("1234567890123", "John", "Doe", "Strada X, nr. 1", "0722222222", 1, "123", "Informatica"));
//        this.students.add(new Student("1234567890124", "Xane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
//        this.students.add(new Student("1234567890135", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
//        this.students.add(new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
//        this.students.add(new Student("1234567890124", "Jane", "Doe", "Strada X, nr. 2", "0722222223", 1, "123", "Informatica"));
//    }
    public List<Student> getStudents(){
        return this.students;
    }

    public List<Student> getStudentsByYear(){
        System.out.println("Getting students by year: ");
        Integer year = scanner.nextInt();
        List<Student> studentsByYear = new ArrayList<>();
        for(Student s : studentsRepository.findByYear(year)){
            if(s.getYear() == year){
                studentsByYear.add(s);
            }
        }
        return studentsByYear;
    }
    public void saveStudent(){
        studentsRepository.save(this.readData());
    }

    public Student readData(){
        System.out.println("Enter the cnp: ");
        String cnp = scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the group: ");
        String group = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the year: ");
        Integer year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the specialization: ");
        String specialization = scanner.nextLine();



        Student student = new Student(cnp, name, surname, address, phoneNumber, year, group, specialization);
        return student;
    }

    public List<Student> findAll(){
        return studentsRepository.findAll();
    }
    public Student findByName(String name){
        return studentsRepository.findByName(name);
    }
    public Optional<Student> findById(String cnp){
        return studentsRepository.findById(cnp);
    }

    public void updateStudent(String cnp){
        Student updatedStudent = this.readData();
        updatedStudent.setCnp(cnp);
        studentsRepository.update(updatedStudent);
    }

    public void deleteStudent(String cnp){
        studentsRepository.deleteByCnp(cnp);
    }
}
