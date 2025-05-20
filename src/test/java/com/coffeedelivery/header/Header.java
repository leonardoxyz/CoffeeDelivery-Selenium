package com.coffeedelivery.header;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
	private final WebDriver driver;
	private final HeaderLocators headerLocators;
	
	public Header(WebDriver driver, HeaderLocators headerLocators) {
		this.driver = driver;
		this.headerLocators = headerLocators;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getLogoImageElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(headerLocators.logo));
	}
	
	public WebElement getLocalizationElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(headerLocators.localization));
	}
	
	public WebElement getCartElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(headerLocators.cart));
	}
	
	public WebElement clickOnCartButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(headerLocators.cart));
		cartElement.click();
		return cartElement;
	}
}