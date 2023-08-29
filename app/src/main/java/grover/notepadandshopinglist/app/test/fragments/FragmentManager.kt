package grover.notepadandshopinglist.app.test.fragments

import androidx.appcompat.app.AppCompatActivity
import grover.notepadandshopinglist.app.test.R

object FragmentManager {
    var currentFrag : BaseFragment ?= null

    fun setFragment(newFrag: BaseFragment, activity: AppCompatActivity){
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFrag)
        transaction.commit()
        currentFrag = newFrag
    }
}