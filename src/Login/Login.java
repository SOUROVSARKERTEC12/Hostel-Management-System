package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Login extends Application
{


    public void start(Stage stage)
            throws Exception
    {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene = new Scene(root);

        stage.getIcons().add(new Image("file:G:\\HMProject\\src\\Login\\logo.png"));
        stage.setScene(scene);
        stage.setTitle("TEC Boy's Hostel Management System");
        stage.show();
    }

    public static void showInformationAlertBox(String info){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(info);
        alert.showAndWait();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
