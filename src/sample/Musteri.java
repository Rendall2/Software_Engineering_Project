package sample;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Musteri {

    private String MusteriAdi;
    private String TestYeri;
    private String IsEmriNo;
    private String TeklifNo;
    private int MusteriID;

    public Musteri(String musteriAdi, String testYeri, String isEmriNo, String teklifNo) {
        this.MusteriAdi = musteriAdi;
        this.TestYeri = testYeri;
        this.IsEmriNo = isEmriNo;
        this.TeklifNo = teklifNo;
    }

    public void setMusteriID(int musteriID) {
        if(musteriID>=0){
            this.MusteriID = musteriID;
        }
        else{
            throw new IllegalArgumentException("Musterinin ID'si pozitif bir değer olmalıdır");
        }
    }

    public void setMusteriAdi(String musteriAdi) { this.MusteriAdi = musteriAdi; }

    public void setTestYeri(String testYeri) { this.TestYeri = testYeri; }

    public void setIsEmriNo(String isEmriNo) { this.IsEmriNo = isEmriNo; }

    public void setTeklifNo(String teklifNo) { this.TeklifNo =teklifNo; }

    public String getTestYeri() { return TestYeri; }

    public String getIsEmriNo() { return IsEmriNo; }

    public String getTeklifNo() { return TeklifNo; }

    public String getMusteriAdi() { return MusteriAdi; }

    public int getMusteriID() { return MusteriID; }

    public void insertIntoDB() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            //1.Connect to the DB
            conn = Database.getConnenction();
            //2. Create a String that holds the query with ? as inputs
            String sql = "INSERT INTO Musteri(MusteriAdi,TestYeri,IsEmriNo,TeklifNo ) " +
                    "VALUES (?,?,?,?)";

            //3. Prepare the query
            preparedStatement = conn.prepareStatement(sql);

            //4. Bind the values to the parameters
            preparedStatement.setString(1, MusteriAdi);
            preparedStatement.setString(2, TestYeri);
            preparedStatement.setString(3, IsEmriNo);
            preparedStatement.setString(4,TeklifNo);

            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(preparedStatement!=null) preparedStatement.close();
            if(conn!=null) conn.close();
        }
    }

}