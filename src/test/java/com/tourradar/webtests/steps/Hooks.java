package com.tourradar.webtests.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    private final Base base;

    public Hooks(Base base) {
        this.base = base;
    }

/*
    set up and tear down methods which will run before and after every scenario
*/
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @After
    public void TearDown() {
        base.driver.quit();
        base.driver = null;
    }
}
