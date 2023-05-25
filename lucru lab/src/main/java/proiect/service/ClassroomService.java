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
//
//    public void getDummyClassrooms(){
//        this.classrooms.add(new ClassRoom(1, 1, "A"));
//        this.classrooms.add(new ClassRoom(2, 2, "A"));
//        this.classrooms.add(new ClassRoom(3, 3, "A"));
//        this.classrooms.add(new ClassRoom(4, 4, "A"));
//        this.classrooms.add(new ClassRoom(5, 5, "A"));
//        this.classrooms.add(new ClassRoom(6, 6, "A"));
//    }
//
//    public List<ClassRoom> getClassrooms(){
//        return this.classrooms;
//    }
//
//    public List<ClassRoom> getClassroomsByBuilding(){
//        System.out.println("Getting classrooms by building: ");
//        String building = scanner.nextLine();
//        List<ClassRoom> classroomsByBuilding = new ArrayList<>();
//        for(ClassRoom c : classroomRepository.findByBuilding(building)){
//            if(c.getBuilding().equals(building)){
//                classroomsByBuilding.add(c);
//            }
//        }
//        return classroomsByBuilding;
//    }
//
//    public List<ClassRoom> getClassroomsByCapacity(){
//        System.out.println("Getting classrooms by capacity: ");
//        Integer capacity = scanner.nextInt();
//        List<ClassRoom> classroomsByCapacity = new ArrayList<>();
//        for(ClassRoom c : classroomRepository.findByCapacity(capacity)){
//            if(c.getCapacity() == capacity){
//                classroomsByCapacity.add(c);
//            }
//        }
//        return classroomsByCapacity;
//    }
//
//    public List<ClassRoom> getClassroomsByNumber(){
//        System.out.println("Getting classrooms by number: ");
//        Integer number = scanner.nextInt();
//        List<ClassRoom> classroomsByNumber = new ArrayList<>();
//        for(ClassRoom c : classroomRepository.findByNumber(number)){
//            if(c.getNumber() == number){
//                classroomsByNumber.add(c);
//            }
//        }
//        return classroomsByNumber;
//    }
//
//    public List<ClassRoom> getClassroomsByBuildingAndCapacity(){
//        System.out.println("Getting classrooms by building and capacity: ");
//        String building = scanner.nextLine();
//        Integer capacity = scanner.nextInt();
//        List<ClassRoom> classroomsByBuildingAndCapacity = new ArrayList<>();
//        for(ClassRoom c : classroomRepository.findByBuildingAndCapacity(building, capacity)){
//            if(c.getBuilding().equals(building) && c.getCapacity() == capacity){
//                classroomsByBuildingAndCapacity.add(c);
//            }
//        }
//        return classroomsByBuildingAndCapacity;
//    }
}
