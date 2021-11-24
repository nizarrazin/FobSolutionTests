package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver ;
    public static WebDriver driver1 ;

    @BeforeSuite
    public void startDriver()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://wego.here.com/");

       // driver1 = driver.switchTo().newWindow(WindowType.TAB);
       // driver1.get("https://www.gsmarena.com/");
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }

}
