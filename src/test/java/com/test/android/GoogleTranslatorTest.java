package com.test.android;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

public class GoogleTranslatorTest {
	/*
	 * Objects of SelendroidConfiguration, SelendroidLauncher, SelendroidCapabilities
	 * and SelendroidDriver
	 */
	SelendroidConfiguration config;
	SelendroidLauncher launcher;
	SelendroidCapabilities capabilitites;
	SelendroidDriver driver;
	
	/*
	 * In before method we initialize all objects.	 * 
	 */
	@Before
	public void setUp() throws Exception {
		config = new SelendroidConfiguration();
		config.addSupportedApp("src/main/resources/Russian_English_Translator_v2.1.7.apk");
		launcher = new SelendroidLauncher(config);
		launcher.launchSelendroid();
		capabilitites = new SelendroidCapabilities("com.vertaler.ruen:2.1.7");
		driver = new SelendroidDriver(capabilitites);
	}
	
	/*
	 * Small test for application
	 */
	@Test
	public void runGoogleTranslatorTest() {			
		driver.findElement(By.id("etInput")).sendKeys("test text");
	}
	
	/*
	 * Stop driver and launcher to end the test
	 */
	@After
	public void tearDrop() {
		driver.quit();
		launcher.stopSelendroid();
	}
	
}