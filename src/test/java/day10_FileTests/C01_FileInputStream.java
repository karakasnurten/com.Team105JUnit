package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu = "C:\\Users\\mserk\\OneDrive\\Masaüstü\\merhabaJava.docx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        /*
        Dosya File testlerinde genellikle downloads'a indirilecek bir dosyanin
        indirildigini test etmek
        veya masaustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz

        Ancak herkesin bilgisayarinin ismi, kullanici isimleri gibi farkliliklar
        olacagindan testler tek bir bilgisayarda calisacak gibi yazilmak zorunda kalirlar

        Bu karisikligin onune gecmek icin Java
         2 basit kod blogu sunmus
         */

        System.out.println(System.getProperty("user.dir"));
        // o anda calisan dosyanin (C01_FileInputStream) yolunu verir
        // C:\Users\mserk\IdeaProjects\com.Team105JUnit

        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path'ini verir
        // C:\Users\mserk

        // masaustune gitmek istersek
        // C:/Users/mserk + /Desktop eklememiz yeterlidir

        // Downloads'a gitmek istersek
        // /Users/mserk + /Downloads eklememiz yeterlidir

        // Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan olacak sekilde
        // olustururuz

        // dosyaYolu = "/Users/mserk/Desktop/MerhabaJava.docx

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/MerhabaJava.docx";

    }
}
