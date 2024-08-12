package GlueCode;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import PageFactory.Common_PF;
import PageObjects.page_pom;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ScreenshotUtil;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CVCheckSteps  {
	public WebDriver driver=null;
 ExtentReports extent;
 ExtentTest extentTest ;
 File file;
 page_pom pom;
// Common_PF cpf = new Common_PF(driver);
 @Before
 public void setup() throws Exception {
	 System.out.println("Browser is opened");
	  extent = new ExtentReports();
	  File file  = new File(System.getProperty("user.dir")+"\\ExtentReports\\report.html");
//	  ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	  ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
	 extent.attachReporter(sparkReporter);
	 extentTest = extent.createTest(Scenario.getGherkinName());
 }
@After
public void tear() throws Exception {
//	driver.close();
	System.out.println("Browser closed");
	extent.flush();
//	Desktop.getDesktop().browse(file.toURI());

    }
public void testWithScreenshot() {
    // Your test steps here
	UUID randomUUID = UUID.randomUUID();
    // Convert the UUID to a string
//    String randomID = randomUUID.toString();
    
    // Capture screenshot and add to report
    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, randomUUID.toString());
    extentTest.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//    extentTest.pass("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
}
public void highlightElement(WebDriver driver, WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].style.border='3px solid red'", element);
}
@Given("Browser is opened")
public void browser_is_opened() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver" , "C:\\Users\\sumalatha.u\\eclipse-workspace\\automation\\MyBrowsers\\chromedriver.exe");
	 driver = new ChromeDriver();
//	System.setProperty("webdriver.edge.driver", "E:\\New folder\\edgedriver_win64\\msedgedriver.exe");
//	driver = new EdgeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	System.out.println("Chrome browser started successfully");
	Thread.sleep(5000);
	testWithScreenshot();

}
@When("User search for Application URL")
public void user_search_for_application_url() throws InterruptedException {
	driver.get("https://testcl-oleweb.adecco.it/login31.asp");
	Thread.sleep(5000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	String AppTitle = driver.getTitle();
	System.out.println("Application Title is :"+AppTitle);	
	System.out.println("User logged into application successfully");
	testWithScreenshot();
	Thread.sleep(2000);
}

@Then("^Switch to Frame(.*)$")
public void switch_to_frame1(String parentframe) throws InterruptedException {
	driver.switchTo().frame(driver.findElement(By.id(parentframe)));
	Thread.sleep(10000);
}

@When("^User select Branch(.*)$")
public void user_select_branch(String branch) throws Exception {
	//Brach selection
	 pom= new page_pom(driver);
	pom.branchId(branch);
//	WebElement textfield = driver.findElement(By.xpath("//input[@id='txtBranchId']")); // Replace with your actual XPath
//	textfield.click();
//	textfield.sendKeys(branch);
//    Thread.sleep(2000);
//    textfield.sendKeys( Keys.ARROW_DOWN, Keys.ENTER);
//    Thread.sleep(2000);
//    testWithScreenshot();
//    Thread.sleep(2000);
}

@Then("^Click on main menu(.*)$")
public void click_on_main_menu(String MainMenu) throws Exception {
	WebElement main_menu = driver.findElement(By.xpath("//a[text()='"+MainMenu+"']"));
	highlightElement(driver, main_menu);
	main_menu.click();
	Thread.sleep(2000);
    testWithScreenshot();
    Thread.sleep(2000);
}

@Then("^Click on sub menu(.*)$")
public void click_onsub_menu(String submenu) throws Exception {
	WebElement sub_menu = driver.findElement(By.xpath("//a[text()='"+submenu+"']"));	
	highlightElement(driver, sub_menu);
	sub_menu.click();
	Thread.sleep(3000);
	testWithScreenshot();
	Thread.sleep(3000);
    
}

@Then("Click on Crea Numero Automatico button")
public void click_on_crea_numero_automatico_button() throws Exception {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
    pom.createbutton();
	
//	WebElement create_button = driver.findElement(By.xpath("//span[text()='Crea Numero Automatico']"));
//    highlightElement(driver,create_button);
//    Thread.sleep(2000);
//    create_button.click();
//    testWithScreenshot();
//    Thread.sleep(2000);
}

@Then("Enter UserName(.*)$")
public void enter_user_name(String name) throws InterruptedException {
	
	pom.userName(name);
	
	
//	WebElement username = driver.findElement(By.xpath("//input[@id='textName']"));
//    username.sendKeys("test013");
//    Thread.sleep(2000);
//    String UserName = username.getText();
//    System.out.println("User name is :" + UserName);
}

@Then("Enter SurName(.*)$")
public void enter_sur_name(String surname) throws InterruptedException {
	
	pom.surName(surname);
//	WebElement surname = driver.findElement(By.xpath("//input[@id='textSurname']"));
//    surname.sendKeys("test009");
//    Thread.sleep(2000);
//    String Surname = surname.getText();
//    System.out.println("Surname is :"+Surname);
}

@Then("Select Gender")
public void select_gender() throws InterruptedException {

	WebElement gender =  driver.findElement(By.xpath("//input[@id='radioSexFemale']"));
    gender.click();
    Thread.sleep(2000);
}

@Then("Enter DOB")
public void enter_dob() throws InterruptedException {
	WebElement birthcalendar = driver.findElement(By.xpath("//input[@id='datepickerBirthPlace']"));
	birthcalendar.click();
//    LocalDate birth = LocalDate.now();
//    String birthDate = birth.format(DateTimeFormatter.ofPattern("1999-07-22"));
//    WebElement birthElement = driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over ']"));
//    WebElement birthElement = driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over ']"));//25
      WebElement birthElement = driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over '] "));
    Thread.sleep(2000);
    birthElement.click();
    Thread.sleep(2000);
}

@Then("Enter Address_Town")
public void enter_address_town() throws InterruptedException {
	WebElement address = driver.findElement(By.xpath("//input[@id='textAddressTown']"));
    address.click();
    address.sendKeys("NAPOLI");
    Thread.sleep(2000);
    address.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    Thread.sleep(6000);
}

@Then("Enter AddressStreet")
public void enter_address_street() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='textAddressStreet']")).sendKeys("prueba");//address
    Thread.sleep(2000);
}

@Then("Enter Contact Number")
public void enter_contact_number() throws InterruptedException {
	WebElement phone = driver.findElement(By.xpath("//input[@id='textMobile']"));
	phone.sendKeys("987654221");
	Thread.sleep(2000);
	String Phone = phone.getText();
	System.out.println("Contact Number :"+phone);
}

@Then("Enter E-mail")
public void enter_e_mail() throws InterruptedException {
	UUID randomUUID = UUID.randomUUID();
    // Convert the UUID to a string and take the first part before the dash
    String randomID = randomUUID.toString().split("-")[0];
    // Define the domain part of the email
    String domain = "gmail.com"; // Change this to any domain you want

    // Concatenate the randomID and the domain to form the email
    String email_gen = randomID + "@" + domain;
    
     System.out.println(email_gen);
	
	WebElement email = driver.findElement(By.xpath("//input[@id='textEmail']"));
//	email.sendKeys("test48@gmail.com");
	email.sendKeys(email_gen);
	Thread.sleep(2000);
//	String Email = email.getText();
//	System.out.println("E-mail : "+Email);
//	Thread.sleep(2000);
}

@Then("Enter profession")
public void enter_profession() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='buttonProfessione']")).click();
	Thread.sleep(2000);	
}

//@Then("Switch to ChildFrame")
//public void switch_to_childframe() {
//	driver.switchTo().frame(driver.findElement(By.id("TB_iframeContent")));
//}
@Then ("Select Area Proffession")
public void select_AreaProffession() {
	driver.findElement(By.xpath("//select[@id='selectProfessionalCategoriesGrandFather']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
}
@Then ("Select Sotto-Area Professionale")
public void select_SottoArea_Professionale() {
	driver.findElement(By.xpath("//select[@id='selectProfessionalCategoriesFather']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    driver.findElement(By.xpath("//select[@id='selectProfessionalCategories']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
}
@Then ("Click on Confirm button on ChildFrame")
public void click_on_confirm_button_on_ChildFrame() throws Exception {
	driver.findElement(By.xpath("//input[@value='Conferma']")).click();
	Thread.sleep(2000);
	testWithScreenshot();
	Thread.sleep(2000);
}
@Then ("Switch to Default frame")
public void switch_to_Default_frame() throws Exception {
	driver.switchTo().parentFrame();
    Thread.sleep(3000);
}
@Then ("Select Fonte di reclutamento")
public void select_Fonte_di_reclutamento() throws Exception {
	WebElement profession = driver.findElement(By.xpath("//select[@id='selectAssociateSourceFather']"));
	profession.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	Thread.sleep(2000);
	String Profession = profession.getText();
	System.out.println("profession is : "+Profession);
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//select[@id='selectAssociateSource']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    Thread.sleep(5000);
}
//@Then ("Switch to ChildFrame2")
//public  void switch_to_ChildFrame2() throws Exception {
//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iFrameInsertCV']")));
//    Thread.sleep(2000);
//}
@Then ("Upload CV on Curriculum Vitae in allegato")
public void upload_CV_on_Curriculumn_vitae_in_allegato() throws Exception {
	driver.findElement(By.xpath("//input[@value='Carica CV']//preceding::input")).sendKeys("C:\\Users\\sumalatha.u\\Documents\\Adecco\\credentials.txt");
	driver.findElement(By.xpath("//input[@value='Carica CV']")).click();
    Thread.sleep(2000);
    testWithScreenshot();
    Thread.sleep(2000);
}
@Then ("Select Option Presa visione on Dichiarazione di Consenso")
public void select_Option_presa_visione_on_Dichiarazione_di_Consenso() {
	
	driver.findElement(By.xpath("//input[@id='rdnPrivacy']")).click();
}
@Then ("Select Option Consenso concesso on Dichiarazione di Consenso")
public void select_Option_Consenso_Consenso_on_Dichiarazione_di_Consenso() {
	driver.findElement(By.xpath("(//input[@id='rdnPrivacy'])[3]")).click();
}
@Then ("Select Data firma modulo privacy in filiale")
public void select_Data_firma_modulo_privacy_in_filiale() throws Exception {
	WebElement calendar = driver.findElement(By.xpath("//input[@id='txtPrivacySign']"));
	Thread.sleep(1000);
    calendar.click();
    LocalDate today = LocalDate.now();
    String todayDate = today.format(DateTimeFormatter.ofPattern("2024-08-22"));
    WebElement todayElement = driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']"));
//    WebElement todayElement = driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-today']"));
    Thread.sleep(2000);
    todayElement.click();
    Thread.sleep(2000);
    
}
//@Then ("Switch to ChildFrame3")
//public void switch_to_ChildFrame3() {
//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iFrameInsertPrivacy']")));
//    
//}
@Then ("Upload CV on Curriculum Vitae in Documenti Allegati Privacy Firmata")
public void upload_CV_on_Currriculum_Vitae_in_Documenti_Allegatto_Privacy_Firmata() throws Exception {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Carica Documento']//preceding::input")).sendKeys("C:\\Users\\sumalatha.u\\Documents\\Adecco\\credentials.txt");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Carica Documento']")).click();
    System.out.println("CV uploaded successfully");
    testWithScreenshot();
    Thread.sleep(2000);
}
@Then ("Click on Save button")
public void click_on_Save_button() throws Exception {
	pom.save();
//	WebElement save = driver.findElement(By.xpath("//button[@id='buttonSave']"));
//    highlightElement(driver,save);
//    Thread.sleep(2000);
//	save.click();
}
//@Then ("Switch to ChildFrame4")
//public void switch_to_ChildFrame4() throws Exception {
//	driver.switchTo().frame(driver.findElement(By.id("TB_iframeContent")));
//    Thread.sleep(2000);
//}
@Then ("Click on Confirm on ChildFrame4")
public void click_on_Confirm_on_ChildFrame4() throws Exception {
	driver.findElement(By.xpath("//button[@id='buttonUpdate']")).click();
    Thread.sleep(5000);
}
@Then ("Click on Delete button")
public void click_on_Delete_button() throws Exception {
	pom.delete();
//	driver.findElement(By.xpath("//button[@id='buttonDelete']")).click();
	Thread.sleep(2000);
}
@Then ("Click Confirm button on ChildFrame4")
public void click_Confirm_button_on_ChildFrame4() throws Exception {
	Thread.sleep(2000);
driver.findElement(By.xpath("//button[@id='buttonUpdate']")).click();
System.out.println("CV Deleted successfully");
Thread.sleep(2000);
testWithScreenshot();
Thread.sleep(2000);
}

// 2 nd scenario
@Then ("Select Option Ricerca e selezione")
public void select_Option_Ricerca_e_selezione() throws Exception {
	WebElement option = driver.findElement(By.xpath("//span[text()='Ricerca e selezione']"));
	highlightElement(driver,option);
	option.click();
	testWithScreenshot();
	Thread.sleep(2000);
}
@Then ("Accept Alert")
public void accept_Alert() {
	driver.switchTo().alert().accept();
}
@Then ("Select Client")
public void select_Client() throws Exception {
	Thread.sleep(3000);
WebElement client = driver.findElement(By.xpath("//input[@id='Combojquery_divComboClient']"));
client.sendKeys("COLGATE - PALMOLIVE COMMERCIALE S.R.L.", Keys.ARROW_DOWN, Keys.ENTER);
//highlightElement(driver,client);
System.out.println("Client selected Successfully");
Thread.sleep(2000);
testWithScreenshot();
Thread.sleep(2000);
client.click();
}
@Then ("Click on Applica Filtro button")
public void click_on_Applica_Filtro_button() throws Exception {
	driver.findElement(By.xpath("//span[@class='ui-button-text']")).click();
	Thread.sleep(2000);
	
}
@Then ("Click on Mostra altre info button")
public void clickon_Mostra_altre_info_button() throws Exception {
	WebElement mostra = driver.findElement(By.xpath("//span[text()='Mostra altre info']"));
	mostra.click();
	WebElement mostra_features = driver.findElement(By.xpath("//div[@class='ColVis_collection TableTools_collection']"));
	highlightElement(driver,mostra_features);
	Thread.sleep(2000);
	testWithScreenshot();
    Thread.sleep(2000);
}
@Then ("Click on Close button")
public void click_on_close_button() throws Exception {
	WebElement close = driver.findElement(By.xpath("//input[@id='buttonClose']"));
	highlightElement(driver,close);
	close.click();
	Thread.sleep(2000);
	
}
@Then ("Click on Storico stati dellordine button")
public void click_on_storico_dellordine_button() throws Exception{
	WebElement storico = driver.findElement(By.xpath("//input[@id='buttonExcelReport']"));
	highlightElement(driver,storico);
	storico.click();
	Thread.sleep(5000);
	testWithScreenshot();
    Thread.sleep(2000);
}

}

