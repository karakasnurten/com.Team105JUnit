package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    //   Text Box’a “Merhaba Dunya!” yazin.
    //   TextBox’in altinda bulunan “Elemental Selenium”
    //   linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

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
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement actualSayfaYazisi = driver.findElement(By.tagName("h3"));

        // 2 ) Bir metod olusturun: iframeTest
        //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        //   Text Box’a “Merhaba Dunya!” yazin.
        Assert.assertTrue(actualSayfaYazisi.isEnabled());
        Thread.sleep(3000);

        //   Text Box’a “Merhaba Dunya!” yazin.

        // normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi
        // yani elementi bulamadi
        // kontrol ederken istedigimiz webElementi'ni biriframe icinde oldugunu gorduk
        // Bu durumda once o iframe

        WebElement iframeWebElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeWebElementi);
        WebElement yaziKutuElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        //   TextBox’in altinda bulunan “Elemental Selenium”
        //   linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.


        // iframe'nin icine girdikten sonra oradan cik denilinceye kadar driver iframe'nin icinde kalir
        // eger disina cikmak isterseniz

        // driver.switchTo().parentFrame(); // bulundugu iframe'den bir ust html sayfasina gecer
        // bu daha cok ic ice iframe'ler oldugunda tercih edilir
        driver.switchTo().defaultContent(); // ana sayfaya gecis yapar
        WebElement elementelSeleniumLinkElementi= driver.findElement(By.xpath("//div[text()='Powered by ']"));

        Assert.assertTrue(elementelSeleniumLinkElementi.isDisplayed());
        System.out.println(elementelSeleniumLinkElementi.getText());




    }
}
