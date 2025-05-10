import org.testng.annotations.Test
import pages.NotesPage

class NoteCreationTest: BaseTest() {

    @Test(description = "Add a valid note")
    fun `Add a valid note`() {
        val notesPage = NotesPage()
        notesPage.clickToAddNote()
            .enterTitle("New Title")
            .enterDescription("New Description")
            .clickToConfirmNoteCreation()
            .waitUntilFabIsVisible()
    }

}