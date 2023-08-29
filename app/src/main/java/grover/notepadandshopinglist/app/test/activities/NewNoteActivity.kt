package grover.notepadandshopinglist.app.test.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import grover.notepadandshopinglist.app.test.R
import grover.notepadandshopinglist.app.test.databinding.ActivityNewNoteBinding
import grover.notepadandshopinglist.app.test.fragments.NoteFragment

class NewNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.save_note){
            setMainResult()
        } else if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setMainResult(){
        val i = Intent().apply {
            putExtra(NoteFragment.TITLE_KEY, binding.edTitle.text.toString())
            putExtra(NoteFragment.DESC_KEY, binding.edDescription.text.toString())
        }
        setResult(RESULT_OK, i)
        finish()
    }

    private fun actionBarSettings(){
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }

}