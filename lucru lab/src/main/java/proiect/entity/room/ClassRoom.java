package main.java.proiect.entity.room;

public class ClassRoom extends Room {
    private int numberOfCalculators;
    private int numberOfTables;

    public ClassRoom(int number, int capacity, String type, int numberOfCalculators, int numberOfTables) {
        super(number, capacity, type);
        this.numberOfCalculators = numberOfCalculators;
        this.numberOfTables = numberOfTables;
    }

    public ClassRoom() {
        super();
        this.numberOfCalculators = 0;
        this.numberOfTables = 0;
    }

    public int getNumberOfCalculators() {
        return numberOfCalculators;
    }
    public void setNumberOfCalculators(int numberOfCalculators) {
        this.numberOfCalculators = numberOfCalculators;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }
    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public String toString() {
        return super.toString() + ", Number of calculators: " + numberOfCalculators + ", Number of tables: " + numberOfTables;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ClassRoom) {
            ClassRoom classRoom = (ClassRoom) obj;
            return super.equals(classRoom) && numberOfCalculators == classRoom.numberOfCalculators && numberOfTables == classRoom.numberOfTables;
        }
        return false;
    }
}
