package services;

import models.Student;
import models.Teacher;
import utils.FileUtil;

import java.util.List;
import java.util.Scanner;

public class StudentService implements BaseService {
    @Override
    public void create() {
        System.out.print("Enter the PIN: ");
        String pin = new Scanner(System.in).nextLine();

        List<Student> students = FileUtil.readObjectFromFile("students.obj");
        boolean exists = false;

        for (Student student : students) {
            if (pin.equals(student.getPin())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Student already exists with this PIN!");
            return;
        }

        System.out.print("Enter the first name: ");
        String firstName = new Scanner(System.in).nextLine();
        System.out.print("Enter the last name: ");
        String lastName = new Scanner(System.in).nextLine();
        System.out.print("Enter the GPA: ");
        double gpa = new Scanner(System.in).nextDouble();
        System.out.print("Enter the PIN of teacher: ");
        String pinOfTeacher = new Scanner(System.in).nextLine();

        List<Teacher> teachers = FileUtil.readObjectFromFile("teachers.obj");

        Teacher foundTeacher = null;

        for (Teacher teacher : teachers) {
            if (pinOfTeacher.equals(teacher.getPin())) {
                foundTeacher = teacher;
                break;
            }
        }

        Student newStudent = new Student();
        newStudent.setPin(pin).setFirstName(firstName).setLastName(lastName);
        newStudent.setGpa(gpa);

        if (foundTeacher != null) {
            newStudent.setTeacher(foundTeacher);
        } else {
            System.out.println("Teacher not found!");
        }

        students.add(newStudent);

        FileUtil.writeObjectToFile("students.obj", students);
        System.out.println("Student was added successfully!");
    }

    @Override
    public void getByPin() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();
        List<Student> students = FileUtil.readObjectFromFile("students.obj");

        Student foundStudent = null;

        for (Student student : students) {
            if (searchedPin.equals(student.getPin())) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found!");
        }
    }

    @Override
    public void getList() {
        List<Student> students = FileUtil.readObjectFromFile("students.obj");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void update() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();

        List<Student> students = FileUtil.readObjectFromFile("students.obj");
        boolean exists = false;

        for (Student student : students) {
            if (searchedPin.equals(student.getPin())) {
                exists = true;
                System.out.print("Which field do you want to change: ");
                String fieldName = new Scanner(System.in).nextLine();

                if (fieldName.equalsIgnoreCase("first name")) {
                    System.out.print("Enter the new first name: ");
                    String newFirstName = new Scanner(System.in).nextLine();
                    student.setFirstName(newFirstName);
                    FileUtil.writeObjectToFile("students.obj", students);
                    System.out.println("Subject was updated successfully!");
                } if (fieldName.equalsIgnoreCase("last name")) {
                    System.out.print("Enter the new first name: ");
                    String newLastName = new Scanner(System.in).nextLine();
                    student.setLastName(newLastName);
                    FileUtil.writeObjectToFile("students.obj", students);
                    System.out.println("Student was updated successfully!");
                } if (fieldName.equalsIgnoreCase("gpa")) {
                    System.out.print("Enter the new GPA: ");
                    double newGpa = new Scanner(System.in).nextDouble();
                    student.setGpa(newGpa);
                    FileUtil.writeObjectToFile("students.obj", students);
                    System.out.println("Student was updated successfully!");
                } else {
                    System.out.println("Invalid field name!");
                }
                break;
            }
        }

        if (!exists) {
            System.out.println("Student not found!");
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();

        List<Student> students = FileUtil.readObjectFromFile("students.obj");
        boolean removed = students.removeIf(student -> searchedPin.equals(student.getPin()));

        if (removed) {
            FileUtil.writeObjectToFile("students.obj", students);
            System.out.println("Student was deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}
