import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutor {
    public static void main(String[] args) throws IOException {
        // How to use javascriptExecutor in selenium webdriver?
        // Syntax
        // Drawing border & take screenshot
        // Getting title of the page
        // click action
        // Generate alert
        // Refreshing the page
        // Scrolling down page
        // Zoom page
        // flash
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();


        // Syntax
//        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
//        javaScriptExecutor.executeScript(Script, args);


        // Drawing border & take screenshot
//        WebElement logo = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
//        JavaScriptUtil.drawBorder(logo, driver);
//        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
//        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File target = new File(".\\screenshots\\logo2.png");
//        FileUtils.copyFile(src, target);


        // Getting title of the page
//        String title = JavaScriptUtil.getTitleByJS(driver);
//        System.out.println(title);


        // click action
//        WebElement registerLink = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
//        JavaScriptUtil.clickElementByJs(registerLink, driver);


        // Generate alert
        //JavaScriptUtil.generateAlert(driver, "This is Arafat");

        // Refreshing the page
//        JavaScriptUtil.refreshBrowserByJs(driver);



        // Scrolling down page
        /*
        JavaScriptUtil.scrollPageDownByJs(driver);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Scrolling up page
        JavaScriptUtil.scrollPageUpByJs(driver);
        */


        // Zoom page
        //JavaScriptUtil.zoomPageByJs(driver);


        // flash
        WebElement logo = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
        JavaScriptUtil.flashByJs(logo, driver);







    }
}
