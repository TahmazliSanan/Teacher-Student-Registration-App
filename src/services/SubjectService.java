package services;

import models.Subject;
import utils.FileUtil;
import utils.MenuUtil;

import java.util.List;
import java.util.Scanner;

public class SubjectService extends MenuUtil implements BaseService {
    @Override
    public void showOperationMenu() {
        System.out.println("1.Add subject\n" +
                "2.Get subject\n" +
                "3.Get subject list\n" +
                "4.Update subject\n" +
                "5.Delete subject\n" +
                "6.Exit system");
        System.out.print("Select operation: ");
    }

    @Override
    public void create() {
        System.out.print("Enter the PIN: ");
        String pin = new Scanner(System.in).nextLine();

        List<Subject> subjects = FileUtil.readObjectFromFile("subjects.obj");
        boolean exists = false;

        for (Subject subject : subjects) {
            if (pin.equals(subject.getPin())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Subject already exists with this PIN!");
            return;
        }

        System.out.print("Enter the name: ");
        String name = new Scanner(System.in).nextLine();

        Subject newSubject = new Subject();
        newSubject.setPin(pin).setName(name);
        subjects.add(newSubject);

        FileUtil.writeObjectToFile("subjects.obj", subjects);
        System.out.println("Subject was added successfully!");
    }

    @Override
    public void getByPin() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();
        List<Subject> subjects = FileUtil.readObjectFromFile("subjects.obj");

        Subject foundSubject = null;

        for (Subject subject : subjects) {
            if (searchedPin.equals(subject.getPin())) {
                foundSubject = subject;
                break;
            }
        }

        if (foundSubject != null) {
            System.out.println(foundSubject);
        } else {
            System.out.println("Subject not found!");
        }
    }

    @Override
    public void getList() {
        List<Subject> subjects = FileUtil.readObjectFromFile("subjects.obj");

        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    @Override
    public void update() {
        System.out.print("Enter the PIN: ");
        String searchedPin = new Scanner(System.in).nextLine();

        List<Subject> subjects = FileUtil.readObjectFromFile("subjects.obj");
        boolean exists = false;

        for (Subject subject : subjects) {
            if (searchedPin.equals(subject.getPin())) {
                exists = true;
                System.out.print("Which field do you want to change: ");
                String fieldName = new Scanner(System.in).nextLine();

                if (fieldName.equalsIgnoreCase("name")) {
                    System.out.print("Enter the new name: ");
                    String newName = new Scanner(System.in).nextLine();
                    subject.setName(newName);
                    FileUtil.writeObjectToFile("subjects.obj", subjects);
                    System.out.println("Subject was updated successfully!");
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

        List<Subject> subjects = FileUtil.readObjectFromFile("subjects.obj");
        boolean removed = subjects.removeIf(subject -> searchedPin.equals(subject.getPin()));

        if (removed) {
            FileUtil.writeObjectToFile("subjects.obj", subjects);
            System.out.println("Subject was deleted successfully!");
        } else {
            System.out.println("Subject not found!");
        }
    }
}
