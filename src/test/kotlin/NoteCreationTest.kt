import models.NoteData
import org.testng.annotations.Test
import pages.NotesPage
import utils.NoteDataProvider

class NoteCreationTest: BaseTest() {

    @Test(dataProvider = "noteDataProvider", dataProviderClass = NoteDataProvider::class)
    fun `Test note creation from JSON`(note: NoteData) {
        val flow = NotesPage()
            .clickToAddNote()
            .enterTitle(note.title)
            .enterDescription(note.description)
            .clickToConfirmNoteCreation()

        if (note.expectError) {
            when (note.expectedErrorType) {
                "EmptyTitle" -> flow.checkErrorMessageForEmptyTitleDisplayed()
                "EmptyDescription" -> flow.checkErrorMessageForEmptyDescriptionDisplayed()
                "EmptyTileAndDescription" -> flow.checkErrorMessageForEmptyTitleDisplayed()
            }
        } else {
            NotesPage().waitUntilFabIsVisible()
        }
    }
}