package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en. *;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionClass {

	WebDriver driver;

	String firstName = "Roshni123";
	String lastName = "user1";
	String email = "Roshni123.user1@gmail.com";
	String username = "Roshni123user1";
	String pass = "abcd1234";

	@Given("User is on elearning upskills website login screen")
	public void user_is_on_elearning_upskills_website_login_screen() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");

	}

	@When("user clicks Sign up link")
	public void user_clicks_Sign_up_link() {

		driver.findElement(By.partialLinkText("Sign")).click();
	}

	@Then("user is navigated to the registration page")
	public void user_is_navigated_to_the_registration_page() {

		String registrationPage = driver.getTitle();
		System.out.println(registrationPage);
		Assert.assertEquals(registrationPage, "elearning - elearning - Registration");
	}


	@When("user fills all the mandatory fields")
	public void user_fills_all_the_mandatory_fields() {
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pass1")).sendKeys(pass);
		driver.findElement(By.name("pass2")).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@And("clicks Register button")
	public void clicks_Register_button() { 
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("user is registered succesfully and user logs out")
	public void user_is_registered_succesfully_and_user_logs_out() { 

		String regritrationSuccess = driver.getTitle();
		Assert.assertEquals("elearning - elearning - Registration",regritrationSuccess);

		System.out.println("The user is registered succesfully");
		driver.findElement(By.id("logout_button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.quit();

	}


	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password() { 

		driver.findElement(By.id("login")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);

	}

	@And("clicks Login button")
	public void clicks_Login_button() { 

		driver.findElement(By.name("submitAuth")).click();
	}

	@Then("user is navigated to My courses screen")
	public void user_is_navigated_to_My_courses_screen() { 

		String myCourses =  driver.getTitle();
		System.out.println(myCourses);

		Assert.assertEquals("elearning - elearning - My courses", myCourses);

	}

	@When("user clicks Inbox link")
	public void user_clicks_Inbox_link() { 

		driver.findElement(By.xpath("//a[@href='http://elearningm1.upskills.in/main/messages/inbox.php?f=social']")).click();
	}

	@And("clicks Compose icon")
	public void clicks_Compose_icon() { 
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/new-message.png']")).click();
	}

	@And("enter three characters")
	public void enter_three_characters() {

		driver.findElement(By.className("select2-search__field")).sendKeys("abc"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@And("chooses a value from the autosuggest list")
	public void chooses_a_value_from_the_autosuggest_list() { 
		driver.findElement(By.xpath("//ul/li[contains(text(),'Anamika Anamika')]")).click();
	}

	@And("enters Subject text")
	public void enters_Subject_text() { 
		driver.findElement(By.name("title")).sendKeys("Test email");
	}

	@When("user clicks Send message button")
	public void user_clicks_Send_message_button() { 
		driver.findElement(By.name("compose")).click();
	}

	@Then("mail is sent succesfully with validation message shown")
	public void mail_is_sent_succesfully_with_validation_message_shown() { 

		String mailSentSuccessMessage =  driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println("Validation message : " + mailSentSuccessMessage);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}


}


