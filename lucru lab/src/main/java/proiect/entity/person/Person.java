package main.java.proiect.entity.person;

public class Person {
    protected String cnp;
    protected String name;
    protected String surname;
    protected String address;
    protected String phoneNumber;

    public Person(String cnp, String name, String surname, String address, String phoneNumber) {
        this.cnp = cnp;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Person(){
        this.cnp = "";
        this.name = "";
        this.surname = "";
        this.address = "";
        this.phoneNumber = "";
    }

    public String getCnp() {
        return cnp;
    }
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "CNP: " + cnp + ", Name: " + name + ", Surname: " + surname + ", Address: " + address + ", Phone number: " + phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return person.cnp.equals(cnp);
    }

    @Override
    public int hashCode() {
        return cnp.hashCode();
    }
}
