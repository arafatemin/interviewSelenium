import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLSin2Tabs {
    public static void main(String[] args) {
        // How to capture tooltip of the Web Element?
        // How to open a link in new tab?
        // How to open URL's in a multiple tabs Windows?
        // How to capture Size & Location of the Web Element?


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

         // How to open URL's in a multiple tabs Windows?
        //driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);


        driver.get("https://www.opencart.com/");

    }
}
