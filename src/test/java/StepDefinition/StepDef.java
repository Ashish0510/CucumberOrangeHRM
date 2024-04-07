package StepDefinition;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import POM.LoginPage;
import Utility.ScreenshotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class StepDef  {
	public static WebDriver driver;
	public  LoginPage lPage;
	public static Logger logger;

	@Before 
	public void setup() {
		System.out.println("Before method is implemented");
		
     	driver=new ChromeDriver ();
		
	}
	
	@Given("user open the browser and enters the url {string}")
	public void user_open_the_browser_and_enters_the_url(String string) {
		
		System.out.println("the user navigated");
		System.out.println("Before method is implemented");
	
     	driver=new ChromeDriver ();
		driver.get(string);
		driver.manage().window().maximize();
		System.out.println("The browser has been launched");
		lPage=new LoginPage(driver);
		logger = LogManager.getLogger("StepDef");
	}
	
	/*@Given("user navigates to the login page")
	public void user_navigates_to_the_login_page() {
		System.out.println("User navigates to the login page ");
	}*/
	
	@When("user enters the username as {string}")
	public void user_enters_the_username_as(String username) throws InterruptedException {
		System.out.println("the driver sets here : " + driver);
		logger.info("the driver sets here : " +driver);
		System.out.println("calling pom class loginpage :" +username);
		logger.info("calling pom class loginpage : " +username);
		lPage.Enters_username(username);
		System.out.println("The username has been entered");
		
	}
	
	@When("enters the password as {string}")
	public void enters_the_password_as(String password) throws InterruptedException {
		lPage.Enters_Password(password);
		System.out.println("The password has been entered");
		
	}
	
	@When("click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		lPage.Login_button();
		System.out.println("The login has been clicked");
	}
	
	
	@After
	public void TearDown() throws IOException, InterruptedException  {
		System.out.println("tear down method implemented");
		ScreenshotUtility ssScreenshotUtility= new ScreenshotUtility();
		ssScreenshotUtility.takeScrenshot(driver);
		Thread.sleep(5000);
		driver.quit();
	}


}
