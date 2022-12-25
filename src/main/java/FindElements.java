import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        // findElement() --> always returns the single WebElement.
        // findElement() method returns the first matching element on the current page.
        // if the element is not found then it throws NoSuchElementException.

        //1
        /*
        WebElement searchArea = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        searchArea.sendKeys("Arafat");
        */

        //2
        /*
        WebElement links = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(links.getText());
        */


        //3 NoSuchElementException
        //WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"small-login\"]"));


        // findElements() --> always returns the multiple WebElements.
        // findElements() method returns all the matching elements on the current page and it doesn't throw any exception if the element is not found, instead it will return zero elements.


        //1
        /*
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(links.size());
        for (WebElement link: links){
            System.out.println(link.getText());
        }
        */


        //2
        /*
        List<WebElement> logo = driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
        System.out.println(logo.size());
        */


        //3 don't give NoSuchElementException
        List<WebElement> searchButton = driver.findElements(By.xpath("//*[@id=\"small-login\"]"));
        System.out.println(searchButton.size());

    }
}
