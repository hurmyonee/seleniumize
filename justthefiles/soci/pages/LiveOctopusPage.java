package com.soci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class LiveOctopusPage {
	private WebDriver driver;
	private WebDriverWait wait;


	String workingDir = System.getProperty("user.dir");

	// Page Location
	private String location = "file://" + workingDir + "/src/com/soci/html/testPage.html";

	// Locators

	// Combo Box
	@FindBy(how = How.ID, using = "shirt")
	private WebElement shirtDropdown;

	// Text Area
	@FindBy(how = How.ID, using = "theText")
	private WebElement textArea;

	 public void selectShirtByValue(String value){
	 Select selectShirt = new Select(shirtDropdown);
	 selectShirt.selectByValue(value);

	 logSelections(selectShirt);
	 }
	
	 public void selectShirtByIndex(int index){
	 Select selectShirt = new Select(shirtDropdown);
	 selectShirt.selectByIndex(index);
	 
	 logSelections(selectShirt);
	 }
	 
	 private String getSelectedOptionText(Select select){
		 return select.getFirstSelectedOption().getText();
	 }
	 
	 private String getSelectedOptionValue(Select select){
		 return select.getFirstSelectedOption().getAttribute("value");
	 }

	 private void logSelections(Select select){
		 System.out.println("Selected " + getSelectedOptionText(select) + " with value of " + getSelectedOptionValue(select));
	 }

	// Constructor
	public LiveOctopusPage(WebDriver driver) {
		this.driver = driver;
		driver.get(location);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	public WebElement getShirtDropdown() {
		return shirtDropdown;
	}

	public String getTextAreaValue() {
		return textArea.getText();
	}
	
	
}
