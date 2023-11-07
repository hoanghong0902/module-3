package repository;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddNewStudentRepository {
    String QUERY = "INSERT INTO STUDENT(NAME, DATE_OF_BIRTH, ADDRESS, PHONE_NUMBER, EMAIL, CLASSROOM) " +
            "VALUES (?,?,?,?,?,?) ";

    public boolean addNewStudent(Student student){
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDateOfBirth());
            pstmt.setString(3, student.getAddress());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getClassroom());
            pstmt.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
