package tests.day15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_PozitifLoginTesti {
    @Test(groups = "smoke")
    public void test01(){

        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        // cookies i kabul edin
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        // 2- login linkine basin
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        // 3- Kullanici email'i olarak valid email girin
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("rataxa8964@vingood.com");
        // 4- Kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordKutusu.sendKeys("AA12345zz.");
        // 5- Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());

        Driver.closeDriver();


    }
}