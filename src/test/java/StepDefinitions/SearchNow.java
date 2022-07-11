package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchNow {
    WebDriver driver;

    @Given("^User on the home page$")
    public void User_on_the_home_page() throws Throwable {
        System.out.println("Set up browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://qa.cilsy.id:8080/en/");
        System.out.println("At this step user on the home page");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[4]/div/div/div/div[1]/div/div/h1")).getText();
        Thread.sleep(1000);
    }

    @When("^Enter hotel location$")
    public void Enter_hotel_location() throws Throwable {
        System.out.println("At this step user enters hotel location");
        driver.findElement(By.xpath("//*[@id=\"hotel_location\"]")).sendKeys("Bandung");
        Thread.sleep(1000);
    }

    @And("^Select hotel$")
    public void Select_hotel() throws Throwable {
        System.out.println("At this step user select the hotel");
        driver.findElement(By.xpath("//*[@id=\"id_hotel_button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li")).click();
        Thread.sleep(1000);
    }

    @And("^Select check in date$")
    public void Select_check_in_date() throws Throwable {
        System.out.println("At this step user check the check in data");
        driver.findElement(By.xpath("//*[@id=\"check_in_time\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")).click();
        Thread.sleep(1000);
    }

    @And("^Select check out date$")
    public void Select_check_out_date() throws Throwable {
        System.out.println("At this step user check the check out data");
        driver.findElement(By.xpath("//*[@id=\"check_out_time\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        Thread.sleep(1000);
    }

    @And("^Click search now button$")
    public void Click_search_now_button() throws Throwable {
        System.out.println("At this step user click search now button");
        driver.findElement(By.xpath("//*[@id=\"search_room_submit\"]/span")).click();
        Thread.sleep(1000);
    }

    @Then("^Hotel room list will appear$")
    public void Hotel_room_list_will_appear() throws Throwable {
        System.out.println("Hotel room list appeared");
        driver.getTitle();
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        driver.quit();
    }
}
