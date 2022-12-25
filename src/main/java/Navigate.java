import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // What is the difference between get() and navigate().to() method?
        // both the methods are used for opening url in the browser. there is no difference between them.
        // they are synonyms for one another.
        // the only difference is that cam be found in the parameters.
        // get() accepts only one string parameter.
        // navigate().to() accepts string parameter and url instance as parameter.

        driver.get("https://www.amazon.co.uk/");
        WebElement acceptButton = driver.findElement(By.id("sp-cc-accept"));
        acceptButton.click();
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
