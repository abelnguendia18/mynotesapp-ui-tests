package pages

import driver.DriverManager
import io.appium.java_client.AppiumBy
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import java.time.Duration

class NotesPage : BasePage() {
    init {
        PageFactory.initElements(
            AppiumFieldDecorator(
                DriverManager.getDriver(),
                          Duration.ofSeconds(Constants.WAIT_10_SECONDS)
            ),
            this
        )
    }

    /*******************  Define locators of the page here ************************/

    val fab_: By = AppiumBy.id("fab")

    @AndroidFindBy(id = "fab")
    lateinit var fab: WebElement

    /*******************  Define actions on the page here ************************/

    @Step("Click to add a new note")
    fun clickToAddNote(): CreateNotePage {
       if (fab.isDisplayed) fab.click()
        return CreateNotePage()
    }

    fun waitUntilFabIsVisible(): NotesPage {
        waitForElement(fab_).isDisplayed
        return this
    }
}