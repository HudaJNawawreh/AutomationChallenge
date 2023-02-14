/**
 * Initiating variables
 */
package selenium.utils;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.buisnessFlows.HomePageLogics;
import selenium.buisnessFlows.LoginPageLogics;
import selenium.buisnessFlows.OrderPageLogics;
import selenium.buisnessFlows.TrackingPageLogics;
import selenium.pagesObjects.HomePageObjects;
import selenium.pagesObjects.LoginPageObjects;
import selenium.pagesObjects.OrderPageObjects;
import selenium.pagesObjects.TrackingPageObjects;

import java.time.Duration;

public class ManagePages extends baseClass {

    public static void initObjectsAndLogics()
    {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);

        loginPg= PageFactory.initElements(driver, LoginPageObjects.class);
        homePg = PageFactory.initElements(driver, HomePageObjects.class);
        trackPg = PageFactory.initElements(driver, TrackingPageObjects.class);
        orderPg =PageFactory.initElements(driver, OrderPageObjects.class);


        loginPageLogics = new LoginPageLogics();
        homePageLogics = new HomePageLogics();
        trackingPageLogics = new TrackingPageLogics();
        orderPageLogics = new OrderPageLogics();

    }
}