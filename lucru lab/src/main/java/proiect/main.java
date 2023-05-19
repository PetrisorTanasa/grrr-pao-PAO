package main.java.proiect;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.entity.person.Student;
import main.java.proiect.entity.room.Amphitheater;
import main.java.proiect.entity.room.ClassRoom;
import main.java.proiect.persistence.FacultyRepository;
import main.java.proiect.service.FacultyService;
import main.java.proiect.service.ProffessorService;
import main.java.proiect.service.StudentService;
import main.java.proiect.exceptions.CustomException;
import main.java.proiect.persistence.FacultyRepository;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class main {
    private final Scanner scanner = new Scanner(System.in);

    private final FacultyService facultyService = new FacultyService();

    private final StudentService studentService = new StudentService();

    private final ProffessorService proffessorService = new ProffessorService();
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
        } while (option < 0 || option > 8);
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
                System.out.println("0. exit");
                int optionSubmenu = readOption();
                switch (optionSubmenu){
                    case 1: {
                        this.facultyService.saveFaculty();
                        System.out.println("The faculty has been added successfully!");
                        break;
                    }
                    case 2: {
                        for(Faculty faculty : facultyService.findAll()){
                            System.out.println(faculty);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println(facultyService.findByName());
                        break;
                    }
                    case 4: {
                        System.out.println(facultyService.findById());
                        break;
                    }
                    case 5: {
                        this.facultyService.updateFaculty();
                        System.out.println("The faculty has been updated successfully!");
                        break;
                    }
                    case 6: {
                        this.facultyService.deleteFaculty();
                        System.out.println("The faculty has been deleted successfully!");
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("You have selected the students section. Choose your action:");
                System.out.println("1. Add a new student");
                System.out.println("2. List all students");
                System.out.println("3. Find student by name");
                System.out.println("4. Find student by cnp");
                System.out.println("5. Update student details");
                System.out.println("6. Delete student");
                System.out.println("7. Get students by year");
                System.out.println("0. exit");
                int optionSubmenu = readOption();
                switch (optionSubmenu){
                    case 1: {
                        this.studentService.saveStudent();
                        System.out.println("The student has been added successfully!");
                        break;
                    }
                    case 2: {
                        for(Student student : studentService.findAll()){
                            System.out.println(student);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the name of the student you want to find: ");
                        String name = scanner.next();
                        System.out.println(this.studentService.findByName(name));
                        break;
                    }
                    case 4: {
                        System.out.println("Enter the cnp of the student you want to find: ");
                        String cnp = scanner.nextLine();
                        System.out.println(this.studentService.findById(cnp));
                        break;
                    }
                    case 5: {
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the student you want to update: ");
                        this.studentService.updateStudent(scanner.nextLine());
                        System.out.println("The student has been updated successfully!");
                        break;
                    }
                    case 6: {
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the student you want to delete: ");
                        String cnp = scanner.nextLine();
                        this.studentService.deleteStudent(cnp);
                        System.out.println("The student has been deleted successfully!");
                        break;
                    }
                    case 7: {
                        System.out.println(studentService.getStudentsByYear());
                        break;
                    }
                }
                break;
            }
            case 3: {
                System.out.println("You have selected the students section. Choose your action:");
                System.out.println("1. Add a new proffessor");
                System.out.println("2. List all proffessors");
                System.out.println("3. Find proffessor by name");
                System.out.println("4. Find proffessor by cnp");
                System.out.println("5. Update proffessor details");
                System.out.println("6. Delete proffessor");
                System.out.println("7. Get proffessors by department");
                System.out.println("0. exit");
                int optionSubmenu = readOption();
                switch (optionSubmenu){
                    case 1:{
                        this.proffessorService.addProffessor();
                        System.out.println("The proffessor has been added successfully!");
                        break;
                    }
                    case 2: {
                        for(Proffessor proffessor : proffessorService.findAll()){
                            System.out.println(proffessor);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the name of the proffessor you want to find: ");
                        String name = scanner.next();
                        System.out.println(this.proffessorService.findByName(name));
                        break;
                    }
                    case 4: {
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the proffessor you want to find: ");
                        String cnp = scanner.nextLine();
                        System.out.println(this.proffessorService.findByCnp(cnp));
                        break;
                    }
                    case 5: {
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the proffessor you want to update: ");
                        this.proffessorService.updateProffessor(scanner.nextLine());
                        System.out.println("The proffessor has been updated successfully!");
                        break;
                    }
                    case 6: {
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the proffessor you want to delete: ");
                        String cnp = scanner.nextLine();
                        this.proffessorService.deleteProffessor(cnp);
                        System.out.println("The proffessor has been deleted successfully!");
                        break;
                    }
                    case 7: {
                        System.out.println(proffessorService.getProffessorsByDepartment());
                        break;
                    }

                }
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
