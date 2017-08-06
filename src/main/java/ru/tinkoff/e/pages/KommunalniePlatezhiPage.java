package ru.tinkoff.e.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница Комунальные платежи
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
@DefaultUrl("https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/")
public class KommunalniePlatezhiPage extends BasePage{

    public KommunalniePlatezhiPage (WebDriver driver) {
        super(driver);
    }

    String kommunalniePlatezhiPageLocator = ".KB6gy._39Wik._3f8nW";
    String popupChangeRegionLocator = ".ui-regions";
    String currentRegionOnPageLocator = ".ui-link.payment-page__title_inner";
    String listRegoinInPopupLocator = ".ui-link";
    String firstServiceProviderInList = "//ul[@class='ui-menu ui-menu_icons _1-BXo']/li[1]";


    /**
     * Проверка, что страница коммунальных платежей открыта
     * @return boolean
     */
    public boolean isKommunalniePlatezhiPresent() {
        return waitForElementPresent(By.cssSelector(kommunalniePlatezhiPageLocator));
    }

    /**
     * Получаем имя текущего региона на странице коммунальных платежей
     * @param currentRegion
     * @return
     */
    public String getNameCurrentRegionFromPage(String currentRegion) {
        String locator = String.format(currentRegionOnPageLocator, currentRegion);
        return $(locator).getText();
    }

    /**
     * Нажатие на текущий регион на странице оплаты коммунальных платежей
     */
    public void clickCurrentRegionButton(){
        $(String.format(currentRegionOnPageLocator)).click();
    }

    /**
     * Проверка появления попапа с выбором региона
     * @return boolean
     */
    public boolean isPopupChangeRegionPresent(){
        return waitForElementPresent(By.cssSelector(popupChangeRegionLocator));
    }

    /**
     * Нажатие на имя выборанного региона из списка
     */
    public void clickRegionFromPopup(String region){
    String locator = String.format(listRegoinInPopupLocator, region);
    $(locator).click();
    }

    /**
     * Проверка, что попап закрылся
     * @return boolean
     */
    public boolean isPopupChangeRegionNotPresent(){
        return waitForElementNotPresent(By.cssSelector(popupChangeRegionLocator));
    }

    /**
     *  Проверка, имени первого постовщека услуг
     *  @param firstServiceProvider
     *  @return
     */
    public String getFirstServiceProviderInListFromPage(String firstServiceProvider) {
        String locator = String.format(firstServiceProviderInList, firstServiceProvider);
        return $(locator).getText();
    }

    /**
     * Нажатие на певрого поставщика услуг из списка
     */
    public void clickFirstServiceProviderInList(String firstServiceProvider){
        String locator = String.format(firstServiceProviderInList, firstServiceProvider);
        $(locator).click();
    }
}