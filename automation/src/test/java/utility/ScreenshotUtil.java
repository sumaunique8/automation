package utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {
	WebDriver driver;
	    public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        
	    	TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destination = "screenshots/" + screenshotName + ".png";
	        try {
	            Files.createDirectories(Paths.get("screenshots")); // Ensure the directory exists
	            Files.copy(source.toPath(), Paths.get(destination));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return destination;
	    }
	}

