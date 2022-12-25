import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class States {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"pollanswers-1\"]"));
        System.out.println(textArea.isDisplayed());
        System.out.println(textArea.isEnabled());
        System.out.println(radioButton.isSelected());

        radioButton.click();
        System.out.println(radioButton.isSelected());


    }
}
