import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookiesClass {
    public static void main(String[] args) {
        // How to capture cookies from browser?
        // How to print cookies from browser?
        // How to add cookie to the browser?
        // How to delete specific cookie from the browser?
        // How to delete all cookies from the browser?


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();


        // How to capture cookies from browser?
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies: " + cookies.size());


        // How to print cookies from browser?
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }


        // How to add cookie to the browser?
        Cookie cookieObject = new Cookie("MyCookie", "123456");
        driver.manage().addCookie(cookieObject);
        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after adding: " + cookies.size());





        // How to delete specific cookie from the browser?
        // method 1
        /*
        driver.manage().deleteCookie(cookieObject);
        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after adding: " + cookies.size());
         */

        // method 2
        driver.manage().deleteCookieNamed("MyCookie");
        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after adding: " + cookies.size());



        // How to delete all cookies from the browser?
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies after adding: " + cookies.size());



    }
}
