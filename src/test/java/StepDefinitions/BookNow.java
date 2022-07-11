package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookNow {
    WebDriver driver;

    @Given("^User access website URL$")
    public void User_access_website_URL() throws Throwable {
        System.out.println("Set up browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println("Access website URL");
        driver.get("http://qa.cilsy.id:8080/en/");

        System.out.println("Verify website");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[4]/div/div/div/div[1]/div/div/h1")).getText();
        Thread.sleep(1000);
    }

    @When("^Click book now button$")
    public void Click_book_now_button() throws Throwable {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 3000);");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"hotelRoomsBlock\"]/div/div[2]/div/div[1]/div[2]/div/div[3]/a/span")).click();
        Thread.sleep(3000);
    }

    @Then("^Rooms information will appeared$")
    public void Hotel_room_list_will_appear() throws Throwable {
        System.out.println("Room information appeared");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(3000);
        driver.getTitle();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }
}
