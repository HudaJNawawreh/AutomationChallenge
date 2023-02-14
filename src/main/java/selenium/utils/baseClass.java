/**
 * Definning the main variable that will be needed in the project
 */
package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.buisnessFlows.HomePageLogics;
import selenium.buisnessFlows.LoginPageLogics;
import selenium.buisnessFlows.OrderPageLogics;
import selenium.buisnessFlows.TrackingPageLogics;
import selenium.pagesObjects.HomePageObjects;
import selenium.pagesObjects.LoginPageObjects;
import selenium.pagesObjects.OrderPageObjects;
import selenium.pagesObjects.TrackingPageObjects;

public class baseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;


    public static LoginPageObjects loginPg;
    public static HomePageObjects homePg;
    public static TrackingPageObjects trackPg;
    public static OrderPageObjects orderPg;

    public static LoginPageLogics loginPageLogics;
    public static HomePageLogics homePageLogics;
    public static TrackingPageLogics trackingPageLogics;
    public static OrderPageLogics orderPageLogics;




}
