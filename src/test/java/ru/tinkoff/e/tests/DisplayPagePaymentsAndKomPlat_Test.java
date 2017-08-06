package ru.tinkoff.e.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.tinkoff.e.pages.KommunalniePlatezhiPage;
import ru.tinkoff.e.pages.MainPage;
import ru.tinkoff.e.pages.PaymentsPage;
import ru.tinkoff.e.pages.ZhkuMoskvaPage;

/**
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class DisplayPagePaymentsAndKomPlat_Test extends BaseTestClass{

    @Test
    public void display_and_work_pages() {

        MainPage mainPage = new MainPage(driver);
        PaymentsPage paymentsPage = new PaymentsPage(driver);
        KommunalniePlatezhiPage kommunalniePlatezhiPage = new KommunalniePlatezhiPage(driver);
        ZhkuMoskvaPage zhkuMoskvaPage = new ZhkuMoskvaPage(driver);

        String regionMoscow = "г. Москва";
        String regionPiter = "г. Санкт-Петербург";
        String firstServiceProvider = "ЖКУ-Москва";
        String fieldPayerCode = "123";
        String fieldPeriodPayment = "0";
        String fieldVoluntaryInsurance = "123";
        String fieldAmountOfPayment = "123";
        String searctText = "ЖКУ-Москва";


        //Открытие главной страницы tinkoff
        driver.get("https://www.tinkoff.ru/");
        Assert.assertTrue("Главная страница tinkoff не отображается",
                mainPage.isMainPagePresent());

        //Переход на страницу платежей
        mainPage.clickPaymentsButton();
        Assert.assertTrue("Страница платежей не открывается",
                paymentsPage.isPaymentsPagePresent());

        //Переход на страницу коммунальных платежей

        paymentsPage.clickKommunalniePlatezhiButton();
        Assert.assertTrue("Страница коммунальных платежей не открыта",
                kommunalniePlatezhiPage.isKommunalniePlatezhiPresent());

        //Проверка, что текущий город Москва
        kommunalniePlatezhiPage.clickCurrentRegionButton();
        Assert.assertTrue("Попап смены региона не открыт",
                kommunalniePlatezhiPage.isPopupChangeRegionPresent());
        kommunalniePlatezhiPage.clickRegionFromPopup(regionMoscow);
        Assert.assertTrue("Попап смены региона остался открытым",
                kommunalniePlatezhiPage.isPopupChangeRegionNotPresent());
        Assert.assertEquals("Текущий город не Москва", "г. Москва",
                kommunalniePlatezhiPage.getNameCurrentRegionFromPage(regionMoscow));

        //Выбор поставщика услуг
        Assert.assertEquals("Первый поставщик услуг не ЖКУ-Москва", "ЖКУ-Москва",
                kommunalniePlatezhiPage.getFirstServiceProviderInListFromPage(firstServiceProvider));
        kommunalniePlatezhiPage.clickFirstServiceProviderInList(firstServiceProvider);

        //Проверка, что произошел переход на страницу ЖКУ-Москва
        Assert.assertTrue("Страница ЖКУ-Москва не открылась",
                zhkuMoskvaPage.isZhkuMoskvaPagePresent());

        //Переход на вклдаку оплаты ЖКУ в Москве
        zhkuMoskvaPage.clickPayZhkuInMoscow();
        Assert.assertTrue("Вкладка оплаты ЖКУ в Москве не открылась",
                zhkuMoskvaPage.isPayZhkuInMoscowTabPresent());

        //Ввод невалидных данных в поля ввода
        zhkuMoskvaPage.setKodPlatelshika(fieldPayerCode);
        zhkuMoskvaPage.setPeriodPayment(fieldPeriodPayment);
        zhkuMoskvaPage.setAmountOfVoluntaryInsurance(fieldVoluntaryInsurance);
        zhkuMoskvaPage.setAmountOfPayment(fieldAmountOfPayment);
        zhkuMoskvaPage.clickPayZhkuInMoscowButton();

        //Переход на вкладку платежи
        mainPage.clickPaymentsButton();
        Assert.assertTrue("Страница платежей не открывается",
                paymentsPage.isPaymentsPagePresent());

        //Ввод текста в строку быстрого поиска
        paymentsPage.setSearchText(searctText);

        //Переход на вкладку платежи
        mainPage.clickPaymentsButton();
        Assert.assertTrue("Страница платежей не открывается",
                paymentsPage.isPaymentsPagePresent());

        //Переход на страницу коммунальных платежей
        paymentsPage.clickKommunalniePlatezhiButton();
        Assert.assertTrue("Страница коммунальных платежей не открыта",
                kommunalniePlatezhiPage.isKommunalniePlatezhiPresent());

        //Проверка выбора текущего города Санкт-Петербург
        kommunalniePlatezhiPage.clickCurrentRegionButton();
        Assert.assertTrue("Попап смены региона не открыт",
                kommunalniePlatezhiPage.isPopupChangeRegionPresent());
        kommunalniePlatezhiPage.clickRegionFromPopup(regionPiter);
        Assert.assertTrue("Попап смены региона остался открытым",
                kommunalniePlatezhiPage.isPopupChangeRegionNotPresent());
        Assert.assertEquals("Текущий город не Санкт-Петербург", "г. Санкт-Петербург",
                kommunalniePlatezhiPage.getNameCurrentRegionFromPage(regionPiter));
    }
}