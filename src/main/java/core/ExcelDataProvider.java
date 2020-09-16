package core;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExcelDataProvider {

   public static void readFromExcelFile() throws Exception {
       File file = new File("./files/DataSet_forTest.xlsx");
       FileInputStream fileStream = new FileInputStream(file);
       XSSFWorkbook testDataWorkbook = new XSSFWorkbook();
       //XSSFSheet sheet = testDataWorkbook.getSheetAt(0); //get the INT sheet
       XSSFSheet sheet = testDataWorkbook.getSheet("INT");
       int rowEnd = sheet.getLastRowNum();
       //int rowEnd = sheet.getPhysicalNumberOfRows();
       for (int i=0;i<rowEnd;i++){
           XSSFRow row = sheet.getRow(i);
           int lastCellInRow = row.getPhysicalNumberOfCells();
           for (int j=0;j<lastCellInRow;j++){
               XSSFCell cell = row.getCell(j);
               String cellValue = getCellValue(cell);
               System.out.print("||"+cellValue);
           }
           System.out.println();
       }

       testDataWorkbook.close();
       fileStream.close();

   }


   public static String getCellValue(XSSFCell cell) {
       switch (cell.getCellType()){
           case NUMERIC:
               return String.valueOf(cell.getNumericCellValue());
           case BOOLEAN:
               return String.valueOf(cell.getBooleanCellValue());
           case STRING:
               return cell.getStringCellValue();
           default:
               return cell.getStringCellValue();
       }
   }

    public static List<Map<String, String>> getTestDataInMap() throws IOException {
        List<Map<String,String>> testDataAllRows=null;
        Map<String,String> testData=null;
        FileInputStream fileInputStream=new FileInputStream("./files/DataSet_forTest.xlsx");
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        int lastRowNumber=sheet.getLastRowNum();
        int lastColNumber=sheet.getRow(0).getLastCellNum();
        List list=new ArrayList();
            //go to all columns
            for(int i=0; i<lastColNumber;i++){
                Row row=sheet.getRow(0); //reading all column value of row0
                Cell cell=row.getCell(i);
                String rowHeader = cell.getStringCellValue().trim();
                list.add(rowHeader); //Headers stored in the List
            }
            testDataAllRows=new ArrayList<Map<String,String>>();
               //STARTING ALL ROWS FROM #1 to and. ROW #0 is header
            for (int j=1;j<lastRowNumber;j++){
                Row row=sheet.getRow(j);
                testData=new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
                //each column for every row(j)
                for(int k=0;k<lastColNumber;k++){
                    Cell cell=row.getCell(k);
                    String colValue=cell.getStringCellValue().trim();
                                        //KEY           //VALUE
                    testData.put((String) list.get(k),colValue);
                }
                testDataAllRows.add(testData);
            }

        return testDataAllRows;  //TESTDATA FOR ALL ROWS
    }

/*
    public static void createAndWriteExcelFile() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("INT");
        int totalNumberRows = 5;
        int totalNumberColumns=3;
        sheet.createRow(0);  //create HEADERS
        sheet.getRow(0).createCell(0).setCellValue("Company Role");
        sheet.getRow(0).createCell(1).setCellValue("CompanyID");
        sheet.getRow(0).createCell(2).setCellValue("Email");
        sheet.getRow(0).createCell(3).setCellValue("Phone");
        for(int i=1;i<=totalNumberRows;i++)    {
            sheet.createRow(i);
                for(int j=0;j<=totalNumberColumns;j++){
                    if(j==0){
                    sheet.getRow(i).createCell(j).setCellValue("Tester"+i);
                    }else if (j==1){
                        sheet.getRow(i).createCell(j).setCellValue("89743");
                    }else if (j==2){
                        sheet.getRow(i).createCell(j).setCellValue("example@email.com");
                    }else if (j==3){
                        sheet.getRow(i).createCell(j).setCellValue("34879856");
                    }

                }


        }

        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Hello");
        sheet.getRow(0).createCell(1).setCellValue("World");
        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Dan");
        sheet.getRow(1).createCell(1).setCellValue("Tester");


        FileOutputStream file=new FileOutputStream("C:\\Users\\marinellid\\Automation\\Widzom_May20\\excel_30\\DataSet_test2.xlsx");
        workbook.write(file);
        workbook.close();
   }
*/
}
