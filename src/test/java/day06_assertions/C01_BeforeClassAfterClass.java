package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {

    // 3 ayri test method'u olusturun
    // 1. method'da amazon'a gididp, amazon'a gitttigimizi test edin
    // 2. method'da nutella aratip, sonuclarin nutella icerdigini test edin
    // 3. method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin
   static WebDriver driver;
    @BeforeClass
    // @BeforeClass ve @AfterClass notasyonu kullanan method'lar static olmali
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("setUp method'u calisti");
    }
    @AfterClass
    public static void tearDown(){
        driver .close();
        System.out.println("teardown method'u calisti");

    }
    @Test
    public void test01(){
        // 1. method'da amazon'a gididp, amazon'a gitttigimizi test edin
        driver.get("https://www.amazon.com");

        String expectedKelime ="Amazon";
        String actuallTitle = driver.getTitle();

        if (actuallTitle.contains(expectedKelime)){
            System.out.println("Amazon gidis testi PASSED");
        }else{
            System.out.println("Amazon gidis testi FAILED");
        }

    }
    @Test
    public void test02(){
        // 2. method'da nutella aratip, sonuclarin nutella icerdigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedKelime="Nutella";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr=sonucYaziElementi.getText();
        if (sonucYazisiStr.contains(expectedKelime)){
            System.out.println("Nutella arama testi PASSED");
        }else {
            System.out.println("Nutella arama testi FAILED");
        }
    }
    @Test
    public void test03(){
        // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr=sonucYaziElementi.getText();

        String[] sonucYazisiArr= sonucYazisiStr.split(" ");
        String sonucAdediStr=sonucYazisiArr[2]; // "74"
        int actualSonucAdediInt= Integer.parseInt(sonucAdediStr);

        int expectedAramaSonucusayisi= 50;
        if (actualSonucAdediInt>expectedAramaSonucusayisi){
            System.out.println("Nutella arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Nutella arama sonuc sayisi testi FAILED");
        }




}

}
