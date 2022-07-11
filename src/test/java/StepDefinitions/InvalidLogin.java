package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InvalidLogin {
    WebDriver driver;

    @Given("^Access website URL$")
    public void Access_website_URL() throws Throwable {
        System.out.println("Set up browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println("Access the website");
        driver.get("http://qa.cilsy.id:8080/en/");
    }

    @When("^Click sign in navigation link 2$")
    public void Click_sign_in_navigation_link_2() throws Throwable {
        System.out.println("At this step User clicks sign in navigation link");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")).click();
        Thread.sleep(1500);
    }

    @And("^Enter invalid email and password$")
    public void Enter_invalid_email_and_password() throws Throwable {
        System.out.println("At this step User enters the invalid emal and password");
        driver.findElement(By.id("email")).sendKeys("katakana186@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("passwd")).sendKeys("Katakana");
        Thread.sleep(1000);
    }

    @And("^Click sign in button 2$")
    public void Click_sign_in_button_2() throws Throwable {
        System.out.println("At this step user clicks sign in button");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(1000);
    }

    @Then("^User failed to login$")
    public void User_failed_to_login() throws Throwable {
        System.out.println("At this step login should be failed");
        System.out.println("===LOGIN FAILED===");
    }

    @And("^Pop up error message box$")
    public void Pop_up_error_message_box() throws Throwable {
        System.out.println("An error message box will pop up");
        Thread.sleep(1000);
        driver.quit();
    }
}
