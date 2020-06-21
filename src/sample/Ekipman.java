package sample;

//Oğulcan Şahin 170503007

import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ekipman {
    private String EkipmanAdi;
    private String KutupMesafesi;
    private String MPTasiyiciOrtam;
    private String MıknatıslamaTeknigi;
    private String UVIsikSiddeti;
    private String IsikMesafesi;
    private int ekipmanID;



    public Ekipman(String ekipmanAdi,
                   String kutupMesafesi,
                   String MPTasiyiciOrtam,
                   String mıknatıslamaTeknigi,
                   String UVIsikSiddeti,
                   String isikMesafesi) {

        this.EkipmanAdi = ekipmanAdi;
        this.KutupMesafesi = kutupMesafesi;
        this.MPTasiyiciOrtam = MPTasiyiciOrtam;
        this.MıknatıslamaTeknigi = mıknatıslamaTeknigi;
        this.UVIsikSiddeti = UVIsikSiddeti;
        this.IsikMesafesi = isikMesafesi;
    }

    public int getEkipmanID() { return ekipmanID; }

    public String getEkipmanAdi() { return EkipmanAdi; }

    public String getKutupMesafesi() { return KutupMesafesi; }

    public String getMPTasiyiciOrtam() { return MPTasiyiciOrtam; }

    public String getMıknatıslamaTeknigi() { return MıknatıslamaTeknigi; }

    public String getUVIsikSiddeti() { return UVIsikSiddeti; }

    public String getIsikMesafesi() { return IsikMesafesi; }


    public void setEkipmanID(int ekipmanID) {
        if(ekipmanID>=0){
        this.ekipmanID = ekipmanID;
    }
    else{
        throw new IllegalArgumentException("Ekipmanın ID'si pozitif bir değer olmalıdır");
    }
    }

    public void setEkipmanAdi(String ekipmanAdi) { this.EkipmanAdi = ekipmanAdi; }

    public void setKutupMesafesi(String kutupMesafesi) { this.KutupMesafesi = kutupMesafesi; }

    public void setMPTasiyiciOrtam(String MPTasiyiciOrtam) { this.MPTasiyiciOrtam =  MPTasiyiciOrtam; }

    public void setMıknatıslamaTeknigi(String mıknatıslamaTeknigi) { this.MıknatıslamaTeknigi = mıknatıslamaTeknigi; }

    public void setUVIsikSiddeti(String UVIsikSiddeti) { this.UVIsikSiddeti = UVIsikSiddeti; }

    public void setIsikMesafesi(String isikMesafesi) { this.IsikMesafesi = isikMesafesi; }

    public void insertIntoDB() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            //1.Connect to the DB
            conn = Database.getConnenction();
            //2. Create a String that holds the query with ? as inputs
            String sql = "INSERT INTO Ekipman(ekipmanAdi,kutupMesafesi,MPTasiyiciOrtam,MıknatıslamaTeknigi,UVIsikSiddeti,IsikMesafesi)"
                        + "VALUES (?,?,?,?,?,?)";

            //3. Prepare the query
            preparedStatement = conn.prepareStatement(sql);

            //4. Bind the values to the parameters
            preparedStatement.setString(1, EkipmanAdi);
            preparedStatement.setString(2, KutupMesafesi);
            preparedStatement.setString(3, MPTasiyiciOrtam);
            preparedStatement.setString(4,MıknatıslamaTeknigi);
            preparedStatement.setString(5,UVIsikSiddeti);
            preparedStatement.setString(6,IsikMesafesi);

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
