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

public class MusteriBilgileriController {
    @FXML private TableView<Musteri> musteriTableView;
    @FXML private TableColumn<Musteri,Integer> musteriIDTableColumn;
    @FXML private TableColumn<Musteri,String> musteriAdiTableColumn;
    @FXML private TableColumn<Musteri,String> testYeriTableColumn;
    @FXML private TableColumn<Musteri,String> isEmriNoTableColumn;
    @FXML private TableColumn<Musteri, String> teklifNoTableColumn;

    @FXML private TextField musteriAdiTextField;
    @FXML private TextField testYeriTextField;
    @FXML private TextField isEmriTextField;
    @FXML private TextField teklifNoTextField;


    public void updateMusteriAdiCellEvent(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        //TableView
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        String sql = "UPDATE Musteri SET MusteriAdi=? WHERE musteriID=?";
        selectedMusteri.setMusteriAdi(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, musteriTableView.getSelectionModel().getSelectedItem().getMusteriID());
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

    public void updateTestYeri(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        //TableView
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        String sql = "UPDATE Musteri SET TestYeri=? WHERE musteriID=?";
        selectedMusteri.setTestYeri(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, musteriTableView.getSelectionModel().getSelectedItem().getMusteriID());
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
    public void updateIsEmriNo(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        //TableView
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        String sql = "UPDATE Musteri SET IsEmriNo=? WHERE musteriID=?";
        selectedMusteri.setIsEmriNo(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, musteriTableView.getSelectionModel().getSelectedItem().getMusteriID());
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

    public void updateTeklifNo(TableColumn.CellEditEvent edittedCell) throws SQLException{
        //SQL
        Connection conn = Database.getConnenction();
        PreparedStatement statement = null;
        //TableView
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        String sql = "UPDATE Musteri SET TeklifNo=? WHERE musteriID=?";
        selectedMusteri.setTeklifNo(edittedCell.getNewValue().toString());
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, edittedCell.getNewValue().toString());
            statement.setInt(2, musteriTableView.getSelectionModel().getSelectedItem().getMusteriID());
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
    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }


    public void musteriEkleButtonPushed(){
        try {
            Musteri newMusteri = new Musteri(musteriAdiTextField.getText(), testYeriTextField.getText(),
                    isEmriTextField.getText(),teklifNoTextField.getText());
            //Get all the items from the table as a list, then add the new Person
            newMusteri.insertIntoDB();
            musteriTableView.getItems().add(newMusteri);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void musteriSilButtonPushed() throws SQLException{
        Connection conn = null;
        PreparedStatement statement = null;
        ObservableList<Musteri> selectedRow, secilenCalisanlar;
        secilenCalisanlar = musteriTableView.getItems();
        selectedRow = musteriTableView.getSelectionModel().getSelectedItems();
        try {
            conn = Database.getConnenction();
            String sql = "DELETE FROM Musteri WHERE musteriID=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1,musteriTableView.getSelectionModel().getSelectedItem().getMusteriID());
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

    public void initialize(){
        musteriIDTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,Integer>("musteriID"));
        musteriAdiTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("MusteriAdi"));
        testYeriTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("TestYeri"));
        isEmriNoTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("IsEmriNo"));
        teklifNoTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("TeklifNo"));

        musteriTableView.setEditable(true);
        musteriAdiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        testYeriTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        isEmriNoTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        teklifNoTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        try{
            loadMusteriler();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    //Bu method SQL'den çalışanları çeker
    public void loadMusteriler() throws SQLException{
        ObservableList<Musteri> musteriler = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //1. Connecting to DB
            conn = Database.getConnenction();

            //2. Create a statemant object
            statement = conn.createStatement();

            //3. Create the SQL query
            resultSet = statement.executeQuery("SELECT * FROM Musteri");

            //4. Create calisan objects from each record
            while(resultSet.next()){
                Musteri newMusteri = new Musteri(resultSet.getString("MusteriAdi"),
                        resultSet.getString("TestYeri"),
                        resultSet.getString("IsEmriNo"),
                        resultSet.getString("TeklifNo"));
                newMusteri.setMusteriID(resultSet.getInt("musteriID"));
                musteriler.add(newMusteri);
            }
            musteriTableView.getItems().addAll(musteriler);
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

