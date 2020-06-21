package sample;

//Oğulcan Şahin 170503007

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {

    @FXML PasswordField adminSifrePasswordField;
    @FXML Label errorLabel;

    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }

    public void adminOlarakGirisYapButtonPushed(ActionEvent event) throws IOException,NullPointerException {

        String sifre = adminSifrePasswordField.getText();
        String password = "password";
        if(sifre.equals(password)){
            Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
            Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

            //This line get the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(AdminAnaEkranScene);
            window.show();
            }
        else if(adminSifrePasswordField.getText().trim().isEmpty()){
            errorLabel.setText("Lütfen şifrenizi giriniz.");
        }
        else{
            errorLabel.setText("Hatalı şifre! Lütfen tekrar deneyiniz.");
        }
        }



    }

