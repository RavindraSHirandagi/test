
// from web Ravi edited
package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;

public class Demo {


	AndroidDriver<WebElement> driver;

	@BeforeTest
	public void Setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto G4 Plus");
		//capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		//capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		capabilities.setCapability("deviceName", "Moto G4 Plus");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("appPackage", "com.android.calculator2");
		//capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.web.MShopWebGatewayActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub/"), capabilities);	
		//driver=new AndroidDriver (new URL("http://192.168.0.2:4723/wb/hub"), capabilities);
		Scroll_and_Click("Apps","android:id/text");
		SwipeLeft();
		SwipeRight();
		SwipeUp();
		SwipeDown();


	}


	public void SwipeDown() {
		// swipe \/
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();

		int startX=screenWidth/2;
		int endX=screenWidth/2;
		int startY=screenHeight*6/7;
		int endY=screenHeight/7;
		driver.swipe(startX, startY, endX, endY, 5000);
	}


	public void SwipeUp() {
		// swipe /\
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();

		int startX=screenWidth/2;
		int endX=screenWidth/2;
		int startY=screenHeight/6;
		int endY=screenHeight*6/7;
		driver.swipe(startX, startY, endX, endY, 5000);

	}
	
	// Testing Git push


	public void SwipeRight() {
		// swipe <---
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();

		int startX=screenWidth*8/9;
		int endX=screenWidth/9;
		int startY=screenHeight/2;
		int endY=screenHeight/2;
		driver.swipe(startX, startY, endX, endY, 5000);
	}


	public void SwipeLeft() {
		// swipe --->
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();

		int startX=screenWidth/7;
		int endX=screenWidth*6/7;
		int startY=screenHeight/2;
		int endY=screenHeight/2;
		driver.swipe(startX, startY, endX, endY, 5000);
	}


	// Scroll till Apps & click on it
	public void Scroll_and_Click(String val, String layout)
	{
		List<WebElement> title = driver.findElements(By.id(layout));
		boolean flag = true;
		while(true)
		{
			for(WebElement element: title)
			{
				if(element.getText().equals(val))
				{
					element.click();
					flag= false;
					break;
				}
			}
			if(flag=true)
			{
				int totalTitle=title.size();
				WebElement lastElement = title.get(totalTitle-1);
				int xInitial= lastElement.getLocation().getX()+lastElement.getSize().getWidth()/2;
				int yInitial= lastElement.getLocation().getY()+lastElement.getSize().getHeight()/2;
				driver.swipe(xInitial, yInitial, xInitial, yInitial-400,5000);
			}
		}

	}
}
