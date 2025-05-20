package com.coffeedelivery.sellpage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coffeedelivery.base.BaseTest;

public class SellPageTest extends BaseTest{
	private SellPageValidator validator;
	private SellPage sellPage;
	
	@Test
	@DisplayName("It must validate the existence of an image on the product card")
	public void validateProductImage() {
		sellPage = new SellPage(driver, new SellPageLocators());
		validator = new SellPageValidator(driver);
		
		sellPage.navigateToProductSection();
		
		validator.validateProductCard(1);
	}

	@Test
	@DisplayName("It must validate the product quantity increment and decrement functionality")
	public void validateProductQuantity() {
		sellPage = new SellPage(driver, new SellPageLocators());
		validator = new SellPageValidator(driver);
		
		sellPage.navigateToProductSection();
		
		validator.validateProductQuantity(1);
	}
}
