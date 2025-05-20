package com.coffeedelivery.sellpage;

import org.openqa.selenium.By;

public class SellPageLocators {
	public final By productSection = By.xpath("//*[@id=\"root\"]/div/main/div[2]");
	
	public By getProductImage(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/header/img", index));
	}
	
	public By getProductType(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/header/div/div", index));
	}
	
	public By getProductTitle(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/main/h2", index));
	}
	
	public By getProductDescription(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/main/p", index));
	}
	
	public By getProductPrice(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/footer/div", index));
	}
	
	public By getProductQuantity(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/footer/form/div", index));
	}
	
	public By getProductDecrementButton(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/footer/form/div/button[1]", index));
	}
	
	public By getProductIncrementButton(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/footer/form/div/button[2]", index));
	}
	
	public By getProductItemQuantity(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/footer/form/div/p", index));
	}
	
	public By getProductAddToCart(int index) {
		return By.xpath(String.format("//*[@id=\"root\"]/div/main/div[2]/section/div[%d]/footer/form/button", index));
	}
}