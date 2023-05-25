package main.java.proiect;

import main.java.proiect.entity.Audit;
import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.entity.person.Student;
import main.java.proiect.entity.room.Amphitheater;
import main.java.proiect.entity.room.ClassRoom;
import main.java.proiect.persistence.FacultyRepository;
import main.java.proiect.service.*;
import main.java.proiect.exceptions.CustomException;
import main.java.proiect.persistence.FacultyRepository;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class main {
    private final Scanner scanner = new Scanner(System.in);

    private final FacultyService facultyService = new FacultyService();

    private final StudentService studentService = new StudentService();

    private final ProffessorService proffessorService = new ProffessorService();

    private final AuditService auditService = AuditService.getInstance();

    private final ClassroomService classroomService= new ClassroomService();

    public String ACTION = "SYSTEM running";
    LocalDateTime timestamp = LocalDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws IOException {
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

    private void execute(int option) throws IOException {
        Audit audit = new Audit(ACTION, String.valueOf(System.currentTimeMillis()));
        auditService.save(audit);
        switch (option) {
            case 1: {
                this.ACTION = "Faculty - ";
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
                        this.ACTION += "Add a new faculty";
                        this.facultyService.saveFaculty();
                        System.out.println("The faculty has been added successfully!");
                        break;
                    }
                    case 2: {
                        this.ACTION += "List all faculties";
                        for(Faculty faculty : facultyService.findAll()){
                            System.out.println(faculty);
                        }
                        break;
                    }
                    case 3: {
                        this.ACTION += "Find faculty by name";
                        System.out.println(facultyService.findByName());
                        break;
                    }
                    case 4: {
                        this.ACTION += "Find faculty by id";
                        System.out.println(facultyService.findById());
                        break;
                    }
                    case 5: {
                        this.ACTION += "Update faculty details";
                        this.facultyService.updateFaculty();
                        System.out.println("The faculty has been updated successfully!");
                        break;
                    }
                    case 6: {
                        this.ACTION += "Delete faculty";
                        this.facultyService.deleteFaculty();
                        System.out.println("The faculty has been deleted successfully!");
                        break;
                    }
                }
                break;
            }
            case 2: {
                this.ACTION = "Student - ";
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
                        this.ACTION += "Add a new student";
                        this.studentService.saveStudent();
                        System.out.println("The student has been added successfully!");
                        break;
                    }
                    case 2: {
                        this.ACTION += "List all students";
                        for(Student student : studentService.findAll()){
                            System.out.println(student);
                        }
                        break;
                    }
                    case 3: {
                        this.ACTION += "Find student by name";
                        System.out.println("Enter the name of the student you want to find: ");
                        String name = scanner.next();
                        System.out.println(this.studentService.findByName(name));
                        break;
                    }
                    case 4: {
                        this.ACTION += "Find student by cnp";
                        System.out.println("Enter the cnp of the student you want to find: ");
                        String cnp = scanner.nextLine();
                        System.out.println(this.studentService.findById(cnp));
                        break;
                    }
                    case 5: {
                        this.ACTION += "Update student details";
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the student you want to update: ");
                        this.studentService.updateStudent(scanner.nextLine());
                        System.out.println("The student has been updated successfully!");
                        break;
                    }
                    case 6: {
                        this.ACTION += "Delete student";
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the student you want to delete: ");
                        String cnp = scanner.nextLine();
                        this.studentService.deleteStudent(cnp);
                        System.out.println("The student has been deleted successfully!");
                        break;
                    }
                    case 7: {
                        this.ACTION += "Get students by year";
                        System.out.println(studentService.getStudentsByYear());
                        break;
                    }
                }
                break;
            }
            case 3: {
                this.ACTION = "Proffessor - ";
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
                        this.ACTION += "Add a new proffessor";
                        this.proffessorService.addProffessor();
                        System.out.println("The proffessor has been added successfully!");
                        break;
                    }
                    case 2: {
                        this.ACTION += "List all proffessors";
                        for(Proffessor proffessor : proffessorService.findAll()){
                            System.out.println(proffessor);
                        }
                        break;
                    }
                    case 3: {
                        this.ACTION += "Find proffessor by name";
                        System.out.println("Enter the name of the proffessor you want to find: ");
                        String name = scanner.next();
                        System.out.println(this.proffessorService.findByName(name));
                        break;
                    }
                    case 4: {
                        this.ACTION += "Find proffessor by cnp";
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the proffessor you want to find: ");
                        String cnp = scanner.nextLine();
                        System.out.println(this.proffessorService.findByCnp(cnp));
                        break;
                    }
                    case 5: {
                        this.ACTION += "Update proffessor details";
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the proffessor you want to update: ");
                        this.proffessorService.updateProffessor(scanner.nextLine());
                        System.out.println("The proffessor has been updated successfully!");
                        break;
                    }
                    case 6: {
                        this.ACTION += "Delete proffessor";
                        scanner.nextLine();
                        System.out.println("Enter the cnp of the proffessor you want to delete: ");
                        String cnp = scanner.nextLine();
                        this.proffessorService.deleteProffessor(cnp);
                        System.out.println("The proffessor has been deleted successfully!");
                        break;
                    }
                    case 7: {
                        this.ACTION += "Get proffessors by department";
                        System.out.println(proffessorService.getProffessorsByDepartment());
                        break;
                    }

                }
                break;
            }
            case 4: {
                this.ACTION = "Classrooms - ";
                System.out.println("You have selected the classrooms section. Choose your action:");
                System.out.println("1. Add a new classroom");
                System.out.println("2. List all classrooms");
                System.out.println("3. Find classroom by id");
                System.out.println("4. Update classroom details");
                System.out.println("5. Delete classroom");
                System.out.println("6. Get classrooms by type");
                System.out.println("0. exit");
                int optionSubmenu = readOption();
                switch (optionSubmenu)  {
                    case 1: {
                        this.ACTION += "Add a new classroom";
                        this.classroomService.addClassroom();
                        System.out.println("The classroom has been added successfully!");
                        break;
                    }
                    case 2: {
                        this.ACTION += "List all classrooms";
                        for(ClassRoom classroom : classroomService.findAll()){
                            System.out.println(classroom);
                        }
                        break;
                    }
                    case 3: {
                        this.ACTION += "Find classroom by id";
                        System.out.println(this.classroomService.findByName());
                        break;
                    }
                    case 4: {
                        this.ACTION += "Update classroom details";
                        this.classroomService.updateClassroom();
                        System.out.println("The classroom has been updated successfully!");
                        break;
                    }
                    case 5: {
                        this.ACTION += "Delete classroom";
                        this.classroomService.deleteClassroom();
                        System.out.println("The classroom has been deleted successfully!");
                        break;
                    }
                    case 6: {
                        this.ACTION += "Get classrooms by type";
                        System.out.println(classroomService.findByType());
                        break;
                    }
                }
                break;
            }
            case 5: {
                this.ACTION = "Audit - wrote data to file";
                this.auditService.writeData();
                break;
            }

            case 0: {
                scanner.close();
                System.exit(0);
            }
        }
    }
}
