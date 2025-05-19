package models

data class NoteData(
    val title: String,
    val description: String,
    val expectError: Boolean = false,
    val expectedErrorType: String? = null
)
