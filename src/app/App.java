package app;

import services.BaseService;
import services.StudentService;
import services.SubjectService;
import services.TeacherService;
import utils.MenuUtil;

import java.util.Scanner;

public class App {
    private static final BaseService subjectService = new SubjectService();
    private static final BaseService teacherService = new TeacherService();
    private static final BaseService studentService = new StudentService();

    public static void main(String[] args) {
        MenuUtil menuUtil = new MenuUtil(new Scanner(System.in));
        menuUtil.showServiceMenu(subjectService, teacherService, studentService);
    }
}
