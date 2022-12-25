import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        //  login
        WebElement username = driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");

        WebElement userPassword = driver.findElement(By.id("input-password"));
        userPassword.clear();
        userPassword.sendKeys("demo");

        driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[3]/button")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // for Alert
        driver.findElement(By.xpath("//*[@id=\"modal-security\"]/div/div/div[1]/button")).click();

        // Sales --> Orders
        driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"collapse-4\"]/li[1]/a")).click();

        // Table
        // 1) Find Total Number of page in table
        String text = driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[2]/div[2]")).getText();
        int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        System.out.println("total_pages: " + total_pages);

        // 2)  Find How many rows exists in each pages
        for (int p=1; p<=total_pages-1; p++){
            WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("active_page: " + active_page.getText());


            int rows = driver.findElements(By.xpath("//*[@id=\"form-order\"]/div[1]/table//tbody/tr")).size();
            System.out.println("Number of rows: " + rows);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 3) Read all the rows from each page
            for (int r=1; r<=rows; r++){
                String customer =  driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[1]/table//tbody//tr["+r+"]//td[4]")).getText();
                String status =  driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[1]/table/tbody//tr["+r+"]//td[5]")).getText();
                String total =  driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[1]/table//tbody//tr["+r+"]//td[6]")).getText();
                if (status.equals("Pending")){
                    System.out.println(customer + "   " + status + "    " + total);
                }
            }

            // 4) click next page
            String pageNo = Integer.toString(p+1);
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+ pageNo +"']")).click();


        }


    }
}
