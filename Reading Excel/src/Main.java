import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("/Users/mohanaditya/Downloads/sampledatafoodsales.xlsx")));
        XSSFSheet sheet = workbook.getSheet("FoodSales");

        for(int rows=0; rows<sheet.getLastRowNum(); rows++){
            for(int columns=1; columns<sheet.getRow(0).getLastCellNum(); columns++){
                System.out.print(sheet.getRow(rows).getCell(columns).toString());
                System.out.print("         ");
            }
            System.out.println();
        }
    }
}