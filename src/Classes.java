import com.company.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class Classes {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;

    public Integer getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(Integer teacherID) {
        TeacherID = teacherID;
    }

    private Integer TeacherID;

    public Integer getStudentID() {
        return StudentID;
    }

    public void setStudentID(Integer studentID) {
        StudentID = studentID;
    }

    private Integer StudentID;

    public String getGrades() {
        return Grades;
    }

    public void setGrades(String grades) {
        Grades = grades;
    }

    private String Grades;

    private static String SQLclasses = "SELECT * FROM class WHERE Name LIKE ?";

    private static String SQLclassesbyStudentID = "SELECT * FROM class WHERE Student_ID LIKE ?";
    private static String SQLclassesbyTeacherID = "SELECT * FROM class WHERE Teacher_ID LIKE ?";
    public static void getTeacher(ResultSet rs) throws SQLException {
        while(rs.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Class " + rs.getString("Name"));
            buffer.append(" Teacher_ID " + rs.getString("Name"));
            buffer.append(" Student_ID is " + rs.getString("Student_ID"));
            System.out.println(buffer.toString());

        }
    }
    public static ResultSet GetclassesofStudent(String email) throws SQLException {
        Integer StudentID = Student.getStudentbuyName(email);
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLclassesbyStudentID, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1,StudentID);
            rs = stmt.executeQuery();
            return rs;
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return rs;
    }
    public static ResultSet GetclassesofTeacher(int teacherID) throws SQLException {
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLclassesbyTeacherID, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1,teacherID);
            rs = stmt.executeQuery();
            return rs;
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return rs;
    }
}
