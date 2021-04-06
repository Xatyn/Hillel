import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class UsersTest
{
 public static WebDriver driver;
  @Test //Начало теста
 public void login() throws InterruptedException
 {
  System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe");
  driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    //Вход на сайт и в аккаунт
    driver.get("http://users.bugred.ru/user/login/index.html");
    driver.findElement(By.name("login")).sendKeys("xatyn@ya.ua");
    driver.findElement(By.name("password")).sendKeys("test1501");
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input")).click();

    //Проверка работоспособности кнопки
    WebElement PoiskButton=driver.findElement(By.xpath("//a[contains(text(),'Добавить пользователя')]"));
    Assert.assertEquals(true, PoiskButton.isDisplayed());

    //Поиск пользователя
    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[4]/td/input")).sendKeys("xatyntester5@ya.ua");
    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[1]/button")).click();

    //Добавить нового пользователя
    driver.findElement(By.xpath("/html/body/div[3]/p[1]/a")).click();
    driver.findElement(By.name("noibiz_name")).sendKeys("xatyntester6");
    driver.findElement(By.name("noibiz_email")).sendKeys("xatyntester6@ya.ua");
    driver.findElement(By.name("noibiz_password")).sendKeys("test1501");
    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[21]/td[2]/input")).click();

    //изменение в личном кабинете
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]")).click();
    driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/ul/li[1]/a")).click();
    driver.findElement(By.name("name")).sendKeys("Other");
    driver.findElement(By.name("gender")).sendKeys("мужской");
    driver.findElement(By.name("birthday")).sendKeys("01.01.2000");
    driver.findElement(By.name("date_start")).sendKeys("10.10.2021");
    driver.findElement(By.name("hobby")).sendKeys("Хобби-бобби");
    driver.findElement(By.name("inn")).sendKeys("123456789012");
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[8]/td[2]/input")).click();

     }
}
