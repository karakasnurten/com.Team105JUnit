package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev {

    // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    // 2) sayfadaki iframe sayısını bulunuz.
    // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
    // 5) ikinci iframe'deki (Jmeter Made Easy) linke
    // (https://www.guru99.com/live-selenium-project.html) tıklayını

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //  1- Bir class olusturun : BasicAuthentication
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) sayfadaki iframe sayısını bulunuz.
        WebElement iframeSayisi=driver.findElement(By.tagName("iframe"));

        // int i

    }
}
