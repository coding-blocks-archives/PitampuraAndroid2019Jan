package com.codingblocks.notes;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> noteArrayList = new ArrayList<>();
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Calendar c = Calendar.getInstance();
//
//        c.setTimeInMillis(System.currentTimeMillis());
//
//        c.getTime();

        RecyclerView recyclerView = findViewById(R.id.rvNotes);

        FloatingActionButton floatingActionButton = findViewById(R.id.fabAdd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        noteAdapter = new NoteAdapter(noteArrayList);

        recyclerView.setAdapter(noteAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note note = new Note("Hello",
                        "World",
                        String.valueOf(System.currentTimeMillis()));

                noteArrayList.add(note);

//                noteAdapter.notifyDataSetChanged();

                noteAdapter.notifyItemInserted(noteArrayList.size() - 1);

            }
        });

    }
}