package grover.notepadandshopinglist.app.test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import grover.notepadandshopinglist.app.test.R
import grover.notepadandshopinglist.app.test.databinding.ActivityMainBinding
import grover.notepadandshopinglist.app.test.fragments.FragmentManager
import grover.notepadandshopinglist.app.test.fragments.NoteFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()
    }

    private fun setBottomNavListener(){
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.settings -> {
                    Log.d("MyLog", "settings")
                }
                R.id.notes -> {
                    FragmentManager.setFragment(NoteFragment.newInstance(), this)
                }
                R.id.shop_list -> {
                    Log.d("MyLog", "list")
                }
                R.id.new_item -> {
                    FragmentManager.currentFrag?.onClickNew()
                }
            }
            true
        }
    }
}