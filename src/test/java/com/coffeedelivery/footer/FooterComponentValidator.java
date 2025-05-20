package com.coffeedelivery.footer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

public class FooterComponentValidator {
	private final FooterComponent footerComponent;
	private static final String EXPECTED_FOOTER_TEXT = "Feito com ♥ por Ramon Pinheiro";
	
	public FooterComponentValidator(WebDriver driver) {
		this.footerComponent = new FooterComponent(driver, new FooterComponentLocators());
	}
	
	public void validateFooterComponentContext() {
		String actualText = footerComponent.getFooterText();
		assertEquals(EXPECTED_FOOTER_TEXT, actualText, 
			"O texto do footer está incorreto!\nExpected: " + EXPECTED_FOOTER_TEXT + 
			"\nResult: " + actualText);
	}
}