package com.soci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProjectPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// Page URL
	private static String URL = "https://www.mysamplepage.com";

	// Locators

	// Add Project button
	@FindBy(how = How.CLASS_NAME, using = "add_project")
	private WebElement projectAddButton;

	// Project Name text input
	@FindBy(how = How.XPATH, using = "//*[@id='project_name']")
	private WebElement projectNameInput;

	// Person Name text input
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'create_project')]//TABLE//TR[5]/TD[2]/INPUT")
	private WebElement personNameInput;

	// Person Email text input
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'create_project')]//TABLE//TR[6]/TD[2]/INPUT")
	private WebElement personEmailInput;

	// Person Phone text input
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'create_project')]//TABLE//TR[7]/TD[2]/INPUT")
	private WebElement personPhoneInput;

	// Person Website text input
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'create_project')]//TABLE//TR[8]/TD[2]/INPUT")
	private WebElement personWebsiteInput;

	// Person City text input
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'create_project')]//TABLE//TR[9]/TD[2]/INPUT")
	private WebElement personCityInput;

	// Person Postal Code text input
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'create_project')]//TABLE//TR[10]/TD[2]/INPUT")
	private WebElement personPostalCodeInput;

	// Create Project button
	@FindBy(how = How.CLASS_NAME, using = "create")
	private WebElement projectCreateButton;

	// Project Name text field
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'project_name’)]//TABLE//TR")
	private WebElement projectName;

	// Constructor
	public CreateProjectPage(WebDriver driver) {
		this.driver = driver;
		driver.get(URL);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	public void clickProjectAddButton() {
		wait.until(ExpectedConditions.elementToBeClickable(projectAddButton));
		projectAddButton.click();
	}

	public void enterProjectName(String projectName) {
		wait.until(ExpectedConditions.elementToBeClickable(projectNameInput));
		projectNameInput.clear();
		projectNameInput.sendKeys(projectName);
	}

	public void enterPersonName(String personName) {
		wait.until(ExpectedConditions.elementToBeClickable(personNameInput));
		personNameInput.clear();
		personNameInput.sendKeys(personName);
	}

	public void enterPersonEmail(String personEmail) {
		wait.until(ExpectedConditions.elementToBeClickable(personEmailInput));
		personEmailInput.clear();
		personEmailInput.sendKeys(personEmail);
	}

	public void enterPersonPhone(String personPhone) {
		wait.until(ExpectedConditions.elementToBeClickable(personPhoneInput));
		personPhoneInput.clear();
		personPhoneInput.sendKeys(personPhone);
	}

	public void enterPersonWebsite(String personWebsite) {
		wait.until(ExpectedConditions.elementToBeClickable(personWebsiteInput));
		personWebsiteInput.clear();
		personWebsiteInput.sendKeys(personWebsite);
	}

	public void enterPersonCity(String personCity) {
		wait.until(ExpectedConditions.elementToBeClickable(personCityInput));
		personCityInput.clear();
		personCityInput.sendKeys(personCity);
	}

	public void enterPersonPostalCode(String personPostalCode) {
		wait.until(ExpectedConditions.elementToBeClickable(personPostalCodeInput));
		personPostalCodeInput.clear();
		personPostalCodeInput.sendKeys(personPostalCode);
	}

	public void clickProjectCreateButton() {
		waitUntilProjectCreateButtonClickable();
		projectCreateButton.click();
	}

	public void waitUntilProjectAddButtonClickable() {
		wait.until(ExpectedConditions.elementToBeClickable(projectAddButton));
	}

	public void waitUntilProjectNameInputPresent() {
		wait.until(ExpectedConditions.visibilityOf(projectNameInput));
	}

	public void waitUntilProjectCreateButtonClickable() {
		wait.until(ExpectedConditions.elementToBeClickable(projectCreateButton));
	}

	public String getProjectName() {
		return projectName.getText();
	}
}
