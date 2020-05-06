import com.company.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    public static void closeRs(ResultSet rs) throws SQLException {
        if(rs != null){
            rs.close();
        }
    }
    public static void main(String args[]) throws SQLException {
        ResultSet rs = null;

        /*Student Andrew = new Student();
        Andrew.setGPA(3);
        Andrew.setStudentEmail("andrew@gmail.com");
        Andrew.setStudentID(4);
        Andrew.setStudentName("Andrew");
        Andrew.setStudentPassword("things");
        Andrew.insertStudent(Andrew.getGPA(),Andrew.getStudentName(),Andrew.getStudentID(),Andrew.getStudentEmail(),Andrew.getStudentPassword());
        rs = Student.calltoStudentTable();
        Student.getStudents(rs);*/
        //Teacher MrDA = new Teacher();
        //MrDA.setClassID(1);
        //MrDA.setEmail("MrDA@gmail.com");
        //MrDA.setName("MR.DA");
       // MrDA.setPassword("MR.DAAAA");
        //MrDA.insertTeacher(MrDA.getName(), MrDA.getClassID(),MrDA.getEmail(),MrDA.getPassword());
        //rs = Teacher.calltoTeachersTable();
        System.out.println(Student.StudentLogin("Theocalianos18@gmail.com","poop"));
        //closeRs(rs);
    }
}
