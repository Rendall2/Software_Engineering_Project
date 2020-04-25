package sample;

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
import java.time.LocalDate;

public class EkipmanBilgileriController {
    @FXML private TableView<Ekipman> ekipmanTableView;
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


    public void changeEkipmanAdiCellEvent(TableColumn.CellEditEvent edittedCell){
        Ekipman selectedItem = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedItem.setEkipmanAdi(edittedCell.getNewValue().toString());
    }

    public void changeKutupMesafesiCellEvent(TableColumn.CellEditEvent edittedCell){
        Ekipman selectedItem = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedItem.setKutupMesafesi(edittedCell.getNewValue().toString());
    }

    public void changeMPTasiyiciOrtamCellEvent(TableColumn.CellEditEvent edittedCell){
        Ekipman selectedItem = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedItem.setMPTasiyiciOrtam(edittedCell.getNewValue().toString());
    }

    public void changeUVIsikSiddetiCellEvent(TableColumn.CellEditEvent edittedCell){
        Ekipman selectedItem = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedItem.setUVIsikSiddeti(edittedCell.getNewValue().toString());
    }

    public void changeIsikMesafesiCellEvent(TableColumn.CellEditEvent edittedCell){
        Ekipman selectedItem = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedItem.setIsikMesafesi(edittedCell.getNewValue().toString());
    }

    public void changeMiknatislamaTeknigiCellEvent(TableColumn.CellEditEvent edittedCell){
        Ekipman selectedItem = ekipmanTableView.getSelectionModel().getSelectedItem();
        selectedItem.setMıknatıslamaTeknigi(edittedCell.getNewValue().toString());
    }


    public void ekipmanEkle(){
        Ekipman newCalisan = new Ekipman(ekipmanAdiTextField.getText(),
                                         kutupMesafesiTextField.getText(),
                                         mpTasiyiciOrtamTextField.getText(),
                                         miknatislamaTeknigiTextField.getText(),
                                         uvIsikSiddetiTextField.getText(),
                                         isikMesafesiTextField.getText());

        //Get all the items from the table as a list, then add the new Ekipman
        ekipmanTableView.getItems().add(newCalisan);
    }

    //This method will delete the chosen Person(s)
    public void ekipmaniSil(){
        ObservableList<Ekipman> selectedRows,secilenCalisanlar;
        secilenCalisanlar = ekipmanTableView.getItems();

        selectedRows =  ekipmanTableView.getSelectionModel().getSelectedItems();

        secilenCalisanlar.removeAll(selectedRows);
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
    }
}
