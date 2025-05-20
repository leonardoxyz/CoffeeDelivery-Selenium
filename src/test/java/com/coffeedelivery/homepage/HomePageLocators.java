package com.coffeedelivery.homepage;

import java.util.List;
import java.util.Arrays;

import org.openqa.selenium.By;

public class HomePageLocators {
	public final By title = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/h1");
	public final By description = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/p");
	public final By logo = By.xpath("//*[@id=\"root\"]/div/header/nav/a/img");
	public final By localization = By.xpath("//*[@id=\"root\"]/div/header/nav/div/div/p");
	
	public static final List<By> INFORMATION_ITEMS = Arrays.asList(
			By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/div/div[1]/p"),
			By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/div/div[2]/p"),
			By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/div/div[3]/p"),
			By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/div/div[4]/p"));

	public static final List<String> EXPECTED_MESSAGES = Arrays.asList("Compra simples e segura",
			"Embalagem mantém o café intacto", "Entrega rápida e rastreada", "O café chega fresquinho até você");
}
