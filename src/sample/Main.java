package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.poi.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Gözetim Muayene ve Eğitim Hizmetleri");
        primaryStage.setScene(new Scene(root, 355, 265));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
        //Calisan calisan = new Calisan("s","e","iki",LocalDate.of(2019, Month.AUGUST,14));
        //calisan.insertIntoDB();

        launch(args);

    }
}
