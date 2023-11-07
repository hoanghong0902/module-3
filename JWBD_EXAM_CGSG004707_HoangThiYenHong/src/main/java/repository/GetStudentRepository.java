package repository;

import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetStudentRepository {
    String QUERY1 = "SELECT * FROM STUDENT";
    String QUERY2 = "SELECT * FROM STUDENT WHERE ID = ?;";

    public List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY1)){
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String classroom = resultSet.getString("classroom");
                studentList.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classroom));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public Student getStudent(Integer id){
        Student student = null;
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY2)){
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String emails = resultSet.getString("email");
                String classroom = resultSet.getString("classroom");
                student = new Student(id,name,dateOfBirth,address,phoneNumber,emails,classroom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
