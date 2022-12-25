import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DownloadFile {
    public static void main(String[] args) {
        // How to download the Files using the selenium WebDriver?
        //Chrome, FireFox, Edge

        //Chrome
        String location = System.getProperty("user.dir")+ "\\Downloads\\";

        HashMap preferences = new HashMap();
        preferences.put("download.default_directory", location);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a")).click();



    }
}
