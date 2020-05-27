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

        Font fontHeader1 = workbook.createFont();
        fontHeader1.setItalic(true);
        fontHeader1.setBold(true);
        fontHeader1.setFontHeightInPoints((short) 15);
        fontHeader1.setColor(IndexedColors.DARK_RED.getIndex());

        //The main empty cell style
        cellStyle1.setBorderBottom(BorderStyle.THICK);
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setAlignment(CENTER);

        //The main rosa cell style with text

        //Header1 cell style
        cellStyle2.setBorderBottom(BorderStyle.THICK);
        cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle2.setAlignment(CENTER);
        cellStyle2.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cellStyle2.setFont(fontHeader1);

        //It is for the last cells of my function doTheFancyStuff(It also outlines the right side of the Cell)
        cellStyle3.setBorderBottom(BorderStyle.THICK);
        cellStyle3.setBorderRight(BorderStyle.THICK);

        //It thickens the right Corner of the Cell only
        cellStyle5.setBorderRight(BorderStyle.THICK);

        //Creating the rows and setting their heights
        Row rowTitle1 = rapor.createRow(0);
        Row rowTitle2 = rapor.createRow(1);
        rowTitle1.setHeight((short) 700);
        rowTitle2.setHeight((short) 900);


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
        Excel.createCells(0,0,20,rapor);
        Excel.createCells(1,0,20,rapor);


        //Printing values
        Cell gözetimMuayeneEğitimHizmetleri = CellUtil.createCell(rowTitle1,4, "Gözetim Muayene ve Eğitim Hizmetleri");



        //Merging all the cells
        rapor.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
        rapor.addMergedRegion(new CellRangeAddress(0, 0, 4, 20));
        rapor.addMergedRegion(new CellRangeAddress(1, 1, 4, 20));



        //Giving the cells style
        Excel.doTheFancyStuff(0,1,0,3,rapor,cellStyle1,cellStyle3,cellStyle5);
        Excel.doTheFancyStuff(0,0,0,3,rapor,cellStyle1,cellStyle3,cellStyle5);
        Excel.doTheFancyStuff(0,0,4,20,rapor,cellStyle2,cellStyle3,cellStyle5);



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
