import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVsGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://admin-demo.nopcommerce.com/login");

        // getText() method retruns the innerText of an element.
        // getAttribute() method fetches the text contained by an attribute in an html document.



        WebElement inputArea = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        /*
        inputArea.clear();
        inputArea.sendKeys("Arafat@gmail.com");
        */

        //capture text from inputBox
        System.out.println(inputArea.getAttribute("value"));
        System.out.println(inputArea.getText());




        // Button
        WebElement button = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
        System.out.println(button.getAttribute("type"));
        System.out.println(button.getText());



    }
}
