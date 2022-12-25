import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopUp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("https://the-internet.herokuapp.com/basic_auth");

        // Syntax
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
