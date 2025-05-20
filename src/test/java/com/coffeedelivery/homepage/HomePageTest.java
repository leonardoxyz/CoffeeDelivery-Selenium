package com.coffeedelivery.homepage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.coffeedelivery.base.BaseTest;

public class HomePageTest extends BaseTest {
    private HomePageValidator validator;
    
    @Test
    @DisplayName("It should validate the grid informations on HomePage screen.")
    public void testInformationItems() {
        validator = new HomePageValidator(driver);
        validator.validateInformationItems();
    }
    
    @Test
    @DisplayName("It should validate the image on HomePage screen.")
    public void validateCoffeeImage() {
        validator = new HomePageValidator(driver);
        validator.validateCoffeeImage();
    }
}