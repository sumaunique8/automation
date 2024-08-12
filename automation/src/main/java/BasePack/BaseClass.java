package BasePack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;

//scripting extends methods reuse extends executingTestcases extends baseclass
public class BaseClass {
	public static WebDriver driver;
	public static Properties obj ;
  //@BeforeMethod
  //public void openBrowser() throws IOException {
	@Before
	 public void setup() throws IOException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumalatha.u\\eclipse-workspace\\NewExtent\\MyBrowsers\\chromedriver.exe");
   driver = new ChromeDriver();
  driver.manage().window().maximize();
  
  FileInputStream fis = new FileInputStream("C:\\Users\\sumalatha.u\\eclipse-workspace\\automation\\src\\main\\resources\\Testdata\\TestData");
   obj = new Properties();
  //to dupm fis data to prop
  obj.load(fis);
  obj.getProperty("URL");
//  System.out.println(obj.getProperty("URL"));
  }
//  @AfterClass
//  public void closeBowser() {
//	  driver.close();
	@After
	public void tear() throws Exception {
		driver.close();
  }
}
