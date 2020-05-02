import com.company.Input;

import java.sql.*;

public class Teacher {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    private String Name;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;

    public Integer getClassID() {
        return ClassID;
    }

    public void setClassID(Integer classID) {
        ClassID = classID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;

    private Integer ClassID;
    private static String SQLteacher = "SELECT * FROM teacher WHERE Name LIKE?";
    public static void getTeacher(ResultSet rs) throws SQLException {
        while(rs.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Email " + rs.getString("email"));
            buffer.append(" name is " + rs.getString("Name"));
            buffer.append(" ClassId is " + rs.getString("ClassID"));
            System.out.println(buffer.toString());

        }
    }
    public static ResultSet calltoTeachersTable() throws SQLException{
        String name;
        try {
            name = Input.getString("enter name of Teacher");
        }
        catch (Exception e)
        {
            System.err.println("Invalid name");
            return null;
        }
        ResultSet rs = null;
        try {
            Connection conn = com.company.DBconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLteacher, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
    public void insertTeacher(String Name, int ClassID, String email, String Password) throws SQLException {
        try {
            Connection conn = com.company.DBconnection.getConnection();
            Statement st = conn.createStatement();
            String insert =  String.format(" VALUES (" +
                    "\""+Name+"\", %d, \" "+Email+" \", \""+Password+"\");", ClassID);
            System.out.println("INSERT INTO `teacher` (`Name`, `ClassID`, `Email`, `password`)" + insert);
            st.executeUpdate("INSERT INTO `teacher` (`Name`, `ClassID`, `Email`, `password`)" + insert);

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }


    }
}
