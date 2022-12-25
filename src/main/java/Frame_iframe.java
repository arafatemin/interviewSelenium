import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_iframe {
    public static void main(String[] args) {
        // What is the difference between frame and iframe/
        // How to handle iframes in WebDriver?
        // How to Switch between multiple iFrames?
        // How to work with inner iFrames?

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();



        // first iframe
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
        driver.switchTo().defaultContent();  // go back to the main page.

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // second iframe
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("/html/body/main/div/section[1]/ul/li[14]/a/span")).click();
        driver.switchTo().defaultContent();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // third iframe
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[8]/a")).click();



    }
}
