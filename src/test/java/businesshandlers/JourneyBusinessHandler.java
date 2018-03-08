package businesshandlers;

import pageobjects.JourneyPageObject;
import pageobjects.RoadMapPageObject;

public class JourneyBusinessHandler {

    JourneyPageObject journeyPage;

    int journeyCount;

    public JourneyBusinessHandler(JourneyPageObject journeyPage) {
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
