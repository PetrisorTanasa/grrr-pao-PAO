package main.java.proiect.entity;

public class Audit {

    public Audit(String action, String timestamp) {
        this.action = action;
        this.timestamp = timestamp;
    }

    private String action;
    private String timestamp;

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
