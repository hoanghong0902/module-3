package repository;

import entity.Classroom;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetClassroomRepository {
    String QUERY = "SELECT * FROM CLASSROOM";
    public List<Classroom> getListClass(){
        List<Classroom> classrooms = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                classrooms.add(new Classroom(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classrooms;
    }
}
