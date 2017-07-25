package com.retail.pageObjects;

import org.openqa.selenium.By;

import com.framework.wrapper.WebOperations;

public class viewNotesPage extends WebOperations{
	
	public static By
	
	backButton = By.xpath("//span[text()='Back']"),
	viewAllButton = By.xpath("//span[@class='note-links']/a[2]"),
	addNewButton= By.xpath("//a[text()='Add Note']"),
	sortingButton=By.xpath("//md-icon[@aria-hidden='false']"),
	source=By.xpath("//span[text()='Source ']"),
	name=By.xpath("//th[text()='Name ']"),
	type=By.xpath("//th[text()='Type ']"),
	subject=By.xpath("//th[text()='Subject ']"),
	message=By.xpath("//th[text()='Message ']");
}
