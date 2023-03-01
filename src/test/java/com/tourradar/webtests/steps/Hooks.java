package com.tourradar.webtests.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        String os = SystemUtils.OS_NAME;
        System.out.println("The name of the operating system is " + os);
        String pathToChromeDriver = null;

        if (os.contains("Windows")) {
            pathToChromeDriver = "drivers/windows/chromedriver.exe";
        } else {
            pathToChromeDriver = "drivers/linux/chromedriver";
        }

        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        ChromeOptions options = new ChromeOptions();

        base.driver = new ChromeDriver(options);
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @After
    public void TearDown() {
        base.driver.quit();
        base.driver = null;
    }
}
