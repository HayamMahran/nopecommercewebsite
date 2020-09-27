package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Method to take screenshots when the test cases fail
	
	public static void CaptureScreenshots(WebDriver driver, String screenshotname) {
		
		Path destination = Paths.get("./Screenshots", screenshotname+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while Taking a Screenshot"+ e.getMessage());
		}
	}
}
