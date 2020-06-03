package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.IOUtils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Optional;

import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;


public class ManyetikParcacikMuayeneRaporuController {

    //All the Choiceboxes
    @FXML ChoiceBox musteriChoiceBox;
    @FXML ChoiceBox projeAdiChoiceBox;
    @FXML ChoiceBox yuzeyDurumuChoiceBox;
    @FXML ChoiceBox muayeneAsamasiChoiceBox;
    @FXML ChoiceBox isEmriNoChoiceBox;
    @FXML ChoiceBox teklifNoChoiceBox;
    @FXML ChoiceBox akimTipiChoiceBox;
    @FXML ChoiceBox sonucChoiceBox1;
    @FXML ChoiceBox sonucChoiceBox2;
    @FXML ChoiceBox sonucChoiceBox3;
    @FXML ChoiceBox sonucChoiceBox4;
    @FXML ChoiceBox sonucChoiceBox5;
    @FXML ChoiceBox sonucChoiceBox6;
   /* @FXML ChoiceBox sonucChoiceBox7;
    @FXML ChoiceBox sonucChoiceBox8;
    @FXML ChoiceBox sonucChoiceBox9;
    @FXML ChoiceBox sonucChoiceBox10; */


    //All the TextFields
    @FXML TextField testYeriTextField;
    @FXML TextField muayeneStandartıTextField;
    @FXML TextField değerlendirenStandartıTextField;
    @FXML TextField muayeneProsedürüTextField;
    @FXML TextField muayeneKapsamıTextField;
    @FXML TextField resimNoTextField;
    @FXML TextField sayfaNoTextField;
    @FXML TextField raporNoTextField;
    @FXML TextField raporTarihiTextField;

    @FXML TextField kutupMesafesiTextField;
    @FXML TextField cihazTextField;
    @FXML TextField mpTasiyiciOrtamTextField;
    @FXML TextField miknatislamaTeknigiTextField;
    @FXML TextField uvIsikSiddetiTextField;
    @FXML TextField isikMesafesiTextField;
    @FXML TextField muayeneBolgesiTextField;
    @FXML TextField luxmetreTextField;
    @FXML TextField muayeneOrtamiTextField;
    @FXML TextField miknatisGiderimiTextField;
    @FXML TextField isilIslemTextField;
    @FXML TextField muayeneBolgesindekiAlanSiddetiTextfield;
    @FXML TextField yuzeyTextField;
    @FXML TextField isikCihaziTanimiTextField;
    @FXML TextField kaldirmaTestiTarihiTextField;

    @FXML TextField kaynakParcaNoTextfield1;
    @FXML TextField kaynakParcaNoTextfield2;
    @FXML TextField kaynakParcaNoTextfield3;
    @FXML TextField kaynakParcaNoTextfield4;
    @FXML TextField kaynakParcaNoTextfield5;
    @FXML TextField kaynakParcaNoTextfield6;
   /* @FXML TextField kaynakParcaNoTextfield7;
    @FXML TextField kaynakParcaNoTextfield8;
    @FXML TextField kaynakParcaNoTextfield9;
    @FXML TextField kaynakParcaNoTextfield10;   */


    @FXML TextField kontrolUzunTextfield1;
    @FXML TextField kontrolUzunTextField2;
    @FXML TextField kontrolUzunTextField3;
    @FXML TextField kontrolUzunTextField4;
    @FXML TextField kontrolUzunTextField5;
    @FXML TextField kontrolUzunTextField6;
  /*  @FXML TextField kontrolUzunTextField7;
    @FXML TextField kontrolUzunTextField8;
    @FXML TextField kontrolUzunTextField9;
    @FXML TextField kontrolUzunTextField10;  */

    @FXML TextField kaynakYonTextField1;
    @FXML TextField kaynakYonTextField2;
    @FXML TextField kaynakYonTextField3;
    @FXML TextField kaynakYonTextField4;
    @FXML TextField kaynakYonTextField5;
    @FXML TextField kaynakYonTextField6;
  /*  @FXML TextField kaynakYonTextField7;
    @FXML TextField kaynakYonTextField8;
    @FXML TextField kaynakYonTextField9;
    @FXML TextField kaynakYonTextField10; */

    @FXML TextField kalinlikTextField1;
    @FXML TextField kalinlikTextField2;
    @FXML TextField kalinlikTextField3;
    @FXML TextField kalinlikTextField4;
    @FXML TextField kalinlikTextField5;
    @FXML TextField kalinlikTextField6;
   /* @FXML TextField kalinlikTextField7;
    @FXML TextField kalinlikTextField8;
    @FXML TextField kalinlikTextField9;
    @FXML TextField kalinlikTextField10; */

    @FXML TextField capTextField1;
    @FXML TextField capTextField2;
    @FXML TextField capTextField3;
    @FXML TextField capTextField4;
    @FXML TextField capTextField5;
    @FXML TextField capTextField6;
   /* @FXML TextField capTextField7;
    @FXML TextField capTextField8;
    @FXML TextField capTextField9;
    @FXML TextField capTextField10; */

    @FXML TextField hataTipiTextField1;
    @FXML TextField hataTipiTextField2;
    @FXML TextField hataTipiTextField3;
    @FXML TextField hataTipiTextField4;
    @FXML TextField hataTipiTextField5;
    @FXML TextField hataTipiTextField6;
   /* @FXML TextField hataTipiTextField7;
    @FXML TextField hataTipiTextField8;
    @FXML TextField hataTipiTextField9;
    @FXML TextField hataTipiTextField10; */

    @FXML TextField hataninYeriTextField1;
    @FXML TextField hataninYeriTextField2;
    @FXML TextField hataninYeriTextField3;
    @FXML TextField hataninYeriTextField4;
    @FXML TextField hataninYeriTextField5;
    @FXML TextField hataninYeriTextField6;
   /* @FXML TextField hataninYeriTextField7;
    @FXML TextField hataninYeriTextField8;
    @FXML TextField hataninYeriTextField9;
    @FXML TextField hataninYeriTextField10; */


    @FXML Spinner yuzeySicakligiSpinner;

    @FXML CheckBox alinKaynagiCheckbox;
    @FXML CheckBox koseKaynagiCheckbox;

    @FXML Label musteriAdiLabel;
    @FXML Label operatorAdiLabel;
    @FXML Label operatorLevelLabel;
    @FXML Label degerlendirenAdiLabel;
    @FXML Label degerlendirenLevelLabel;
    @FXML Label onaylayanAdiLabel;
    @FXML Label onaylayanLevelLabel;

    public String operatorAdi,operatorSoyadi, onaylayanAdi, onaylayanSoyadi, degerlendirenAdi, degerlendirenSoyadi;

    public void exceleAktarButtonPushed(ActionEvent event) throws  Exception {

        int muayeneKapsamiInt = Integer.parseInt(muayeneKapsamıTextField.getText());

        if (muayeneKapsamiInt > 100 || 0 > muayeneKapsamiInt ||
                !(muayeneKapsamıTextField.getText().length() == 1 || muayeneKapsamıTextField.getText().length() == 2 || muayeneKapsamıTextField.getText().length() == 3)) {
            AlertBox.createAlertBox("Lütfen muayene kapsamı için 1'den 100'e kadar bir değer giriniz.\nGirilen değer: " + muayeneKapsamıTextField.getText());
        }

        else {
            Workbook workbook = Excel.createExcelDocument("test.xls");
            Sheet rapor = workbook.getSheet("Rapor");

            //Insterting the images

            InputStream inputStream1 = new FileInputStream("C:\\Users\\Ogulcan\\IdeaProjects\\Software Engineering Project\\src\\Alin Kaynagi Excel.png");
            InputStream inputStream2 = new FileInputStream("C:\\Users\\Ogulcan\\IdeaProjects\\Software Engineering Project\\src\\Kose Kaynagi Excel.png");
            InputStream inputStream3 = new FileInputStream("C:\\Users\\Ogulcan\\IdeaProjects\\Software Engineering Project\\src\\checked checkbox.png");
            InputStream inputStream4 = new FileInputStream("C:\\Users\\Ogulcan\\IdeaProjects\\Software Engineering Project\\src\\unchecked checkbox.png");
                 //Get the contents of an InputStream as a byte[]
            byte[] bytes1 = IOUtils.toByteArray(inputStream1);
            byte[] bytes2 = IOUtils.toByteArray(inputStream2);
            byte[] bytes3 = IOUtils.toByteArray(inputStream3);
            byte[] bytes4 = IOUtils.toByteArray(inputStream4);
                //Adds a picture to the workbook
            int pictureIdx1 = workbook.addPicture(bytes1, Workbook.PICTURE_TYPE_PNG);
            int pictureIdx2 = workbook.addPicture(bytes2, Workbook.PICTURE_TYPE_PNG);
                //close the input stream
            inputStream1.close();
            inputStream2.close();
            inputStream3.close();
            inputStream4.close();

                //Creates the top-level drawing patriarch.
            Drawing drawing1 = rapor.createDrawingPatriarch();
            Drawing drawing2 = rapor.createDrawingPatriarch();
            Drawing drawing3 = rapor.createDrawingPatriarch();
            Drawing drawing4 = rapor.createDrawingPatriarch();


            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor1 = workbook.getCreationHelper().createClientAnchor();
            ClientAnchor anchor2 = workbook.getCreationHelper().createClientAnchor();
            ClientAnchor anchor3 = workbook.getCreationHelper().createClientAnchor();
            ClientAnchor anchor4 = workbook.getCreationHelper().createClientAnchor();

                //Setting the image's location
            anchor1.setCol1(0);
            anchor1.setRow1(15);

            anchor2.setCol1(6);
            anchor2.setRow1(15);

            anchor3.setCol1(4);
            anchor3.setRow1(18);

            anchor4.setCol1(9);
            anchor4.setRow1(18);

                //Creates a picture
            Picture pict1 = drawing1.createPicture(anchor1, pictureIdx1);
            Picture pict2 = drawing2.createPicture(anchor2, pictureIdx2);

                //Reset the image to the original size
            pict1.resize(4.5,3.4);
            pict2.resize(3.8,3.5);

            if(alinKaynagiCheckbox.isSelected() && !(koseKaynagiCheckbox.isSelected())){
                int pictureIdx3 = workbook.addPicture(bytes3, Workbook.PICTURE_TYPE_PNG);
                int pictureIdx4 = workbook.addPicture(bytes4, Workbook.PICTURE_TYPE_PNG);
                Picture pict3 = drawing3.createPicture(anchor3, pictureIdx3);
                Picture pict4 = drawing4.createPicture(anchor4, pictureIdx4);
                pict3.resize(0.6,0.6);
                pict4.resize(0.37,0.6);
            }
            else if(alinKaynagiCheckbox.isSelected() && koseKaynagiCheckbox.isSelected()){
                int pictureIdx3 = workbook.addPicture(bytes3, Workbook.PICTURE_TYPE_PNG);
                Picture pict3 = drawing3.createPicture(anchor3, pictureIdx3);
                Picture pict4 = drawing4.createPicture(anchor4, pictureIdx3);
                pict3.resize(0.6,0.6);
                pict4.resize(0.35,0.6);
            }

            else if(!(alinKaynagiCheckbox.isSelected()) && koseKaynagiCheckbox.isSelected()){
                int pictureIdx3 = workbook.addPicture(bytes3, Workbook.PICTURE_TYPE_PNG);
                int pictureIdx4 = workbook.addPicture(bytes4, Workbook.PICTURE_TYPE_PNG);
                Picture pict3 = drawing3.createPicture(anchor3, pictureIdx4);
                Picture pict4 = drawing4.createPicture(anchor4, pictureIdx3);
                pict3.resize(0.6,0.6);
                pict4.resize(0.35,0.6);
            }

            else if(!(alinKaynagiCheckbox.isSelected()) && !(koseKaynagiCheckbox.isSelected())){
                int pictureIdx4 = workbook.addPicture(bytes4, Workbook.PICTURE_TYPE_PNG);
                Picture pict3 = drawing3.createPicture(anchor3, pictureIdx4);
                Picture pict4 = drawing4.createPicture(anchor4, pictureIdx4);
                pict3.resize(0.6,0.6);
                pict4.resize(0.37,0.6);
            }

            //Initializing of the cell styles
            CellStyle cellStyle1 = workbook.createCellStyle();
            CellStyle cellStyle2 = workbook.createCellStyle();
            CellStyle cellStyle3 = workbook.createCellStyle();
            CellStyle cellStyle4 = workbook.createCellStyle();
            CellStyle cellStyle5 = workbook.createCellStyle();
            CellStyle cellStyle6 = workbook.createCellStyle();
            CellStyle cellStyle7 = workbook.createCellStyle();
            CellStyle cellStyleText = workbook.createCellStyle();
            CellStyle cellStyleText2 = workbook.createCellStyle();


            //Initializing the fonts of headers
            Font fontHeader1 = workbook.createFont();  //Turkish with rosa text
            Font fontHeader2 = workbook.createFont();  //Turkish
            Font fontHeader3 = workbook.createFont();  //English


            //Initializing the main fonts
            Font fontText1 = workbook.createFont();     //Turkish
            Font fontText2 = workbook.createFont();     //English

            Font fontText3 = workbook.createFont();     //Text area
            Font fontText4 = workbook.createFont();     //Gecis area


            //Fonts for headers
            fontHeader1.setBold(true);
            fontHeader1.setFontHeightInPoints((short) 13);
            fontHeader1.setColor(IndexedColors.RED.getIndex());

            fontHeader2.setBold(true);
            fontHeader2.setFontHeightInPoints((short) 16);

            fontHeader3.setFontHeightInPoints((short) 13);


            //Fonts for main text
            fontText1.setBold(true);
            fontText1.setFontHeightInPoints((short) 8);

            fontText2.setItalic(true);
            fontText2.setFontHeightInPoints((short) 8);

            fontText3.setBold(true);
            fontText3.setFontHeightInPoints((short) 9);


            //The main empty cell style
            cellStyle1.setBorderBottom(BorderStyle.THICK);
            cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle1.setAlignment(CENTER);


            //The main rosa cell style with text
            cellStyle2.setBorderBottom(BorderStyle.THICK);

            cellStyle2.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle2.setWrapText(true);

            //Header1 cell style
            cellStyle3.setBorderBottom(BorderStyle.THICK);
            cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle3.setAlignment(CENTER);
            cellStyle3.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            cellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle3.setWrapText(true);

            cellStyle3.setFont(fontHeader1);


            //It is for the last cells of my function styleTheCells(It also outlines the right side of the Cell)
            cellStyle4.setBorderBottom(BorderStyle.THICK);
            cellStyle4.setBorderRight(BorderStyle.THICK);


            //It thickens the right Corner of the Cell only
            cellStyle5.setBorderRight(BorderStyle.THICK);


            //Rosa foreground and thick right corner of the cell
            cellStyle6.setBorderRight(BorderStyle.THICK);
            cellStyle6.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            cellStyle6.setFillPattern(FillPatternType.SOLID_FOREGROUND);


            //Rosa foreground and thick right bottom corner of the cell
            cellStyle7.setBorderBottom(BorderStyle.THICK);
            cellStyle7.setBorderRight(BorderStyle.THICK);

            cellStyle7.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            cellStyle7.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle7.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle7.setAlignment(CENTER);
            cellStyle7.setWrapText(true);


            //Text cellstyle
            cellStyleText.setBorderBottom(BorderStyle.THICK);

            cellStyleText.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyleText.setAlignment(CENTER);
            cellStyleText.setWrapText(true);

            cellStyleText.setFont(fontText3);

            //Rosa and text in the middle cellstlye
            cellStyleText2.setBorderBottom(BorderStyle.THICK);
            cellStyleText2.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyleText2.setAlignment(CENTER);
            cellStyleText2.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            cellStyleText2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyleText2.setWrapText(true);


            //Initializing the rows
            Row rowTitle1 = rapor.createRow(0);
            Row rowTitle2 = rapor.createRow(1);

            Row row1_1 = rapor.createRow(2);
            Row row1_2 = rapor.createRow(3);
            Row row1_3 = rapor.createRow(4);
            Row row1_4 = rapor.createRow(5);
            Row row1_5 = rapor.createRow(6);

            Row rowGecis1 = rapor.createRow(7);

            Row row2_1 = rapor.createRow(8);
            Row row2_2 = rapor.createRow(9);
            Row row2_3 = rapor.createRow(10);
            Row row2_4 = rapor.createRow(11);
            Row row2_5 = rapor.createRow(12);
            Row row2_6 = rapor.createRow(13);

            Row row3_1 = rapor.createRow(14);
            Row row3_2 = rapor.createRow(15);
            Row row3_3 = rapor.createRow(16);
            Row row3_4 = rapor.createRow(17);
            Row row3_5 = rapor.createRow(18);

            Row row4_1 = rapor.createRow(19);
            Row row4_2 = rapor.createRow(20);
            Row row4_3 = rapor.createRow(21);

            Row rowGecis2 = rapor.createRow(22);

            Row row5_1 = rapor.createRow(23);
            Row row5_2 = rapor.createRow(24);
            Row row5_3 = rapor.createRow(25);
            Row row5_4 = rapor.createRow(26);
            Row row5_5 = rapor.createRow(27);
            Row row5_6 = rapor.createRow(28);
            Row row5_7 = rapor.createRow(29);
            Row row5_8 = rapor.createRow(30);
            Row row5_9 = rapor.createRow(31);
            Row row5_10 = rapor.createRow(32);
            Row row5_11 = rapor.createRow(33);

            Row row6_1 = rapor.createRow(34);
            Row row6_2 = rapor.createRow(35);
            Row row6_3 = rapor.createRow(36);
            Row row6_4 = rapor.createRow(37);
            Row row6_5 = rapor.createRow(38);


            //Setting the heights of the rows
            rowTitle1.setHeight((short) 700);
            rowTitle2.setHeight((short) 900);

            row1_1.setHeight((short) 620);
            row1_2.setHeight((short) 620);
            row1_3.setHeight((short) 620);
            row1_4.setHeight((short) 620);
            row1_5.setHeight((short) 620);

            rowGecis1.setHeight((short) 400);

            row2_1.setHeight((short) 620);
            row2_2.setHeight((short) 620);
            row2_3.setHeight((short) 620);
            row2_4.setHeight((short) 620);
            row2_5.setHeight((short) 620);
            row2_6.setHeight((short) 620);

            row3_1.setHeight((short) 400);
            row3_2.setHeight((short) 400);
            row3_3.setHeight((short) 400);
            row3_4.setHeight((short) 400);
            row3_5.setHeight((short) 400);

            row4_1.setHeight((short) 620);
            row4_2.setHeight((short) 620);
            row4_3.setHeight((short) 620);

            rowGecis2.setHeight((short) 400);

            row5_1.setHeight((short) 620);
            row5_2.setHeight((short) 500);
            row5_3.setHeight((short) 500);
            row5_4.setHeight((short) 500);
            row5_5.setHeight((short) 500);
            row5_6.setHeight((short) 500);
            row5_7.setHeight((short) 500);
            row5_8.setHeight((short) 500);
            row5_9.setHeight((short) 500);
            row5_10.setHeight((short) 500);
            row5_11.setHeight((short) 500);

            row6_1.setHeight((short) 620);
            row6_2.setHeight((short) 620);
            row6_3.setHeight((short) 620);
            row6_4.setHeight((short) 620);
            row6_5.setHeight((short) 1400);


            //Adjusting the Column widths
            rapor.setColumnWidth(0, 2280);   //A
            rapor.setColumnWidth(1, 3120);   //B
            rapor.setColumnWidth(2, 270);    //C
            rapor.setColumnWidth(3, 1300);   //D
            rapor.setColumnWidth(4, 1440);   //E
            rapor.setColumnWidth(5, 1050);   //F
            rapor.setColumnWidth(6, 2460);   //G
            rapor.setColumnWidth(7, 1720);   //H
            rapor.setColumnWidth(8, 2180);   //I
            rapor.setColumnWidth(9, 2530);   //J
            rapor.setColumnWidth(10, 960);   //K
            rapor.setColumnWidth(11, 3200);  //L
            rapor.setColumnWidth(12, 1465);  //M
            rapor.setColumnWidth(13, 1270);  //N
            rapor.setColumnWidth(14, 1460);  //O
            rapor.setColumnWidth(15, 3200);  //P
            rapor.setColumnWidth(16, 910);   //Q
            rapor.setColumnWidth(17, 1820);  //R
            rapor.setColumnWidth(18, 1550);  //S
            rapor.setColumnWidth(19, 2100);  //T
            rapor.setColumnWidth(20, 3290);  //U


            //Creating all the Cells
            for (int rowNumber = 0; rowNumber <= 38; rowNumber++) {
                Excel.createCells(rowNumber, 0, 20, rapor);
            }


            //GIVING CELLS TEXT VALUES
            //Header
            Cell gözetimMuayeneEğitimHizmetleriCell = CellUtil.createCell(rowTitle1, 5, "GÖZETİM MUAYENE VE EGİTİM HİZMETLERİ");
            Cell manyetikParcacikMuayeneRaporuCell = CellUtil.createCell(rowTitle2, 5, "MANYETİK PARÇACIK MUAYENE RAPORU\nMAGNETIC PARTICLE INSPECTION REPORT");

            //row1
            Cell musteriCell = CellUtil.createCell(row1_1, 0, "Müşteri\nCustomer");
            Cell projeAdiCell = CellUtil.createCell(row1_2, 0, "Proje Adi\nProject Name");
            Cell testYeriCell = CellUtil.createCell(row1_3, 0, "Test yeri\nInspection Place");
            Cell muayeneStandartıCell = CellUtil.createCell(row1_4, 0, "Muayene Standartı\nInspection Standart");
            Cell değerlendirenStandartıCell = CellUtil.createCell(row1_5, 0, "Değerlendiren Standartı\nEvaluation Standart");

            Cell muayeneProsedürüCell = CellUtil.createCell(row1_1, 10, "Muayene Prosedürü\nInspection Procedure");
            Cell muayeneKapsamiCell = CellUtil.createCell(row1_2, 10, "Muayene Kapsami\nInspection Scope");
            Cell resimNoCell = CellUtil.createCell(row1_3, 10, "Resim No\nDrawing No");
            Cell yüzeyDurumuCell = CellUtil.createCell(row1_4, 10, "Yüzey Durumu\nSurface Condition");
            Cell muayeneAsamasiCell = CellUtil.createCell(row1_5, 10, "Muayene Aşaması\nStage of Examination");

            Cell sayfaNoCell = CellUtil.createCell(row1_1, 16, "Sayfa no\nPage");
            Cell raporNoCell = CellUtil.createCell(row1_2, 16, "Rapor No\nReport No");
            Cell raporTarihiCell = CellUtil.createCell(row1_3, 16, "Rapor tarihi\nReport Date");
            Cell isEmriNoCell = CellUtil.createCell(row1_4, 16, "İş Emri No\nJob Order No");
            Cell teklifNoCell = CellUtil.createCell(row1_5, 16, "Teklif No\nOffer No");

            //gecis1
            Cell ekipmanBilgileriCell = CellUtil.createCell(rowGecis1, 0, "Ekipman Bilgeri/Equipment Informations");

            //row2
            Cell kutupMesafesiCell = CellUtil.createCell(row2_1, 0, "Kutup mesafesi, mm\nPole Distance");
            Cell cihazCell = CellUtil.createCell(row2_2, 0, "Cihaz\nEquipment");
            Cell mpTasiyiciOrtamCell = CellUtil.createCell(row2_3, 0, "MP Taşıyıcı Ortam\nMP Carrier Medium");
            Cell mıknatislamaTeknigiCell = CellUtil.createCell(row2_4, 0, "Mıknatıslama Tekniği\nMag. Tech.");
            Cell uvIsikSiddettiCell = CellUtil.createCell(row2_5, 0, "UV Işık Şiddeti\nUV Light Intensity");
            Cell isikMesafesiCell = CellUtil.createCell(row2_6, 0, "Işık Mesafesi\nDistance of Light");

            Cell muayeneBölgesiCell = CellUtil.createCell(row2_1, 7, "Muayene Bölgesi\nExamination Area");
            Cell akimTipiCell = CellUtil.createCell(row2_2, 7, "Akım Tipi\nCurrent Type");
            Cell luxmetreCell = CellUtil.createCell(row2_3, 7, "Luxmetre/Işık Şiddeti\nLuxmeter");
            Cell muayeneOrtamiCell = CellUtil.createCell(row2_4, 7, "Muayene Ortamı\nTest Medium");
            Cell miknatisGiderimiCell = CellUtil.createCell(row2_5, 7, "Mıknatıs Giderimi\nDemagnelization");
            Cell isilIslemCell = CellUtil.createCell(row2_6, 7, "Isıl İşlem\nHeat Treatment");

            Cell yuzeySicakligiCell = CellUtil.createCell(row2_1, 15, "Yüzey Sıcaklığı(°C)\nSurface Temperature");
            Cell muayeneBölgesiAlanSiddetiCell = CellUtil.createCell(row2_2, 15, "Muayene Bölgesi Alan Şiddeti, kA/m\nGauss Field Strength\n");
            Cell yüzeyCell = CellUtil.createCell(row2_4, 15, "Yüzey\nSurface Condition");
            Cell isikCihaziTanimiCell = CellUtil.createCell(row2_5, 15, "Işık Cihazı Tanımı\nIdentification of Light Equip.");
            Cell kaldirmaTestiTarihCell = CellUtil.createCell(row2_6, 15, "Kaldırma Testi No / Lifting Case No\nTarih / Date");


            //row3
            Cell sureksizliginYeriCell = CellUtil.createCell(row3_1, 10, "Süreksizliğin Yeri / Location of Discontinuity");
            Cell bmCell = CellUtil.createCell(row3_2, 10, "BM");
            Cell wCell = CellUtil.createCell(row3_3, 10, "W");
            Cell hazCell = CellUtil.createCell(row3_4, 10, "HAZ");
            Cell bCell = CellUtil.createCell(row3_5, 10, "B");
            Cell anaMetalCell = CellUtil.createCell(row3_2, 12, "Ana Metal / Base Metal");
            Cell isidanEtkilenenBölgeCell = CellUtil.createCell(row3_3, 12, "Isıdan etkilenen bölge / Heat affected zone");
            Cell kaynakCell = CellUtil.createCell(row3_4, 12, "Kaynak / Weld");
            Cell kaynakAgziCell = CellUtil.createCell(row3_5, 12, "Kaynak ağzı / Bevel");


            //row4
            Cell standartSapmalarCell = CellUtil.createCell(row4_1, 0, "Standart Sapmalar\nStandart Deviations");
            Cell muayeneTarihleriCell = CellUtil.createCell(row4_2, 0, "Muayene Tarihleri\nInspection Results");
            Cell aciklamalarVeEklerCell = CellUtil.createCell(row4_3, 0, "Açıklamalar ve Ekler\nDescriptions and Attachments");

            //gecis2
            Cell muayeneSonuclariCell = CellUtil.createCell(rowGecis2, 0, "Muayene Sonuçları / Inspection Results");


            //row5
            Cell siraNoCell = CellUtil.createCell(row5_1, 0, "Sıra No\nSerial No");
            Cell kaynakParcaNoCell = CellUtil.createCell(row5_1, 1, "Kaynak-Parça No\nWeld/Piece No");
            Cell kontrolUzunluguCell = CellUtil.createCell(row5_1, 6, "Kontrol Uzun.\nTest Length");
            Cell kaynakYonCell = CellUtil.createCell(row5_1, 8, "Kaynak Yön.\nWelding Process");
            Cell kalınlıkCell = CellUtil.createCell(row5_1, 11, "Kalınlık (mm)\nThickness");
            Cell capCell = CellUtil.createCell(row5_1, 12, "Çap (mm)\nDiameter");
            Cell hataninTipiCell = CellUtil.createCell(row5_1, 15, "Hata Tipi\nDefect Type");
            Cell hataninYeriCell = CellUtil.createCell(row5_1, 17, "Hatanın yeri\nDefect Location");
            Cell sonucCell = CellUtil.createCell(row5_1, 20, "Sonuç\nResult");


            //row6
            Cell personelBilgeriCell = CellUtil.createCell(row6_1, 0, "Personel Bilgileri / Person. Infor.");
            Cell operator = CellUtil.createCell(row6_1, 4, "Operatör / Operator");
            Cell degerlendirenCell = CellUtil.createCell(row6_1, 9, "Degerlendiren / Evaluated by");
            Cell onayCell = CellUtil.createCell(row6_1, 14, "Onay / Confirmation");
            Cell musteriCell2 = CellUtil.createCell(row6_1, 18, "Müşteri / Customer");

            Cell adiSoyadıCell = CellUtil.createCell(row6_2, 0, "Adı Soyadı / Name Surname");
            Cell seviyeCell = CellUtil.createCell(row6_3, 0, "Seviye / Level");
            Cell tarihCell = CellUtil.createCell(row6_4, 0, "Tarih / Date");
            Cell imzaCell = CellUtil.createCell(row6_5, 0, "İmza / Signature");


            //PRINTING TEXTS WITH DIFFERENT FONTS BY TURKISH AND ENGLISH
            //Header
            Excel.printWithDifferentFonts(manyetikParcacikMuayeneRaporuCell, workbook, fontHeader2, fontHeader3);

            //Row1
            Excel.printWithDifferentFonts(musteriCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(projeAdiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(testYeriCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(muayeneStandartıCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(değerlendirenStandartıCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(muayeneProsedürüCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(muayeneKapsamiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(resimNoCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(yüzeyDurumuCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(muayeneAsamasiCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(sayfaNoCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(raporNoCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(raporTarihiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(isEmriNoCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(teklifNoCell, workbook, fontText1, fontText2);

            //Gecis1
            Excel.printWithDifferentFonts(ekipmanBilgileriCell, workbook, fontText1, fontText2);

            //Row2
            Excel.printWithDifferentFonts(kutupMesafesiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(cihazCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(mpTasiyiciOrtamCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(mıknatislamaTeknigiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(uvIsikSiddettiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(isikMesafesiCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(muayeneBölgesiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(akimTipiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(luxmetreCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(muayeneOrtamiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(miknatisGiderimiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(isilIslemCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(yuzeySicakligiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(muayeneBölgesiAlanSiddetiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(yüzeyCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(isikCihaziTanimiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(uvIsikSiddettiCell, workbook, fontText1, fontText2);

            RichTextString kaldirmaTestiTarihRichText = workbook.getCreationHelper().createRichTextString("Kaldırma Testi No/Lifting Case\n" + "Tarih / Date");
            kaldirmaTestiTarihRichText.applyFont(0, 17, fontText1);
            kaldirmaTestiTarihRichText.applyFont(17, 30, fontText2);
            kaldirmaTestiTarihRichText.applyFont(31, 36, fontText1);
            kaldirmaTestiTarihRichText.applyFont(37, 43, fontText2);

            kaldirmaTestiTarihCell.setCellValue(kaldirmaTestiTarihRichText);

            //Row3
            Excel.printWithDifferentFonts(sureksizliginYeriCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(bmCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(hazCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(wCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(bCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(anaMetalCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(isidanEtkilenenBölgeCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(kaynakCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(kaynakAgziCell, workbook, fontText1, fontText2);

            //Row4
            Excel.printWithDifferentFonts(standartSapmalarCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(muayeneTarihleriCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(aciklamalarVeEklerCell, workbook, fontText1, fontText2);

            //gecisRow
            Excel.printWithDifferentFonts(muayeneSonuclariCell, workbook, fontText1, fontText2);

            //Row5
            Excel.printWithDifferentFonts(siraNoCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(kaynakParcaNoCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(kontrolUzunluguCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(kaynakYonCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(kalınlıkCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(capCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(hataninTipiCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(hataninYeriCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(sonucCell, workbook, fontText1, fontText2);

            //Row6
            Excel.printWithDifferentFonts(personelBilgeriCell, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(operator, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(degerlendirenCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(onayCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(musteriCell2, workbook, fontText1, fontText2);

            Excel.printWithDifferentFonts(adiSoyadıCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(seviyeCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(tarihCell, workbook, fontText1, fontText2);
            Excel.printWithDifferentFonts(imzaCell, workbook, fontText1, fontText2);

            //Merging all the cells
            rapor.addMergedRegion(new CellRangeAddress(0, 1, 0, 4));
            rapor.addMergedRegion(new CellRangeAddress(0, 0, 5, 20));


            rapor.addMergedRegion(new CellRangeAddress(1, 1, 5, 20));

            //A small code shortening with using 'for' for merging the cells
            for (int rowValue = 2; rowValue < 7; rowValue++) {
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 0, 1));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 2, 9));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 10, 12));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 13, 15));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 16, 18));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 19, 20));
            }


            rapor.addMergedRegion(new CellRangeAddress(7, 7, 0, 20));


            rapor.addMergedRegion(new CellRangeAddress(8, 8, 0, 2));
            rapor.addMergedRegion(new CellRangeAddress(8, 8, 3, 6));
            rapor.addMergedRegion(new CellRangeAddress(8, 8, 7, 9));
            rapor.addMergedRegion(new CellRangeAddress(8, 8, 10, 14));
            rapor.addMergedRegion(new CellRangeAddress(8, 8, 15, 17));
            rapor.addMergedRegion(new CellRangeAddress(8, 8, 18, 20));

            rapor.addMergedRegion(new CellRangeAddress(9, 9, 0, 2));
            rapor.addMergedRegion(new CellRangeAddress(9, 9, 3, 6));
            rapor.addMergedRegion(new CellRangeAddress(9, 9, 7, 9));
            rapor.addMergedRegion(new CellRangeAddress(9, 9, 10, 14));

            rapor.addMergedRegion(new CellRangeAddress(9, 10, 15, 17));
            rapor.addMergedRegion(new CellRangeAddress(9, 10, 18, 20));

            rapor.addMergedRegion(new CellRangeAddress(10, 10, 0, 2));
            rapor.addMergedRegion(new CellRangeAddress(10, 10, 3, 6));
            rapor.addMergedRegion(new CellRangeAddress(10, 10, 7, 9));
            rapor.addMergedRegion(new CellRangeAddress(10, 10, 10, 14));

            rapor.addMergedRegion(new CellRangeAddress(11, 11, 0, 2));
            rapor.addMergedRegion(new CellRangeAddress(11, 11, 3, 6));
            rapor.addMergedRegion(new CellRangeAddress(11, 11, 7, 9));
            rapor.addMergedRegion(new CellRangeAddress(11, 11, 10, 14));
            rapor.addMergedRegion(new CellRangeAddress(11, 11, 15, 17));
            rapor.addMergedRegion(new CellRangeAddress(11, 11, 18, 20));

            rapor.addMergedRegion(new CellRangeAddress(12, 12, 0, 2));
            rapor.addMergedRegion(new CellRangeAddress(12, 12, 3, 6));
            rapor.addMergedRegion(new CellRangeAddress(12, 12, 7, 9));
            rapor.addMergedRegion(new CellRangeAddress(12, 12, 10, 14));
            rapor.addMergedRegion(new CellRangeAddress(12, 12, 15, 17));
            rapor.addMergedRegion(new CellRangeAddress(12, 12, 18, 20));

            rapor.addMergedRegion(new CellRangeAddress(13, 13, 0, 2));
            rapor.addMergedRegion(new CellRangeAddress(13, 13, 3, 6));
            rapor.addMergedRegion(new CellRangeAddress(13, 13, 7, 9));
            rapor.addMergedRegion(new CellRangeAddress(13, 13, 10, 14));
            rapor.addMergedRegion(new CellRangeAddress(13, 13, 15, 17));
            rapor.addMergedRegion(new CellRangeAddress(13, 13, 18, 20));


            rapor.addMergedRegion(new CellRangeAddress(14, 18, 0, 4));

            rapor.addMergedRegion(new CellRangeAddress(14, 18, 5, 9));

            rapor.addMergedRegion(new CellRangeAddress(14, 14, 10, 20));

            rapor.addMergedRegion(new CellRangeAddress(15, 15, 10, 11));
            rapor.addMergedRegion(new CellRangeAddress(16, 16, 10, 11));
            rapor.addMergedRegion(new CellRangeAddress(17, 17, 10, 11));
            rapor.addMergedRegion(new CellRangeAddress(18, 18, 10, 11));

            rapor.addMergedRegion(new CellRangeAddress(15, 15, 12, 20));
            rapor.addMergedRegion(new CellRangeAddress(16, 16, 12, 20));
            rapor.addMergedRegion(new CellRangeAddress(17, 17, 12, 20));
            rapor.addMergedRegion(new CellRangeAddress(18, 18, 12, 20));


            rapor.addMergedRegion(new CellRangeAddress(19, 19, 0, 4));
            rapor.addMergedRegion(new CellRangeAddress(20, 20, 0, 4));
            rapor.addMergedRegion(new CellRangeAddress(21, 21, 0, 4));

            rapor.addMergedRegion(new CellRangeAddress(19, 19, 5, 20));
            rapor.addMergedRegion(new CellRangeAddress(20, 20, 5, 20));
            rapor.addMergedRegion(new CellRangeAddress(21, 21, 5, 20));

            rapor.addMergedRegion(new CellRangeAddress(22, 22, 0, 20));

            //Sayfa sayisini 10 belirledim.
            for (int rowValue = 23; rowValue <= 33; rowValue++) {
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 1, 5));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 6, 7));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 8, 10));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 12, 14));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 15, 16));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 17, 19));
            }

            for (int rowValue = 34; rowValue <= 38; rowValue++) {
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 0, 3));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 4, 8));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 9, 13));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 14, 17));
                rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 18, 20));
            }


            //GIVING ALL THE CELLS STYLE
            Excel.styleTheCells(0, 1, 0, 4, rapor, cellStyle1, cellStyle4, cellStyle5);

            Excel.styleTheCells(0, 0, 5, 20, rapor, cellStyle3, cellStyle7, cellStyle6);

            Excel.styleTheCells(1, 1, 5, 20, rapor, cellStyle3, cellStyle7, cellStyle6);


            //From Müşteri to Değerlendiren Standartı cells
            for (int rowValue = 2; rowValue <= 6; rowValue++) {

                Excel.styleTheCells(rowValue, rowValue, 0, 1, rapor, cellStyle2, cellStyle7, cellStyle6);
                Excel.styleTheCells(rowValue, rowValue, 10, 12, rapor, cellStyle2, cellStyle7, cellStyle6);
                Excel.styleTheCells(rowValue, rowValue, 16, 18, rapor, cellStyle2, cellStyle7, cellStyle6);

                Excel.styleTheCells(rowValue, rowValue, 2, 9, rapor, cellStyleText, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 13, 15, rapor, cellStyleText, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 19, 20, rapor, cellStyleText, cellStyle4, cellStyle5);
            }

            Excel.styleTheCells(7, 7, 0, 20, rapor, cellStyleText2, cellStyle7, cellStyle6);

            //From kutup mesafesi to isik mesafesi cells without the rightest cells
            for (int rowValue = 8; rowValue <= 13; rowValue++) {
                Excel.styleTheCells(rowValue, rowValue, 0, 2, rapor, cellStyle2, cellStyle7, cellStyle6);
                Excel.styleTheCells(rowValue, rowValue, 7, 9, rapor, cellStyle2, cellStyle7, cellStyle6);
                Excel.styleTheCells(rowValue, rowValue, 15, 17, rapor, cellStyle2, cellStyle7, cellStyle6);

                Excel.styleTheCells(rowValue, rowValue, 3, 6, rapor, cellStyleText, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 10, 14, rapor, cellStyleText, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 18, 20, rapor, cellStyleText, cellStyle4, cellStyle5);
            }

            Excel.styleTheCells(9, 10, 15, 17, rapor, cellStyleText2, cellStyle7, cellStyle6);

            //Foto cells
            Excel.styleTheCells(14, 18, 0, 4, rapor, cellStyle1, cellStyle4, cellStyle5);
            Excel.styleTheCells(14, 18, 5, 9, rapor, cellStyle1, cellStyle4, cellStyle5);

            Excel.styleTheCells(14, 14, 10, 20, rapor, cellStyle2, cellStyle7, cellStyle6);

            //Süreksizliğin Yeri cells
            Excel.styleTheCells(15, 15, 10, 11, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(16, 16, 10, 11, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(17, 17, 10, 11, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(18, 18, 10, 11, rapor, cellStyleText2, cellStyle7, cellStyle6);
            for (int rowValue = 15; rowValue <= 18; rowValue++) {

                Excel.styleTheCells(rowValue, rowValue, 12, 20, rapor, cellStyle2, cellStyle7, cellStyle6);

            }

            //Standart Sapmalar to acıklamalar cells
            Excel.styleTheCells(19, 19, 0, 4, rapor, cellStyle2, cellStyle7, cellStyle6);
            Excel.styleTheCells(20, 20, 0, 4, rapor, cellStyle2, cellStyle7, cellStyle6);
            Excel.styleTheCells(21, 21, 0, 4, rapor, cellStyle2, cellStyle7, cellStyle6);

            Excel.styleTheCells(19, 19, 5, 20, rapor, cellStyle1, cellStyle4, cellStyle5);
            Excel.styleTheCells(20, 20, 5, 20, rapor, cellStyle1, cellStyle4, cellStyle5);
            Excel.styleTheCells(21, 21, 5, 20, rapor, cellStyle1, cellStyle4, cellStyle5);

            //Gecis2 cells
            Excel.styleTheCells(22, 22, 0, 20, rapor, cellStyleText2, cellStyle7, cellStyle6);

            //Muayene Sonuclari
            siraNoCell.setCellStyle(cellStyle7);
            // Excel.styleTheCells(23,23,0,0,rapor,cellStyleText2,cellStyle7,cellStyle6);
            Excel.styleTheCells(23, 23, 1, 5, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 6, 7, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 8, 10, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 11, 11, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 12, 14, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 15, 16, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 17, 19, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(23, 23, 20, 20, rapor, cellStyleText2, cellStyle7, cellStyle6);

            for (int rowValue = 24; rowValue <= 33; rowValue++) {

                Excel.styleTheCells(rowValue, rowValue, 0, 0, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 1, 5, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 6, 7, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 8, 10, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 11, 11, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 12, 14, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 15, 16, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 17, 19, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 20, 20, rapor, cellStyle1, cellStyle4, cellStyle5);

            }

            //Son Kisim

            Excel.styleTheCells(34, 34, 0, 3, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(35, 35, 0, 3, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(36, 36, 0, 3, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(37, 37, 0, 3, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(38, 38, 0, 3, rapor, cellStyleText2, cellStyle7, cellStyle6);

            Excel.styleTheCells(34, 34, 4, 8, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(34, 34, 9, 13, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(34, 34, 14, 17, rapor, cellStyleText2, cellStyle7, cellStyle6);
            Excel.styleTheCells(34, 34, 18, 20, rapor, cellStyleText2, cellStyle7, cellStyle6);

            for (int rowValue = 35; rowValue <= 38; rowValue++) {

                Excel.styleTheCells(rowValue, rowValue, 4, 8, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 9, 13, rapor, cellStyle1, cellStyle4, cellStyle4);
                Excel.styleTheCells(rowValue, rowValue, 14, 17, rapor, cellStyle1, cellStyle4, cellStyle5);
                Excel.styleTheCells(rowValue, rowValue, 18, 20, rapor, cellStyle1, cellStyle4, cellStyle5);

            }

            //Printing entered values to excel file
            //Row1  //(String) getselection.getselecteditem
            CellUtil.createCell(row1_1, 2, musteriChoiceBox.getValue().toString());
//            CellUtil.createCell(row1_2, 2, projeAdiChoiceBox.getValue().toString());
            CellUtil.createCell(row1_3, 2, testYeriTextField.getText());
            CellUtil.createCell(row1_4, 2, muayeneStandartıTextField.getText());
            CellUtil.createCell(row1_5, 2, değerlendirenStandartıTextField.getText());

            CellUtil.createCell(row1_1, 13, muayeneProsedürüTextField.getText());
            CellUtil.createCell(row1_2, 13, muayeneKapsamıTextField.getText() + "%");
            CellUtil.createCell(row1_3, 13, resimNoTextField.getText());
            //    CellUtil.createCell(row1_4, 13, yuzeyDurumuChoiceBox.getValue().toString());
            //   CellUtil.createCell(row1_5, 13, muayeneAsamasiChoiceBox.getValue().toString());

            CellUtil.createCell(row1_1, 19, sayfaNoTextField.getText());
            CellUtil.createCell(row1_2, 19, raporNoTextField.getText());
            CellUtil.createCell(row1_3, 19, raporTarihiTextField.getText());
            CellUtil.createCell(row1_4, 19, isEmriNoChoiceBox.getValue().toString());
            CellUtil.createCell(row1_5, 19, teklifNoChoiceBox.getValue().toString());

            //Row2
            CellUtil.createCell(row2_1, 3, kutupMesafesiTextField.getText());
            CellUtil.createCell(row2_2, 3, cihazTextField.getText());
            CellUtil.createCell(row2_3, 3, mpTasiyiciOrtamTextField.getText());
            CellUtil.createCell(row2_4, 3, miknatisGiderimiTextField.getText());
            CellUtil.createCell(row2_5, 3, uvIsikSiddetiTextField.getText());
            CellUtil.createCell(row2_6, 3, isikMesafesiTextField.getText());

            CellUtil.createCell(row2_1, 10, muayeneBolgesiTextField.getText());
            CellUtil.createCell(row2_2, 10, akimTipiChoiceBox.getValue().toString());
            CellUtil.createCell(row2_3, 10, luxmetreTextField.getText());
            CellUtil.createCell(row2_4, 10, muayeneOrtamiTextField.getText());
            CellUtil.createCell(row2_5, 10, miknatisGiderimiTextField.getText());
            CellUtil.createCell(row2_6, 10, isilIslemTextField.getText());

            CellUtil.createCell(row2_1, 18, yuzeySicakligiSpinner.getValue().toString() + "°C");
            CellUtil.createCell(row2_2, 18, muayeneBolgesindekiAlanSiddetiTextfield.getText());
            CellUtil.createCell(row2_3, 18, yuzeyTextField.getText());
            CellUtil.createCell(row2_4, 18, isikCihaziTanimiTextField.getText());
            CellUtil.createCell(row2_5, 18, kaldirmaTestiTarihiTextField.getText());


            try {
                FileOutputStream output = new FileOutputStream("test.xls");
                workbook.write(output);
                output.close();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public void initialize() throws  SQLException{



        akimTipiChoiceBox.getItems().addAll("AC","DC");

        SpinnerValueFactory<Integer> yuzeySicakligiValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(-40,60,15);
        yuzeySicakligiSpinner.setValueFactory(yuzeySicakligiValueFactory);
        loadMusteri();


    }

    public void initMusteriData(String musteriAdi) throws SQLException{
        Connection conn = null;
        PreparedStatement statement1 = null;
        ResultSet resultSet = null;
        try {
            conn = Database.getConnenction();

            statement1 = conn.prepareStatement("SELECT*FROM Musteri WHERE musteriAdi = ?");
            statement1.setString(1,musteriAdi);

            resultSet = statement1.executeQuery();

            resultSet.next();
            Musteri musteri = new Musteri(resultSet.getString("MusteriAdi"),
                    resultSet.getString("TestYeri"),
                    resultSet.getString("IsEmriNo"),
                    resultSet.getString("TeklifNo"));
            musteriChoiceBox.setValue(musteri.getMusteriAdi());
            testYeriTextField.setText(musteri.getTestYeri());
            isEmriNoChoiceBox.setValue(musteri.getIsEmriNo());
            teklifNoChoiceBox.setValue(musteri.getTeklifNo());
            musteriAdiLabel.setText(musteri.getMusteriAdi());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) { conn.close(); }
            if(statement1!=null) { statement1.close(); }
            if(resultSet!=null) { resultSet.close(); }

        }
    }

    public void initEkipmanData(String ekipmanAdi) throws SQLException{
        Connection conn = null;
        PreparedStatement statement1 = null;
        ResultSet resultSet = null;
        try {
            conn = Database.getConnenction();

            statement1 = conn.prepareStatement("SELECT*FROM Ekipman WHERE ekipmanAdi = ?");
            statement1.setString(1,ekipmanAdi);

            resultSet = statement1.executeQuery();

            resultSet.next();

            Ekipman ekipman = new Ekipman(resultSet.getString("ekipmanAdi"),
                    resultSet.getString("kutupMesafesi"),
                    resultSet.getString("MPTasiyiciOrtam"),
                    resultSet.getString("MıknatıslamaTeknigi"),
                    resultSet.getString("UVIsikSiddeti"),
                    resultSet.getString("IsikMesafesi"));

            kutupMesafesiTextField.setText(ekipman.getKutupMesafesi());
            cihazTextField.setText(ekipman.getEkipmanAdi());
            mpTasiyiciOrtamTextField.setText(ekipman.getMPTasiyiciOrtam());
            miknatislamaTeknigiTextField.setText(ekipman.getMıknatıslamaTeknigi());
            uvIsikSiddetiTextField.setText(ekipman.getUVIsikSiddeti());
            isikMesafesiTextField.setText(isikMesafesiTextField.getText());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) { conn.close(); }
            if(statement1!=null) { statement1.close(); }
            if(resultSet!=null) { resultSet.close(); }

        }
    }

    public void initOperatorData(String operator) throws  SQLException{
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        for(int i=0; i<operator.length(); i++){
            if(operator.lastIndexOf(" ") == i){
                operatorAdi = operator.substring(0,i);
                operatorSoyadi = operator.substring(i+1,operator.length());
            }
        }

        try{
            conn = Database.getConnenction();

            statement = conn.prepareStatement("SELECT*FROM Calisan WHERE calisanAdi = ? AND calisanSoyadi = ?");
            statement.setString(1,operatorAdi);
            statement.setString(2,operatorSoyadi);

            resultSet = statement.executeQuery();

            resultSet.next();

            Calisan newOperator = new Calisan(resultSet.getString("calisanAdi"),
                    resultSet.getString("calisanSoyadi"),
                    resultSet.getString("calisanLevel"),
                    resultSet.getDate("calisanSertifikaTarihi").toLocalDate());

            operatorAdiLabel.setText(newOperator.getCalisanAdi() + " " + newOperator.getCalisanSoyadi());
            operatorLevelLabel.setText(newOperator.getCalisanLevel());
        }
        catch (Exception e){
            e.getMessage();
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null)  statement.close();
            if(resultSet!=null)  resultSet.close();

        }
    }

    public void initDegerlendirenData(String degerlendiren) throws SQLException{
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        for(int i=0; i<degerlendiren.length(); i++){
            if(degerlendiren.lastIndexOf(" ") == i){
                degerlendirenAdi = degerlendiren.substring(0,i);
                degerlendirenSoyadi = degerlendiren.substring(i+1,degerlendiren.length());
            }
        }

        try{
            conn = Database.getConnenction();

            statement = conn.prepareStatement("SELECT*FROM Calisan WHERE calisanAdi = ? AND calisanSoyadi = ?");
            statement.setString(1,degerlendirenAdi);
            statement.setString(2,degerlendirenSoyadi);

            resultSet = statement.executeQuery();

            resultSet.next();

            Calisan newDegerlendiren = new Calisan(resultSet.getString("calisanAdi"),
                    resultSet.getString("calisanSoyadi"),
                    resultSet.getString("calisanLevel"),
                    resultSet.getDate("calisanSertifikaTarihi").toLocalDate());

            degerlendirenAdiLabel.setText(newDegerlendiren.getCalisanAdi() + " " + newDegerlendiren.getCalisanSoyadi());
            degerlendirenLevelLabel.setText(newDegerlendiren.getCalisanLevel());
        }
        catch (Exception e){
            e.getMessage();
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null)  statement.close();
            if(resultSet!=null)  resultSet.close();
        }
    }

    public void initOnaylayanData(String onaylayan) throws SQLException{
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        for(int i=0; i<onaylayan.length(); i++){
            if(onaylayan.lastIndexOf(" ") == i){
                onaylayanAdi = onaylayan.substring(0,i);
                onaylayanSoyadi = onaylayan.substring(i+1,onaylayan.length());
            }
        }

        try{
            conn = Database.getConnenction();

            statement = conn.prepareStatement("SELECT*FROM Calisan WHERE calisanAdi = ? AND calisanSoyadi = ?");
            statement.setString(1,onaylayanAdi);
            statement.setString(2,onaylayanSoyadi);

            resultSet = statement.executeQuery();

            resultSet.next();

            Calisan newOnaylayan = new Calisan(resultSet.getString("calisanAdi"),
                    resultSet.getString("calisanSoyadi"),
                    resultSet.getString("calisanLevel"),
                    resultSet.getDate("calisanSertifikaTarihi").toLocalDate());


            onaylayanAdiLabel.setText(newOnaylayan.getCalisanAdi() + " " + newOnaylayan.getCalisanSoyadi());
            onaylayanLevelLabel.setText(newOnaylayan.getCalisanLevel());
        }
        catch (Exception e){
            e.getMessage();
        }
        finally {
            if(conn!=null) conn.close();
            if(statement!=null)  statement.close();
            if(resultSet!=null)  resultSet.close();

        }
    }


    public void loadMusteri() throws  SQLException {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = Database.getConnenction();

            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT*FROM Musteri");

            while (resultSet.next()) {
                Musteri newMusteri = new Musteri(resultSet.getString("MusteriAdi"),
                        resultSet.getString("TestYeri"),
                        resultSet.getString("IsEmriNo"),
                        resultSet.getString("TeklifNo"));
                newMusteri.setMusteriID(resultSet.getInt("musteriID"));
                musteriChoiceBox.getItems().add(newMusteri.getMusteriAdi());
                isEmriNoChoiceBox.getItems().add(newMusteri.getIsEmriNo());
                teklifNoChoiceBox.getItems().add(newMusteri.getTeklifNo());
            }

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            if(conn!=null) { conn.close(); }
            if(statement!=null) { statement.close(); }
            if(resultSet!=null) { resultSet.close(); }

        }
    }
   }

