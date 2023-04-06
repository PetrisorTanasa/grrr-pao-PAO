package main.java.proiect;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.entity.person.Student;
import main.java.proiect.entity.room.Amphitheater;
import main.java.proiect.entity.room.ClassRoom;
import main.java.proiect.service.StudentService;

import java.util.List;
import java.util.Vector;

public class main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.getDummyStudents();
        List<Student> students = studentService.getStudents();
        students.sort((o1, o2) -> o1.getCnp().compareTo(o2.getCnp()));
        for(Student i : students){
            System.out.println(i);
        }

        Proffessor proffessor= new Proffessor();
        proffessor.setCnp("1234567890123");
        proffessor.setName("John");
        proffessor.setSurname("Doe");
        proffessor.setAddress("Strada X, nr. 1");
        proffessor.setPhoneNumber("0722222222");
        proffessor.setDepartment("Informatica");
        proffessor.setTitle("Profesor");
        System.out.println(proffessor);

        Amphitheater amphitheater = new Amphitheater();
        amphitheater.setNumber(1);
        amphitheater.setCapacity(100);
        amphitheater.setNumberOfProjectors(2);
        amphitheater.setNumberOfChalkboards(20);
        amphitheater.setNumberOfSeats(20);
        amphitheater.setNumberOfOutlets(20);
        amphitheater.setType("Amfiteatru");
        System.out.println(amphitheater);

        Vector<ClassRoom> classRooms = new Vector<>();
        classRooms.add(new ClassRoom(1, 100, "classroom", 20, 20));
//        ClassRoom classRoom = new ClassRoom();
//        classRoom.setNumber(1);
//        classRoom.setCapacity(100);
//        classRoom.setNumberOfCalculators(2);
//        classRoom.setNumberOfTables(20);
//        classRoom.setType("classroom");
        System.out.println(classRooms.get(0));

        Faculty faculty = new Faculty();
        faculty.setNameOfDean("John Doe");
        faculty.setName("Informatica");
        faculty.setNameOfSecretary("Jane Doe");
        faculty.setNumberOfAmphitheaters(2);
        faculty.setNumberOfCafeterias(2);
        faculty.setAddress("Strada X, nr. 1");
        faculty.setNumberOfClassRooms(2);
        faculty.setNumberOfDepartments(2);
        faculty.setNumberOfLibraries(2);
        faculty.setNumberOfOffices(2);
        faculty.setNumberOfStudents(2);
        faculty.setNumberOfTeachers(2);
        faculty.setNumberOfLaboratories(2);
        faculty.setFoundingYear(2000);
        faculty.setNumberOfRooms(2);
        faculty.setNumberOfFloors(2);
        faculty.setUsefulSquareMeters(2000);
        faculty.setSquareMeters(2000);
        System.out.println(faculty);
    }
}
