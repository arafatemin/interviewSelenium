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

public class GenericFluentWait {
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

        waitForElementWithFluentWait(driver, elementLocation).click();

    }


    public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator){
        Wait<WebDriver> myWait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchFieldException.class);

        WebElement element = myWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;

    }
}
