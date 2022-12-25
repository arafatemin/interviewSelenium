import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndLocationOfElement {
    public static void main(String[] args) {
        // How to capture tooltip of the Web Element?
        // How to open a link in new tab?
        // How to open URL's in a multiple tabs Windows?
        // How to capture Size & Location of the Web Element?

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Location method 1
        /*
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"));
        System.out.println("getLocation(x, y)" + logo.getLocation());
        System.out.println("getLocation(x, y)" + logo.getLocation().getX());
        System.out.println("getLocation(x, y)" + logo.getLocation().getY());
        */


        // Location method 2
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"));
        System.out.println("getLocation(x, y)" + logo.getLocation());
        System.out.println("getLocation(x, y)" + logo.getRect().getX());
        System.out.println("getLocation(x, y)" + logo.getRect().getY());

        //Size Method 1
        /*
        System.out.println("Size(Width, Height)" + logo.getSize());
        System.out.println("Size(Width)" + logo.getSize().getWidth());
        System.out.println("Size(Height)" + logo.getSize().getHeight());
        */


        //Size Method 2
        System.out.println("Size(Width, Height)" + logo.getSize());
        System.out.println("Size(Width)" + logo.getRect().getDimension().getWidth());
        System.out.println("Size(Height)" + logo.getRect().getDimension().getHeight());

    }




}
