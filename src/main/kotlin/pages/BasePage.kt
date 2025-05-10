package pages

import driver.DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class BasePage {
    val wait = WebDriverWait(
        DriverManager.getDriver(),
        Duration.ofSeconds(Constants.WAIT_30_SECONDS)
    )

    protected fun waitForElement(byLocator: By): WebElement {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator))
    }
    protected fun getElement(byLocator: By): WebElement {
        return DriverManager.getDriver().findElement(byLocator)
    }

}