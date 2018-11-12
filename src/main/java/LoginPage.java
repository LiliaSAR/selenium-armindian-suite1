import base.BasePage;
import org.openqa.selenium.By;

import static base.WaitHelper.waitForElementToBeVisible;

public class LoginPage extends BasePage {
    //private By usernameField = By.name("login");
    //private By passwordField = By.name("password");
    //private By signInButton = By.name("commit");
    //private By errorMessage = By.cssSelector("#js-flash-container .flash-error");
    private By usernameField = By.id("Email");
    private By passwordField = By.id("Password");
    private By signInButton = By.id("btnSubmit");
    private By errorMessage = By.cssSelector("#Message div");

    public LoginPage() {
        super();
        driver.get(getUrl());
    }

   // public String getUrl() {
    //    return "https://github.com/login";
    //}

     public String getUrl() {
         return "https://portal.citynabz.com/Account/Login";
     }

    public void loginWith(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(signInButton);
    }

    public boolean isErrorMessageDisplayed() {
        waitForElementToBeVisible(errorMessage);
        return isDisplayed(errorMessage);
    }


}
