package com.coffeedelivery.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.List;

public class HomePage {
	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getInformationItems() {
		return driver.findElements(HomePageLocators.INFORMATION_ITEMS.get(0));
	}

	public String getInformationItemText(int index) {
		return driver.findElement(HomePageLocators.INFORMATION_ITEMS.get(index)).getText();
	}

	public boolean isInformationItemDisplayed(int index) {
		try {
			return driver.findElement(HomePageLocators.INFORMATION_ITEMS.get(index)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public WebElement getCoffeeImageElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div[1]/img")));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}