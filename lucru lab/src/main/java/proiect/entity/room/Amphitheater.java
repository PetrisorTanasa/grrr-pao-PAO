package main.java.proiect.entity.room;

public class Amphitheater extends Room {
    private int numberOfSeats;
    private int numberOfChalkboards;
    private int numberOfProjectors;
    private int numberOfOutlets;

    public Amphitheater(int number, int capacity, String type, int numberOfSeats, int numberOfChalkboards, int numberOfProjectors, int numberOfOutlets) {
        super(number, capacity, type);
        this.numberOfSeats = numberOfSeats;
        this.numberOfChalkboards = numberOfChalkboards;
        this.numberOfProjectors = numberOfProjectors;
        this.numberOfOutlets = numberOfOutlets;
    }

    public Amphitheater() {
        super();
        this.numberOfSeats = 0;
        this.numberOfChalkboards = 0;
        this.numberOfProjectors = 0;
        this.numberOfOutlets = 0;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfChalkboards() {
        return numberOfChalkboards;
    }
    public void setNumberOfChalkboards(int numberOfChalkboards) {
        this.numberOfChalkboards = numberOfChalkboards;
    }

    public int getNumberOfProjectors() {
        return numberOfProjectors;
    }
    public void setNumberOfProjectors(int numberOfProjectors) {
        this.numberOfProjectors = numberOfProjectors;
    }

    public int getNumberOfOutlets() {
        return numberOfOutlets;
    }
    public void setNumberOfOutlets(int numberOfOutlets) {
        this.numberOfOutlets = numberOfOutlets;
    }

    public String toString() {
        return super.toString() + ", Number of seats: " + numberOfSeats + ", Number of chalkboards: " + numberOfChalkboards + ", Number of projectors: " + numberOfProjectors + ", Number of outlets: " + numberOfOutlets;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Amphitheater) {
            Amphitheater amphitheater = (Amphitheater) obj;
            return super.equals(amphitheater) && numberOfSeats == amphitheater.numberOfSeats && numberOfChalkboards == amphitheater.numberOfChalkboards && numberOfProjectors == amphitheater.numberOfProjectors && numberOfOutlets == amphitheater.numberOfOutlets;
        }
        return false;
    }
}
