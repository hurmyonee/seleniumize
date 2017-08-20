package com.soci.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.soci.pages.CreateProjectPage;

public class CreateNewProjectTest {
	WebDriver driver;
	String PROJECT_NAME = "Project 123";
	String PERSON_NAME = "Bob Jones";
	String PERSON_EMAIL = "bobjones@email.com";
	String PERSON_PHONE = "858-544-2342";
	String PERSON_WEBSITE = "www.bobjones.com";
	String PERSON_CITY = "San Jose";
	String PERSON_POSTAL_CODE = "95130";

	@Before
	public void setup() {
		// use FF Driver
		driver = new FirefoxDriver();
	}

	// Creates a new Project and assert that project name created matches the
	// given
	@Test
	public void createNewProject() {
		// Create CreateProjectPage object
		CreateProjectPage testpage = new CreateProjectPage(driver);
		String foundtext = "";

		// Wait until the Add Project button is clickable, then click
		testpage.waitUntilProjectAddButtonClickable();
		testpage.clickProjectAddButton();

		// Wait until the Project Name text input is present, then enter the
		// project name
		testpage.waitUntilProjectNameInputPresent();
		testpage.enterProjectName(PROJECT_NAME);

		testpage.enterPersonName(PERSON_NAME);
		testpage.enterPersonPhone(PERSON_PHONE);
		testpage.enterPersonEmail(PERSON_EMAIL);
		testpage.enterPersonWebsite(PERSON_WEBSITE);
		testpage.enterPersonCity(PERSON_CITY);
		testpage.enterPersonPostalCode(PERSON_POSTAL_CODE);

		testpage.waitUntilProjectCreateButtonClickable();
		testpage.clickProjectCreateButton();
		
		testpage.waitUntilProjectNameFieldAppears();

		foundtext = testpage.getProjectName();

		Assert.assertTrue(("Test failed, found text not equal to " + PROJECT_NAME), foundtext.equals(PROJECT_NAME));

	}

}
