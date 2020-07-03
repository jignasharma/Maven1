package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Practice
{
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Soft\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("Jigna");

        driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Sharma");

        String pagetext=driver.findElement(By.xpath("//div[@class='title']/strong")).getText();
        System.out.println(pagetext);


    }
}
