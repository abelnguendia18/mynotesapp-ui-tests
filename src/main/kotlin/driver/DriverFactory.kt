package driver

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

object DriverFactory {
    fun createDriver(): AppiumDriver {
        val env = System.getProperty("test.env", "local")
        return if (env == "browserstack") {
            createBrowserStackDriver()
        } else {
            createLocalDriver()
        }
    }

    private fun createLocalDriver(): AppiumDriver {
        val desiredCapabilities = DesiredCapabilities().apply {
            setCapability("appium:platformName", "Android")
            setCapability("appium:automationName", "UiAutomator2")
            setCapability("appium:appPackage", "com.tapondjou.mynotesapp")
            setCapability("appium:appActivity", "com.tapondjou.mynotesapp.MainActivity")
        }
        return AppiumDriver(URL("http://127.0.0.1:4723/"), desiredCapabilities)
    }

    private fun createBrowserStackDriver(): AppiumDriver {
        val desiredCapabilities = DesiredCapabilities().apply {
            setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"))
            setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"))
            setCapability("app", System.getProperty("app"))
            setCapability("device", System.getProperty("device"))
            setCapability("os_version", System.getProperty("os_version"))
            setCapability("project", "Hybrid App Test")
            setCapability("build", "Hybrid Test Build")
            setCapability("name", "BrowserStack Test")
        }
        return AppiumDriver(URL("https://hub.browserstack.com/"), desiredCapabilities)
    }
}