package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Register {
    WebDriver driver;

    @Given("^User open website URL$")
    public void User_open_website_URL() throws Throwable {
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

    @When("^Click sign in navigation link 3$")
    public void Click_sign_in_navigation_link_3() throws Throwable {
        System.out.println("At this step user clicks sign in navigation links");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")).click();
        Thread.sleep(1000);
    }

    @And("^Enter valid email$")
    public void Enter_valid_email() throws Throwable {
        System.out.println("At this step users enters valid email");
        driver.findElement(By.id("email_create")).sendKeys("rashnite28@gmail.com");
        Thread.sleep(1000);
    }

    @And("^Click create an account$")
    public void Click_create_an_account() throws Throwable {
        System.out.println("At this step user clicks create an account button");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Thread.sleep(1000);
    }

    @And("^Enter personal information$")
    public void Enter_personal_information() throws Throwable {
        System.out.println("At this step user enters personal information");
        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Greg");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Morgen");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Tester186");
        Thread.sleep(1000);
    }

    @And("^Click register button$")
    public void Click_register_button() throws Throwable {
        System.out.println("At this step user clicks register button");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
        Thread.sleep(1000);
    }

    @Then("^User successfully register$")
    public void User_successfully_register() throws Throwable {
        System.out.println("At this step user should be successfully registered");
        Thread.sleep(1000);
        driver.quit();
    }

    @And("^Showed success message box$")
    public void Showed_success_message_box() throws Throwable {
        System.out.println("Your account has been created.");
        Thread.sleep(1000);
        driver.quit();
    }
}
