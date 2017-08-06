package ru.tinkoff.e.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Базовая страница
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class BasePage extends PageObject {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    private final int DEFAULT_IMPLICITLY_WAIT = 15000;

    private void zeroingImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    private void setDefaultTimeout() {
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT, TimeUnit.MILLISECONDS);
    }

    /**
     * Ожидание появления элемента в DOM (видимость не проверяется)
     * @param locator локатор для web-элемента
     * @return boolean
     */
    protected boolean isElementPresent(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.size() > 0;
    }

    /**
     * Ожидание исчезновения элемента из DOM (видимость не проверяется)
     * @param locator локатор для web-элемента
     * @return boolean
     */
    protected boolean isElementNotPresent(By locator) {
        List<WebElement> elements;
        boolean result = false;
        long timeout = System.currentTimeMillis() + DEFAULT_IMPLICITLY_WAIT;

        zeroingImplicitlyWait();

        do {
            elements = driver.findElements(locator);

            if (elements.size() <= 0) {
                result = true;
                break;
            }else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    throw new Error(ie);
                }
            }
        } while (System.currentTimeMillis() < timeout);

        setDefaultTimeout();
        return result;
    }

    /**
     * Ожидание видимого элемента
     * @param locator локатор для web-элемента
     * @return boolean
     */
    protected boolean waitForElementPresent(By locator) {
        boolean result;
        if (isElementPresent(locator) == false) {
            result = false;
        }else {
            WebElement element = driver.findElement(locator);
            result = element.isDisplayed();
        }
        return result;
    }

    /**
     * Ожидание становления видимого элемента невидимым
     * @param locator локатор для web-элемента
     * @return boolean
     */
    protected boolean waitForElementNotPresent(By locator) {
        boolean result = false;
        WebElement element;
        long timeout = System.currentTimeMillis() + DEFAULT_IMPLICITLY_WAIT;

        if (isElementPresent(locator) == false) {
            result = false;
        }else {
            do {
                element = driver.findElement(locator);

                if (element.isDisplayed()) {
                    result = true;
                    break;
                }else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ie) {
                        throw new Error(ie);
                    }
                }
            } while (System.currentTimeMillis() < timeout);
        }
        return result;
    }
}