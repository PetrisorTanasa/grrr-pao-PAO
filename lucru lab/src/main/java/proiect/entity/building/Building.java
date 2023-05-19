package main.java.proiect.entity.building;

public class Building {
    private String name;
    private String address;
    private int numberOfRooms;
    private int numberOfFloors;
    private int foundingYear;
    private int squareMeters;
    private int usefulSquareMeters;
    private int id;

    public Building(String name, String address, int numberOfRooms, int numberOfFloors, int foundingYear, int squareMeters, int usefulSquareMeters, int id) {
        this.name = name;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.numberOfFloors = numberOfFloors;
        this.foundingYear = foundingYear;
        this.squareMeters = squareMeters;
        this.usefulSquareMeters = usefulSquareMeters;
        this.id = id;
    }
    public Building(){
        this.name = "";
        this.address = "";
        this.numberOfRooms = 0;
        this.numberOfFloors = 0;
        this.foundingYear = 0;
        this.squareMeters = 0;
        this.usefulSquareMeters = 0;
        this.id = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getFoundingYear() {
        return foundingYear;
    }
    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public int getSquareMeters() {
        return squareMeters;
    }
    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getUsefulSquareMeters() {
        return usefulSquareMeters;
    }
    public void setUsefulSquareMeters(int usefulSquareMeters) {
        this.usefulSquareMeters = usefulSquareMeters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Address: " + address + ", Number of rooms: " + numberOfRooms + ", Number of floors: " + numberOfFloors + ", Founding year: " + foundingYear + ", Square meters: " + squareMeters + ", Useful square meters: " + usefulSquareMeters;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Building) {
            Building building = (Building) obj;
            return name.equals(building.name) && address.equals(building.address) && numberOfRooms == building.numberOfRooms && numberOfFloors == building.numberOfFloors && foundingYear == building.foundingYear && squareMeters == building.squareMeters && usefulSquareMeters == building.usefulSquareMeters;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (address == null ? 0 : address.hashCode());
        hash = 31 * hash + numberOfRooms;
        hash = 31 * hash + numberOfFloors;
        hash = 31 * hash + foundingYear;
        hash = 31 * hash + squareMeters;
        hash = 31 * hash + usefulSquareMeters;
        return hash;
    }
}
