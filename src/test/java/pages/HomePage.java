package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

import java.util.List;

public class HomePage extends TestBase {

    @FindBy(xpath =".//input[@id='typeahead-input-desktop']")
    private WebElement searchField;

    @FindBy(xpath =".//i[@class='icon icon-search']")
    private WebElement btnLent;

    @FindBy(xpath =".//a[@href='/mens/ga-1?query=buffalo bills caps']")
    private WebElement checkBoxMens;

    @FindBy(xpath =".//a[@data-trk-id='mens-sizes.view-more']")
    private WebElement btnMoreSizes;

    @FindBy(xpath =".//a[text()='7 3/4']")
    private WebElement btnSize734;

    @FindBy(xpath =".//a[@id='9']")
    private WebElement golfLogo;

    @FindBy(xpath =".//a[@id='2']")
    private WebElement ncaaLogo;

    @FindBy(xpath =".//a[@href='/golf-tiger-woods/o-11+a-8940']")
    private WebElement linkTigerWoods;

    @FindBy(xpath =".//div[@class='product-card row']")
    private List<WebElement> capsInPage;

    @FindBy(xpath =".//a[contains(text(),'Account')]")
    private WebElement btnAccount;

    @FindBy(xpath =".//div[@class='column']")
    private List<WebElement> listAllTigerWoodsItems;

    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public LogInPage logInUser(){
        btnAccount.click();
        return new LogInPage(driver);
    }

    public int searchTeamsCaps() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(6000);
        searchField.sendKeys("buffalo bills caps");
        btnLent.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        checkBoxMens.click();
        Thread.sleep(2000);
        btnMoreSizes.click();
        Thread.sleep(2000);
        btnSize734.click();
        int numberOfCaps=capsInPage.size();
        System.out.println("Only " +numberOfCaps+" Bills Caps (Size 7 3/4) are available!");
        return numberOfCaps;
    }

    public int searchTigerWoodsItems() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(6000);
        Actions action = new Actions(driver);
        action.moveToElement(golfLogo).build().perform();
        Thread.sleep(2000);
        linkTigerWoods.click();
        int itemsWoods = listAllTigerWoodsItems.size();
        System.out.println("Tiger Woods items on the page are: " +itemsWoods);
        return itemsWoods;
    }

    public CollegeTeamsPage searchCollegeTeams() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(6000);
        Actions action = new Actions(driver);
        action.moveToElement(ncaaLogo).click().build().perform();
        Thread.sleep(2000);
        return new CollegeTeamsPage(driver);
    }

}
