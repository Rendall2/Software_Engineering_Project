package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RaporSecimEkraniController {

    @FXML private Button RaporOlusturmayaBaslaButton;
    @FXML private ChoiceBox musteriSecimiChoiceBox;
    @FXML private ChoiceBox ekipmanSecimiChoiceBox;
    @FXML private ChoiceBox operatorSecimiChoiceBox;
    @FXML private ChoiceBox degerlendirenSecimiChoiceBox;
    @FXML private ChoiceBox onaylayanSecimiChoiceBox;
    @FXML ChoiceBox<String> RaporTuruChoiceBox = new ChoiceBox();

    public void RaporOlusturmayaBaslaButtonPushed(ActionEvent event) throws IOException,SQLException {
        if(musteriSecimiChoiceBox.getSelectionModel().getSelectedItem() == null){
            AlertBox.createAlertBox("Lütfen müşteri seçiniz!");
        }

        else if(ekipmanSecimiChoiceBox.getSelectionModel().getSelectedItem() == null){
            AlertBox.createAlertBox("Lütfen ekipman seçiniz!");
        }

        else if(operatorSecimiChoiceBox.getSelectionModel().getSelectedItem() == null){
            AlertBox.createAlertBox("Lütfen operator seçiniz!");
        }

        else if(degerlendirenSecimiChoiceBox.getSelectionModel().getSelectedItem() == null){
            AlertBox.createAlertBox("Lütfen değerlendiren seçiniz!");
        }

        else if(onaylayanSecimiChoiceBox.getSelectionModel().getSelectedItem() == null){
            AlertBox.createAlertBox("Lütfen onaylayan seçiniz!");
        }

        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ManyetikParcacikMuayeneRaporu.fxml"));
            Parent raporSecimEkraniParent = loader.load();

            Scene AdminAnaEkranScene = new Scene(raporSecimEkraniParent);

            ManyetikParcacikMuayeneRaporuController controller = loader.getController();
            controller.initMusteriData(musteriSecimiChoiceBox.getValue().toString());

            controller.initOperatorData(operatorSecimiChoiceBox.getValue().toString());
            controller.initOnaylayanData(onaylayanSecimiChoiceBox.getValue().toString());
            controller.initDegerlendirenData(degerlendirenSecimiChoiceBox.getValue().toString());

            controller.initEkipmanData(ekipmanSecimiChoiceBox.getValue().toString());

            //This line get the stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(AdminAnaEkranScene);
            window.show();
        }
    }

    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }



    public void initialize() {

        RaporTuruChoiceBox.getItems().addAll( "Manyetik Parçacık Muayene Raporu");


        if(RaporTuruChoiceBox.getSelectionModel().isEmpty()) {
            RaporOlusturmayaBaslaButton.visibleProperty().bind(Bindings.isNotNull(RaporTuruChoiceBox.valueProperty()));
        }

        try {
            loadMusterilerChoiceBox();
            loadEkipmanlarChoiceBox();
            loadCalisanlarChoiceBox();
        }
        catch (SQLException e){
            e.getMessage();
        }
    }

    public void loadEkipmanlarChoiceBox() throws SQLException{
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = Database.getConnenction();

            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT*FROM Ekipman");

            while (resultSet.next()) {
                Ekipman newEkipman = new Ekipman(resultSet.getString("ekipmanAdi"),
                        resultSet.getString("kutupMesafesi"),
                        resultSet.getString("MPTasiyiciOrtam"),
                        resultSet.getString("MıknatıslamaTeknigi"),
                        resultSet.getString("UVIsikSiddeti"),
                        resultSet.getString("IsikMesafesi"));
                newEkipman.setEkipmanID(resultSet.getInt("ekipmanID"));
                ekipmanSecimiChoiceBox.getItems().add(newEkipman.getEkipmanAdi());
            }

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) { conn.close(); }
            if(statement!=null) { statement.close(); }
            if(resultSet!=null) { resultSet.close(); }

        }

    }
    public  void loadCalisanlarChoiceBox() throws SQLException{
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = Database.getConnenction();

            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT*FROM Calisan");

            while (resultSet.next()) {
                Calisan newCalisan = new Calisan(resultSet.getString("calisanAdi"),
                        resultSet.getString("calisanSoyadi"),
                        resultSet.getString("calisanLevel"),
                        resultSet.getDate("calisanSertifikaTarihi").toLocalDate());
                newCalisan.setCalisanID(resultSet.getInt("calisanID"));
                operatorSecimiChoiceBox.getItems().add(newCalisan.getCalisanAdi() + " " + newCalisan.getCalisanSoyadi());
                onaylayanSecimiChoiceBox.getItems().add(newCalisan.getCalisanAdi() + " " + newCalisan.getCalisanSoyadi());
                degerlendirenSecimiChoiceBox.getItems().add(newCalisan.getCalisanAdi() + " " + newCalisan.getCalisanSoyadi());
            }

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) { conn.close(); }
            if(statement!=null) { statement.close(); }
            if(resultSet!=null) { resultSet.close(); }

        }
    }

    public void loadMusterilerChoiceBox() throws SQLException {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = Database.getConnenction();

            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT*FROM Musteri");

            while (resultSet.next()) {
                Musteri newMusteri = new Musteri(resultSet.getString("MusteriAdi"),
                        resultSet.getString("TestYeri"),
                        resultSet.getString("IsEmriNo"),
                        resultSet.getString("TeklifNo"));
                newMusteri.setMusteriID(resultSet.getInt("musteriID"));
                musteriSecimiChoiceBox.getItems().add(newMusteri.getMusteriAdi());
            }

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) { conn.close(); }
            if(statement!=null) { statement.close(); }
            if(resultSet!=null) { resultSet.close(); }

        }

    }
}
