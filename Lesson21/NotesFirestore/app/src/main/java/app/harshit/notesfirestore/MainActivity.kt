package app.harshit.notesfirestore

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_dialog.view.*

class MainActivity : AppCompatActivity() {

    private val notes = arrayListOf<Note>()
    private val noteAdapter by lazy {
        NoteAdapter(notes)
    }

    private val db = FirebaseFirestore.getInstance()

    private val dialogView by lazy {
        layoutInflater.inflate(R.layout.layout_dialog, null, false)
    }

    private val noteAlert by lazy {
        AlertDialog.Builder(this)
            .setTitle("Enter the note here")
            .setView(dialogView)
            .setPositiveButton("Save") { dialog, _ ->

                val note = Note(
                    dialogView.etTitle.text.toString(),
                    dialogView.etDescription.text.toString(),
                    System.currentTimeMillis().toString()
                )

                saveNoteToFireStore(note)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    private fun saveNoteToFireStore(note: Note) {

//        db.collection("notes")
//            .document("dhfds").set(note)

        db.collection("notes")
            .add(note)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = noteAdapter

        fabAddNote.setOnClickListener {
            noteAlert.show()
        }
    }

    override fun onStart() {
        super.onStart()

        db.collection("notes").addSnapshotListener { querySnapshot, firebaseFirestoreException ->

            querySnapshot?.documentChanges?.forEach {
                notes.add(0, it.document.toObject(Note::class.java))
                noteAdapter.notifyItemInserted(0)
                rvNotes.scrollToPosition(0)
            }
        }

//        db.collection("notes").get()
//            .addOnSuccessListener {
//                it.documents.forEach {
//                    notes.add(it.toObject(Note::class.java)!!)
//                }
//
//                noteAdapter.notifyDataSetChanged()
//            }

    }

}
