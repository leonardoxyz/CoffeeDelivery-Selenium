package com.coffeedelivery.sellpage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class SellPageValidator {
	private final SellPage sellPage;

	public SellPageValidator(WebDriver driver) {
		this.sellPage = new SellPage(driver, new SellPageLocators());
	}

	public void validateProductCard(int index) {
		validateProductImage(index);
		validateProductType(index);
		validateProductTitle(index);
		validateProductDescription(index);
		validateProductPrice(index);
		validateProductQuantityComponent(index);
		validateProductAddToCart(index);
	}

	public void validateProductQuantity(int index) {
		assertEquals(1, sellPage.getCurrentQuantity(index), "Initial quantity should be 1");
		
		sellPage.clickOnIncrementItemQuantityButton(index);
		assertEquals(2, sellPage.getCurrentQuantity(index), "Quantity should be 2 after increment");
		
		try {
			Thread.sleep(Duration.ofSeconds(3).toMillis());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		sellPage.clickOnDecrementItemQuantityButton(index);
		assertEquals(1, sellPage.getCurrentQuantity(index), "Quantity should be 1 after decrement");
	}

	private void validateProductImage(int index) {
		WebElement productImage = sellPage.getProductImageElement(index);
		assertTrue(productImage.isDisplayed(), "The product image isn't displayed");
	}
	
	private void validateProductType(int index) {
		WebElement productType = sellPage.getProductType(index);
		assertTrue(productType.isDisplayed(), "The product type isn't displayed");
	}
	
	private void validateProductTitle(int index) {
		WebElement productTitle = sellPage.getProductTitle(index);
		assertTrue(productTitle.isDisplayed(), "The product title isn't displayed");
	}
	
	private void validateProductDescription(int index) {
		WebElement productDescription = sellPage.getProductDescription(index);
		assertTrue(productDescription.isDisplayed(), "The description type isn't displayed");
	}
	
	private void validateProductPrice(int index) {
		WebElement productPrice = sellPage.getProductPrice(index);
		assertTrue(productPrice.isDisplayed(), "The product price isn't displayed");
	}
	
	private void validateProductQuantityComponent(int index) {
		WebElement productQuantityComponent = sellPage.getProductQuantityComponent(index);
		assertTrue(productQuantityComponent.isDisplayed(), "The product quantity component isn't displayed");
	}
	
	private void validateProductAddToCart(int index) {
		WebElement addProductToCart = sellPage.getProductAddToCart(index);
		assertTrue(addProductToCart.isDisplayed(), "The button to add product to cart isn't displayed");
	}
}