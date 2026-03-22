package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.TestBase;

public class CommonUtils extends TestBase {

    // Common method to capture screenshot
    public static void takeScreenshotAtEndOfTest() throws IOException {
        // 1. Capture the screenshot as a file
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // 2. Set current timestamp for a unique file name
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String currentDir = System.getProperty("user.dir");
        
        // 3. Copy the file to your desired location
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + timestamp + ".png"));
    }
    public static String getTestData(String key) throws FileNotFoundException
    {
    	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata.properties");
    	Properties prop=new Properties();
    	
    	try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return prop.getProperty(key);

    }
    public static String ReadExcel(int row, int column) throws IOException
    {
    	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
    	
    	XSSFWorkbook workbook = new XSSFWorkbook(fis);
    	XSSFSheet sheet=workbook.getSheet("Sheet1");
    	
    	DataFormatter formatter=new DataFormatter();
    	return formatter.formatCellValue(sheet.getRow(row).getCell(column));
    	
    }
}