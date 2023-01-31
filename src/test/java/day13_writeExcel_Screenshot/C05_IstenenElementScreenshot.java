package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_IstenenElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazona gidelim
        driver.get("https://www.amazon.com");
        // Nutella aratin
      WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
      aramakutusu.sendKeys("Nutella");
        // Sonuclarin Nutella icerdigini tets edin
        WebElement aramaSonucuElement= driver.findElement(By.xpath(""));
        String expectedKelime= "Nutella";
        String actualAramaSonucu= aramaSonucuElement.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
        // arama sonuc elemntinin screenshot'unu cekin

        ReusableMethods.elementSSCek(aramaSonucuElement);




    }
}
