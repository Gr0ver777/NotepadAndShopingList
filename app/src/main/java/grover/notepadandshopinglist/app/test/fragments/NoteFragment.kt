package grover.notepadandshopinglist.app.test.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import grover.notepadandshopinglist.app.test.R
import grover.notepadandshopinglist.app.test.activities.MainApp
import grover.notepadandshopinglist.app.test.activities.NewNoteActivity
import grover.notepadandshopinglist.app.test.databinding.FragmentNoteBinding
import grover.notepadandshopinglist.app.test.db.MainViewModel


class NoteFragment : BaseFragment() {

    private lateinit var binding : FragmentNoteBinding
    private val mainViewModel: MainViewModel by activityViewModels{
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onClickNew() {
        startActivity(Intent(activity, NewNoteActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = NoteFragment()
            }
    }