package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {
    /*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedSayfaYazisi = "Opening a new window";
        String actulaSayfaYazisi = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedSayfaYazisi, actulaSayfaYazisi);
        Thread.sleep(3000);

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedSayfaTitle = "The Internet";
        String actualSayfaTitle = driver.getTitle();
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        Assert.assertEquals(expectedSayfaTitle, actualSayfaTitle);

        // ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        /*
        Konrolsuz acilan taba gecis yapmak icin
        1- ilk sayfada iken o sayfanini WHD alip kaydedin
        2- 2. sayfa acildiktan sonra getWindowHandles() kullanarak
           acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
        3- Su anda elimizde iki elementli set var. Elementlerden bir tanesi 1. sayfanin WHD
           1. sayfanin WHD'ine esit olmayan ise 2. sayfanin WHD 'ne esit olur.
        4- bu sekilde 2.sayfanini WHD elde edildikten sonra
           WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir.

         */

        Set<String> tumWHDegerleriSeti= driver.getWindowHandles();

        String ikinciSayfaWHD ="";
        for (String eachWhd : tumWHDegerleriSeti){
            if (!eachWhd.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD=eachWhd;

            }
        }

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedNewSayfaTitle = "The Internet";
        String actualNewSayfaTitle = driver.getTitle();

        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedYeniSayfaYazi ="New Window";
        String actualYeniSayfaYazi =driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedSayfaTitle = "The Internet";
        actualSayfaTitle = driver.getTitle();


        Assert.assertEquals(expectedSayfaTitle, actualSayfaTitle);

        Thread.sleep(3000);
    }
}
