package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);

//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
////         wrong password
//        sleep(2);
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("user");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("b");
//        element = driver.findElement(By.name("login"));
//        
//        sleep(2);
//        
//        element.submit();
//        
//        sleep(2);

        // user creation
        WebElement e = driver.findElement(By.linkText("register new user"));
        Random r = new Random();
        e.click();
        
        e = driver.findElement(By.name("username"));
        e.sendKeys("ossi" + r.nextInt(100000));
        e = driver.findElement(By.name("password"));
        e.sendKeys(("a"));
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(("a"));
        sleep(2);
        
        e = driver.findElement(By.name("signup"));
        e.click();
        
        sleep(2);
        
        e = driver.findElement(By.linkText("continue to application mainpage"));
        e.click();
        
        sleep(2);
        
        e = driver.findElement(By.linkText("logout"));
        
        e.click();
        
        sleep(2);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
