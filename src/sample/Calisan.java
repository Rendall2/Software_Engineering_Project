package sample;

import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.time.LocalDate;

public class Calisan {
    private SimpleStringProperty calisanAdi;
    private SimpleStringProperty calisanSoyadi;
    private SimpleStringProperty calisanLevel;
    private SimpleStringProperty calisanSifre;
    private LocalDate calisanSertifikaTarihi;



    public Calisan(String ad, String soyad, LocalDate sertifikatarihi) {
        this.calisanAdi = new SimpleStringProperty(ad);
        this.calisanSoyadi = new SimpleStringProperty(soyad);
        this.calisanSertifikaTarihi = sertifikatarihi;
    }

    public Calisan(String ad, String soyad, String calisanLevel, LocalDate sertifikatarihi) {
        this.calisanAdi = new SimpleStringProperty(ad);
        this.calisanSoyadi = new SimpleStringProperty(soyad);
        this.calisanLevel = new SimpleStringProperty(calisanLevel);
        this.calisanSertifikaTarihi = sertifikatarihi;
    }

    public String getCalisanAdi() { return calisanAdi.get(); }

    public String getCalisanSoyadi() { return calisanSoyadi.get(); }

    public String getCalisanLevel() { return calisanLevel.get(); }

    public String getCalisanSifre() { return calisanSifre.get(); }

    public LocalDate getCalisanSertifikaTarihi() { return calisanSertifikaTarihi; }

    public void setCalisanAdi(String calisanAdi) { this.calisanAdi = new SimpleStringProperty(calisanAdi); }

    public void setCalisanSoyadi(String calisanSoyadi) { this.calisanSoyadi = new SimpleStringProperty(calisanSoyadi); }

    public void setCalisanLevel(String calisanLevel) { this.calisanLevel = new SimpleStringProperty(calisanLevel); }

    public void setCalisanSifre(String calisanSifre) { this.calisanSifre.set(calisanSifre); }

    public void setCalisanZertifikatsDatum(LocalDate calisanSertifikaTarihi) { this.calisanSertifikaTarihi = calisanSertifikaTarihi; }

    public void insertIntoDB() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            //1.Connect to the DB
            conn = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\Ogulcan\\Desktop\\ProjeFolderı\\","Rendall","RelmAdo239");
            System.out.println("database connected");
            //2. Create a String that holds the query with ? as inputs
            String sql = "INSERT INTO Calisan(calisanAdi,calisanSoyadi,calisanLevel,calisanSertifikaTarihi) " +
                    "VALUES (?,?,?,?)";

            //3. Prepare the query
            preparedStatement = conn.prepareStatement(sql);

            //4. Convert the SertifikaTarihi into a SQL date
            Date db = Date.valueOf(calisanSertifikaTarihi);

            //5. Bind the values to the parameters
            preparedStatement.setString(1, calisanAdi.toString());
            preparedStatement.setString(2, calisanSoyadi.toString());
            preparedStatement.setString(3, calisanLevel.toString());
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
