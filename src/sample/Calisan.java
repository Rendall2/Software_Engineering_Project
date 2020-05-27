package sample;

import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.time.LocalDate;

public class Calisan {
    private String calisanAdi;
    private String calisanSoyadi;
    private String calisanLevel;
    private String calisanSifre;
    private LocalDate calisanSertifikaTarihi;
    private int calisanID;



    public Calisan(String ad, String soyad, String calisanLevel, LocalDate sertifikatarihi) {
        this.calisanAdi = ad;
        this.calisanSoyadi = soyad;
        this.calisanLevel = calisanLevel;
        this.calisanSertifikaTarihi = sertifikatarihi;
    }

    public int getCalisanID() { return calisanID; }

    public String getCalisanAdi() { return calisanAdi; }

    public String getCalisanSoyadi() { return calisanSoyadi; }

    public String getCalisanLevel() { return calisanLevel; }

    public String getCalisanSifre() { return calisanSifre; }

    public LocalDate getCalisanSertifikaTarihi() { return calisanSertifikaTarihi; }

    public void setCalisanID(int calisanID) {
        if(calisanID>0){
            this.calisanID = calisanID;
        }
        else{
            throw new IllegalArgumentException("Calisan ID'si pozitif bir değer olmalıdır");
        }
    }

    public void setCalisanAdi(String calisanAdi) { this.calisanAdi = calisanAdi; }

    public void setCalisanSoyadi(String calisanSoyadi) { this.calisanSoyadi = calisanSoyadi; }

    public void setCalisanLevel(String calisanLevel) { this.calisanLevel = calisanLevel; }

    public void setCalisanSifre(String calisanSifre) { this.calisanSifre = calisanSifre; }

    public void setCalisanSertifikaTarihi(LocalDate calisanSertifikaTarihi) { this.calisanSertifikaTarihi = calisanSertifikaTarihi; }

    public void insertIntoDB() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            //1.Connect to the DB
            conn = Database.getConnenction();
            //2. Create a String that holds the query with ? as inputs
            String sql = "INSERT INTO Calisan(calisanAdi,calisanSoyadi,calisanLevel,calisanSertifikaTarihi) " +
                    "VALUES (?,?,?,?)";

            //3. Prepare the query
            preparedStatement = conn.prepareStatement(sql);

            //4. Convert the SertifikaTarihi into a SQL date
            Date db = Date.valueOf(calisanSertifikaTarihi);

            //5. Bind the values to the parameters
            preparedStatement.setString(1, calisanAdi);
            preparedStatement.setString(2, calisanSoyadi);
            preparedStatement.setString(3, calisanLevel);
            preparedStatement.setDate(4,db);

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
