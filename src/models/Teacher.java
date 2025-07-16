package models;

import abstracts.Person;

import java.io.Serializable;
import java.util.List;

public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Teacher setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    @Override
    public String toString() {
        return "PIN: " + getPin() + "\n" +
                "First name: " + getFirstName() + "\n" +
                "Last name: " + getLastName() + "\n" +
                "Subjects: " + subjects;
    }
}
