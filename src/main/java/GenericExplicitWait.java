import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericExplicitWait {
    public static void main(String[] args) {

        // What is Synchronization problem in automation?
        // What are the different types of waits available in Selenium WebDriver?


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();


        driver.findElement(By.name("q")).sendKeys("selenium webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);  // Pass Enter
        By elementLocation = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/a/h3");

        waitForElementPresent(driver, elementLocation, 10).click();

    }

    public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

}
