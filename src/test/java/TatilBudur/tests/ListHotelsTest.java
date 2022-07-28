package TatilBudur.tests;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class ListHotelsTest {

    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait;

    @Given("TatilBudur web sitesi açılır")
    public void tatilBudurWebSitesiAçılır(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\baris\\IdeaProjects\\tatilBudur_testCase\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.tatilbudur.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("Antalya kelimesi arama kısmına girilir")
    public void antalyaKelimesiAramaKısmınaGirilir() {
        driver.findElement(By.id("key")).click();
        driver.findElement(By.xpath("//input[@id='key']")).sendKeys("Antalya");
    }

    @And("Başlangıç tarihi {int} Ağustos seçilir")
    public void başlangıçTarihiAğustosSeçilir(int arg0) {
        driver.findElement(By.xpath("//input[(@placeholder='Giriş Tarihi') and @id=\"hotelSearchCheckIn\"]")).click();
        driver.findElement(By.xpath("//th[contains(text(),'Temmuz 2022')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Ağu')]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();
    }


    @And("Bitiş tarihi {int} ağustos seçilir")
    public void bitişTarihiAğustosSeçilir(int arg0) {
        driver.findElement(By.xpath("//input[@name='checkOutDate' and @placeholder='Çıkış Tarihi']")).click();
        driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).click();
    }


    @And("Arama tuşuna basılır")
    public void aramaTuşunaBasılır() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='searchFormHotelSubmitBtn']")).click();
        Thread.sleep(3000);
    }

    @And("Sonuçlarda en üstte çıkan oda seçilir ve detay sayfasına geçilir")
    public void sonuçlardaEnÜstteÇıkanOdaSeçilirVeDetaySayfasınaGeçilir() throws InterruptedException {
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Oteli İncele")).click();
        Thread.sleep(3000);
    }

    @And("Detay sayfasında en üstteki oda seçilir ve ödeme sayfasına geçilir")
    public void detaySayfasındaEnÜsttekiOdaSeçilirVeÖdemeSayfasınaGeçilir() throws InterruptedException {
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='roomSelectBtn1']")).click();
    }


    @And("Ulaşım ister misiniz alanına İstiyorum seçeneği işaretlenir")
    public void ulaşımIsterMisinizAlanınaİstiyorumSeçeneğiIşaretlenir() throws InterruptedException {
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//label[@for='transportationYes']")).click();
    }


    @And("Kalkış havalimanına Sabiha Gokcen yazılır")
    public void kalkışHavalimanınaSabihaGokcenYazılır() throws InterruptedException {
        driver.findElement(By.id("txtFromLocationReservation")).click();
        driver.findElement(By.id("txtFromLocationReservation")).sendKeys("Sabiha");
        Thread.sleep(4000);
        driver.findElement(By.id("ui-id-1")).click();
    }


    @And("Varış havalimanına Sabiha Gokcen yazılır")
    public void varışHavalimanınaSabihaGokcenYazılır() throws InterruptedException {
        driver.findElement(By.id("txtFromLocationReservation")).click();
        driver.findElement(By.id("txtFromLocationReservation")).sendKeys("Sabiha");
        Thread.sleep(4000);
        driver.findElement(By.id("ui-id-2")).click();
    }


    @Then("Ara butonuna basılır ve uçaklar listelenir")
    public void araButonunaBasılırVeUçaklarListelenir() {
        driver.findElement(By.xpath("//*[@id=\"personInfo\"]/section[4]/div[3]/div/button")).click();
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
