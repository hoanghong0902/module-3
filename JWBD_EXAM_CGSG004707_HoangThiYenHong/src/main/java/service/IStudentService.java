package service;

import entity.Student;

import java.util.List;

public interface IStudentService {
    boolean addNewStudent(String name, String dateOfBirth, String address, String phoneNumber, String email, String classroom);
    boolean editStudentInfo(Integer id, String name, String dateOfBirth, String address, String phoneNumber, String email, String classroom);
    boolean deleteStudent(Integer id);
    List<Student> getAllStudent();
    Student getStudent(Integer id);
}
