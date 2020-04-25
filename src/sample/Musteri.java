package sample;

import javafx.beans.property.SimpleStringProperty;

public class Musteri {

    private SimpleStringProperty MusteriAdi;
    private SimpleStringProperty TestYeri;
    private SimpleStringProperty IsEmriNo;
    private SimpleStringProperty TeklifNo;

    public Musteri(String musteriAdi, String testYeri, String isEmriNo, String teklifNo) {
        this.MusteriAdi = new SimpleStringProperty(musteriAdi);
        this.TestYeri = new SimpleStringProperty(testYeri);
        this.IsEmriNo = new SimpleStringProperty(isEmriNo);
        this.TeklifNo = new SimpleStringProperty(teklifNo);
    }

    public void setMusteriAdi(String musteriAdi) { this.MusteriAdi = new SimpleStringProperty(musteriAdi); }

    public void setTestYeri(String testYeri) { this.TestYeri = new SimpleStringProperty(testYeri); }

    public void setIsEmriNo(String isEmriNo) { this.IsEmriNo = new SimpleStringProperty(isEmriNo); }

    public void setTeklifNo(String teklifNo) { this.TeklifNo = new SimpleStringProperty(teklifNo); }

    public String getTestYeri() { return TestYeri.get(); }

    public String getIsEmriNo() { return IsEmriNo.get(); }

    public String getTeklifNo() { return TeklifNo.get(); }

    public String getMusteriAdi() { return MusteriAdi.get(); }

}