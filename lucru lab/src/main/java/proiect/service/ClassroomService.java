package main.java.proiect.service;

import main.java.proiect.entity.room.ClassRoom;
import main.java.proiect.persistence.ClassRoomRepository;

import java.util.List;
import java.util.Scanner;

public class ClassroomService {
    public List<ClassRoom> classrooms;
    public Scanner scanner = new Scanner(System.in);

    public ClassRoomRepository classroomRepository = ClassRoomRepository.getInstance();

    public ClassroomService(){
    }
    public List<ClassRoom> findAll(){
        return classroomRepository.findAll();
    }

    public void addClassroom(){

        System.out.println("Insert classroom number: ");
        Integer number = scanner.nextInt();
        System.out.println("Insert classroom capacity: ");
        Integer capacity = scanner.nextInt();
        String typed = scanner.nextLine();
        System.out.println("Insert classroom type: ");
        String type = scanner.nextLine();
        System.out.println("Insert number of calculators: ");
        Integer numberOfCalculators = scanner.nextInt();
        System.out.println("Insert number of tables: ");
        Integer numberOfTables = scanner.nextInt();
        ClassRoom classrooms = new ClassRoom(number, capacity, type, numberOfCalculators, numberOfTables);
        this.classroomRepository.save(classrooms);
    }

    public void removeClassroom(ClassRoom classroom){
        System.out.println("Insert classroom number: ");
        Integer number = scanner.nextInt();
        this.classrooms.remove(number);
    }

    public void updateClassroom(){

        System.out.println("Insert classroom number: ");
        Integer number = scanner.nextInt();
        System.out.println("Insert classroom capacity: ");
        Integer capacity = scanner.nextInt();
        String typed = scanner.nextLine();
        System.out.println("Insert classroom type: ");
        String type = scanner.nextLine();
        System.out.println("Insert number of calculators: ");
        Integer numberOfCalculators = scanner.nextInt();
        System.out.println("Insert number of tables: ");
        Integer numberOfTables = scanner.nextInt();

        ClassRoom classrooms = new ClassRoom(number, capacity, type, numberOfCalculators, numberOfTables);
        this.classroomRepository.update(classrooms);
    }
    public void deleteClassroom(){
        System.out.println("Insert classroom number: ");
        Integer number = scanner.nextInt();
        this.classroomRepository.remove(number);
    }

    public List<ClassRoom> findByType() {
        String typed = scanner.nextLine();
        System.out.println("Insert classroom type: ");
        String type = scanner.nextLine();
        return classroomRepository.findByType(type);
    }

    public ClassRoom findByName(){
        System.out.println("Insert classroom number: ");
        String number = scanner.nextLine();
        System.out.println(number);
        return classroomRepository.findByName(number);
    }
}
