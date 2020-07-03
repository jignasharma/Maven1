package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Digital_Storm {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[text()= 'Digital Storm VANQUISH 3 Custom Performance PC']")).click();
        driver.findElement(By.xpath("//input[contains(@value, \"Email a friend\") and contains(@class, \"button-2 email-a-friend-button valid\")]")).click();
        String pagetext =driver.findElement(By.xpath("//span[@id=\"YourEmailAddress-error\"]")).getText();

    }
}