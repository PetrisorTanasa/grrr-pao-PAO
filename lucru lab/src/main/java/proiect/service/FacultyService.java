package main.java.proiect.service;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.persistence.FacultyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FacultyService {

    private final FacultyRepository facultyRepository = FacultyRepository.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    public void saveFaculty(){
        System.out.println(facultyRepository.findAll());
        Faculty faculty = this.readData();
        facultyRepository.save(faculty);
    }
    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }

    public Faculty findByName(){
        System.out.println("Enter the name of the faculty: ");
        String name = scanner.next();
        return facultyRepository.findByName(name);
    }

    public Faculty findById(){
        System.out.println("Enter the id of the faculty: ");
        int id = scanner.nextInt();
        return facultyRepository.findByIdInt(id);
    }

    public Faculty updateFaculty(){
        Faculty faculty = this.readData();
        facultyRepository.update(faculty);
        return faculty;
    }

    public Faculty deleteFaculty(){
        System.out.println("Enter the id of the faculty you want to delete: ");
        int id = scanner.nextInt();
        Faculty faculty = facultyRepository.findByIdInt(id);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Faculty readData(){
        System.out.println("Enter the id of the faculty: ");
        int id = scanner.nextInt();
        System.out.println("Enter the name of the faculty: ");
        String name = scanner.next();
        System.out.println("Enter the address of the faculty: ");
        String address = scanner.next();
        System.out.println("Enter the dean of the faculty: ");
        String dean = scanner.next();
        System.out.println("Enter the number of students of the faculty: ");
        int numberOfStudents = scanner.nextInt();
        System.out.println("Enter the number of proffessors of the faculty: ");
        int numberOfProffessors = scanner.nextInt();
        System.out.println("Enter the number of classrooms of the faculty: ");
        int numberOfClassrooms = scanner.nextInt();
        System.out.println("Enter the number of amphitheaters of the faculty: ");
        int numberOfAmphitheaters = scanner.nextInt();
        System.out.println("Enter the number of offices of the faculty: ");
        int numberOfOffices = scanner.nextInt();
        System.out.println("Enter the number of laboratories of the faculty: ");
        int numberOfLaboratoris = scanner.nextInt();
        System.out.println("Enter the number of libraries of the faculty: ");
        int numberOfLibraries = scanner.nextInt();
        System.out.println("Enter the number of cafeterias of the faculty: ");
        int numberOfCafeterias = scanner.nextInt();
        System.out.println("Enter the number of rooms of the faculty: ");
        int numberOfRooms = scanner.nextInt();
        System.out.println("Enter the number of floors of the faculty: ");
        int numberOfFloors = scanner.nextInt();
        System.out.println("Enter the founding year of the faculty: ");
        int foundingYear = scanner.nextInt();
        System.out.println("Enter the square meters of the faculty: ");
        int squareMetes = scanner.nextInt();
        System.out.println("Enter the useful square meters of the faculty: ");
        int usefulSquareMeters = scanner.nextInt();
        System.out.println("Enter the secretary of the faculty: ");
        String secretary = scanner.next();
        System.out.println("Enter the number of departments of the faculty: ");
        int numberOfDepartments = scanner.nextInt();

        Faculty faculty = new Faculty(id, name, address,numberOfRooms,numberOfFloors,foundingYear,squareMetes,usefulSquareMeters, dean, secretary,numberOfDepartments,numberOfStudents, numberOfProffessors, numberOfLaboratoris, numberOfClassrooms, numberOfOffices,numberOfLibraries,numberOfCafeterias,numberOfAmphitheaters);
        return faculty;
    }
}
