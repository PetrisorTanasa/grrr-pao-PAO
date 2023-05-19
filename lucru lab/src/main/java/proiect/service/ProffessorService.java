package main.java.proiect.service;

import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.entity.person.Student;
import main.java.proiect.persistence.ProffessorRepository;
import main.java.proiect.persistence.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProffessorService {

    public List<Proffessor> proffessors;

    public Scanner scanner = new Scanner(System.in);

    public ProffessorRepository proffessorRepository = ProffessorRepository.getInstance();

    public void addProffessor() {
        proffessorRepository.save(this.readData());
    }

    public Proffessor readData(){
        System.out.println("Enter the proffessor's CNP: ");
        String cnp = scanner.nextLine();
        System.out.println("Enter the proffessor's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the proffessor's surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the proffessor's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the proffessor's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the proffessor's title: ");
        String title = scanner.nextLine();
        System.out.println("Enter the proffessor's department: ");
        String department = scanner.nextLine();
        Proffessor proffessor = new Proffessor(cnp, name, surname, address, phoneNumber, department, title);
        return proffessor;
    }
    public void updateProffessor(String cnp) {
        Proffessor proffessor = this.readData();
        proffessor.setCnp(cnp);
        proffessorRepository.update(proffessor);
    }

    public List<Proffessor> findAll(){
        return proffessorRepository.findAll();
    }

    public Optional<Proffessor> findByCnp(String cnp){
        return proffessorRepository.findByCnp(cnp);
    }

    public Proffessor findByName(String name){
        return proffessorRepository.findByName(name);
    }

    public void deleteProffessor(String cnp){
        proffessorRepository.deleteByCnp(cnp);
    }

    public List<Proffessor> getProffessorsByDepartment(){
        System.out.println("Getting proffessors by department: ");
        String department = scanner.nextLine();
        List<Proffessor> proffessorsByDepartment = proffessorRepository.findByDepartment(department);
        return proffessorsByDepartment;
    }
}
