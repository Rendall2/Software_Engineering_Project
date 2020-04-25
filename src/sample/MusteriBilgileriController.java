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

public class MusteriBilgileriController {
    @FXML private TableView<Musteri> musteriTableView;
    @FXML private TableColumn<Musteri,String> musteriAdiTableColumn;
    @FXML private TableColumn<Musteri,String> testYeriTableColumn;
    @FXML private TableColumn<Musteri,String> isEmriNoTableColumn;
    @FXML private TableColumn<Musteri, String> teklifNoTableColumn;

    @FXML private TextField musteriAdiTextField;
    @FXML private TextField testYeriTextField;
    @FXML private TextField isEmriTextField;
    @FXML private TextField teklifNoTextField;


    public void changeMusteriAdiCellEvent(TableColumn.CellEditEvent edittedCell){
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        selectedMusteri.setMusteriAdi(edittedCell.getNewValue().toString());
    }

    public void changeTestYeriCellEvent(TableColumn.CellEditEvent edittedCell){
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        selectedMusteri.setTestYeri(edittedCell.getNewValue().toString());
    }

    public void changeIsEmriCellEvent(TableColumn.CellEditEvent edittedCell){
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        selectedMusteri.setIsEmriNo(edittedCell.getNewValue().toString());
    }

    public void changeTeklifNoCellEvent(TableColumn.CellEditEvent edittedCell){
        Musteri selectedMusteri = musteriTableView.getSelectionModel().getSelectedItem();
        selectedMusteri.setTeklifNo(edittedCell.getNewValue().toString());
    }


    public void geriButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("AdminAnaEkran.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
    }


    public void musteriEkle(){
        Musteri newMusteri = new Musteri(musteriAdiTextField.getText(), testYeriTextField.getText(), isEmriTextField.getText(), teklifNoTextField.getText());

        //Get all the items from the table as a list, then add the new Person
        musteriTableView.getItems().add(newMusteri);
    }

    public void müsteriSil(){
        ObservableList<Musteri> selectedRow,secilenMusteri;
        secilenMusteri = musteriTableView.getItems();

        selectedRow =  musteriTableView.getSelectionModel().getSelectedItems();

        secilenMusteri.removeAll(selectedRow);
    }

    public void initialize(){
        musteriAdiTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("MusteriAdi"));
        testYeriTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("TestYeri"));
        isEmriNoTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("IsEmriNo"));
        teklifNoTableColumn.setCellValueFactory(new PropertyValueFactory<Musteri,String>("TeklifNo"));

        musteriTableView.setEditable(true);
        musteriAdiTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        testYeriTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        isEmriNoTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        teklifNoTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}
