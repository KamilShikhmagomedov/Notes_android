package com.example.notes_android.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.notes_android.R;
import com.example.notes_android.data.InMemoryRepoImp;
import com.example.notes_android.data.Note;
import com.example.notes_android.data.Repo;
import com.example.notes_android.recycler.NotesAdapter;

public class NotesListActivity extends AppCompatActivity {

    private Repo repository = new InMemoryRepoImp();
    private RecyclerView list;
    private NotesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        fillRepo();

        adapter = new NotesAdapter();
        adapter.setNotes(repository.getAll());

        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        list.setAdapter(adapter);
    }

    private void fillRepo() {
        repository.create(new Note("Title 1", "Description 1"));
        repository.create(new Note("Title 2", "Description 2"));
        repository.create(new Note("Title 3", "Description 3"));
        repository.create(new Note("Title 4", "Description 4"));
        repository.create(new Note("Title 5", "Description 5"));
        repository.create(new Note("Title 6", "Description 6"));
        repository.create(new Note("Title 7", "Description 7"));
        repository.create(new Note("Title 8", "Description 8"));
        repository.create(new Note("Title 9", "Description 9"));
        repository.create(new Note("Title 10", "Description 10"));
        repository.create(new Note("Title 11", "Description 11"));
    }
}