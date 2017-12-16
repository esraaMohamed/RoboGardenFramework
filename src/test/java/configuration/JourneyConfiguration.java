package configuration;

import pageobjects.JourneyPageObject;
import pageobjects.RoadMapPageObject;

public class JourneyConfiguration {
	JourneyPageObject journeyPage;
	
	public JourneyConfiguration(JourneyPageObject journeyPage) {
		this.journeyPage = journeyPage;
	}
	
	public RoadMapPageObject clickPlayNowButton() {
		return journeyPage.clickOnPlayNowButton();
	}
}
