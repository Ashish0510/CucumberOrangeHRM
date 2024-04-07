package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;

public class LoginPage {
	WebDriver driver;

    public LoginPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement LoginButton;
	
	
	public void Enters_username(String usernam) throws InterruptedException {
		System.out.println("Loginpage pom username method invokes"+usernam);
		System.out.println("driver getting here :"+driver);
		

		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));*/
		Thread.sleep(5000);
		
		username.click();
		username.sendKeys(usernam);
		Thread.sleep(2000);
		
	}
	
	
	public void Enters_Password(String password)throws InterruptedException {

		Password.click();
		Password.sendKeys(password);
		Thread.sleep(2000);
		
	}
	
	public void Login_button() throws InterruptedException {

		LoginButton.click();
		Thread.sleep(3000);
		try {
	 WebElement Invalid_credentials = driver.findElement(By.xpath("//div [contains (text(),\"Invalid Credentials\")]"));
	 
	 if (Invalid_credentials!=null) {
		 Assert.assertTrue(false);
	 }
	 
	 else {
		 Assert.assertTrue(true);
	 }
		}catch (Exception e) {
			System.out.println("User logged in successfully");
		}
		
	
		
	}

	
	


}
