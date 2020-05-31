package sample;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import java.io.FileOutputStream;

public class Excel {

    public static Workbook createExcelDocument(String name){
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("Rapor");

        return workbook;
    }

        public static void createCells(int rowNumber, int firstCell, int lastCell, Sheet sheet){

            for(int j = firstCell; j <= lastCell; j++){
                sheet.getRow(rowNumber).createCell(j);
            }
        }

        public static void styleTheCells(int firstRow,
                                     int lastRow,
                                     int firstCellIndex,
                                     int lastCellIndex,
                                     Sheet sheet,
                                     CellStyle bottom, CellStyle bottomRight, CellStyle right){

            for(;firstCellIndex < lastCellIndex; firstCellIndex++){
                 sheet.getRow(lastRow).getCell(firstCellIndex).setCellStyle(bottom);
            }
            sheet.getRow(lastRow).getCell(lastCellIndex).setCellStyle(bottomRight);

            if(firstRow!=lastRow) {
                for(;firstRow < lastRow; firstRow++) {
                    sheet.getRow(firstRow).getCell(lastCellIndex).setCellStyle(right);
                }
            }
        }

        public static void printWithDifferentFonts(Cell cell, Workbook workbook, Font turkishFont, Font englishFont){
            String cellValue = cell.getStringCellValue();

            for(int i=0; i < cellValue.length(); i++){
                if(i==cellValue.indexOf("\n")){

                    RichTextString headerRichText = workbook.getCreationHelper().createRichTextString(cellValue);

                    headerRichText.applyFont(0,i,turkishFont);
                    headerRichText.applyFont(i,cellValue.length(),englishFont);

                    cell.setCellValue(headerRichText);
                    break;
                }

                else if(i==cellValue.indexOf("/")){
                    RichTextString headerRichText = workbook.getCreationHelper().createRichTextString(cellValue);

                    headerRichText.applyFont(0,i,turkishFont);
                    headerRichText.applyFont(i,cellValue.length(),englishFont);

                    cell.setCellValue(headerRichText);
                    break;
                }
            }
        }
}
