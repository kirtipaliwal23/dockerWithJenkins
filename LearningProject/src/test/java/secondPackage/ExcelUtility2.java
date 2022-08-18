package secondPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"Book1.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int sheets = workBook.getNumberOfSheets();
		ArrayList <String> a = new ArrayList();
		for(int i=0; i<sheets;i++) {
			if(workBook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workBook.getSheetAt(i);
			Iterator<Row> row = sheet.iterator();
		Row r=	row.next();
			Iterator<Cell> cell = r.iterator();
			int k =0;
			int col=0;
			while(cell.hasNext()) {
				Cell value =cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases"));{
					col=k;
				}
				k++;
			}
			System.out.println("col no "+ col);
			while(row.hasNext()) {
				Row rows = row.next();
				if(rows.getCell(col).getStringCellValue().equalsIgnoreCase("DeleteProfile")) {
					System.out.println("Delete profile found");
					Iterator<Cell> cv = rows.iterator();
					while(cv.hasNext()) {
						Cell c =cv.next();
						if(c.getCellType()==CellType.STRING) {
							System.out.println("string");
							a.add(c.getStringCellValue());
						}
						else {
							System.out.println("integer");
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
						
					}
					System.out.println(a);
				}
			}
			
			}
			
		}
			
	}

}
