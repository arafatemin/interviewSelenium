import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GetWindowHandles {
    public static void main(String[] args) {

        // how to handle Browser windows in selenium webdriver?
        // what is the difference between getWindowHandle() & getWindowHandles() method?
        // How to Switch between Multiple Browser Windows?
        // How to close all browsers?
        // How to close specific Browser Window by choice?



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver.manage().window().maximize();

        // getWindowHandle()
        //String windowId = driver.getWindowHandle();  // return ID of the single browser window.
        //System.out.println(windowId);  // CDwindow-01EEB34EF670296746A5300809901815
                                      // CDwindow-B7F1B8A2FF68229AB597C2D29D4F327B


        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();// opens another browser window, child window.


        // getWindowHandles()
        Set<String> windowIds = driver.getWindowHandles(); // returns ID's of multiple browser window.



        // First method - iterator()
        /*
        Iterator<String> iterator = windowIds.iterator();

        String parentWindowID = iterator.next();
        String childWindowID = iterator.next();

        System.out.println("Parent Window ID: " + parentWindowID);
        System.out.println("Child Window ID: " + childWindowID);
         */


        // First method - using List/ArrayList
        List<String> windowIDsList = new ArrayList<>(windowIds); // converting Set to List

        /*
        String parentWindowID = windowIDsList.get(0);
        String childWindowID = windowIDsList.get(1);
        System.out.println("Parent Window ID: " + parentWindowID);
        System.out.println("Child Window ID: " + childWindowID);

        // How to use window ID's for switching?
        driver.switchTo().window(parentWindowID);
        System.out.println("Parent window title: " + driver.getTitle());

        driver.switchTo().window(childWindowID);
        System.out.println("Child window title: " + driver.getTitle());
         */




        // for each loop to get the windowID
        /*
        for (String winId: windowIds){
            String titleWindow = driver.switchTo().window(winId).getTitle();
            System.out.println(titleWindow);
        }
         */

        //driver.close();       // close single browser window driver which pinging
        //driver.quit();        // close all browser windows driver which pinging



        for (String winId: windowIds){
            String titleWindow = driver.switchTo().window(winId).getTitle();
            if (titleWindow.equals("OrangeHRM")){
                driver.close();
            }
        }

    }
}
