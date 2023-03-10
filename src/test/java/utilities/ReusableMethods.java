package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver)  {

            // 1- screenshot alacagimiz elementi locate et
        TakesScreenshot tss= (TakesScreenshot)driver;
            // 2- kaydedecegimiz dosyayi olustur
            // her resmi cektiginde ust uste kaydetmemesi icin
            // resim dosya yoluna tarih ve saat iceren bir ek yapalim

            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String tarih = ldt.format(dtf);
            String dosyaYolu = "target/ekranResimleri/tumEkranSS" + tarih + ".jpeg";
            File tumSayfaScreenshot = new File(dosyaYolu);

            // File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // FileUtils.copyFile(file, new File("src/test/java/day13_writeExcel_Screenshot/ss.png"));

            // 3- tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydedelim
            File gecici = tss.getScreenshotAs(OutputType.FILE);

            // 4- gecici dosyayi ana dosyaya kopyala
            try {
                FileUtils.copyFile(gecici, tumSayfaScreenshot);
            } catch (IOException e) {

            }
        }
    public static void elementSSCek(WebElement element) {

        // 1- screensot alacagimiz elementi locate et
        // 2- kaydedecegimiz dosyayi olustur

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/istenenElementSS" + tarih + ".jpeg";
        File elementSS = new File(dosyaYolu);

        // 3- gecici dosyayi olusturup, elemnt uzerinden screenshot yapalim

        File gecici= element.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {

        }

    }
}
