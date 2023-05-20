package main.java.proiect.service;

import main.java.proiect.entity.room.ClassRoom;

import java.util.List;
import java.util.Scanner;

public class ClassroomService {
    public List<ClassRoom> classrooms;
    public Scanner scanner = new Scanner(System.in);

    public ClassroomRepository classroomRepository = ClassroomRepository.getInstance();

    public ClassroomService(){
    }

    public void addClassroom(ClassRoom classroom){
        this.classrooms.add(classroom);
    }

    public void removeClassroom(ClassRoom classroom){
        this.classrooms.remove(classroom);
    }

    public void updateClassroom(ClassRoom classroom){
        for(ClassRoom c : this.classrooms){
            if(c.equals(classroom)){
                c.setNumber(classroom.getNumber());
                c.setCapacity(classroom.getCapacity());
                c.setBuilding(classroom.getBuilding());
            }
        }
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
