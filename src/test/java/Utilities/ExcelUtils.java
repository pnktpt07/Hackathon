package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import testBase.BaseClass;

public class ExcelUtils extends BaseClass {


	String excelFilePath = "C:\\Users\\2303503\\eclipse-workspace\\Hackathon-Project\\testData\\homeloan.xlsx";
	public void writeToExcel(List<List<String>> tableData) {

		try{

			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("TableData");
			for(int i =0; i< tableData.size(); i++){
				Row row =sheet.createRow(i);
				for(int j = 0; j< tableData.get(i).size(); j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(tableData.get(i).get(j));
				}
			}

			FileOutputStream fileOut = new FileOutputStream(excelFilePath);
			workbook.write(fileOut);
			workbook.close();
			fileOut.close();
			System.out.println("Excel Writing is Done!!!!!");	

		} catch(IOException e) {
			e.printStackTrace();

		}

	}


}

