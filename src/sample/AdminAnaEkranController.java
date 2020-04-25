package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminAnaEkranController {
    @FXML private VBox FirmaBilgileriniGoruntuleVBox;
    @FXML private VBox RaporOlusturVBox;
    @FXML private VBox EkipmanBilgileriniGoruntuleVBox;
    @FXML private VBox CalısanBilgileriniGoruntuleVBox;

    public void setFirmaBilgileriniGoruntuleVBox(VBox firmaBilgileriniGoruntuleVBox) {
        FirmaBilgileriniGoruntuleVBox = firmaBilgileriniGoruntuleVBox;
    }

    public VBox getFirmaBilgileriniGoruntuleVBox() {
        return FirmaBilgileriniGoruntuleVBox;
    }

    public void RaporOlusturPushed(MouseEvent event) throws IOException {
        Parent RaporSecimEkraniParent = FXMLLoader.load(getClass().getResource("RaporSecimEkrani.fxml"));
        Scene RaporSecimEkraniScene = new Scene(RaporSecimEkraniParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(RaporSecimEkraniScene);
        window.show();
    }

    public void MüşteriBilgileriPushed(MouseEvent event) throws IOException {
        Parent MüşteriBilgileriParent = FXMLLoader.load(getClass().getResource("MusteriBilgileri.fxml"));
        Scene MüşteriBilgileriScene = new Scene(MüşteriBilgileriParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(MüşteriBilgileriScene);
        window.show();
    }

    public void EkipmanBilgileriPushed(MouseEvent event) throws IOException {
        Parent EkipmanBilgileriParent = FXMLLoader.load(getClass().getResource("EkipmanBilgileri.fxml"));
        Scene EkipmanBilgileriScene = new Scene(EkipmanBilgileriParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(EkipmanBilgileriScene);
        window.show();
    }

    public void CalisanBilgileriPushed(MouseEvent event) throws IOException {
        Parent RaporSecimEkraniParent = FXMLLoader.load(getClass().getResource("CalisanBilgileri.fxml"));
        Scene RaporSecimEkraniScene = new Scene(RaporSecimEkraniParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(RaporSecimEkraniScene);
        window.show();
    }

    public void initialize(){

    }
}
