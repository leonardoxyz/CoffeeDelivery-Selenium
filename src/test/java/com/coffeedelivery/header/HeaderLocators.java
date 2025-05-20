package com.coffeedelivery.header;

import org.openqa.selenium.By;

public class HeaderLocators {
	public final By logo = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
	public final By localization = By.xpath("//*[@id=\"root\"]/div/header/nav/div/div");
	public final By cart = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a/div/div[1]");
}