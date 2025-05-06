package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "userName")
    public WebElement username;
    @FindBy(how = How.ID, using = "password")
    public WebElement password;
    @FindBy(how = How.ID, using = "login")
    public WebElement loginButton;

    public void loginActions(String username1, String password1) {
        username.sendKeys(username1);
        password.sendKeys(password1);
        loginButton.click();

    }


}
