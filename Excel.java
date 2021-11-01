package testcase;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public String[][] run(String xsname) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("C:\\TestLeaf\\MavenProject\\Data\\" + xsname + ".xlsx");
		XSSFSheet sheetAt = wb.getSheet("sheet1");
		int lastRowNum = sheetAt.getLastRowNum();
		int columnCount = sheetAt.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][columnCount];
		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < columnCount; j++) {
				String text = sheetAt.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j] = text;
			}
			wb.close();
		}
		return data;
	}

}
