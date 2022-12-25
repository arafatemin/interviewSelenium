import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) {

        // How to Handle JavaScript Alerts?
        // How to Handle Authentication popup?
        // How to Handle permission based pop-ups?




        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();


        // Alert window button with OK button.
        /*
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
         */


        // Alert Window with OK & Cancel Button.
        /*
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.switchTo().alert().accept();    // close alert by using ok button
        driver.switchTo().alert().dismiss(); // close alert by using cancel button
         */




        // Alert window with input box
        /*
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Arafat");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().alert().accept();
        */


        // Alert window with input box
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        org.openqa.selenium.Alert alertWindow =  driver.switchTo().alert();
        System.out.println(alertWindow.getText());
        alertWindow.sendKeys("Arafat");
        alertWindow.accept();
    }
}
