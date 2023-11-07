package repository;

import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditStudentInfoRepository {
    String QUERY = "UPDATE STUDENT SET NAME = ?, DATE_OF_BIRTH = ?, ADDRESS = ?, PHONE_NUMBER = ?, " +
            "EMAIL = ?, CLASSROOM = ? WHERE ID = ?;";

    public boolean editStudent(Integer id, Student student){
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDateOfBirth());
            pstmt.setString(3, student.getAddress());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getClassroom());
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
