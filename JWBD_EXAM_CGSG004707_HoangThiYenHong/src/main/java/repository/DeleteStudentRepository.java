package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudentRepository {
    String QUERY = "DELETE FROM STUDENT WHERE ID = ?";
    public boolean deleteStudent(Integer id){
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setInt(1, id);
            pstmt.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
