package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLdata {

	
//	@DataProvider(name = "testDataFromExcel")
	public static Object[][] getData(String excelName, String excelSheetName) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Test Data\\"+excelName+".xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);


		Object testData[][] = new String[sheetName.getLastRowNum()] [sheetName.getRow(0).getLastCellNum()];
		for(int i=0; i < sheetName.getLastRowNum(); i++) {
			for(int j=0;j<sheetName.getRow(0).getLastCellNum(); j++) {
				testData[i] [j] = sheetName.getRow(i+1).getCell(j).toString();
			}
		}

		return testData;

	}

}
