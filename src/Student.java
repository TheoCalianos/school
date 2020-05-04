import com.company.Input;

import java.sql.*;

public class Student {
    private int GPA;
    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
    private String Name;
    public String getStudentName() {
        return Name;
    }

    public void setStudentName(String name) {
        Name = name;
    }


    private int StudentID;
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }
    private String Email;
    public String getStudentEmail() {
        return Email;
    }

    public void setStudentEmail(String email) {
        Email = email;
    }
    private String password;
    public String getStudentPassword() {
        return password;
    }

    public void setStudentPassword(String password) {
        this.password = password;
    }

    private static String SQLstudent = "SELECT * FROM students";
    private static String SQLStudentLogin = "SELECT * FROM students WHERE Email LIKE ?";
    private static String SQLstudentLook = "SELECT * FROM students WHERE First_Name LIKE?";
    public static void getStudents(ResultSet rs) throws SQLException {
        while(rs.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Student_ID" + rs.getInt("Student_ID"));
            buffer.append(rs.getString("First_Name"));
            System.out.println(buffer.toString());

        }
    }
    public static ResultSet calltoStudentTable() throws SQLException{
        //String name;
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLstudent, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //stmt.setString(1,name);

            rs = stmt.executeQuery();
            return rs;
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return rs;
    }
    public static boolean StudentLogin(String email, String password) throws SQLException {
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLStudentLogin, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, email);

            rs = stmt.executeQuery();
            while(rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public static Integer getStudentbuyName(String name) throws SQLException{
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLstudentLook, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1,name);
            rs = stmt.executeQuery();
            while(rs.next()) {
                return rs.getInt("Student_ID");
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return -1;
    }
    public void insertStudent(int GPA, String Name, int StudentID, String email, String Password) throws SQLException {
        try {
            Connection conn = com.company.DBconnection.getConnection();
            Statement st = conn.createStatement();
            String insert =  String.format(" VALUES (%d, " +
                    "\""+Name+"\", %d, \" "+Email+" \", \""+Password+"\");" , GPA, StudentID);
            System.out.println("INSERT INTO `students` (`GPA`, `First_Name`, `Student_ID`, `Email`, `password`)" + insert);
            st.executeUpdate("INSERT INTO `students` (`GPA`, `First_Name`, `Student_ID`, `Email`, `password`)" + insert);

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }


    }
}
