package driver

import io.appium.java_client.AppiumDriver

object DriverManager {
    /*** ThreadLocal to hold AppiumDriver per thread ***
     *** This prevents conflicts when running tests in parallel.***/
    private val driver = ThreadLocal<AppiumDriver>()

    fun getDriver(): AppiumDriver = driver.get()

    fun setDriver(newDriver: AppiumDriver) = driver.set(newDriver)
}