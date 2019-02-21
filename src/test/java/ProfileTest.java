import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProfileTest {

    private WebDriver driver;
    public Helpers helper;
    public JavascriptExecutor javaExecutor;
    public Random random;
    public Randomizer randomizer;
    public WebDriverWait wait;


    @DataProvider
    public Object[][] routes(){
        return new Object[][]{
                {"https://www.petsexpert.de/"},
                {"https://www.petsexpert.co.uk/"},
                {"https://www.petsexpert.es/"},
        };
    }



    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        helper = new Helpers(driver);
        javaExecutor = (JavascriptExecutor) driver;
        random = new Random();
        wait = new WebDriverWait(driver, 10);
        randomizer = new Randomizer();

    }



    @Test (dataProvider = "routes")
    public void test(String route) throws InterruptedException {
        driver.get(route);

        //Login and redirect to membership page
        helper.loginAs("o.kir@mailinator.com", "123456");
        helper.findElement(ProfileTestLocators.blockProfile).click();

        //Fill account information with new data that differs from old one
        javaExecutor.executeScript("arguments[0].scrollIntoView();", driver.findElement(ProfileTestLocators.fldFirstName));
        String FirstName = helper.sendkeys(ProfileTestLocators.fldFirstName, randomizer.generateString());
        String SurName = helper.sendkeys(ProfileTestLocators.fldSurname, randomizer.generateString());
        String Street = helper.sendkeys(ProfileTestLocators.fldStreet, randomizer.generateString());
        String House = helper.sendkeys(ProfileTestLocators.fldHouse, randomizer.generateString());
        String City = helper.sendkeys(ProfileTestLocators.fldCity, randomizer.generateString());
        String Phone = helper.sendkeys(ProfileTestLocators.fldPhone, "123");

        //Change check/uncheck dog as a pet
        driver.findElement(ProfileTestLocators.chkAnimal).click();
        Boolean changeCheck = driver.findElement(ProfileTestLocators.chkAnimal).isSelected();

        //Change country and corresponding postal code
        helper.findElement(ProfileTestLocators.slctCountry).click();
        Select dropdownCountry = new Select(driver.findElement(ProfileTestLocators.slctCountry));
        int  randomInt = random.nextInt(40);
        //If project is now Switzerland, this country can't be chosen in the dropdown;
        if(route != "https://www.petsexpert.ch/"){
            while (randomInt != 3){
                randomInt = random.nextInt(40);
            }
        }
        dropdownCountry.selectByIndex(randomInt);
        String currentCountry = driver.findElement(ProfileTestLocators.slctCountry).getAttribute("value");
        System.out.println(currentCountry);
        String PostalCode = helper.sendkeys(ProfileTestLocators.fldPostCode, helper.countriesMap.get(currentCountry));
        System.out.println(helper.countriesMap.get(currentCountry));

        //Save information
        driver.findElement(ProfileTestLocators.btnUpdateInformation).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ProfileTestLocators.blockSuccessfullSave)));

        //Check saved information
        javaExecutor.executeScript("arguments[0].scrollIntoView();", driver.findElement(ProfileTestLocators.fldFirstName));
        Assert.assertEquals(FirstName, driver.findElement(ProfileTestLocators.fldFirstName).getAttribute("value"));
        Assert.assertEquals(SurName, driver.findElement(ProfileTestLocators.fldSurname).getAttribute("value"));
        Assert.assertEquals(Street, driver.findElement(ProfileTestLocators.fldStreet).getAttribute("value"));
        Assert.assertEquals(House, driver.findElement(ProfileTestLocators.fldHouse).getAttribute("value"));
        Assert.assertEquals(City, driver.findElement(ProfileTestLocators.fldCity).getAttribute("value"));
        Assert.assertEquals(Phone, driver.findElement(ProfileTestLocators.fldPhone).getAttribute("value"));
        Assert.assertEquals(PostalCode, driver.findElement(ProfileTestLocators.fldPostCode).getAttribute("value"));
        Boolean verifyCheck = driver.findElement(ProfileTestLocators.chkAnimal).isSelected();
        Assert.assertEquals(changeCheck, verifyCheck);
    }


    @AfterTest
    public  void quit(){
        driver.quit();
    }

}
