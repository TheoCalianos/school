import com.company.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    private static String SQLclasses = "SELECT * FROM class WHERE Name LIKE?";
    public static void getTeacher(ResultSet rs) throws SQLException {
        while(rs.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Class " + rs.getString("Name"));
            buffer.append(" Teacher_ID " + rs.getString("Name"));
            buffer.append(" Student_ID is " + rs.getString("Student_ID"));
            System.out.println(buffer.toString());

        }
    }
    public static ResultSet calltoTeachersTable() throws SQLException{
        String name;
        try {
            name = Input.getString("enter name of Classes");
        }
        catch (Exception e)
        {
            System.err.println("Invalid name");
            return null;
        }
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLclasses, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1,name);

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
