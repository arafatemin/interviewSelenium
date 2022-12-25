import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBaseTesting {
    public static void main(String[] args) {
        // How to perform Database Testing in selenium WebDriver?
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a")).click();
    }
}
