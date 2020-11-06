package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.Random;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
//    WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @Given("command new user is selected") 
    public void newUserIsSelevted() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
    }
    
    
    @Given ("user with username {string} with password {string} is successfully created") 
    public void newCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement e = driver.findElement(By.linkText("register new user"));
        Random r = new Random();
        e.click();
        
        e = driver.findElement(By.name("username"));
        e.sendKeys(username);
        e = driver.findElement(By.name("password"));
        e.sendKeys(password);
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(password);
        
        e = driver.findElement(By.name("signup"));
        e.click();
        
        
        e = driver.findElement(By.linkText("continue to application mainpage"));
        e.click();
        
        
        e = driver.findElement(By.linkText("logout"));
        
        e.click();
    }
    
    @Given ("user with username {string} and password {string} is tried to be created")
    public void badUserNamePassword(String username, String password) {
        driver.get(baseUrl);
        WebElement e = driver.findElement(By.linkText("register new user"));
        Random r = new Random();
        e.click();
        
        e = driver.findElement(By.name("username"));
        e.sendKeys(username);
        e = driver.findElement(By.name("password"));
        e.sendKeys(password);
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(password);
        
        e = driver.findElement(By.name("signup"));
        e.click();
        
        
        e = driver.findElement(By.linkText("back to home"));
        
        e.click();
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validNewUser(String username, String password) {
        Random r = new Random();
        WebElement e = driver.findElement(By.name("username"));
        
        e.sendKeys(username);
        e = driver.findElement(By.name("password"));
        e.sendKeys(password);
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(password);
        
        e = driver.findElement(By.name("signup"));
        e.click();
        
    }
    
    @When("a username {string} and unmatching passwords {string} and {string} are entered")
    public void unmatchingpasswords(String username, String pass1, String pass2) {
        WebElement e = driver.findElement(By.name("username"));
        
        e.sendKeys(username);
        e = driver.findElement(By.name("password"));
        e.sendKeys(pass1);
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(pass2);
        
        e = driver.findElement(By.name("signup"));
        e.click();
    }
    
    @When("nonvalid username {string} and valid password {string} and matching password confirmation are entered")
    public void nonValidNewUser(String username, String password) {
        
        WebElement e = driver.findElement(By.name("username"));
        
        e.sendKeys(username);
        e = driver.findElement(By.name("password"));
        e.sendKeys(password);
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(password);
        
        e = driver.findElement(By.name("signup"));
        e.click();
        
    }
    
    @Then("a new user is created")
    public void newUserCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @When("a valid username {string} and invalid password {string} and matching password confirmation are entered")
    public void validUserInvalidPassword(String username, String password) {
        WebElement e = driver.findElement(By.name("username"));
        
        e.sendKeys(username);
        e = driver.findElement(By.name("password"));
        e.sendKeys(password);
        e = driver.findElement(By.name("passwordConfirmation"));
        e.sendKeys(password);
        
        e = driver.findElement(By.name("signup"));
        e.click();
    }
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonExistentUsernameGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreated(String error) {
        pageHasContent(error);
    } 
    
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
}
