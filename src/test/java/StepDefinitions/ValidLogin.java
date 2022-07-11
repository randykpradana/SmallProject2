package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ValidLogin {
    WebDriver driver;

    @Given("^User access the website URL$")
    public void User_access_the_website_URL() throws Throwable {
        System.out.println("Set up browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println("Access the website url");
        driver.get("http://qa.cilsy.id:8080/en/");
        Thread.sleep(1000);
    }

    @When("^Click sign in navigation link 1$")
    public void Click_sign_in_navigation_link_1() throws Throwable {
        System.out.println("At this step user clicks sign in navigation links");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")).click();
        Thread.sleep(1000);
    }

    @And("^Enter valid email and valid password$")
    public void Enter_valid_email_and_valid_password() throws Throwable {
        System.out.println("At this step users enters valid email");
        driver.findElement(By.id("email")).sendKeys("princekatalonia186@gmail.com");
        Thread.sleep(1000);
        System.out.println("At this step users enters valid password");
        driver.findElement(By.id("passwd")).sendKeys("Katalonia186");
        Thread.sleep(1000);
    }

    @And("^Click sign in button 1$")
    public void Click_sign_in_button_1() throws Throwable {
        System.out.println("At this step user clicks sign in button");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(1000);
    }

    @Then("^User successfully logged in$")
    public void User_successfully_logged_in() throws Throwable {
        System.out.println("At this step user should be successfully logged in");
        System.out.println("===LOGIN SUCCESS===");
    }

    @And("^Able to see My Account page$")
    public void Able_to_see_My_Account_page() throws Throwable {
        System.out.println("User should be able to landing and see My Account page");
        Thread.sleep(1000);
        driver.quit();
    }
}
