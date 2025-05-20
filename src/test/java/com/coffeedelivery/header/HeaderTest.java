package com.coffeedelivery.header;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coffeedelivery.base.BaseTest;

public class HeaderTest extends BaseTest{
	private HeaderValidator validator;
	
	@Test
	@DisplayName("It should validate the logo image.")
	public void validateSystemLogo() {
		validator = new HeaderValidator(driver);
		validator.validateHeader();
	}
	
	@Test
	@DisplayName("It should validate the cart navigation and page display")
	public void validateCartNavigation() {
		validator = new HeaderValidator(driver);
		validator.validateCartNavigation();
	}
}