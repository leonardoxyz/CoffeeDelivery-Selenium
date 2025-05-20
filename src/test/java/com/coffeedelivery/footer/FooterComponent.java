package com.coffeedelivery.footer;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterComponent {
	private final WebDriver driver;
	private final FooterComponentLocators footerComponentLocators;

	public FooterComponent(WebDriver driver, FooterComponentLocators footerComponentLocators) {
		this.driver = driver;
		this.footerComponentLocators = footerComponentLocators;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void navigateToFooterComponent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement section = wait
				.until(ExpectedConditions.presenceOfElementLocated(footerComponentLocators.footerComponent));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);

		wait.until(ExpectedConditions.visibilityOf(section));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public String getFooterText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement footerTextElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(footerComponentLocators.footerText));
		return footerTextElement.getText();
	}
}