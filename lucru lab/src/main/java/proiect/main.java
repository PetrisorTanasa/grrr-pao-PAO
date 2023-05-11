package main.java.proiect;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.entity.person.Student;
import main.java.proiect.entity.room.Amphitheater;
import main.java.proiect.entity.room.ClassRoom;
import main.java.proiect.persistence.FacultyRepository;
import main.java.proiect.service.StudentService;
import main.java.proiect.exceptions.CustomException;
import main.java.proiect.persistence.FacultyRepository;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class main {
    private final Scanner scanner = new Scanner(System.in);
    FacultyRepository facultyRepository = FacultyRepository.getInstance();
    public static void main(String[] args) {
        main main = new main();
        while (true) {
            main.showMenu();
            int option = main.readOption();
            main.execute(option);
        }
    }

    private void showMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("What section are you interested in?");
        System.out.println("1. Faculties");
        System.out.println("2. Students");
        System.out.println("3. Proffessors");
        System.out.println("4. Classrooms");
        System.out.println("5. Export logs");
        System.out.println("0. exit");
    }
    private int readOption() {
        int option = -1;
        do {
            try {
                option = readInt();
            } catch (CustomException exception) {
                System.out.println("Invalid option! Try again!");
            }
        } while (option < 0 || option > 5);
        return option;
    }

    private int readInt() throws CustomException {
        String line = scanner.next();
        if (line.matches("^\\d+$")) {
            return Integer.parseInt(line);
        } else {
            throw new CustomException("Invalid number");
        }
    }

    private void execute(int option) {
        switch (option) {
            case 1: {
                System.out.println("You have selected the faculties section. Choose your action:");
                System.out.println("1. Add a new faculty");
                System.out.println("2. List all faculties");
                System.out.println("3. Find faculty by name");
                System.out.println("4. Find faculty by id");
                System.out.println("5. Update faculty details");
                System.out.println("6. Delete faculty");
                System.out.println("7. See all faculties");
                System.out.println("0. exit");
                int optionSubmenu = readOption();
                switch (optionSubmenu){
                    case 1: {
                        FacultyRepository facultyRepository = FacultyRepository.getInstance();
                        System.out.println(facultyRepository.findAll());
                        System.out.println("ok");
                        System.out.println("Enter the name of the faculty: ");
                        String name = scanner.next();
                        System.out.println("Enter the id of the faculty: ");
                        int id = scanner.nextInt();
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

                        Faculty faculty = new Faculty(name, address,numberOfRooms,numberOfFloors,foundingYear,squareMetes,usefulSquareMeters, dean, secretary,numberOfDepartments,numberOfStudents, numberOfProffessors, numberOfLaboratoris, numberOfClassrooms, numberOfOffices,numberOfLibraries,numberOfCafeterias,numberOfAmphitheaters);
                        facultyRepository.save(faculty);
                        System.out.println("The faculty has been added successfully!");
                        break;
                    }
                    case 7: {

                        break;
                    }
                }
                break;
            }
            case 2: {
                // list all employees
                break;
            }
            case 3: {
                // find employee by cnp
                break;
            }
            case 4: {
                // update employee details
                break;
            }
            case 5: {
                // delete employee
                break;
            }

            case 0: {
                scanner.close();
                System.exit(0);
            }
        }
    }
}
