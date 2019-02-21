import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Random;

public class Helpers {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javaExecutor;
    public HashMap <String, String> countriesMap = new HashMap<>();

    public Helpers(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        javaExecutor = (JavascriptExecutor) driver;
        putValuesInMap();
    }

    public WebElement findElement (By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);

    }

    public String sendkeys (By locator, String keys){
        findElement(locator).clear();
        findElement(locator).sendKeys(keys);
        return keys;
    }


    public void loginAs (String login, String password){

        findElement(HelpersLocators.blockProfile).click();
        findElement(HelpersLocators.fldLogin).sendKeys(login);
        findElement(HelpersLocators.fldPassword).sendKeys(password);
        findElement(HelpersLocators.btnSubmitLogin).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(HelpersLocators.blockProfile)));

    }

    public void putValuesInMap(){

        //Albania
        countriesMap.put("23", "1234");
        //Andorra
        countriesMap.put("27", "AD500");
        //Austria
        countriesMap.put("2", "1234");
        //Belgium
        countriesMap.put("5", "1234");
        //Bosnia and Herzegovina
        countriesMap.put("41", "12345");
        //Bulgaria
        countriesMap.put("50", "1234");
        //Canary Islands(Spain)
        countriesMap.put("260", "12345");
        //Croatia
        countriesMap.put("73", "12345");
        //Czech Republic
        countriesMap.put("17", "123 45");
        //Denmark
        countriesMap.put("8", "1234");
        //Estonia
        countriesMap.put("84", "12345");
        //Finland
        countriesMap.put("14", "12345");
        //France
        countriesMap.put("7", "1234");
        //Germany
        countriesMap.put("1", "12345");
        //Great Britain
        countriesMap.put("11", "AA1 2AA");
        //Greece
        countriesMap.put("18", "11523");
        //Greenland
        countriesMap.put("102", "3900");
        //Hungary
        countriesMap.put("114", "1234");
        //Iceland
        countriesMap.put("115", "123");
        //Ireland
        countriesMap.put("120", "H53");
        //Italy
        countriesMap.put("10", "12345");
        //Latvia
        countriesMap.put("135", "LV-1234");
        //Liechtenstein
        countriesMap.put("138", "9496");
        //Lithuania
        countriesMap.put("139", "12345");
        //Luxembourg
        countriesMap.put("6", "1234");
        //Macedonia
        countriesMap.put("233", "1234");
        //Malta
        countriesMap.put("146", "SNT 234");
        //Monaco
        countriesMap.put("151", "98034");
        //Montenegro
        countriesMap.put("154", "81234");
        //Netherlands
        countriesMap.put("4", "1234 AA");
        //Norway
        countriesMap.put("13", "1234");
        //Poland
        countriesMap.put("15", "12-345");
        //Portugal
        countriesMap.put("21", "1234");
        //Romania
        countriesMap.put("190", "123456");
        //San Marino
        countriesMap.put("201", "4789");
        //Serbia
        countriesMap.put("19", "24430");
        //Slovakia
        countriesMap.put("16", "123 45");
        //Slovenia
        countriesMap.put("20", "1234");
        //Spain
        countriesMap.put("9", "12345");
        //Sweden
        countriesMap.put("12", "123 45");
        //Switzerland
        countriesMap.put("3", "1234");
        //The Vatican City State
        countriesMap.put("111", "00120");


    }


}
