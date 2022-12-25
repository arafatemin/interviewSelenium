import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();



        WebElement textArea1 = driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
        textArea1.sendKeys("Welcome class selenium.");

        WebElement textArea2 = driver.findElement(By.xpath("//*[@id=\"inputText2\"]"));


        Actions action = new Actions(driver);

        // ctrl + a
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.perform();

        // ctrl + c
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.perform();

        // tab - shift to input2 box
        action.sendKeys(Keys.TAB);
        action.perform();

        // ctrl + v
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.perform();

        if (textArea1.getAttribute("value").equals(textArea2.getAttribute("value"))) {
            System.out.println("Text Copied");
        }
        else {
            System.out.println("Text Not Copied");
        }


    }
}
