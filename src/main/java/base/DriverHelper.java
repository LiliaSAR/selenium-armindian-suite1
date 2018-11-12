package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {
    public static DriverHelper get() {
        DriverHelper driverHelper = new DriverHelper();
        return driverHelper;
    }
    public WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driverThread.get() == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "C:\\Users\\studentb\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driverThread.set(driver);
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver",
                            "C:\\Users\\studentb\\geckodriver-windows-32bit.exe");
                    driver = new FirefoxDriver();
                    driverThread.set(driver);
                    break;
            }
        }
        return driverThread.get();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
