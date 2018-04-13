package com.mycompany.core.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycompany.core.BaseDriver;

public class HomePageLoc extends LocatorFactory{


	public HomePageLoc() {
		PageFactory.initElements(BaseDriver.getDriver(), this);
	}

	@FindBy(name=("q"))
	public WebElement inputSearch;
	
	@FindBy(name=("btnK"))
	public WebElement btnSearch;
	

}
