package services;

import models.Subject;
import models.Teacher;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements BaseService {
    @Override
    public void create() {
        System.out.print("Enter the PIN: ");
        String pin = new Scanner(System.in).nextLine();

        List<Teacher> teachers = FileUtil.readObjectFromFile("teachers.obj");
        boolean exists = false;

        for (Teacher teacher : teachers) {
            if (pin.equals(teacher.getPin())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Teacher already exists with this PIN!");
            return;
        }

        System.out.print("Enter the first name: ");
        String firstName = new Scanner(System.in).nextLine();
        System.out.print("Enter the last name: ");
        String lastName = new Scanner(System.in).nextLine();
        System.out.print("Enter the count of subjects: ");
        int countOfSubjects = new Scanner(System.in).nextInt();

        List<Subject> foundSubjects = FileUtil.readObjectFromFile("subjects.obj");
        List<Subject> subjectsOfTeacher = new ArrayList<>();
        String pinOfBook;

        for (int i = 0; i < countOfSubjects; i++) {
            System.out.print("Enter the " + (i + 1) + ".book's PIN: ");
            pinOfBook = new Scanner(System.in).nextLine();
            Subject foundSubject = null;

            for (Subject subject : foundSubjects) {
                if (pinOfBook.equals(subject.getPin())) {
                    foundSubject = subject;
                    break;
                }
            }

            if (foundSubject != null) {
                subjectsOfTeacher.add(foundSubject);
            } else {
                System.out.println("Subject not found!");
            }
        }

        Teacher newTeacher = new Teacher();
        newTeacher.setPin(pin).setFirstName(firstName).setLastName(lastName);
        newTeacher.setSubjects(subjectsOfTeacher);
        teachers.add(newTeacher);

        FileUtil.writeObjectToFile("teachers.obj", teachers);
        System.out.println("Teacher was added successfully!");
    }

    @Override
    public void getByPin() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();
        List<Teacher> teachers = FileUtil.readObjectFromFile("teachers.obj");

        Teacher foundTeacher = null;

        for (Teacher teacher : teachers) {
            if (searchedPin.equals(teacher.getPin())) {
                foundTeacher = teacher;
                break;
            }
        }

        if (foundTeacher != null) {
            System.out.println(foundTeacher);
        } else {
            System.out.println("Teacher not found!");
        }
    }

    @Override
    public void getList() {
        List<Teacher> teachers = FileUtil.readObjectFromFile("teachers.obj");

        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void update() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();

        List<Teacher> teachers = FileUtil.readObjectFromFile("teachers.obj");
        boolean exists = false;

        for (Teacher teacher : teachers) {
            if (searchedPin.equals(teacher.getPin())) {
                exists = true;
                System.out.print("Which field do you want to change: ");
                String fieldName = new Scanner(System.in).nextLine();

                if (fieldName.equalsIgnoreCase("first name")) {
                    System.out.print("Enter the new first name: ");
                    String newFirstName = new Scanner(System.in).nextLine();
                    teacher.setFirstName(newFirstName);
                    FileUtil.writeObjectToFile("teachers.obj", teachers);
                    System.out.println("Subject was updated successfully!");
                } if (fieldName.equalsIgnoreCase("last name")) {
                    System.out.print("Enter the new first name: ");
                    String newLastName = new Scanner(System.in).nextLine();
                    teacher.setLastName(newLastName);
                    FileUtil.writeObjectToFile("teachers.obj", teachers);
                    System.out.println("Teacher was updated successfully!");
                } else {
                    System.out.println("Invalid field name!");
                }
                break;
            }
        }

        if (!exists) {
            System.out.println("Subject not found!");
        }
    }

    @Override
    public void delete() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();

        List<Teacher> teachers = FileUtil.readObjectFromFile("teachers.obj");
        boolean removed = teachers.removeIf(subject -> searchedPin.equals(subject.getPin()));

        if (removed) {
            FileUtil.writeObjectToFile("teachers.obj", teachers);
            System.out.println("Teacher was deleted successfully!");
        } else {
            System.out.println("Teacher not found!");
        }
    }
}
