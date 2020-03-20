package com.company.anhkv.service;

import com.company.anhkv.model.Clazz;
import com.company.anhkv.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    private static Scanner studentScanner = new Scanner(System.in);
    private ClazzService clazzService;
    private List<Student> allStudentList = new ArrayList<>();

    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    public void addStudent() {
        int allStudentListSize = allStudentList.size();
        int id = (allStudentListSize > 0) ? (allStudentList.get(allStudentListSize - 1).getStudentId() + 1) : 1;
        Student tmp = new Student();
        try {
            tmp.setStudentId(id);
            tmp.setName(inputName());
            tmp.setDateOfBirth(inputDateOfBirth());
            tmp.setClazz(inputClazz());
            tmp.setAge(inputAge(tmp.getDateOfBirth()));
            tmp.getClazz().studentList.add(tmp);
            this.allStudentList.add(tmp);
            System.out.print("Bạn có muốn thêm học sinh khác 1: yes, 0: no ");
            String choice = studentScanner.nextLine();
            if (choice.equals("1")) {
                addStudent();
            }
        } catch (Exception e) {
            System.out.println("You've got an input error");
        }
    }

    private int inputAge(String date) {
        int year = Integer.parseInt(date.substring(4));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - year;
    }

    public void editStudent() {
        Student tmp = findStudentById();
        System.out.print(tmp.toString());
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(inputClazz());
        System.out.print("Bạn có muốn sửa học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if (choice.equals("1")) {
            editStudent();
        }
    }

    public void deleteStudent() {
        Student tmp = findStudentById();
        allStudentList.remove(tmp);
        System.out.print("Bạn có muốn xóa học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if (choice.equals("1")) {
            deleteStudent();
        }
    }

    private Student findStudentById() {
        System.out.print("Input Student ID: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmp = null;
        List<Student> list = allStudentList.stream().filter(x -> x.getStudentId() == studentID).collect(Collectors.toList());
        if (!list.isEmpty()) {
            tmp = list.get(0);
        }
        return tmp;
    }

    private Clazz inputClazz() {
        return clazzService.findClazzById();
    }

    private String inputName() {
        System.out.print("Input Student's name: ");
        return studentScanner.nextLine();
    }

    private Date inputDateOfBirth() {
        System.out.print("Input Student's birthday (ddMMyyyy): ");
        String dateOfBirth = studentScanner.nextLine();
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        try {
            date = format.parse(dateOfBirth);
        } catch (ParseException e) {
            System.out.println("Ngày tháng không hợp lệ");
        }
        return date;
    }

    public void showAllStudents() {
        allStudentList.forEach(x -> System.out.println(x.toString()));
    }
}
