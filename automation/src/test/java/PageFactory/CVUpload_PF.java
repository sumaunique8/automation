package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CVUpload_PF {
	
	WebDriver diver;
	
     
     
     @FindBy(xpath ="//span[text()='Crea Numero Automatico']" )
     WebElement create_button;
     
     @FindBy(xpath = "//input[@id='textName']")
     WebElement userName;
     
	private Object driver;
     
    
     
     public void  createbutton() {
     	create_button.click();
     }
     public void userName(String UserName ) {
     	userName.sendKeys(UserName);
     }
     
     public CVUpload_PF(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements( driver,this);
     }
}
