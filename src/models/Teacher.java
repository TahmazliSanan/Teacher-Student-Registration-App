package models;

import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pin;
    private String firstName;
    private String lastName;
    private List<Subject> subjects;

    public Teacher(String pin, String firstName, String lastName, List<Subject> subjects) {
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public String getPin() {
        return pin;
    }

    public Teacher setPin(String pin) {
        this.pin = pin;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Teacher setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Teacher setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Teacher setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    @Override
    public String toString() {
        return "PIN: " + pin + "\nFirst name: " + firstName + "\nLast name: " + lastName;
    }
}
