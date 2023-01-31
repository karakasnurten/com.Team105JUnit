package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01(){

       // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
       // 2.chooseFile butonuna basalim
       // 3.Yuklemek istediginiz dosyayi secelim.

        /*
        Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
        acilan bilgisayarimizdaki file dosyalarini click yapabilmemeiz gerekir
        ancak Selenium bilgisayarimizdaki dosyalari click yapamaz

        Bunun yerine soyle bir cozum uretilmistir

        1- chooseFile butonunu locate edin
        2- upload edilecek dosyanin dosya yolunu olusturun
        3- chooseFile butonuna senKeys ile dosya yolunu gonderin

         */

        WebElement chooseFileButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        String dosyaYolu = System.getProperty("user.home") + "/Dekstop/MerhabaJava.docx";
       // 4.Upload butonuna basalim.

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

       // 5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));
        ReusableMethods.bekle(5);
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
