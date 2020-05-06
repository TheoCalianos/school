import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public static void loadStudent(String email) throws SQLException {

        Stage window = new Stage();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        ResultSet rs = null;
        Label lblclasses = new Label("classes");
        grid.add(lblclasses,0,0);
        Label lblgrades = new Label("grades");
        grid.add(lblgrades,1,0);
        ResultSet classes = Classes.GetclassesofStudent(email);
        int count = 1;
        window.setTitle(Student.getStudentNamebyemail(email));
        while(classes.next()) {
            Label className = new Label(classes.getString("Name"));
            grid.add(className,0,count);
            Label grades = new Label(classes.getString("Grades"));
            grid.add(grades,1,count);
            count++;
            System.out.println(classes.getString("Name"));
            System.out.println(count);
        }
        Scene scene=new Scene(grid,800,800);
        window.setScene(scene);
        window.show();

    }
    public static void loadTeacher(String email) throws SQLException {

        Stage window = new Stage();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        ResultSet rs = null;
        Label lblclasses = new Label("classes");
        grid.add(lblclasses,0,0);
        Label lblStudent = new Label("students");
        grid.add(lblStudent,1,0);
        Label lblgrades = new Label("grades");
        grid.add(lblgrades,2,0);
        int teacher = Teacher.Teacherfindbyemail(email);
        int count = 1;
        ResultSet classes = Classes.GetclassesofTeacher(teacher);
        System.out.println(teacher);
        while(classes.next()) {
            Label className = new Label(classes.getString("Name"));
            grid.add(className,0,count);
            Label grades = new Label(classes.getString("Grades"));
            grid.add(grades,2,count);
            String studentName = Student.getStudentbuyID(classes.getInt("Student_ID"));
            Label Students = new Label(studentName);
            grid.add(Students,1,count);
            count++;
        }
        Scene scene=new Scene(grid,800,800);
        window.setScene(scene);
        window.show();

    }
}
