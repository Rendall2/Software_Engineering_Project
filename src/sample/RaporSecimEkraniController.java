package sample;

import javafx.beans.binding.Bindings;
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

public class RaporSecimEkraniController {

    @FXML private Button RaporOlusturmayaBaslaButton;

    @FXML ChoiceBox<String> RaporTuruChoiceBox = new ChoiceBox();

    public void RaporOlusturmayaBaslaButtonPushed(ActionEvent event) throws IOException {
        Parent AdminAnaEkranParent = FXMLLoader.load(getClass().getResource("ManyetikParcacikMuayeneRaporu.fxml"));
        Scene AdminAnaEkranScene = new Scene(AdminAnaEkranParent);

        //This line get the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminAnaEkranScene);
        window.show();
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

        RaporTuruChoiceBox.getItems().addAll("Radyografik Muayene Raporu", "Manyetik Parçacık Muayene Raporu");
     //   RaporOlusturmayaBaslaButton.setDisable(true);
        if(RaporTuruChoiceBox.getSelectionModel().isEmpty()) {
          //  RaporOlusturmayaBaslaButton.setDisable(false);
            RaporOlusturmayaBaslaButton.visibleProperty().bind(Bindings.isNotNull(RaporTuruChoiceBox.valueProperty()));
        }

    }
}
