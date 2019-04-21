package app.harshit.notesfirestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class NoteAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteHolder(inflater.inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]
        with(holder.itemView) {
            tvTitle.text = currentNote.title
            tvDesc.text = currentNote.description
            tvDate.text = currentNote.date
        }
    }

    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}