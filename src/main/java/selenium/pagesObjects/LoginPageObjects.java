/**
 *Holding the web elements of the login page
 */
package selenium.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
    public String url="https://dashboard-qa.ninjavan.co/login-v2";

    @FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy(id="password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

}
