import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {
    public static void main(String[] args) {
        // How to perform mouse operations in selenium WebDriver?
        // How to perform Right click action?
        // How to perform Double click action?
        // How to perform Drag and Drop action?
        // How to perform Mouse Hover action?


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();




        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        WebElement doubleClickBtnMsg = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(doubleClickBtnMsg.getText());


        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        System.out.println(rightClickMessage.getText());


        WebElement dynamicButton = driver.findElement(By.xpath("//div/button[starts-with(text(), 'Click Me')]")); ////div[last()]/button //*[@id="i3CMG"]
        //WebElement dynamicButton = driver.findElement(By.xpath("//div[last()]/button")); ////div[last()]/button //*[@id="i3CMG"]
        dynamicButton.click();
        WebElement dynamicButtonMsg = driver.findElement(By.id("dynamicClickMessage"));
        System.out.println(dynamicButtonMsg.getText());








    }
}
