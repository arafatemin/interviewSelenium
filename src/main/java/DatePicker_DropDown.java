import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePicker_DropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();


        // Select Month
        driver.findElement(By.xpath("//input[@id='dob']")).click();
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        selectMonth.selectByVisibleText("Apr");

        // Select Year
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        selectYear.selectByVisibleText("1995");

        // Get Day
        String date = "6";
        List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
        for (WebElement validate: allDates){
            String day = validate.getText();
            if (day.equals(date)){
                validate.click();
                break;
            }
        }
    }

}
