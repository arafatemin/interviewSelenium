import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class UploadFile {
    public static void main(String[] args) {
        // How to Upload the File using the selenium WebDriver?
        //SendKeys(), Robot Class


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();


        // SendKeys()
        WebElement uploadFile = driver.findElement(By.id("uploadFile"));
        uploadFile.sendKeys("C:\\Users\\lenovo\\OneDrive\\Resimler\\Saved Pictures\\Study\\01 (19).jpg");



        // Robot()






    }
}
