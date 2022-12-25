import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        String year = "2023";
        String month = "July";
        String date = "10";

        driver.findElement(By.id("onward_cal")).click();

        // Month and Year Values
        while(true){
            String monthYear = driver.findElement(By.className("monthTitle")).getText();
            String array[] = monthYear.split(" ");
            String mon = array[0];
            String yr = array[1];

            if (mon.equalsIgnoreCase(month) && yr.equals(year))
                break;
            else
                driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
        }

        // Date Values
        List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody//tr//td"));

        for(WebElement allDate: allDates){
            String dateValue = allDate.getText();
            if (dateValue.equals(date)){
                allDate.click();
                break;
            }
        }


    }
}
