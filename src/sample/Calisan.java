package sample;

import javafx.beans.property.SimpleStringProperty;

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

}
