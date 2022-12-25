import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitClass {
    public static void main(String[] args) {

        // What is Synchronization problem in automation?
        // What are the different types of waits available in Selenium WebDriver?


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Fluent Wait Declaration
        Wait<WebDriver> myWait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchFieldException.class);


        driver.get("https://www.google.com/");
        driver.manage().window().maximize();


        driver.findElement(By.name("q")).sendKeys("selenium webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);  // Pass Enter


        // Usage of Fluent Wait
        WebElement element = myWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/a/h3"));
            }
        });

        element.click();


    }

}
