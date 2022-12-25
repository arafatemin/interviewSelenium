import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {
    public static void main(String[] args) {

        // How to capture tooltip of the Web Element?
        // How to open a link in new tab?
        // How to open URL's in a multiple tabs Windows?
        // How to capture Size & Location of the Web Element?

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);


        // How to capture tooltip of the Web Element?
        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        String toolTipText = inputBox.getAttribute("title");
        System.out.println(toolTipText);




    }
}
