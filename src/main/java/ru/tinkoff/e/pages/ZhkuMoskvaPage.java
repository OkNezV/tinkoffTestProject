package ru.tinkoff.e.pages;


import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описание страниы ЖКУ Москва
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
@DefaultUrl("https://www.tinkoff.ru/zhku-moskva/")
public class ZhkuMoskvaPage extends BasePage{



    public ZhkuMoskvaPage (WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[text()='Оплатить ЖКУ в Москве']")
    public WebElement payZhkuInMoscow;
    @FindBy (css = "#payerCode")
    public WebElement kodPlatelshikaLocator;
    @FindBy (css = ".ui-form__row_date .ui-input__field")
    public WebElement periodPaymentLocator;
    @FindBy (css = ".ui-input__field.ui-input__field_not-empty")
    public WebElement voluntaryInsuranceLocator;
    @FindBy (css = ".ui-form__row_account-amount .ui-input__field")
    public WebElement amountOfPaymentLocator;
    @FindBy (css = ".ui-button_provider-pay")
    public WebElement payZhkuInMoscowButton;


    String zhkuMoskvaPageLocator = ".BqmLz ._3SS6X";
    String payZhkuInMoscowTab = "//button/*[text()='Оплатить ЖКУ в Москве']";


    /**
     * Проверка, что страница ЖКУ Москва открыта
     * @return boolean
     */
    public boolean isZhkuMoskvaPagePresent() {
        return waitForElementPresent(By.cssSelector(zhkuMoskvaPageLocator));
    }

    /**
     * Клик по "Оплатить ЖКУ в Москве"
     */
    public void clickPayZhkuInMoscow(){
        payZhkuInMoscow.click();
    }

    /**
     * Проверка, что вкладка оплаты ЖКУ в Москве открылась
     */
    public boolean isPayZhkuInMoscowTabPresent(){
        return waitForElementPresent(By.xpath(payZhkuInMoscowTab));
    }

    /**
     * Ввод текста в поле "Код плательщика за ЖКУ"
     * @param kodPlatelshika
     */
    public void setKodPlatelshika(String kodPlatelshika) {
        kodPlatelshikaLocator.clear();
        kodPlatelshikaLocator.sendKeys(kodPlatelshika);
    }

    /**
     * Ввод текста в поле "Период оплаты"
     * @param periodPayment
     */
    public void setPeriodPayment(String periodPayment) {
        periodPaymentLocator.clear();
        periodPaymentLocator.sendKeys(periodPayment);
    }


    /**
     * Ввод текста в поле "Сумма добровольного страхования"
     * @param voluntaryInsurance
     */
    public void setAmountOfVoluntaryInsurance(String voluntaryInsurance){
        voluntaryInsuranceLocator.clear();
        voluntaryInsuranceLocator.sendKeys(voluntaryInsurance);
    }

    /**
     * Ввод текста в поле "Сумма платежа"
     * @param amountOfPayment
     */
    public void setAmountOfPayment(String amountOfPayment){
        amountOfPaymentLocator.clear();
        amountOfPaymentLocator.sendKeys(amountOfPayment);
    }

    /**
     * Клик по кнопке "Оплатить ЖКУ в Москве"
     */
    public void clickPayZhkuInMoscowButton(){
        payZhkuInMoscowButton.click();
    }
}