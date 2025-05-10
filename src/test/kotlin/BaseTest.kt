import driver.DriverFactory
import driver.DriverManager
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

open class BaseTest {
    @BeforeMethod
    fun setUp() {
        val driver = DriverFactory.createDriver()
        DriverManager.setDriver(driver)
    }

    @AfterMethod
    fun tearDown() = DriverManager.getDriver().quit()
}