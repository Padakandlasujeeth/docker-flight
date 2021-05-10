package com.udemy.selenium_docker.seleniumdocker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

public class BookFlightTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setupDriver(){
		String chromeDriverPath = "C:\\Users\\721396\\udemy\\seleniumdocker\\chromedriver.exe";
		System.out.println(chromeDriverPath+"chrome driver path");
		System.setProperty("WebDriver.chrome.driver", chromeDriverPath);
		this.driver = new ChromeDriver();
	}
	
	@Test
	public void registrationPageTest(){
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTO();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredentials("selenium", "docker");
		registrationPage.submit();
	}
	
	@Test(dependsOnMethods = "registrationPageTest")
	public void registrationConfirmationPage(){
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
	}
	
	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage(){
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.selectPassengers("2");
		flightDetailsPage.goToFindFilghtsPage();
		
	}
	
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage(){
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFinalFlightPage();
		findFlightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage(){
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		flightConfirmationPage.printConfirmation();
	}

}
