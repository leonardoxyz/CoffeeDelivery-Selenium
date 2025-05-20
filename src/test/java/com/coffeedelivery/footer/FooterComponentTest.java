package com.coffeedelivery.footer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coffeedelivery.base.BaseTest;

public class FooterComponentTest extends BaseTest{
	private FooterComponentValidator validator;
	private FooterComponent footerComponent;
	
	@Test
	@DisplayName("It should validate the footer context")
	public void validateFooterContext() {
		footerComponent = new FooterComponent(driver, new FooterComponentLocators());
		validator = new FooterComponentValidator(driver);
		
		footerComponent.navigateToFooterComponent();
		
		validator.validateFooterComponentContext();
	}
}