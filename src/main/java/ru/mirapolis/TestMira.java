package ru.mirapolis;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMira extends WebDriverSetting{
    @Test//проверка отображения элементов на сайте
    public void authTest1() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement inputLogin = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));

        WebElement inputPassword = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));

        WebElement buttonSubmit = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button_submit_login_form']")));
        Assert.assertEquals(true, inputLogin.isDisplayed());
        Assert.assertEquals(true, inputLogin.isDisplayed());
        Assert.assertEquals(true, inputLogin.isDisplayed());
    }

    @Test
    public void authTest2() { //проверка авторизациb с валидными значениями логин, пароль по кнопке "Войти"
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputLogin = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));
        inputLogin.sendKeys("fominaelena");
        WebElement inputPassword = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        inputPassword.sendKeys("z0K6CTQR");
        WebElement buttonSubmit = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button_submit_login_form']")));
        buttonSubmit.click();
    }
    @Test
    public void authTest3() { //проверка авторизация с валидными значениями логин, пароль по клавише "Enter"
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));
        WebElement inputLogin = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));
        inputLogin.sendKeys("fominaelena");
        WebElement inputPassword = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        inputPassword.sendKeys("z0K6CTQR");
        inputPassword.sendKeys(Keys.ENTER);

    }
    @Test
    public void authTest4() { //проверка защиты поля пароль
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));

        WebElement inputPassword = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        inputPassword.sendKeys("z0K6CTQR");
        inputPassword.sendKeys(Keys.CONTROL,"a");
        inputPassword.sendKeys(Keys.CONTROL,"v");
        WebElement inputLogin = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));
        inputLogin.sendKeys(Keys.CONTROL,"c");
        if(inputLogin.getAttribute("value")=="") {
            System.out.println("Ошибка безопасности поля пароль");
        }
        else System.out.println("Поле пароль защищено");
    }
    @Test//проверка отображения элементов формы авторизации после входа в аккаунт
    public void authTest5() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));

        WebElement inputLogin = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));
        inputLogin.sendKeys("fominaelena");
        WebElement inputPassword = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        inputPassword.sendKeys("z0K6CTQR");
        WebElement buttonSubmit = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button_submit_login_form']")));
        buttonSubmit.click();

        if(inputLogin.isDisplayed()==true| inputPassword.isDisplayed()==true | buttonSubmit.isDisplayed()==true) {
            System.out.println("Ошибка, присутствует форма входа на странице пользователя");
        }

    }
    @Test//проверка успещности выхода из аккаунта
    public void authTest6() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));

        WebElement inputLogin = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));
        inputLogin.sendKeys("fominaelena");
        WebElement inputPassword = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        inputPassword.sendKeys("z0K6CTQR");
        WebElement buttonSubmit = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button_submit_login_form']")));
        buttonSubmit.click();
         WebElement buttonPerson = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mira-drop-down-container-head-caption']")));
        buttonPerson.click();
        WebElement buttonLogOut = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Выйти']")));
        buttonLogOut.click();


    }
    public boolean checkInput(WebElement i)
    {
        if(i.getAttribute("value")=="") {
            return true;
        }
        return false;
    }
}
