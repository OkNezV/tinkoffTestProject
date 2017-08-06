package ru.tinkoff.e.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описание главной страницы tinkoff
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
@DefaultUrl("https://www.tinkoff.ru")
public class MainPage extends BasePage{

    public MainPage (WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id ='mainMenu']//span//*[text()='Платежи']")
    public WebElement paymentsButton;

    String mainPageLocator = "._2cXIm";

    /**
     * Проверяем, что главная страница tinkoff открыта     *
     * @return boolean
     */
    public boolean isMainPagePresent() {
        return waitForElementPresent(By.cssSelector(mainPageLocator));
    }

    /**
     * Нажимаем на пункт меню "Платежи"
     */
    public void clickPaymentsButton() {
        paymentsButton.click();
    }
}