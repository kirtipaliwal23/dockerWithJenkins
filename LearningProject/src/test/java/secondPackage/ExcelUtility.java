package secondPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	public ArrayList<String> getData() throws Exception {
		/*
		 * Apache POI API is used to connect your excel to your java testcase. Required
		 * maven dependencies : poi-ooxml and poi
		 */

		/*
		 * //scenario to test: Identifying Testcases column by scanning the entire 1st row
		 *  once column is identified then scan entire testcase column to identify Purchase testcase row
		 *  After doing this pull ol the data of that row and feed into testcase
		 * 
		 */
		
		
		// Create object for XSSFWorkBook class
		//This XSSFWorkbook expects fileinput stream argument
		// Get access of file
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"Book1.xlsx");
		ArrayList<String> a =new  ArrayList<String>();
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int Sheets = workBook.getNumberOfSheets();
		//Get access to specific sheet
		
		for(int i=0; i<Sheets;i++) {
			
			if(workBook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet Sheet = workBook.getSheetAt(i);
				// Identifying "Testcases" column by scanning the entire 1st row
				Iterator<Row> row = Sheet.iterator(); //Sheet is collection of rows
				Row firstRow=row.next();
				Iterator<Cell> ce = firstRow.iterator();//Row is collection of cells
				int k =0;
				int col = 0;
				while(ce.hasNext()){
					Cell value =ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						col =k;
					}
					k++;
				}
				
				System.out.println("desired col "+ col );
				
				//hasNext() only check if next line is present or not but to move to that line we have to use next()
				while(row.hasNext()) {
					Row r = row.next();
					if(r.getCell(col).getStringCellValue().equalsIgnoreCase("Purchase")) {
						Iterator<Cell> cv = r.iterator();
						
						while(cv.hasNext()) {
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING) {
								a.add(c.getStringCellValue()); 
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue())); 
							}
							
					
						}
					}
				}
			}
			
			
		}
		return a;
		
	}
	public static void main(String[] args){
	

	}

}
