package grover.notepadandshopinglist.app.test.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import grover.notepadandshopinglist.app.test.entities.LibraryItem
import grover.notepadandshopinglist.app.test.entities.NoteItem
import grover.notepadandshopinglist.app.test.entities.ShoppingListItem
import grover.notepadandshopinglist.app.test.entities.ShoppingListNames


@Database (entities = [LibraryItem::class, NoteItem::class,
    ShoppingListItem::class, ShoppingListNames::class], version = 1)
abstract class MainDataBase: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.db"
                ).build()
                instance
            }
        }
    }
}