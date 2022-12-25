import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShots {
    public static void main(String[] args) throws IOException {
        // How to capture screenshot of full page?
        // How to capture screenshot of section of page?
        // How to capture screenshot of element on a page?



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        
        
        // Full page screenshot
        /*
        TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(".\\screenshots\\homepage.png");
        FileUtils.copyFile(src, target);
        */

        // screenshot of section / portion of the page
        /*
        WebElement section = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[3]"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File target = new File(".\\screenshots\\futureProduct.png");
        FileUtils.copyFile(src, target);
        */


        // screenshot an element of the page
        WebElement element = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
        File src = element.getScreenshotAs(OutputType.FILE);
        File target = new File(".\\screenshots\\logo.png");
        FileUtils.copyFile(src, target);




        







    }
}
