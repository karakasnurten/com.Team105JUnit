package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

  //  1- Bir class olusturun : BasicAuthentication
  //  2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
  //  3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
  //  Html komutu : https://username:password@URL
  //  Username    : admin
  //  password     : admin
  //  4- Basarili sekilde sayfaya girildigini dogrulayin

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
        //  2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(3000);
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String actualSonucYazisi= driver.findElement(By.tagName("p")).getText();
        String expectedKelime= "Congratulations";
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Thread.sleep(3000);
    }
    }


    


