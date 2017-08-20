package com.soci.tests;

import org.junit.After;
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
	public void calculateLiveOctopusByPairs() {
		// Create LiveOctopusPage object
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);

		int i;
		int a;
		int b;
		int sum;

		String textAreaValue = "";
		// Calculate the value of each option pair, not including Live Octopus
		// Selects each option, only until second to the last option
		for (i = 0; i < 5; i++) {
			liveOctopusPage.selectShirtByIndex(i);
			a = Integer.parseInt(liveOctopusPage.getTextAreaValue());
			int j;
			// Second select
			for (j = i; j < 5; j++) {
				liveOctopusPage.selectShirtByIndex(j);
				// Getting value of second selection
				b = Integer.parseInt(liveOctopusPage.getTextAreaValue());
				// Computing the sum of the two values
				sum = a + b;
				System.out.println("Calculating using formula: (" + a + " + " + b + ")=" + sum);
				// Check if sum is equal to 5
				if (sum == 5) {
					// Select Live Octopus by value
					liveOctopusPage.selectShirtByValue("0000000" + sum);
					textAreaValue = liveOctopusPage.getTextAreaValue();
					// Validate value in text area after selecting Live Octopus
					Assert.assertTrue(textAreaValue == "00000005");
				}
			}
		}

	}

	// 1+2+2=5
	@Test
	public void CalculateUsing1plus2plus2() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);

		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(1);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = a + b + c;

		fs = String.format("Calculating using formula: (%s+%s+%s)=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");

	}

	// 1+3+1
	@Test
	public void CalculateUsing1Plus3Plus1() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);

		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(1);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(3);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(1);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = a + b + c;

		fs = String.format("Calculating using formula: (%s+%s+%s)=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");

	}

	// (2*2)+1
	@Test
	public void CalculateUsingTwice2Plus1() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(2);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(1);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = a * b + c;

		fs = String.format("Calculating using formula: (%s*%s)+%s=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");

	}

	// (1+2+3+4)/2 = 5
	@Test
	public void CalculateUsingSumAllOverTwo() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int d;
		int e;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(1);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(3);
		c = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(4);
		d = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		e = liveOctopusPage.getTextAreaValueAsInt();

		result = (a + b + c + d) / e;

		fs = String.format("Calculating using formula: (%s+%s+%s+%s)/%s=%s", a, b, c, d, e, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	// (4/2)+3
	@Test
	public void Calculate4Over2Plus3() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(4);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(3);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = (a / b) + c;

		fs = String.format("Calculating using formula: (%s/%s)+%s=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	// (4-1)+2
	@Test
	public void CalculateUsing4Minus1Plus2() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(4);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(1);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = (a - b) + c;

		fs = String.format("Calculating using formula: (%s" + "-" + "%s)+%s=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	// (2*3*4)/(2*2)
	@Test
	public void CalculateUsing2By3By4Over2By3() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int d;
		int e;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(2);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(3);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(4);
		c = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		d = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		e = liveOctopusPage.getTextAreaValueAsInt();

		result = (a * b * c) / (d * e);

		fs = String.format("Calculating using formula: (%s*%s*%s)/(%s*%s)=%s", a, b, c, d, e, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	// (1*2*3)-1
	@Test
	public void CalculateUsing1By2By3Minus1() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int d;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(1);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(3);
		c = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(1);
		d = liveOctopusPage.getTextAreaValueAsInt();

		result = (a * b * c) - d;

		fs = String.format("Calculating using formula: (%s*%s*%s)-%s=%s", a, b, c, d, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	// (2*3)-1
	@Test
	public void CalculateUsing2By3Minus1() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(2);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(3);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(1);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = (a * b) - c;

		fs = String.format("Calculating using formula: (%s*%s)-%s=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	// (3%2)+4
	@Test
	public void CalculateUsin4Minus1Plus2g() {
		LiveOctopusPage liveOctopusPage = new LiveOctopusPage(driver);
		int a;
		int b;
		int c;
		int result;
		String fs;

		liveOctopusPage.selectShirtByIndex(3);
		a = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(2);
		b = liveOctopusPage.getTextAreaValueAsInt();
		liveOctopusPage.selectShirtByIndex(4);
		c = liveOctopusPage.getTextAreaValueAsInt();

		result = (a % b) + c;

		fs = String.format("Calculating using formula: (%s" + "%" + "%s)+%s=%s", a, b, c, result);
		System.out.println(fs);

		Assert.assertTrue(liveOctopusPage.getTextAreaValue() == "00000005");
	}

	@After
	public void tearDown() {
		driver.close();
	}

}
