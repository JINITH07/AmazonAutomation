package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
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
}