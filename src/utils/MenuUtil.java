package utils;

public abstract class MenuUtil {
    public abstract void showOperationMenu();

    public static void showServiceMenu() {
        System.out.println("1.Teacher\n" +
                "2.Student\n" +
                "3.Subject");
    }
}
