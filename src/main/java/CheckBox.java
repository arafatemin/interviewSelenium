import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://itera-qa.azurewebsites.net/home/automation");


        // 1) select specific check box.
        //driver.findElement(By.xpath("//*[@id=\"monday\"]")).click();



        // 2) select all the check boxes
        //List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\" and contains(@id, 'day')]"));
        //System.out.println(checkBoxes.size());

        /*
        for (int i=0; i<checkBoxes.size(); i++){
            checkBoxes.get(i).click();
        }
        */

        /*
        for (WebElement checkbox: checkBoxes){
            checkbox.click();
        }
         */


        // 3) select multiple check boxes by choice
        // monday & sunday
        /*
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\" and contains(@id, 'day')]"));
        for (WebElement checkbox: checkBoxes){
            String checkboxName = checkbox.getAttribute("id");
            if (checkboxName.equals("monday") || checkboxName.equals("sunday")){
                checkbox.click();
            }
        }
         */


        // 4) select last 2 check boxes
        /*
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\" and contains(@id, 'day')]"));
        for(int i=checkBoxes.size()-2; i<checkBoxes.size(); i++){
            checkBoxes.get(i).click();
        }
         */


        // 4) select first 2 check boxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\" and contains(@id, 'day')]"));
        for(int i=0; i<checkBoxes.size(); i++){
            if (i<2){
                checkBoxes.get(i).click();
            }
        }






    }
}
