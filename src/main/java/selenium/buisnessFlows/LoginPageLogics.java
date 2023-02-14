/**
 * A class to contain all methods needed in the login page
 */
package selenium.buisnessFlows;

import selenium.utils.SeleniumActions;

public class LoginPageLogics extends SeleniumActions {

    /**
     * Open the website
     * @param url
     */
    public void openWebsite(String url)
    {
        driver.get(url);
    }

    /**
     * Login to the website
     * @param email
     * @param password
     */
    public void login(String email,String password)
    {
        updateText(loginPg.emailTextBox,email,true);
        updateText(loginPg.passwordTextBox,password,true);
        click(loginPg.loginButton);

    }
}
