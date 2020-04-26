package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CalisanBilgileriController {
    @FXML private TableView<Calisan> calisanTableView;
    @FXML private TableColumn<Calisan, Integer> calisanIDTableColumn;
    @FXML private TableColumn<Calisan,String> calisanAdiTableColumn;
    @FXML private TableColumn<Calisan,String> calisanSoyadiTableColumn;
    @FXML private TableColumn<Calisan,String> calisanLevelTableColumn;
    @FXML private TableColumn<Calisan, LocalDate> calisanSertifikaTarihiTableColumn;

    @FXML private TextField adTextField;
    @FXML private TextField soyadTextField;
    @FXML private TextField levelTextField;
    @FXML private DatePicker sertifikaTarihiDatePicker;
    Controller controller;

    public void updateCalisanAdiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Calisan SET calisanAdi=? WHERE calisanID=?";
        //TableView
        Calisan selectedCalisan = calisanTableView.getSelectionModel().getSelectedItem();
        selectedCalisan.setCalisanAdi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, calisanTableView.getSelectionModel().getSelectedItem().getCalisanID());
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

    public void updateCalisanSoyadiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        String sql = "UPDATE Calisan SET calisanSoyadi=? WHERE calisanID=?";
        //TableView
        Calisan selectedCalisan = calisanTableView.getSelectionModel().getSelectedItem();
        selectedCalisan.setCalisanSoyadi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, calisanTableView.getSelectionModel().getSelectedItem().getCalisanID());
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

    public void updateCalisanLevelCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        //TableView
        Calisan selectedCalisan = calisanTableView.getSelectionModel().getSelectedItem();
        String sql = "UPDATE Calisan SET calisanLevel=? WHERE calisanID=?";
        selectedCalisan.setCalisanLevel(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, calisanTableView.getSelectionModel().getSelectedItem().getCalisanID());
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

    public void updateCalisanSertifikaTarihi(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "UPDATE Calisan SET calisanSertifikaTarihi=? WHERE calisanID=?";

        //Tableview
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        Calisan selectedCalisan = calisanTableView.getSelectionModel().getSelectedItem();
        String date = edittedCell.getNewValue().toString();
        LocalDate localDate = LocalDate.parse(date, formatter);
        selectedCalisan.setCalisanSertifikaTarihi(localDate);
        try {
            conn = Database.getConnenction();
            Date date1 = Date.valueOf(calisanTableView.getSelectionModel().getSelectedItem().getCalisanSertifikaTarihi());
            statement = conn.prepareStatement(sql);
            statement.setDate(1, date1);
            statement.setInt(2, calisanTableView.getSelectionModel().getSelectedItem().getCalisanID());
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
    /*public void changeSertifikaTarihi(TableColumn.CellEditEvent edittedCell){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        Calisan personSelected = calisanTableView.getSelectionModel().getSelectedItem();
        String date = edittedCell.getNewValue().toString();
        System.out.println(date);
        LocalDate localDate = LocalDate.parse(date, formatter);
        personSelected.setCalisanSertifikaTarihi(localDate);
    } */

   /* public ObservableList<Calisan> getCalisanlar(){
        ObservableList<Calisan> calisanlar = FXCollections.observableArrayList();
        calisanlar.add(new Calisan("Duygu","Ezengin","ÜÜÜÜÜÜÜÇÇÇÇÇ",LocalDate.of(2019, Month.AUGUST,14)));

        return calisanlar;
    } */

    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }

    public void calisanEkle(){
        try {
            Calisan newCalisan = new Calisan(adTextField.getText(), soyadTextField.getText(),
                                            levelTextField.getText(),sertifikaTarihiDatePicker.getValue());
            //Get all the items from the table as a list, then add the new Person
            newCalisan.insertIntoDB();
            calisanTableView.getItems().add(newCalisan);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    //This method will delete the chosen Person(s)
     public void calisanSil() throws SQLException{
        Connection conn = null;
        PreparedStatement statement = null;
        ObservableList<Calisan> selectedRow, secilenCalisanlar;
        secilenCalisanlar = calisanTableView.getItems();
        selectedRow = calisanTableView.getSelectionModel().getSelectedItems();
        try {
            conn = Database.getConnenction();
            String sql = "DELETE FROM Calisan WHERE calisanID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1,calisanTableView.getSelectionModel().getSelectedItem().getCalisanID());
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


    public void initialize() {
        calisanIDTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,Integer>("calisanID"));
        calisanAdiTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,String>("calisanAdi"));
        calisanSoyadiTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,String>("calisanSoyadi"));
        calisanLevelTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,String>("calisanLevel"));
        calisanSertifikaTarihiTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,LocalDate>("calisanSertifikaTarihi"));

        //CalisanTableView.setItems(getCalisanlar());

        calisanTableView.setEditable(true);
        calisanAdiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        calisanSoyadiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        calisanLevelTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        LocalDateStringConverter converter = new LocalDateStringConverter();
        calisanSertifikaTarihiTableColumn.setCellFactory(TextFieldTableCell.<Calisan,LocalDate>forTableColumn(converter));

        //calisanTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        try{
            loadCalisanlar();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    //Bu method SQL'den çalışanları çeker
    public void loadCalisanlar() throws SQLException{
        ObservableList<Calisan> calisanlar = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //1. Connecting to DB
            conn = Database.getConnenction();

            //2. Create a statemant object
            statement = conn.createStatement();

            //3. Create the SQL query
            resultSet = statement.executeQuery("SELECT * FROM Calisan");

            //4. Create calisan objects from each record
            while(resultSet.next()){
                Calisan newCalisan = new Calisan(resultSet.getString("calisanAdi"),
                                                resultSet.getString("calisanSoyadi"),
                                                resultSet.getString("calisanLevel"),
                                                resultSet.getDate("calisanSertifikaTarihi").toLocalDate());
                newCalisan.setCalisanID(resultSet.getInt("calisanID"));
                calisanlar.add(newCalisan);
            }
            calisanTableView.getItems().addAll(calisanlar);
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
