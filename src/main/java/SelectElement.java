import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectElement {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.opencart.com/index.php?route=account/register");

        // selectByVisibleText(), selectByIndex()

        WebElement countryId = driver.findElement(By.id("input-country"));
        selectOption(countryId, "Turkey");
        //Select country = new Select(countryId);

        //Approach1
        //country.selectByVisibleText("Turkey");
        //country.selectByIndex(4);
        //country.selectByValue("Fiji");



        //Approach2
        // selecting option from dropdown without using method
        /*
        List<WebElement> options = country.getOptions();
        for(WebElement option: options){
            if (option.getText().equals("Turkey")){
                option.click();
                break;
            }
        }
        */
    }


    //Approach3
    public static void selectOption(WebElement element, String value){
        Select country = new Select(element);
        List<WebElement> options = country.getOptions();
        for(WebElement option: options){
            if (option.getText().equals(value)){
                option.click();
                break;
            }
        }
    }

}
