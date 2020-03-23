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
        Student tmpStudent = new Student();
        try {
            tmpStudent.setStudentId(id);
            tmpStudent.setName(inputName());
            tmpStudent.setDateOfBirth(inputDateOfBirth());
            tmpStudent.setClazz(inputClazz());
            tmpStudent.setAge(inputAge(tmpStudent.getDateOfBirth()));
            tmpStudent.getClazz().studentList.add(tmpStudent);
            this.allStudentList.add(tmpStudent);
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
        Student tmpStudent = findStudentById();
        System.out.print(tmpStudent.toString());
        tmpStudent.setName(inputName());
        tmpStudent.setDateOfBirth(inputDateOfBirth());
        tmpStudent.setClazz(inputClazz());
        System.out.print("Bạn có muốn sửa học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if (choice.equals("1")) {
            editStudent();
        }
    }

    public void deleteStudent() {
        Student tmpStudent = findStudentById();
        allStudentList.remove(tmpStudent);
        System.out.print("Bạn có muốn xóa học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if (choice.equals("1")) {
            deleteStudent();
        }
    }

    private Student findStudentById() {
        System.out.print("Input Student ID: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmpStudent = null;
        List<Student> list = allStudentList.stream().filter(x -> x.getStudentId() == studentID).collect(Collectors.toList());
        if (!list.isEmpty()) {
            tmpStudent = list.get(0);
        }
        return tmpStudent;
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
        Date tmpdateOfBirth = null;
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        try {
            tmpdateOfBirth = format.parse(dateOfBirth);
        } catch (ParseException e) {
            System.out.println("Ngày tháng không hợp lệ");
        }
        return tmpdateOfBirth;
    }

    public void showAllStudents() {
        allStudentList.forEach(x -> System.out.println(x.toString()));
    }
}
