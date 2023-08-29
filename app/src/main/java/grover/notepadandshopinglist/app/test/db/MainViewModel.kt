package grover.notepadandshopinglist.app.test.db

import androidx.lifecycle.*
import grover.notepadandshopinglist.app.test.entities.NoteItem
import kotlinx.coroutines.launch


class MainViewModel(database: MainDataBase) : ViewModel() {
    val dao = database.getDao()
    val allNote: LiveData<List<NoteItem>> = dao.getAllNotes().asLiveData()

    fun insertNote(note: NoteItem) = viewModelScope.launch {
        dao.insertNote(note)
    }

    class MainViewModelFactory(val database: MainDataBase): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw IllegalArgumentException("Unknown")
        }
    }
}