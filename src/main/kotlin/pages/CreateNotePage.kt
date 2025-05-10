package pages

import driver.DriverManager
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import java.time.Duration

class CreateNotePage: BasePage() {
    init {
        PageFactory.initElements(
            AppiumFieldDecorator(
                DriverManager.getDriver(),
                         Duration.ofSeconds(Constants.WAIT_10_SECONDS)
            ),
            this
        )
    }

    @AndroidFindBy(id = "edt_note_title")
    lateinit var edtNoteTitle: WebElement

    @AndroidFindBy(id = "edt_note_description")
    lateinit var edtNoteDescription: WebElement

    @AndroidFindBy(id = "button_create_note")
    lateinit var btnCreateNote: WebElement

    @Step("Enter a title for this note")
    fun enterTitle(title: String): CreateNotePage {
        edtNoteTitle.sendKeys(title)
        return this
    }
    @Step("Enter a description for this note")
    fun enterDescription(description: String): CreateNotePage {
        edtNoteDescription.sendKeys(description)
        return this
    }
    @Step("Confirm the creation of the note by clicking")
    fun clickToConfirmNoteCreation(): NotesPage {
        btnCreateNote.click()
        return NotesPage()
    }

}