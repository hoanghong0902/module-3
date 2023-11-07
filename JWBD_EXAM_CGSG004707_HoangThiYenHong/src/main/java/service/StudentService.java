package service;

import entity.Student;
import repository.AddNewStudentRepository;
import repository.DeleteStudentRepository;
import repository.EditStudentInfoRepository;
import repository.GetStudentRepository;

import java.util.List;

public class StudentService implements IStudentService{

    private AddNewStudentRepository addNewStudentRepository;
    private EditStudentInfoRepository editStudentInfoRepository;
    private DeleteStudentRepository deleteStudentRepository;
    private GetStudentRepository getStudentRepository;

    public StudentService() {
        addNewStudentRepository = new AddNewStudentRepository();
        editStudentInfoRepository = new EditStudentInfoRepository();
        deleteStudentRepository = new DeleteStudentRepository();
        getStudentRepository = new GetStudentRepository();
    }

    @Override
    public List<Student> getAllStudent() {
        return getStudentRepository.getAllStudents();
    }

    @Override
    public Student getStudent(Integer id) {
        return getStudentRepository.getStudent(id);
    }

    @Override
    public boolean addNewStudent(String name, String dateOfBirth, String address, String phoneNumber, String email, String classroom) {
        Student student = new Student(name,dateOfBirth,address,phoneNumber,email,classroom);
        return addNewStudentRepository.addNewStudent(student);
    }

    @Override
    public boolean editStudentInfo(Integer id, String name, String dateOfBirth, String address, String phoneNumber, String email, String classroom) {
        Student student = new Student(name,dateOfBirth,address,phoneNumber,email,classroom);
        return editStudentInfoRepository.editStudent(id, student);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        return deleteStudentRepository.deleteStudent(id);
    }

}
