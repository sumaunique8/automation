package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;

public class page_pom {

	 WebDriver driver;

//	public static Properties obj;

	    By txt_branchid=By.xpath("//input[@id='txtBranchId']");
        By create_button=By.xpath("//span[text()='Crea Numero Automatico']");
        By userName =By.xpath("//input[@id='textName']");
        By surName = By.xpath("//input[@id='textSurname']");
        By gender = By.xpath("//input[@id='radioSexFemale']");
        By save = By.xpath("//button[@id='buttonSave']");
        By delete = By.xpath("//button[@id='buttonDelete']");
        By confirm = By.xpath("//button[@id='buttonUpdate']");
// Constructor,which maintains session between pom & Stepdef  
     
        public page_pom(WebDriver driver) {
        	/*
        	 * this constructor will be called every time when 
        	 * object is created for this class
        	 */
        	this.driver = driver;
        }
        
        public void branchId(String branchid) throws Exception {
        	WebElement bran = driver.findElement(txt_branchid);
        	Thread.sleep(2000);
        	bran.sendKeys(branchid);
        	Thread.sleep(2000);
        	 bran.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        }
        public void  createbutton() {
        	driver.findElement(create_button).click();
        }
        public void userName(String name) {
        	driver.findElement(userName).sendKeys(name);
        }
        public void surName (String surname) {
        	driver.findElement(surName).sendKeys(surname);
        }
        public void gender() {
        	driver.findElement(gender).click();
        }
        public void save() {
        	driver.findElement(save).click();
        }
        public void delete() {
        	driver.findElement(delete).click();
        }
        public void confirm() {
        	driver.findElement(confirm).click();
        }
//    	public WebElement adecco(String a) throws Exception {
        //
//        		FileInputStream fis = new FileInputStream(
//        				"C:\\Users\\sumalatha.u\\eclipse-workspace\\automation\\src\\main\\resources\\Testdata\\TestData");
//        		obj = new Properties();
//        		obj.load(fis);
        //
//        		return driver.findElement(By.xpath(obj.getProperty(a)));
//        	}

        //public void input() throws IOException {
//        	FileInputStream fis = new FileInputStream("C:\\Users\\sumalatha.u\\eclipse-workspace\\automation\\src\\test\\java\\GlueCode\\TestData");
//            Properties prop = new Properties();
//            prop.load(fis);
//            String print = prop.getProperty("URL");
////            System.out.println(print);
        //
        //}	
        
}
