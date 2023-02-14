/**
 * A class to contain all methods needed in th home page of the website
 */
package selenium.buisnessFlows;


import selenium.utils.SeleniumActions;

public class HomePageLogics extends SeleniumActions {

    public enum Section
    {
        Tracking,
        Order_History,
        Pickups,
        Reports,
        Payments,
        Settings,
        DashBoards_Tour

    }

    /**
     * Navigate to a section from the side menu
     * @param section
     */
    public void navigateToSection(Section section)
    {
        switch (section)
        {
            case Tracking:
            {
                click(homePg.trackingOption);
                waitForElementPresent(trackPg.searchButton);
            }
        }
    }
}
