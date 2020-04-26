package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
    Controller controller;
    public void secilenObjeyiSil(TableView tableView, int theIDOfAnObject,String SqlTableName,String ID) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ObservableList<Calisan> selectedRow, secilenObjeler;
        secilenObjeler = tableView.getItems();
        selectedRow = tableView.getSelectionModel().getSelectedItems();
        try {
            conn = Database.getConnenction();
            String sql = "DELETE FROM" + " " + SqlTableName + " " + "WHERE" + " " + ID  + "=?"; // DELETE FROM Calisan WHERE calisanID=?
            statement = conn.prepareStatement(sql);
            statement.setInt(1,theIDOfAnObject);
            statement.executeUpdate();

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null) statement.close();
        }
        secilenObjeler.removeAll(selectedRow);
    }
}
