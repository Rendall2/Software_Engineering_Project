package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML private TextField kullaniciAdiTextField;
    @FXML private TextField şifrePasswordField;
    @FXML private Label adminOlarakGirisYapLabel;
    @FXML private Button girisYapButton;
    @FXML private Label errorLabel;

    public void girisYapButtonPushed(ActionEvent event) throws IOException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        byte[] salt = null;

        String databaseSifre = null;

        try{
            int kullaniciAdi = Integer.parseInt(kullaniciAdiTextField.getText());

            conn = Database.getConnenction();

            ps = conn.prepareStatement("SELECT CalisanSifre,Salt FROM Calisan WHERE calisanID = ?");

            ps.setInt(1,kullaniciAdi);

            resultSet = ps.executeQuery();

            while(resultSet.next()){
                databaseSifre = resultSet.getString("calisanSifre");
                Blob blob = resultSet.getBlob("SALT");
                //convert into a byte array
                int blobLength = (int) blob.length();
                salt = blob.getBytes(1, blobLength);
            }

            String kullaniciSifre = Password.getSHA512Password(şifrePasswordField.getText(),salt);
            if(kullaniciSifre.equals(databaseSifre))
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("RaporSecimEkrani.fxml"));
                Parent raporSecimEkraniParent = loader.load();

                Scene raporSecimEkrani = new Scene(raporSecimEkraniParent);

                RaporSecimEkraniController controller = loader.getController();
                controller.disableGeriButton();

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(raporSecimEkrani);
                window.show();
            }
            else if(şifrePasswordField.getText().isEmpty()){
                errorLabel.setText("Lütfen şifrenizi giriniz!");
            }
            else
            {
                errorLabel.setText("Hatalı giriş! Lütfen tekrar deneyiniz");
            }
        }


        catch (SQLException e){
            if(şifrePasswordField.getText().isEmpty()){
                errorLabel.setText("Lütfen şifrenizi giriniz!");
            }
            else{
                errorLabel.setText("Hatalı giriş! Lütfen tekrar deneyiniz");
            }

            e.getMessage();
        }
        catch(NullPointerException e){
            if(şifrePasswordField.getText().isEmpty()){
                errorLabel.setText("Lütfen şifrenizi giriniz!");
            }
            else if(kullaniciAdiTextField.getText().isEmpty()){
                errorLabel.setText("Lütfen kullanıcı adınızı giriniz!");
            }
            else{
                errorLabel.setText("Hatalı giriş! Lütfen tekrar deneyiniz");
            }
            e.getMessage();
        }
        catch (NumberFormatException e){
            if(şifrePasswordField.getText().isEmpty()){
                errorLabel.setText("Lütfen kullanıcı adınızı ve şifrenizi giriniz!");
            }
            else{
                errorLabel.setText("Lütfen kullanıcı adınızı giriniz!");
            }


        }


    }

    public void adminOlarakGirisYapLabelPushed(MouseEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }
    public void initialize(){
        errorLabel.setText("");
    }
}
