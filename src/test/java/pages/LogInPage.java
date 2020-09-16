package pages;

import core.ExcelDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LogInPage extends TestBase {

    @FindBy(xpath =".//input[@id='emailInput']")
    private WebElement emailField;

    @FindBy(xpath =".//input[@id='passwordInput']")
    private WebElement passwordField;

    @FindBy(xpath =".//div[@class='recaptcha-checkbox-border']")
    private WebElement captchaBox;

    @FindBy(xpath =".//button[text()='Log In']")
    private WebElement btnLogIn;

    @FindBy(xpath =".//div[@class='field-wrapper-error']")
    private WebElement msgError;

    private WebDriver driver;
    public LogInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String insertCredentials() throws IOException, InterruptedException {
        //List<Map<String,String>> testDataInMap= ExcelDataProvider.getTestDataInMap();
        //emailField.sendKeys(testDataInMap.get(2).get("UserName"));
        //passwordField.sendKeys(testDataInMap.get(2).get("Password"));
        driver.navigate().refresh();
        Thread.sleep(2000);
        emailField.sendKeys("userExample");
        passwordField.sendKeys("password");
        //captchaBox.click();
        //btnLogIn.click();
        String error = msgError.getText();
        return error;
    }

}
