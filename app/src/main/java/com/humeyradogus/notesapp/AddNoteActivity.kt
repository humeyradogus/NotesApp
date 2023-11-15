package com.humeyradogus.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.humeyradogus.notesapp.databinding.ActivityAddNoteBinding
import com.humeyradogus.notesapp.databinding.ActivityMainBinding

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            if (title.isEmpty() || content.isEmpty()){
                Toast.makeText(this, "Make sure that you wrote something!", Toast.LENGTH_SHORT).show()
            }
            else{
                db.insertNote(note)
                finish()
                Toast.makeText(this, "Your note saved successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}