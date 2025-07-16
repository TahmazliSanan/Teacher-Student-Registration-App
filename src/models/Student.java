package models;

import abstracts.Person;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private double gpa;
    private Teacher teacher;

    public double getGpa() {
        return gpa;
    }

    public Student setGpa(double gpa) {
        this.gpa = gpa;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    @Override
    public String toString() {
        return "PIN: " + getPin() + "\n" +
                "First name: " + getFirstName() + "\n" +
                "Last name: " + getLastName() + "\n" +
                "GPA: " + gpa + "\n" +
                "Teacher: " + teacher.getFirstName() + " " + teacher.getLastName();
    }
}
