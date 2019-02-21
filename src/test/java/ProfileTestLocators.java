import org.openqa.selenium.By;

public class ProfileTestLocators {

    public static By blockProfile = By.xpath("//a[contains(@class,'login header-button header-profile')]");
    public static By fldFirstName = By.xpath("//form[1]/div[8]/div[1]/input[1]");
    public static By fldSurname = By.xpath("//form[1]/div[8]/div[2]/input[1]");
    public static By fldStreet = By.xpath("//form[1]/div[9]/div[1]/input[1]");
    public static By fldHouse = By.xpath("//form[1]/div[9]/div[2]/input[1]");
    public static By fldCity = By.xpath("//form[1]/div[10]/div[1]/input[1]");
    public static By slctCountry = By.xpath("//form[1]/div[11]/div[1]/div[1]/select[1]");
    public static By fldPhone = By.xpath("//form[1]/div[11]/div[2]/div[1]/input[1]");
    public static By chkAnimal = By.xpath("//form[1]/div[15]/div[1]/ul[1]/li[1]/input[1]");
    public static By fldPostCode = By.xpath("//form[1]/div[10]/div[2]/input[1]");
    public static By btnUpdateInformation = By.xpath("//form[1]/div[13]/div[2]/button[1]");
    public static By blockSuccessfullSave = By.xpath("//main[1]/section[1]/section[1]/section[1]/div[1]/div[1]/div[1]");

}
