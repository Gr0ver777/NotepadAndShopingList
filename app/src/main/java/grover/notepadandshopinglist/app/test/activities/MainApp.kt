package grover.notepadandshopinglist.app.test.activities

import android.app.Application
import grover.notepadandshopinglist.app.test.db.MainDataBase

class MainApp : Application() {
    val database by lazy { MainDataBase.getDataBase(this) }
}