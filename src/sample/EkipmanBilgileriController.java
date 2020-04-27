package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class EkipmanBilgileriController {
    @FXML private TableView<Ekipman> ekipmanTableView;
    @FXML private TableColumn<Ekipman,Integer> ekipmanIDTableColumn;
    @FXML private TableColumn<Ekipman,String> kutupMesafesiTableColumn;
    @FXML private TableColumn<Ekipman,String> mpTasiyiciOrtamTableColumn;
    @FXML private TableColumn<Ekipman,String> uvIsikSiddetiTableColumn;
    @FXML private TableColumn<Ekipman,String> isikMesafesiTableColumn;
    @FXML private TableColumn<Ekipman,String> ekipmanAdiTableColumn;
    @FXML private TableColumn<Ekipman,String> miknatislamateknigiTableColumn;

    @FXML private TextField kutupMesafesiTextField;
    @FXML private TextField mpTasiyiciOrtamTextField;
    @FXML private TextField uvIsikSiddetiTextField;
    @FXML private TextField miknatislamaTeknigiTextField;
    @FXML private TextField isikMesafesiTextField;
    @FXML private TextField ekipmanAdiTextField;


    public void updateEkipmanAdi(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Ekipman SET ekipmanAdi=? WHERE ekipmanID=?";
        //TableView
        Ekipman selectedEkipman = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedEkipman.setEkipmanAdi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
    }

    public void updateKutupMesafesi(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Ekipman SET kutupMesafesi =? WHERE ekipmanID=?";
        //TableView
        Ekipman selectedEkipman = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedEkipman.setKutupMesafesi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
    }

    public void updateMPTasiyiciOrtam(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Ekipman SET MPTasiyiciOrtam =? WHERE ekipmanID=?";
        //TableView
        Ekipman selectedEkipman = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedEkipman.setMPTasiyiciOrtam(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
    }

    public void updateMıknatislamaTeknigi(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Ekipman SET MıknatıslamaTeknigi =? WHERE ekipmanID=?";
        //TableView
        Ekipman selectedEkipman = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedEkipman.setMıknatıslamaTeknigi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
    }

    public void updateUVIsikSiddeti(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Ekipman SET UVIsikSiddeti =? WHERE ekipmanID=?";
        //TableView
        Ekipman selectedEkipman = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedEkipman.setUVIsikSiddeti(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
    }

    public void updateIsikMesafesi(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Ekipman SET IsikMesafesi =? WHERE ekipmanID=?";
        //TableView
        Ekipman selectedEkipman = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedEkipman.setIsikMesafesi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
    }


    public void ekipmanEkleButtonPushed() throws SQLException {
        try{
            Ekipman newEkipman = new Ekipman(ekipmanAdiTextField.getText(),
                    kutupMesafesiTextField.getText(),
                    mpTasiyiciOrtamTextField.getText(),
                    miknatislamaTeknigiTextField.getText(),
                    uvIsikSiddetiTextField.getText(),
                    isikMesafesiTextField.getText());
            newEkipman.insertIntoDB();
            ekipmanTableView.getItems().add(newEkipman);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }


    //This method will delete the chosen Ekipman
    public void ekipmanıSilButtonPushed() throws SQLException{
        Connection conn = null;
        PreparedStatement statement = null;
        ObservableList<Ekipman> selectedRow, secilenCalisanlar;
        secilenCalisanlar = ekipmanTableView.getItems();
        selectedRow = ekipmanTableView.getSelectionModel().getSelectedItems();
        try {
            conn = Database.getConnenction();
            String sql = "DELETE FROM Ekipman WHERE ekipmanID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1,ekipmanTableView.getSelectionModel().getSelectedItem().getEkipmanID());
            statement.executeUpdate();

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
        secilenCalisanlar.removeAll(selectedRow);
    }
    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }


    public void initialize(){
        ekipmanIDTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,Integer>("EkipmanID"));
        ekipmanAdiTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("EkipmanAdi"));
        kutupMesafesiTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("KutupMesafesi"));
        uvIsikSiddetiTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("UVIsikSiddeti"));
        isikMesafesiTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("IsikMesafesi"));
        miknatislamateknigiTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("MıknatıslamaTeknigi"));
        mpTasiyiciOrtamTableColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("MPTasiyiciOrtam"));


        ekipmanTableView.setEditable(true);
        ekipmanAdiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        kutupMesafesiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        uvIsikSiddetiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        isikMesafesiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        miknatislamateknigiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mpTasiyiciOrtamTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        try{
            loadEkipmanlar();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    //Bu method SQL'den ekipmanları çeker
    public void loadEkipmanlar() throws SQLException{
        ObservableList<Ekipman> ekipmanlar = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //1. Connecting to DB
            conn = Database.getConnenction();

            //2. Create a statemant object
            statement = conn.createStatement();

            //3. Create the SQL query
            resultSet = statement.executeQuery("SELECT * FROM Ekipman");

            //4. Create calisan objects from each record
            while(resultSet.next()){
                Ekipman newEkipman = new Ekipman(resultSet.getString("ekipmanAdi"),
                        resultSet.getString("kutupMesafesi"),
                        resultSet.getString("MPTasiyiciOrtam"),
                        resultSet.getString("MıknatıslamaTeknigi"),
                        resultSet.getString("UVIsikSiddeti"),
                        resultSet.getString("IsikMesafesi"));
                newEkipman.setEkipmanID(resultSet.getInt("ekipmanID"));
                ekipmanlar.add(newEkipman);
            }
            ekipmanTableView.getItems().addAll(ekipmanlar);
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

