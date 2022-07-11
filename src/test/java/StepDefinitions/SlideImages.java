package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SlideImages {
    WebDriver driver;

    @Given("^User access the website URL 1$")
    public void User_access_the_website_URL_1() throws Throwable {
        System.out.println("Set up browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println("Access the website");
        driver.get("http://qa.cilsy.id:8080/en/");
        Thread.sleep(1500);
    }

    @When("^Click slide button$")
    public void Click_slide_button() throws Throwable {
        System.out.println("At this step user clicks slide button");
        driver.findElement(By.xpath("//*[@id=\"hotelInteriorBlock\"]/div/div[2]/div/div/div[2]/div[2]/div/div/div/i")).click();
        Thread.sleep(1500);
    }

    @Then("^Images will slides properly$")
    public void Images_will_slides_properly() throws Throwable {
        System.out.println("Images can be slided");
        Thread.sleep(1500);
        driver.quit();
    }
}
