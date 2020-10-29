package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;
	
	public FileInputStream getFileInputStream() {
		String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.xlsx";
		File srcfile = new File(filepath);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occurred : "+ e.getMessage());
			System.exit(0);
		}
		
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException{
		fis = getFileInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    int TotalNumOfRows = (sheet.getLastRowNum()+1);
		    int TotalNumOfCols = 4;
		    String [][] arrayExcelData = new String[TotalNumOfRows][TotalNumOfCols];
		    
		    for (int i = 0; i < TotalNumOfRows; i++) {
				for (int j = 0; j < TotalNumOfCols; j++) {
					XSSFRow row = sheet.getRow(i);
					arrayExcelData [i][j] = row.getCell(j).toString();
				}
			}
		    workbook.close();
		    return arrayExcelData;
	}
}
