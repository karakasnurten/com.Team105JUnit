package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // ilgili ayarlari yapip amazon anasayfaya gidip,
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'nin book ve java icerdigini test edin

        driver.get("https://www.amazon.com");

        // Dropdown menuden istedigimiz option'nu secebilmek icin
        // oncelikle Select class'indan bir obje olusturmaliyiz
        // ancak select objesi olusturmak icin Select class'inin constructor'u
        // handle edecegimiz webElementi istendiginden
        // 1- select objesi once dropdown webelemtini locate etmeliyiz

        WebElement dropdownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdown']"));

        // 2- Select class'dan obje olusturmak
        Select select= new Select(dropdownWebElementi);

        // 3- select objesini kullanmak istedigimiz method/method'lari calistirin

        // select.selectByValue("searh-alias=stripbooks-intl-ship");
        // select.selectByIndex(5);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        String expectedTitle="java";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //dropdown menuden Books seceneginin secildigini test edin

        /*
        Locate ettigimiz elementi bulamazsa NoSuchElementException
        sayfa yenilendigi icin var olan bir elementşi kullanamazsa
        StaleElementException verir
        bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir
         */

        dropdownWebElementi=driver.findElement(By.id("//select[@id='searchDropdown']"));
        select=new Select(dropdownWebElementi);
        select.selectByVisibleText("Books");

        String actualSecilenOption=select.getFirstSelectedOption().getText();
        String expectedSecilecekOption = "Books";

        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);

        // Dropdown menudeki secenek sayisinin 24 oldugunu test edin

        List<WebElement> optionsWebElementListesi = select.getOptions();

        int actualOptionsSayisi= optionsWebElementListesi.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionsSayisi);



        Thread.sleep(5000);
    }
}
