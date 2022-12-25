import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.deadlinkcity.com/");

        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));

        int brokenLinks = 0;

        for (WebElement link: links){
            String url = link.getAttribute("href");
            if (url==null || url.isEmpty()){
                System.out.println("Url is Empty!");
                continue;
            }

            URL linkBroken = new URL(url);
            try {
                HttpURLConnection httpURLConnection =(HttpURLConnection) linkBroken.openConnection();
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode()>=400){
                    System.out.println(httpURLConnection.getResponseCode() + url + "is Broken Links");
                    brokenLinks++;
                }
                else {
                    System.out.println(httpURLConnection.getResponseCode() + url + "is Valid Links");
                }
            } catch (Exception e) {

            }


        }
        System.out.println("Number of Broken Links: " + brokenLinks);
        driver.quit();





    }

}
