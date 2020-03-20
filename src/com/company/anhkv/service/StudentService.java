package com.company.anhkv.service;

import com.company.anhkv.model.Clazz;
import com.company.anhkv.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    //them
    //sua
    //xóa
    private static Scanner studentScanner = new Scanner(System.in);
    ClazzService clazzService;
    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }
    List<Student> allStudentList = new ArrayList<>();
    //add
    public void addStudent() {
        int allStudentListSize = allStudentList.size();
        int id = (allStudentListSize > 0) ? (allStudentList.get(allStudentListSize-1).getStudentId() + 1) : 1;
        Student tmp = new Student();
        tmp.setStudentId(id);
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(selectClazz());
        tmp.setAge(inputAge(tmp.getDateOfBirth()));
        tmp.getClazz().studentList.add(tmp);
        this.allStudentList.add(tmp);
        System.out.print("Bạn có muốn thêm học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if(choice.equals("1")) {
            addStudent();
        }
    }

    private int inputAge(String date) {
        int year = Integer.valueOf(date.substring(4));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - year;
    }

    //edit
    public void editStudent() {
        System.out.print("Nhập ID học sinh muốn sửa: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmp = findStudentById(studentID);
        System.out.print(tmp.toString());
        tmp.setName(inputName());
        tmp.setDateOfBirth(inputDateOfBirth());
        tmp.setClazz(selectClazz());
        System.out.print("Bạn có muốn sửa học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if(choice.equals("1")) {
            editStudent();
        }
    }

    //delete
    public void deleteStudent() {
        System.out.print("Nhập ID học sinh muốn xóa: ");
        int studentID = Integer.parseInt(studentScanner.nextLine());
        Student tmp = findStudentById(studentID);
        allStudentList.remove(tmp);
        System.out.print("Bạn có muốn xóa học sinh khác 1: yes, 0: no ");
        String choice = studentScanner.nextLine();
        if(choice.equals("1")) {
            deleteStudent();
        }
    }

    private Student findStudentById(int id) {
        Student tmp = allStudentList.stream().filter(x -> x.getStudentId() == id).collect(Collectors.toList()).get(0);
        return tmp;
    }

    private Clazz selectClazz() {
        System.out.print("Input Clazz ID: ");
        int clazzId = Integer.parseInt(studentScanner.nextLine());
        return clazzService.findClazzById(clazzId);
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
