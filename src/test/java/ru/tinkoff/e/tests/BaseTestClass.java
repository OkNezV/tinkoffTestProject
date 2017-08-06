package ru.tinkoff.e.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class BaseTestClass {

    public WebDriver driver;
    private final int DEFAULT_IMPLICITLY_WAIT = 15000;

    /**
     * Инициализатор теста. Аннотация @Before отмечает метод как метод
     * инициализации теста. Метод инициализации теста выполняется перед каждым
     * тестом в тестовом классе.
     */
    @Before
    public void setUp() {
        switch (System.getProperty("webdriver.driver", "firefox")) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Финализатор теста. Аннотация @After помечает метод как метод финализации
     * теста. Метод финализатора теста выполняется после каждого теста в
     * тестовом классе.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
