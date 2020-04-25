package sample;

import javafx.beans.property.SimpleStringProperty;

public class Ekipman {
    private SimpleStringProperty EkipmanAdi;
    private SimpleStringProperty KutupMesafesi;
    private SimpleStringProperty MPTasiyiciOrtam;
    private SimpleStringProperty MıknatıslamaTeknigi;
    private SimpleStringProperty UVIsikSiddeti;
    private SimpleStringProperty IsikMesafesi;


    public Ekipman(String ekipmanAdi,
                   String kutupMesafesi,
                   String MPTasiyiciOrtam,
                   String mıknatıslamaTeknigi,
                   String UVIsikSiddeti,
                   String isikMesafesi) {

        this.EkipmanAdi = new SimpleStringProperty(ekipmanAdi);
        this.KutupMesafesi = new SimpleStringProperty(kutupMesafesi);
        this.MPTasiyiciOrtam = new SimpleStringProperty(MPTasiyiciOrtam);
        this.MıknatıslamaTeknigi = new SimpleStringProperty(mıknatıslamaTeknigi);
        this.UVIsikSiddeti = new SimpleStringProperty(UVIsikSiddeti);
        this.IsikMesafesi = new SimpleStringProperty(isikMesafesi);
    }

    public String getEkipmanAdi() { return EkipmanAdi.get(); }

    public String getKutupMesafesi() { return KutupMesafesi.get(); }

    public String getMPTasiyiciOrtam() { return MPTasiyiciOrtam.get(); }

    public String getMıknatıslamaTeknigi() { return MıknatıslamaTeknigi.get(); }

    public String getUVIsikSiddeti() { return UVIsikSiddeti.get(); }

    public String getIsikMesafesi() { return IsikMesafesi.get(); }

    public void setEkipmanAdi(String ekipmanAdi) { this.EkipmanAdi = new SimpleStringProperty(ekipmanAdi); }

    public void setKutupMesafesi(String kutupMesafesi) { this.KutupMesafesi = new SimpleStringProperty(kutupMesafesi); }

    public void setMPTasiyiciOrtam(String MPTasiyiciOrtam) { this.MPTasiyiciOrtam =  new SimpleStringProperty(MPTasiyiciOrtam); }

    public void setMıknatıslamaTeknigi(String mıknatıslamaTeknigi) { this.MıknatıslamaTeknigi = new SimpleStringProperty(mıknatıslamaTeknigi); }

    public void setUVIsikSiddeti(String UVIsikSiddeti) { this.UVIsikSiddeti = new SimpleStringProperty(UVIsikSiddeti); }

    public void setIsikMesafesi(String isikMesafesi) { this.IsikMesafesi = new SimpleStringProperty(isikMesafesi); }
}
