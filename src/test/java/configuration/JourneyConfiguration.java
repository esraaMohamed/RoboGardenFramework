package configuration;

import pageobjects.JourneyPageObject;
import pageobjects.RoadMapPageObject;

public class JourneyConfiguration {

    JourneyPageObject journeyPage;

    int journeyCount;

    public JourneyConfiguration(JourneyPageObject journeyPage) {
        this.journeyPage = journeyPage;
    }

    public RoadMapPageObject clickPlayNowButtonByIndex(int index) {
        return journeyPage.clickOnPlayNowButtonByIndex(index);
    }

    public int journeyCount() {
        journeyCount = journeyPage.getJourneyCount();
        return journeyCount;
    }
    
    public void clickTextualJourneysLink() {
    		journeyPage.clickTextualJourneyLink();
    }
}
