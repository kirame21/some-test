import org.openqa.selenium.By;

public class HelpersLocators {

    public static By blockProfile = By.xpath("//a[contains(@class,'login header-button header-profile')]");
    public static By fldLogin = By.xpath("//header[1]/div[2]/div[2]/form[1]/div[1]/input[1]");
    public static By fldPassword = By.xpath("//header[1]/div[2]/div[2]/form[1]/div[2]/input[1]");
    public static By btnSubmitLogin = By.xpath("//form[1]/div[4]/button[1]");

}
