package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class is uses for create a instance of Browser.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public final class WebDriverManager {
    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * this method is used for initializes the variables.
     */
    private WebDriverManager() {
        initializes();
    }

    /**
     * This method is used for instantiate the WebDriverManager class.
     *
     * @return a webDriverManager.
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * This method is used for initializes the variables.
     */
    private void initializes() {
        this.webDriver = WebDriverFactory.getWebDriver(WebDriverConfig.getInstance().getBrowser());
        this.webDriver.manage().window().maximize();
        this.webDriver.manage()
                .timeouts()
                .implicitlyWait(WebDriverConfig.getInstance().getImplicitlyWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getExplicitlWaitTime());
    }

    /**
     * This method is used for get a WebDriver.
     *
     * @return a WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * This method is used for get a WebDriverWait.
     *
     * @return a WebDriverWait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
