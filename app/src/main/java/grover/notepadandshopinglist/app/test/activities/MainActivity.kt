package grover.notepadandshopinglist.app.test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import grover.notepadandshopinglist.app.test.R
import grover.notepadandshopinglist.app.test.databinding.ActivityMainBinding

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
                    Log.d("MyLog", "notes")
                }
                R.id.shop_list -> {
                    Log.d("MyLog", "list")
                }
                R.id.new_item -> {
                    Log.d("MyLog", "new")
                }
            }
            true
        }
    }
}