package org.example;

import com.google.common.annotations.VisibleForTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assert_Practice {
    static WebDriver driver;

    public static void Sleep1(int n) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilElementIsClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    public static void typetext(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static void selectFromDropDownByVisibleTxt(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void selectFromDropDownByIndex(By by, int n) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(n);
    }

    public static void selectFromDropDownByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public static long timestamp() {
        return (System.currentTimeMillis());
    }

    @BeforeMethod

    public static void setBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public static void setcloseBrowser() {
        driver.close();
    }

    @Test
    public void userShouldBeRegisterSuccessfully() {
        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));// Click on register
        clickOnElement(By.xpath("//input[@id=\"gender-female\"]")); // Select the gender

        typetext(By.xpath("//input[@id=\"FirstName\"]"), "Jigna"); // Enter the FirstName
        typetext(By.xpath("//input[@id=\"LastName\"]"), "Sharma"); // Enter the LastName
        selectFromDropDownByVisibleTxt(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "31");//Enter Date of Birth
        selectFromDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), 12);//Enter Month of Birth
        selectFromDropDownByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1978");//Enter Year of Birth Year
        driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("sharmajigna2+"+timestamp()+"@gmail.com");//Enter your valid Email

        typetext(By.xpath("//input[@id=\"Company\"]"), "yashltd");// Enter the company name
        clickOnElement(By.xpath("//input[@type=\"checkbox\"]"));//select or deselect checkbox
        typetext(By.xpath("//input[@id=\"Password\"]"), "isha99");//Enter your password
        typetext(By.xpath("//input[@id=\"ConfirmPassword\"]"), "isha99");//Confirm your password
        clickOnElement(By.xpath("//input[@id=\"register-button\"]"));//Click on Register button


        String expected = "Your registration completed"; //Expected result
        String actual = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();// Actual result
        Assert.assertEquals(expected, actual, "Text do not match");// Comparing the expected and actual result
        System.out.println(actual); // Print actual result

    }

    @Test
    public void userShouldBeEmailaFriendSuccessFully() {
        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));// click on register link
        clickOnElement(By.xpath("//input[@id=\"gender-female\"]"));// select female
        typetext(By.xpath("//input[@id=\"FirstName\"]"),"Jignas");//Enter first name
        typetext(By.xpath("//input[@id=\"LastName\"]"),"Sharmag");// Enter last name
        selectFromDropDownByVisibleTxt(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"31");//Enter Date of Birth
        selectFromDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),12);//Enter Month of Birth
        selectFromDropDownByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1978");//Enter Year of Birth Year
        typetext(By.xpath("//input[@id=\"Email\"]"),"sharmajigna2+"+timestamp()+"@gmail.com");//Enter your valid Email

        typetext(By.xpath("//input[@id=\"Company\"]"), "jkltd");// Enter the company name
        clickOnElement(By.xpath("//input[@type=\"checkbox\"]"));//select or deselect checkbox
        typetext(By.xpath("//input[@id=\"Password\"]"), "isha12");//Enter your password
        typetext(By.xpath("//input[@id=\"ConfirmPassword\"]"), "isha12");//Confirm your password
        clickOnElement(By.xpath("//input[@id=\"register-button\"]"));//Click on Register button
         //Sleep1(2000);

        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a"));//Find Product Computer
        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/h2/a"));

        clickOnElement(By.xpath("//h2/a[text()=\"Digital Storm VANQUISH 3 Custom Performance PC\"]"));//select Digital Storm
        clickOnElement(By.xpath("//input[@value=\"Email a friend\"]"));//Click on Email a friend

        typetext(By.xpath("//input[@id=\"FriendEmail\"]"), "sharmajigna+"+timestamp()+"@yahoo.com");//enter your friend's email

        typetext(By.xpath("//textarea[@id=\"PersonalMessage\"]"), "Suggest to buy this product");
        clickOnElement(By.xpath("//input[@class=\"button-1 send-email-a-friend-button\"]"));

        String expected = "Your message has been sent";//Expected result
        String actual = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();// Actual result
        Assert.assertEquals(actual, expected, "Text do not match");// Comparing the expected and actual result
        System.out.println(actual);// Print actual result

    }
    @Test

public void UserShouldBeAbleToAddProductToBasketSuccessfully(){
        clickOnElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[5]/a")); //Click on Book product
       // Sleep1(2000);
        String expected = driver.findElement(By.xpath("//a[text()=\"Fahrenheit 451 by Ray Bradbury\"]")).getText();// Select the book
        clickOnElement(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));//Click on Add to cart button
        String expected2 = driver.findElement(By.xpath("//a[text()=\"First Prize Pies\"]")).getText();// Select the book
       // Sleep1(2000);
        clickOnElement(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));//Click on Add to cart button
        clickOnElement(By.xpath("//span[@class=\"cart-label\"]"));//Click on shopping cart
        String actual = driver.findElement(By.xpath("//tr[1]/td[4]/a[@class=\"product-name\"]")).getText();//Check the selected book
        //Sleep1(2000);
        Assert.assertEquals(actual,expected,"text do not match");// Comparing the expected and actual result
        System.out.println(actual);

        String actual2 = driver.findElement(By.xpath("//tr[2]/td[4]/a[@class=\"product-name\"]")).getText();
        Assert.assertEquals(actual2,expected2,"Do not match");// Comparing the expected and actual result
        System.out.println(actual2);




    }

}



