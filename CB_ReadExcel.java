package crossBrowsers;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CB_ReadExcel {

	public String[][] readData(String fileName) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();

		int cellCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i - 1][j] = text;
			}
		}
		wb.close();
		return data;
	}
} 