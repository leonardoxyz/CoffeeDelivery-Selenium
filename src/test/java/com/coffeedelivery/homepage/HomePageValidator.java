package com.coffeedelivery.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.coffeedelivery.utils.VisualAssert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class HomePageValidator {
    private final HomePage homePage;
    
    private static final String COFFEE_IMAGE_PATH = "src/test/resources/homepage-screenshots/coffee_image.png";
    protected WebDriver driver;
    
    public HomePageValidator(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }
    
    public void validateInformationItems() {
        validateInformationItemsVisibility();
        validateInformationItemsText();
    }
    
    private void validateInformationItemsVisibility() {
        for (int i = 0; i < HomePageLocators.INFORMATION_ITEMS.size(); i++) {
            assertTrue(homePage.isInformationItemDisplayed(i), 
                "I can't see the item - " + (i + 1));
        }
    }
    
    private void validateInformationItemsText() {
        for (int i = 0; i < HomePageLocators.INFORMATION_ITEMS.size(); i++) {
            String actualText = homePage.getInformationItemText(i);
            String expectedText = HomePageLocators.EXPECTED_MESSAGES.get(i);
            
            assertEquals(expectedText, actualText,
                "Texto incorreto no item " + (i + 1) + 
                "\nEsperado: " + expectedText + 
                "\nEncontrado: " + actualText);
        }
    }
    
    public void validateCoffeeImage() {
        WebElement imageElement = homePage.getCoffeeImageElement();
        Screenshot screenshot = new AShot()
            .coordsProvider(new WebDriverCoordsProvider())
            .takeScreenshot(homePage.getDriver(), imageElement);
        BufferedImage actualImage = screenshot.getImage();

        File expectedFile = new File(COFFEE_IMAGE_PATH);

        try {
            if (!expectedFile.exists()) {
                expectedFile.getParentFile().mkdirs();
                ImageIO.write(actualImage, "png", expectedFile);
                System.out.println("There was no reference image. It was created in: " + COFFEE_IMAGE_PATH);
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error saving reference image: " + e.getMessage(), e);
        }

        VisualAssert.assertScreenshotEquals(actualImage, COFFEE_IMAGE_PATH);
    }
} 