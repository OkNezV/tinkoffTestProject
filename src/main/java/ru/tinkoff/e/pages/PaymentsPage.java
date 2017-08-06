package ru.tinkoff.e.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описание страницы платежей
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
@DefaultUrl("https://www.tinkoff.ru/payments/")
public class PaymentsPage extends BasePage{

    public PaymentsPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[title='Коммунальные платежи'] .ui-link__text .ui-icon")
    public WebElement kommunalniePlatezhiButton;

    String paymentsPageLocator = ".BqmLz[data-reactid='8']";
    String searchLinePaymentsLocator = "._3kceY";

     /**
     * Проверка, что главная страница tinkoff открыта     *
     * @return boolean
     */
    public boolean isPaymentsPagePresent() {
        return waitForElementPresent(By.cssSelector(paymentsPageLocator));
    }

    /**
     * Клик по кнопке "Комунальные платежи"
     */
    public void clickKommunalniePlatezhiButton() {
        kommunalniePlatezhiButton.click();
    }

    /**
     * Проверка, что есть строка поиска на странице "Платежи"
     * @return boolean
     */
    public boolean isSearshLinePaymentsPresent() {
        return waitForElementPresent(By.cssSelector(searchLinePaymentsLocator));
    }

    /**
     * Ввод текста в строку поиска
     * @param searchText
     */
    public void setSearchText(String searchText) {
        element(searchLinePaymentsLocator).clear();
        element(searchLinePaymentsLocator).sendKeys(searchText);
    }
}