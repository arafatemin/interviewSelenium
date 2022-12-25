import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    public static void main(String[] args) {
        // How many rows in Table?
        // How many columns in Table?
        // Retrieve the specific row/column data

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();

        // How many rows in Table?
        /*
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
        System.out.println(rows.size());
        */



        // How many columns in Table?
        /*
        List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/th"));
        System.out.println(columns.size());
         */




        // Retrieve the specific row/column data
        /*
        WebElement value = driver.findElement(By.xpath("//*[@id=\"customers\"]//tr[3]/td[2]"));
        System.out.println(value.getText());
        */




        // Retrieve all the data from the data
        int rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
        System.out.println(rows);
        for (int i=2; i<=rows; i++){
            String language = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[1]")).getText();
            if (language.equals("Island Trading")){
                String contactName = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[2]")).getText();
                String countryName = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(language + "    " + contactName + "     " + countryName + "    ");
            }
        }





    }
}
