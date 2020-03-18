package com.company.anhkv;

import com.company.anhkv.service.ClazzService;
import com.company.anhkv.service.StudentService;

import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ClazzService clazzService = new ClazzService();
        StudentService studentService = new StudentService();
        studentService.setClazzService(clazzService);
        showMenu();
        String choice;
        while (true) {
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    clazzService.addClazz();
                    showMenu();
                    break;
                case "2":
                    studentService.addStudent();
                    showMenu();
                    break;
                case "3":
                    clazzService.editClazz();
                    showMenu();
                    break;
                case "4":
                    studentService.editStudent();
                    showMenu();
                    break;
                case "5":
                    clazzService.deleteClazz();
                    showMenu();
                    break;
                case "6":
                    studentService.deleteStudent();
                    showMenu();
                    break;
                case "7":
                    clazzService.showAllClass();
                    showMenu();
                    break;
                case "8":
                    studentService.showAllStudents();
                    showMenu();
                    break;
                default:
                    if(choice.equals("0")) {
                        break;
                    }
                    System.out.println("Vui lòng chọn lại: ");
                    showMenu();
                    break;
            }
            if(choice.equals("0")) {
                break;
            }
        }
    }
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Nhập thông tin lớp học.");
        System.out.println("2. Nhập thông tin học sinh.");
        System.out.println("3. Sửa đổi thông tin lớp học.");
        System.out.println("4. Sửa đổi thông tin học sinh.");
        System.out.println("5. Xóa lớp học.");
        System.out.println("6. Xóa học sinh.");
        System.out.println("7. Xem thông tin lớp học.");
        System.out.println("8. Xem thông tin học sinh.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Hãy chọn thao tác: ");
    }
}
