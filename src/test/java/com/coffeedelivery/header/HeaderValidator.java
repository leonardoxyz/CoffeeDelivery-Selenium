package com.coffeedelivery.header;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.coffeedelivery.utils.VisualAssert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class HeaderValidator {
	private final Header header;

	private static final String CART_SCREEN_DISPLAYED = "src/test/resources/header-screenshots/cart_page_displayed.png";
	private static final String LOGO_IMAGE_PATH = "src/test/resources/header-screenshots/logo_image.png";

	public HeaderValidator(WebDriver driver) {
		this.header = new Header(driver, new HeaderLocators());
	}

	public void validateHeader() {
		validateLogoImage();
		validateLocalization();
		validateCart();
	}

	public void validateCartNavigation() {
		header.clickOnCartButton();
		takeScreenShotWhenCartPageIsDisplayed();
	}

	private void validateLogoImage() {
		WebElement imageElement = header.getLogoImageElement();
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(header.getDriver(), imageElement);
		BufferedImage actualImage = screenshot.getImage();

		File expectedFile = new File(LOGO_IMAGE_PATH);

		try {
			if (!expectedFile.exists()) {
				expectedFile.getParentFile().mkdirs();
				ImageIO.write(actualImage, "png", expectedFile);
				System.out.println("There was no reference image. It was created in: " + LOGO_IMAGE_PATH);
				return;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error saving reference image: " + e.getMessage(), e);
		}

		VisualAssert.assertScreenshotEquals(actualImage, LOGO_IMAGE_PATH);
	}

	private void validateLocalization() {
		WebElement localizationElement = header.getLocalizationElement();
		String actualLocalization = localizationElement.getText();
		String expectedLocalization = "Vitória, ES";
		assertEquals(expectedLocalization, actualLocalization, "The location displayed is incorrect!");
	}

	private void validateCart() {
		WebElement cartElement = header.getCartElement();
		assertTrue(cartElement.isDisplayed(), "The cart is not displayed!");
	}

	private void takeScreenShotWhenCartPageIsDisplayed() {
		header.clickOnCartButton();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		Screenshot screenshot = new AShot()
				.takeScreenshot(header.getDriver());
		BufferedImage actualImage = screenshot.getImage();

		File expectedFile = new File(CART_SCREEN_DISPLAYED);

		try {
			if (!expectedFile.exists()) {
				expectedFile.getParentFile().mkdirs();
				ImageIO.write(actualImage, "png", expectedFile);
				System.out.println("There was no reference image. It was created in: " + CART_SCREEN_DISPLAYED);
				return;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error saving reference image: " + e.getMessage(), e);
		}

		VisualAssert.assertScreenshotEquals(actualImage, CART_SCREEN_DISPLAYED);
	}
}