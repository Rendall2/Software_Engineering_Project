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
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CalisanBilgileriController {
    @FXML private TableView<Calisan> CalisanTableView;
    @FXML private TableColumn<Calisan,String> CalisanAdiTableColumn;
    @FXML private TableColumn<Calisan,String> CalisanSoyadiTableColumn;
    @FXML private TableColumn<Calisan,String> CalisanLevelTableColumn;
    @FXML private TableColumn<Calisan, LocalDate> CalisanSertifikaTarihiTableColumn;

    @FXML private TextField adTextField;
    @FXML private TextField soyadTextField;
    @FXML private TextField levelTextField;
    @FXML private DatePicker sertifikaTarihiDatePicker;

    public void changeAdCellEvent(TableColumn.CellEditEvent edittedCell){
        Calisan selectedCalisan = CalisanTableView.getSelectionModel().getSelectedItem();
        selectedCalisan.setCalisanAdi(edittedCell.getNewValue().toString());
    }

    public void changeSoyadCellEvent(TableColumn.CellEditEvent edittedCell){
        Calisan selectedCalisan = CalisanTableView.getSelectionModel().getSelectedItem();
        selectedCalisan.setCalisanAdi(edittedCell.getNewValue().toString());
    }

    public void changeLevelCellEvent(TableColumn.CellEditEvent edittedCell){
        Calisan selectedCalisan = CalisanTableView.getSelectionModel().getSelectedItem();
        selectedCalisan.setCalisanAdi(edittedCell.getNewValue().toString());
    }

    public void changeSertifikaTarihi(TableColumn.CellEditEvent edittedCell){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        Calisan personSelected = CalisanTableView.getSelectionModel().getSelectedItem();
        String date = edittedCell.getNewValue().toString();
        System.out.println(date);
        LocalDate localDate = LocalDate.parse(date, formatter);
        personSelected.setCalisanZertifikatsDatum(localDate);
    }

    public ObservableList<Calisan> getCalisanlar(){
        ObservableList<Calisan> calisanlar = FXCollections.observableArrayList();
        calisanlar.add(new Calisan("Duygu","Ezengin","ÜÜÜÜÜÜÜÇÇÇÇÇ",LocalDate.of(2019, Month.AUGUST,14)));

        return calisanlar;
    }

    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }

    public void calisanEkle(){
        Calisan newCalisan = new Calisan(adTextField.getText(), soyadTextField.getText(), levelTextField.getText(),sertifikaTarihiDatePicker.getValue());

        //Get all the items from the table as a list, then add the new Person
        CalisanTableView.getItems().add(newCalisan);
    }

    //This method will delete the chosen Person(s)
    public void calisanSil(){
        ObservableList<Calisan> selectedRows,secilenCalisanlar;
        secilenCalisanlar = CalisanTableView.getItems();

        selectedRows =  CalisanTableView.getSelectionModel().getSelectedItems();

        secilenCalisanlar.removeAll(selectedRows);
    }


    public void initialize() {
        CalisanAdiTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,String>("calisanAdi"));
        CalisanSoyadiTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,String>("calisanSoyadi"));
        CalisanLevelTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,String>("calisanLevel"));
        CalisanSertifikaTarihiTableColumn.setCellValueFactory(new PropertyValueFactory<Calisan,LocalDate>("calisanSertifikaTarihi"));

        CalisanTableView.setItems(getCalisanlar());

        CalisanTableView.setEditable(true);
        CalisanAdiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CalisanSoyadiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CalisanLevelTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        LocalDateStringConverter converter = new LocalDateStringConverter();
        CalisanSertifikaTarihiTableColumn.setCellFactory(TextFieldTableCell.<Calisan,LocalDate>forTableColumn(converter));

        CalisanTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
