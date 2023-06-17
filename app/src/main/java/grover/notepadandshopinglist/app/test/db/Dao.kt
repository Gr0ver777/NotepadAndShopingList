package grover.notepadandshopinglist.app.test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import grover.notepadandshopinglist.app.test.entities.NoteItem
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    @Query("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>
    @Insert
    suspend fun insertNote(note: NoteItem)
}