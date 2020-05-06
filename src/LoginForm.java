import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import sun.security.util.Password;


import javax.xml.soap.Text;
import java.sql.SQLException;

public class LoginForm extends Application {
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;
        window.setTitle("login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Label lblUser = new Label("username");
        grid.add(lblUser,0,1);
        TextField txtUser = new TextField();

        txtUser.setText("username");
        grid.add(txtUser,1,1);

        Label lblPassword = new Label("password");
        grid.add(lblPassword,0,2);

        PasswordField pwBox=new PasswordField();
        pwBox.setPromptText("password");
        grid.add(pwBox, 1,2);

        Button loginbtn= new Button("Login");
        loginbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(!pwBox.getText().isEmpty() && !txtUser.getText().isEmpty())
                {
                    try {
                        if( Student.StudentLogin(txtUser.getText(),pwBox.getText()))
                        {
                            System.out.println("login sucessful student");
                            Controller.loadStudent(txtUser.getText());
                            window.close();
                        }
                        else if(Teacher.TeacherLogin(txtUser.getText(),pwBox.getText()))
                        {
                            System.out.println("login sucessful teacher");
                            Controller.loadTeacher(txtUser.getText());
                            window.close();
                        }
                        else{
                            System.out.println("Username or password not found");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
        grid.add(loginbtn,1, 3);

        Scene scene=new Scene(grid,800,800);
        window.setScene(scene);
        window.show();
    }
}
