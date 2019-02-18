package com.codingblocks.notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private ArrayList<Note> noteArrayList;
    private Context context;

    public NoteAdapter(ArrayList<Note> notes) {
        this.noteArrayList = notes;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_row, viewGroup, false);
        return new NoteHolder(view);
    }


    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    //This is always called for every row
    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int position) {

        final Note currentNote = noteArrayList.get(position);

        noteHolder.time.setText(currentNote.getDate());
        noteHolder.desc.setText(currentNote.getDescription());
        noteHolder.name.setText(currentNote.getTitle());
        //        noteHolder.rootHolder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "The note that was clicked had the title : " + currentNote.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
////        Will this work?
//        noteHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public class NoteHolder extends RecyclerView.ViewHolder {

        TextView name, desc, time;
        LinearLayout rootHolder;


        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            this.rootHolder = itemView.findViewById(R.id.rootLayout);
            this.name = itemView.findViewById(R.id.tvName);
            this.desc = itemView.findViewById(R.id.tvDesc);
            this.time = itemView.findViewById(R.id.tvTime);


            rootHolder.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //Change the color to orange

                    int position = getAdapterPosition();


                    Note itemToBeRemoved = noteArrayList.get(position);
                    noteArrayList.remove(position);

                    noteArrayList.add(itemToBeRemoved);

//                    notifyDataSetChanged();

                    notifyItemMoved(position, noteArrayList.size() - 1);

                    return true;
                }
            });


            rootHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currentPos = getAdapterPosition();
                    Note currentObj = noteArrayList.get(currentPos);

                    Toast.makeText(context,
                            "The note that was clicked had the title : " + currentObj.getTitle(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
