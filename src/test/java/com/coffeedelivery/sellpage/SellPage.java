package com.coffeedelivery.sellpage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellPage {
	private final WebDriver driver;
	private final SellPageLocators sellPageLocators;

	public SellPage(WebDriver driver, SellPageLocators sellPageLocators) {
		this.driver = driver;
		this.sellPageLocators = sellPageLocators;
	}

	public void navigateToProductSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(sellPageLocators.productSection));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);

		wait.until(ExpectedConditions.visibilityOf(section));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public WebElement getProductImageElement(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductImage(index)));
	}

	public WebElement getProductType(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductType(index)));
	}

	public WebElement getProductTitle(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductTitle(index)));
	}

	public WebElement getProductDescription(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductDescription(index)));
	}

	public WebElement getProductPrice(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductPrice(index)));
	}

	public WebElement getProductQuantityComponent(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductQuantity(index)));
	}

	public WebElement getProductAddToCart(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductAddToCart(index)));
	}

	public void clickOnDecrementItemQuantityButton(int index) {
		driver.findElement(sellPageLocators.getProductDecrementButton(index)).click();
	}

	public void clickOnIncrementItemQuantityButton(int index) {
		driver.findElement(sellPageLocators.getProductIncrementButton(index)).click();
	}

	public int getCurrentQuantity(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement quantityElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(sellPageLocators.getProductItemQuantity(index)));
		return Integer.parseInt(quantityElement.getText());
	}
}