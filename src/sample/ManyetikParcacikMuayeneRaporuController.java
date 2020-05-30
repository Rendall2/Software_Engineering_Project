package sample;


import javafx.event.ActionEvent;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;



import java.io.FileOutputStream;

import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;


public class ManyetikParcacikMuayeneRaporuController {



    public void exceleAktarButtonPushed(ActionEvent event) throws  Exception {
        Workbook workbook = Excel.createExcelDocument("test.xls");
        Sheet rapor = workbook.getSheet("Rapor");

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
        row5_10.setHeight((short)500);
        row5_11.setHeight((short)500);

        row6_1.setHeight((short) 620);
        row6_2.setHeight((short) 620);
        row6_3.setHeight((short) 620);
        row6_4.setHeight((short) 620);
        row6_5.setHeight((short) 1400);




        //Adjusting the Column widths
        rapor.setColumnWidth(0,2280);   //A
        rapor.setColumnWidth(1,3120);   //B
        rapor.setColumnWidth(2,270);    //C
        rapor.setColumnWidth(3,1300);   //D
        rapor.setColumnWidth(4,1440);   //E
        rapor.setColumnWidth(5,1050);   //F
        rapor.setColumnWidth(6,2460);   //G
        rapor.setColumnWidth(7,1720);   //H
        rapor.setColumnWidth(8,2180);   //I
        rapor.setColumnWidth(9,2530);   //J
        rapor.setColumnWidth(10,960);   //K
        rapor.setColumnWidth(11,3200);  //L
        rapor.setColumnWidth(12,1465);  //M
        rapor.setColumnWidth(13,1270);  //N
        rapor.setColumnWidth(14,1460);  //O
        rapor.setColumnWidth(15,3200);  //P
        rapor.setColumnWidth(16,910);   //Q
        rapor.setColumnWidth(17,1820);  //R
        rapor.setColumnWidth(18,1550);  //S
        rapor.setColumnWidth(19,2100);  //T
        rapor.setColumnWidth(20,3290);  //U


        //Creating all the Cells
        for(int rowNumber=0; rowNumber <=38;rowNumber++){
            Excel.createCells(rowNumber,0,20,rapor);
        }




        //GIVING CELLS TEXT VALUES
            //Header
        Cell gözetimMuayeneEğitimHizmetleriCell = CellUtil.createCell(rowTitle1,5, "GÖZETİM MUAYENE VE EGİTİM HİZMETLERİ");
        Cell manyetikParcacikMuayeneRaporuCell = CellUtil.createCell(rowTitle2,5, "MANYETİK PARÇACIK MUAYENE RAPORU\nMAGNETIC PARTICLE INSPECTION REPORT");

            //row1
        Cell musteriCell = CellUtil.createCell(row1_1,0, "Müşteri\nCustomer");
        Cell projeAdiCell = CellUtil.createCell(row1_2,0, "Proje Adi\nProject Name");
        Cell testYeriCell = CellUtil.createCell(row1_3,0, "Test yeri\nInspection Place");
        Cell muayeneStandartıCell = CellUtil.createCell(row1_4,0, "Muayene Standartı\nInspection Standart");
        Cell değerlendirenStandartıCell = CellUtil.createCell(row1_5,0, "Değerlendiren Standartı\nEvaluation Standart");

        Cell muayeneProsedürüCell = CellUtil.createCell(row1_1,10, "Muayene Prosedürü\nInspection Procedure");
        Cell muayeneKapsamiCell = CellUtil.createCell(row1_2,10, "Muayene Kapsami\nInspection Scope");
        Cell resimNoCell = CellUtil.createCell(row1_3,10, "Resim No\nDrawing No");
        Cell yüzeyDurumuCell = CellUtil.createCell(row1_4,10, "Yüzey Durumu\nSurface Condition");
        Cell muayeneAsamasiCell = CellUtil.createCell(row1_5,10, "Muayene Aşaması\nStage of Examination");

        Cell sayfaNoCell = CellUtil.createCell(row1_1,16, "Sayfa no\nPage");
        Cell raporNoCell = CellUtil.createCell(row1_2,16, "Rapor No\nReport No");
        Cell raporTarihiCell = CellUtil.createCell(row1_3,16, "Rapor tarihi\nReport Date");
        Cell isEmriNoCell = CellUtil.createCell(row1_4,16, "İş Emri No\nJob Order No");
        Cell teklifNoCell = CellUtil.createCell(row1_5,16, "Teklif No\nOffer No");

            //gecis1
        Cell ekipmanBilgileriCell = CellUtil.createCell(rowGecis1,0, "Ekipman Bilgeri/Equipment Informations");

            //row2
        Cell kutupMesafesiCell = CellUtil.createCell(row2_1,0, "Kutup mesafesi, mm\nPole Distance");
        Cell cihazCell = CellUtil.createCell(row2_2,0, "Cihaz\nEquipment");
        Cell mpTasiyiciOrtamCell = CellUtil.createCell(row2_3,0, "MP Taşıyıcı Ortam\nMP Carrier Medium");
        Cell mıknatislamaTeknigiCell = CellUtil.createCell(row2_4,0, "Mıknatıslama Tekniği\nMag. Tech.");
        Cell uvIsikSiddettiCell = CellUtil.createCell(row2_5,0, "UV Işık Şiddeti\nUV Light Intensity");
        Cell isikMesafesiCell = CellUtil.createCell(row2_6,0, "Işık Mesafesi\nDistance of Light");

        Cell muayeneBölgesiCell = CellUtil.createCell(row2_1,7, "Muayene Bölgesi\nExamination Area");
        Cell akimTipiCell = CellUtil.createCell(row2_2,7, "Akım Tipi\nCurrent Type");
        Cell luxmetreCell = CellUtil.createCell(row2_3,7, "Luxmetre/Işık Şiddeti\nLuxmeter");
        Cell muayeneOrtamiCell = CellUtil.createCell(row2_4,7, "Muayene Ortamı\nTest Medium");
        Cell miknatisGiderimiCell = CellUtil.createCell(row2_5,7, "Mıknatıs Giderimi\nDemagnelization");
        Cell isilIslemCell = CellUtil.createCell(row2_6,7, "Isıl İşlem\nHeat Treatment");

        Cell yuzeySicakligiCell = CellUtil.createCell(row2_1,15, "Yüzey Sıcaklığı(°C)\nSurface Temperature");
        Cell muayeneBölgesiAlanSiddetiCell = CellUtil.createCell(row2_2,15, "Muayene Bölgesi Alan Şiddeti, kA/m\nGauss Field Strength\n");
        Cell yüzeyCell = CellUtil.createCell(row2_4,15, "Yüzey\nSurface Condition");
        Cell isikCihaziTanimiCell = CellUtil.createCell(row2_5,15, "Işık Cihazı Tanımı\nIdentification of Light Equip.");
        Cell kaldirmaTestiTarihCell = CellUtil.createCell(row2_6,15, "Kaldırma Testi No / Lifting Case No\nTarih / Date");


            //row3
        Cell sureksizliginYeriCell =  CellUtil.createCell(row3_1,10, "Süreksizliğin Yeri / Location of Discontinuity");
        Cell bmCell =  CellUtil.createCell(row3_2,10, "BM");
        Cell wCell =  CellUtil.createCell(row3_3,10, "W");
        Cell hazCell =  CellUtil.createCell(row3_4,10, "HAZ");
        Cell bCell =  CellUtil.createCell(row3_5,10, "B");
        Cell anaMetalCell =  CellUtil.createCell(row3_2,12, "Ana Metal / Base Metal");
        Cell isidanEtkilenenBölgeCell= CellUtil.createCell(row3_3,12, "Isıdan etkilenen bölge / Heat affected zone");
        Cell kaynakCell = CellUtil.createCell(row3_4,12, "Kaynak / Weld");
        Cell kaynakAgziCell = CellUtil.createCell(row3_5,12, "Kaynak ağzı / Bevel");


            //row4
        Cell standartSapmalarCell = CellUtil.createCell(row4_1,0, "Standart Sapmalar\nStandart Deviations");
        Cell muayeneTarihleriCell = CellUtil.createCell(row4_2,0, "Muayene Tarihleri\nInspection Results");
        Cell aciklamalarVeEklerCell = CellUtil.createCell(row4_3,0, "Açıklamalar ve Ekler\nDescriptions and Attachments");

            //gecis2
        Cell muayeneSonuclariCell = CellUtil.createCell(rowGecis2,0,"Muayene Sonuçları / Inspection Results");


            //row5
        Cell siraNoCell = CellUtil.createCell(row5_1,0, "Sıra No\nSerial No");
        Cell kaynakParcaNoCell = CellUtil.createCell(row5_1,1, "Kaynak-Parça No\nWeld/Piece No");
        Cell kontrolUzunluguCell = CellUtil.createCell(row5_1,6, "Kontrol Uzun.\nTest Length");
        Cell kaynakYonCell = CellUtil.createCell(row5_1,8, "Kaynak Yön.\nWelding Process");
        Cell kalınlıkCell = CellUtil.createCell(row5_1,11, "Kalınlık (mm)\nThickness");
        Cell capCell = CellUtil.createCell(row5_1,12, "Çap (mm)\nDiameter");
        Cell hataninTipiCell = CellUtil.createCell(row5_1,15, "Hata Tipi\nDefect Type");
        Cell hataninYeriCell = CellUtil.createCell(row5_1,17, "Hatanın yeri\nDefect Location");
        Cell sonucCell = CellUtil.createCell(row5_1,20, "Sonuç\nResult");


            //row6
        Cell personelBilgeriCell = CellUtil.createCell(row6_1,0, "Personel Bilgileri / Person. Infor.");
        Cell operator = CellUtil.createCell(row6_1,4, "Operatör / Operator");
        Cell degerlendirenCell = CellUtil.createCell(row6_1,9, "Degerlendiren / Evaluated by");
        Cell onayCell = CellUtil.createCell(row6_1,14, "Onay / Confirmation");
        Cell musteriCell2 = CellUtil.createCell(row6_1,18, "Müşteri / Customer");

        Cell adiSoyadıCell = CellUtil.createCell(row6_2,0, "Adı Soyadı / Name Surname");
        Cell seviyeCell = CellUtil.createCell(row6_3,0, "Seviye / Level");
        Cell tarihCell = CellUtil.createCell(row6_4,0, "Tarih / Date");
        Cell imzaCell = CellUtil.createCell(row6_5,0, "İmza / Signature");


        //PRINTING TEXTS WITH DIFFERENT FONTS BY TURKISH AND ENGLISH
            //Header
        Excel.printWithDifferentFonts(manyetikParcacikMuayeneRaporuCell,workbook,fontHeader2,fontHeader3);

            //Row1
        Excel.printWithDifferentFonts(musteriCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(projeAdiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(testYeriCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(muayeneStandartıCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(değerlendirenStandartıCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(muayeneProsedürüCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(muayeneKapsamiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(resimNoCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(yüzeyDurumuCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(muayeneAsamasiCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(sayfaNoCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(raporNoCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(raporTarihiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(isEmriNoCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(teklifNoCell,workbook,fontText1,fontText2);

            //Gecis1
        Excel.printWithDifferentFonts(ekipmanBilgileriCell,workbook,fontText1,fontText2);

            //Row2
        Excel.printWithDifferentFonts(kutupMesafesiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(cihazCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(mpTasiyiciOrtamCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(mıknatislamaTeknigiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(uvIsikSiddettiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(isikMesafesiCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(muayeneBölgesiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(akimTipiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(luxmetreCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(muayeneOrtamiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(miknatisGiderimiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(isilIslemCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(yuzeySicakligiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(muayeneBölgesiAlanSiddetiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(yüzeyCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(isikCihaziTanimiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(uvIsikSiddettiCell,workbook,fontText1,fontText2);

        RichTextString kaldirmaTestiTarihRichText = workbook.getCreationHelper().createRichTextString("Kaldırma Testi No/Lifting Case\n" + "Tarih / Date");
        kaldirmaTestiTarihRichText.applyFont(0,17,fontText1);
        kaldirmaTestiTarihRichText.applyFont(17,30,fontText2);
        kaldirmaTestiTarihRichText.applyFont(31,36,fontText1);
        kaldirmaTestiTarihRichText.applyFont(37,43,fontText2);

        kaldirmaTestiTarihCell.setCellValue(kaldirmaTestiTarihRichText);

            //Row3
        Excel.printWithDifferentFonts(sureksizliginYeriCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(bmCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(hazCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(wCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(bCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(anaMetalCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(isidanEtkilenenBölgeCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(kaynakCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(kaynakAgziCell,workbook,fontText1,fontText2);

            //Row4
        Excel.printWithDifferentFonts(standartSapmalarCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(muayeneTarihleriCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(aciklamalarVeEklerCell,workbook,fontText1,fontText2);

            //gecisRow
        Excel.printWithDifferentFonts(muayeneSonuclariCell,workbook,fontText1,fontText2);

            //Row5
        Excel.printWithDifferentFonts(siraNoCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(kaynakParcaNoCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(kontrolUzunluguCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(kaynakYonCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(kalınlıkCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(capCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(hataninTipiCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(hataninYeriCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(sonucCell,workbook,fontText1,fontText2);

            //Row6
        Excel.printWithDifferentFonts(personelBilgeriCell,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(operator,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(degerlendirenCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(onayCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(musteriCell2,workbook,fontText1,fontText2);

        Excel.printWithDifferentFonts(adiSoyadıCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(seviyeCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(tarihCell,workbook,fontText1,fontText2);
        Excel.printWithDifferentFonts(imzaCell,workbook,fontText1,fontText2);

        //Merging all the cells
        rapor.addMergedRegion(new CellRangeAddress(0, 1, 0, 4));
        rapor.addMergedRegion(new CellRangeAddress(0, 0, 5, 20));


        rapor.addMergedRegion(new CellRangeAddress(1, 1, 5, 20));

            //A small code shortening with using 'for' for merging the cells
        for(int rowValue = 2; rowValue < 7; rowValue++){
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
        for(int rowValue = 23; rowValue <= 33; rowValue++){
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 1, 5));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 6, 7));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 8, 10));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 12, 14));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 15, 16));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 17, 19));
        }

        for(int rowValue = 34; rowValue <= 38; rowValue++){
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 0, 3));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 4, 8));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 9, 13));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 14, 17));
            rapor.addMergedRegion(new CellRangeAddress(rowValue, rowValue, 18, 20));
        }



        //GIVING ALL THE CELLS STYLE
        Excel.styleTheCells(0,1,0,4,rapor,cellStyle1,cellStyle4,cellStyle5);

        Excel.styleTheCells(0,0,5,20,rapor,cellStyle3,cellStyle7,cellStyle6);

        Excel.styleTheCells(1,1,5,20,rapor,cellStyle3,cellStyle7,cellStyle6);


        //From Müşteri to Değerlendiren Standartı cells
        for(int rowValue = 2; rowValue <= 6; rowValue++){

            Excel.styleTheCells(rowValue,rowValue,0,1,rapor,cellStyle2,cellStyle7,cellStyle6);
            Excel.styleTheCells(rowValue,rowValue,10,12,rapor,cellStyle2,cellStyle7,cellStyle6);
            Excel.styleTheCells(rowValue,rowValue,16,18,rapor,cellStyle2,cellStyle7,cellStyle6);

            Excel.styleTheCells(rowValue,rowValue,2,9,rapor,cellStyleText,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,13,15,rapor,cellStyleText,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,19,20,rapor,cellStyleText,cellStyle4,cellStyle5);
        }

        Excel.styleTheCells(7,7,0,20,rapor,cellStyleText2,cellStyle7,cellStyle6);

        //From kutup mesafesi to isik mesafesi cells without the rightest cells
        for(int rowValue = 8; rowValue <=13; rowValue++){
            Excel.styleTheCells(rowValue,rowValue,0,2,rapor,cellStyle2,cellStyle7,cellStyle6);
            Excel.styleTheCells(rowValue,rowValue,7,9,rapor,cellStyle2,cellStyle7,cellStyle6);
            Excel.styleTheCells(rowValue,rowValue,15,17,rapor,cellStyle2,cellStyle7,cellStyle6);

            Excel.styleTheCells(rowValue,rowValue,3,6,rapor,cellStyleText,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,10,14,rapor,cellStyleText,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,18,20,rapor,cellStyleText,cellStyle4,cellStyle5);
        }

        Excel.styleTheCells(9,10,15,17,rapor,cellStyleText2,cellStyle7,cellStyle6);

        //Foto cells
        Excel.styleTheCells(14,18,0,4,rapor,cellStyle1,cellStyle4,cellStyle5);
        Excel.styleTheCells(14,18,5,9,rapor,cellStyle1,cellStyle4,cellStyle5);

        Excel.styleTheCells(14,14,10,20,rapor,cellStyle2,cellStyle7,cellStyle6);

        //Süreksizliğin Yeri cells
        Excel.styleTheCells(15,15,10,11,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(16,16,10,11,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(17,17,10,11,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(18,18,10,11,rapor,cellStyleText2,cellStyle7,cellStyle6);
        for(int rowValue = 15; rowValue <= 18; rowValue++){

            Excel.styleTheCells(rowValue,rowValue,12,20,rapor,cellStyle2,cellStyle7,cellStyle6);

        }

        //Standart Sapmalar to acıklamalar cells
        Excel.styleTheCells(19,19,0,4,rapor,cellStyle2,cellStyle7,cellStyle6);
        Excel.styleTheCells(20,20,0,4,rapor,cellStyle2,cellStyle7,cellStyle6);
        Excel.styleTheCells(21,21,0,4,rapor,cellStyle2,cellStyle7,cellStyle6);

        Excel.styleTheCells(19,19,5,20,rapor,cellStyle1,cellStyle4,cellStyle5);
        Excel.styleTheCells(20,20,5,20,rapor,cellStyle1,cellStyle4,cellStyle5);
        Excel.styleTheCells(21,21,5,20,rapor,cellStyle1,cellStyle4,cellStyle5);

        //Gecis2 cells
        Excel.styleTheCells(22,22,0,20,rapor,cellStyleText2,cellStyle7,cellStyle6);

        //Muayene Sonuclari
        siraNoCell.setCellStyle(cellStyle7);
       // Excel.styleTheCells(23,23,0,0,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,1,5,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,6,7,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,8,10,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,11,11,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,12,14,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,15,16,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,17,19,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(23,23,20,20,rapor,cellStyleText2,cellStyle7,cellStyle6);

        for(int rowValue = 24; rowValue <= 33; rowValue++){

            Excel.styleTheCells(rowValue,rowValue,0,0,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,1,5,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,6,7,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,8,10,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,11,11,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,12,14,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,15,16,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,17,19,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,20,20,rapor,cellStyle1,cellStyle4,cellStyle5);

        }

        //Son Kisim

        Excel.styleTheCells(34,34,0,3,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(35,35,0,3,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(36,36,0,3,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(37,37,0,3,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(38,38,0,3,rapor,cellStyleText2,cellStyle7,cellStyle6);

        Excel.styleTheCells(34,34,4,8,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(34,34,9,13,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(34,34,14,17,rapor,cellStyleText2,cellStyle7,cellStyle6);
        Excel.styleTheCells(34,34,18,20,rapor,cellStyleText2,cellStyle7,cellStyle6);

        for(int rowValue = 35; rowValue <= 38; rowValue++){

            Excel.styleTheCells(rowValue,rowValue,4,8,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,9,13,rapor,cellStyle1,cellStyle4,cellStyle4);
            Excel.styleTheCells(rowValue,rowValue,14,17,rapor,cellStyle1,cellStyle4,cellStyle5);
            Excel.styleTheCells(rowValue,rowValue,18,20,rapor,cellStyle1,cellStyle4,cellStyle5);

        }


        try{
            FileOutputStream output = new FileOutputStream("test.xls");
            workbook.write(output);
            output.close();
            workbook.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
