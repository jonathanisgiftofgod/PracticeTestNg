package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver; 
	public void launchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void enterText(WebElement id, String text) {
		id.sendKeys(text);
	}
	public void btnClick(WebElement id) {
		id.click();
	}
	public void Clear(WebElement id) {
		id.clear();
	}
	public String readFile(String sheet, int row, int column) throws IOException {
		File f = new File("C:\\Users\\Britto\\eclipse-workspace\\PracticeTestNg\\Excel\\Adactin.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w  = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		CellType cellType = c.getCellType();
		String val = String.valueOf(cellType);
		if (val.equals("String")) {
			String value = c.getStringCellValue();
		} else if(val.equals("Numeric")){
			if (DateUtil.isCellDateFormatted(c)) {
				Date value = c.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String date = format.format(value);
				System.out.println(date);
			} else {
				double d = c.getNumericCellValue();
				long l = (long)d;
				System.out.println(l);
			}
		}
		return val;
	}
}
