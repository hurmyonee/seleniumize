package com.soci.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.soci.pages.LiveOctopusPage;

public class LiveOctopusTest {
	WebDriver driver;
	
	@Before
	public void setup() {
		// use FF Driver
		driver = new FirefoxDriver();
		driver.get("file:///Users/adriennedelval/Documents/workspace/SeleniumExercise/src/com/soci/html/testPage.html");
	}
	
	@Test
	public void calculateLiveOctopus() {
		//Create LiveOctopusPage object
//		System.setProperty("webdriver.gecko.driver", "/Users/adriennedelval/Documents");
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		
		int i;
		int a;
		int b;
		int sum;
		String textAreaValue = "";
		//Calculate the value of each option pair, not including Live Octopus
		//Selects each option, only until second to the last option
		for(i=0; i < 5; i++){
			liveOctopusPage.selectShirtByIndex(i);
			a = Integer.parseInt(liveOctopusPage.getTextAreaValue());
			int j;
			//Second select
			for(j=i;j < 5; j++){
				liveOctopusPage.selectShirtByIndex(j);
				//Getting value of second selection
				b = Integer.parseInt(liveOctopusPage.getTextAreaValue());
				//Computing the sum of the two values
				sum = a + b;
				System.out.println("Calculating using formula: (" + a + " + " + b + ")=" + sum );
				//Check if sum is equal to 5
				if(sum == 5){
					//Select Live Octopus by value
					liveOctopusPage.selectShirtByValue("00000005");
					textAreaValue = liveOctopusPage.getTextAreaValue();
					//Validate value in text area after selecting Live Octopus
					Assert.assertTrue(textAreaValue == "00000005");
				}
			}
		}
						
	}

}