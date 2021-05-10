package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//font[contains(text(),'Confirmation')]")
	private WebElement flightConfirmationHeader;
	
	@FindBy(xpath = "//table[@id=\"confirm-table\"]/tbody/tr[3]/td[2]")
	private WebElement price;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffLink;
	
	public FlightConfirmationPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void printConfirmation(){
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
		System.out.println(this.flightConfirmationHeader.getText());
		System.out.println(this.price);
		this.signOffLink.click();
	}

}
