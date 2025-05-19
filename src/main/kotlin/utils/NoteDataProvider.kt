package utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.NoteData
import org.testng.annotations.DataProvider
import java.io.InputStreamReader

object NoteDataProvider {

    @JvmStatic
    @DataProvider(name = "noteDataProvider")
    fun noteDataProvider(): Array<Array<Any>> {
        val inputStream = this::class.java.classLoader.getResourceAsStream("note_test_data.json")
            ?: throw IllegalArgumentException("Test data file not found")

        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<NoteData>>() {}.type
        val notes: List<NoteData> = Gson().fromJson(reader, type)

        return notes.map { arrayOf(it as Any) }.toTypedArray()
    }
}