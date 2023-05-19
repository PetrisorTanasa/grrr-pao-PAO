package main.java.proiect.entity.building;

public class Faculty extends Building{
    private String nameOfDean;
    private String nameOfSecretary;
    private int numberOfDepartments;
    private int numberOfStudents;
    private int numberOfTeachers;
    private int numberOfLaboratories;
    private int numberOfClassRooms;
    private int numberOfOffices;
    private int numberOfLibraries;
    private int numberOfCafeterias;
    private int numberOfAmphitheaters;

    public Faculty(Integer id, String name, String address, int numberOfRooms, int numberOfFloors, int foundingYear, int squareMeters, int usefulSquareMeters, String nameOfDean, String nameOfSecretary, int numberOfDepartments, int numberOfStudents, int numberOfTeachers, int numberOfLaboratories, int numberOfClassRooms, int numberOfOffices, int numberOfLibraries, int numberOfCafeterias, int numberOfAmphitheaters) {
        super(name, address, numberOfRooms, numberOfFloors, foundingYear, squareMeters, usefulSquareMeters,id);
        this.nameOfDean = nameOfDean;
        this.nameOfSecretary = nameOfSecretary;
        this.numberOfDepartments = numberOfDepartments;
        this.numberOfStudents = numberOfStudents;
        this.numberOfTeachers = numberOfTeachers;
        this.numberOfLaboratories = numberOfLaboratories;
        this.numberOfClassRooms = numberOfClassRooms;
        this.numberOfOffices = numberOfOffices;
        this.numberOfLibraries = numberOfLibraries;
        this.numberOfCafeterias = numberOfCafeterias;
        this.numberOfAmphitheaters = numberOfAmphitheaters;
    }

    public Faculty(){
        super();
        this.nameOfDean = "";
        this.nameOfSecretary = "";
        this.numberOfDepartments = 0;
        this.numberOfStudents = 0;
        this.numberOfTeachers = 0;
        this.numberOfLaboratories = 0;
        this.numberOfClassRooms = 0;
        this.numberOfOffices = 0;
        this.numberOfLibraries = 0;
        this.numberOfCafeterias = 0;
        this.numberOfAmphitheaters = 0;
    }

    public String getNameOfDean() {
        return nameOfDean;
    }
    public void setNameOfDean(String nameOfDean) {
        this.nameOfDean = nameOfDean;
    }

    public String getNameOfSecretary() {
        return nameOfSecretary;
    }
    public void setNameOfSecretary(String nameOfSecretary) {
        this.nameOfSecretary = nameOfSecretary;
    }

    public int getNumberOfDepartments() {
        return numberOfDepartments;
    }
    public void setNumberOfDepartments(int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }
    public void setNumberOfTeachers(int numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }

    public int getNumberOfLaboratories() {
        return numberOfLaboratories;
    }
    public void setNumberOfLaboratories(int numberOfLaboratories) {
        this.numberOfLaboratories = numberOfLaboratories;
    }

    public int getNumberOfClassRooms() {
        return numberOfClassRooms;
    }
    public void setNumberOfClassRooms(int numberOfClassRooms) {
        this.numberOfClassRooms = numberOfClassRooms;
    }

    public int getNumberOfOffices() {
        return numberOfOffices;
    }
    public void setNumberOfOffices(int numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public int getNumberOfLibraries() {
        return numberOfLibraries;
    }
    public void setNumberOfLibraries(int numberOfLibraries) {
        this.numberOfLibraries = numberOfLibraries;
    }

    public int getNumberOfCafeterias() {
        return numberOfCafeterias;
    }
    public void setNumberOfCafeterias(int numberOfCafeterias) {
        this.numberOfCafeterias = numberOfCafeterias;
    }

    public int getNumberOfAmphitheaters() {
        return numberOfAmphitheaters;
    }
    public void setNumberOfAmphitheaters(int numberOfAmphitheaters) {
        this.numberOfAmphitheaters = numberOfAmphitheaters;
    }

    @Override
    public String toString() {
        return super.toString() + ", NameOfDean: " + nameOfDean + ", NameOfSecretary: " + nameOfSecretary + ", NumberOfDepartments: " + numberOfDepartments + ", NumberOfStudents: " + numberOfStudents + ", NumberOfTeachers: " + numberOfTeachers + ", NumberOfLaboratories: " + numberOfLaboratories + ", NumberOfClassRooms: " + numberOfClassRooms + ", NumberOfOffices: " + numberOfOffices + ", NumberOfLibraries: " + numberOfLibraries + ", NumberOfCafeterias: " + numberOfCafeterias + ", NumberOfAmphitheaters: " + numberOfAmphitheaters + ", " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Faculty) {
            Faculty faculty = (Faculty) obj;
            return super.equals(faculty) && nameOfDean.equals(faculty.nameOfDean) && nameOfSecretary.equals(faculty.nameOfSecretary) && numberOfDepartments == faculty.numberOfDepartments && numberOfStudents == faculty.numberOfStudents && numberOfTeachers == faculty.numberOfTeachers && numberOfLaboratories == faculty.numberOfLaboratories && numberOfClassRooms == faculty.numberOfClassRooms && numberOfOffices == faculty.numberOfOffices && numberOfLibraries == faculty.numberOfLibraries && numberOfCafeterias == faculty.numberOfCafeterias && numberOfAmphitheaters == faculty.numberOfAmphitheaters;
        }
        return false;
    }
}
