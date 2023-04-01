package main.java.proiect.entity.room;

public class Room {
    protected int number;
    protected int capacity;
    protected String type;

    public Room(int number, int capacity, String type) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
    }
    public Room() {
        this.number = 0;
        this.capacity = 0;
        this.type = "";
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Number: " + number + ", Capacity: " + capacity + ", Type: " + type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Room)) {
            return false;
        }
        Room room = (Room) obj;
        return room.number == this.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
