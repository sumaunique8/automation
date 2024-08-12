//package PageFactory;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class Common_PF {
//	WebDriver driver;
//
//    @FindBy(xpath = "//input[@id='txtBranchId']")
//	WebElement txt_branchid;
//     
//    @FindBy(xpath = "//span[text()='Ricerca e selezione']")
//    WebElement option;
//    
//    public void branchId(String branchid) throws Exception {
//   	 txt_branchid.sendKeys(branchid);
//   	 Thread.sleep(2000);
//   	 txt_branchid.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//    }
//    public void option() {
//    	option.click();
//    }
//    /*constructor gives driver instance
//     * in it method initializes elements
//     * in constructor, driver is the class driver which is calling this class
//     * eg:step definition class calls this class, 
//     * so we have to create an object of this class in stepdef class
//     */
//    public Common_PF(WebDriver driver) {
//   	 this.driver=driver;
//   	 PageFactory.initElements( driver,this);
//   	 /*
//   	  * this refers to class(Common_PF)
//   	  */
//   	PageFactory.initElements( driver,Common_PF.class);
//    }
//}
