package utils;

import services.BaseService;

import java.util.Scanner;

public class MenuUtil {
    private final Scanner scanner;

    public MenuUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showOperationMenu(String title, BaseService service) {
        while (true) {
            System.out.println("=== " + title.toUpperCase() + " MENU ===");
            System.out.println("1.Create");
            System.out.println("2.Get by PIN");
            System.out.println("3.Get list");
            System.out.println("4.Update");
            System.out.println("5.Delete");
            System.out.println("6.Back");
            System.out.print("Choose an operation: ");

            int operationNumber = scanner.nextInt();

            switch (operationNumber) {
                case 1:
                    service.create();
                    break;
                case 2:
                    service.getByPin();
                    break;
                case 3:
                    service.getList();
                    break;
                case 4:
                    service.update();
                    break;
                case 5:
                    service.delete();
                    break;
                case 6:
                    return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    public void showServiceMenu(BaseService subjectService,
                                       BaseService teacherService,
                                       BaseService studentService) {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1.Subject Menu");
            System.out.println("2.Teacher Menu");
            System.out.println("3.Student Menu");
            System.out.println("4.Exit");
            System.out.print("Choose an menu: ");

            int serviceNumber = scanner.nextInt();

            switch (serviceNumber) {
                case 1:
                    showOperationMenu("Subject", subjectService);
                    break;
                case 2:
                    showOperationMenu("Teacher", teacherService);
                    break;
                case 3:
                    showOperationMenu("Student", studentService);
                    break;
                case 4:
                    System.out.println("Exit system");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
