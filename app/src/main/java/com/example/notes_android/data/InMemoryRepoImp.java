package com.example.notes_android.data;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepoImp implements Repo{

    private ArrayList<Note> notes = new ArrayList<>();
    private int counter = 0;

    @Override
    public int create(Note note) {
        int id = counter++;
        note.setId(id);
        notes.add(note);
        return id;
    }

    @Override
    public Note read(int id) {
        for(Note note : notes) {
            if (note.getId() == id){
                return note;
            }
        }
        return null;
    }

    @Override
    public void update(Note note) {
        for (Note noteFromList: notes) {
            if (note.getId().equals(noteFromList.getId())){
                noteFromList.setTitle(note.getTitle());
                noteFromList.setDescription(note.getDescription());
            }
        }
    }

    @Override
    public void delete(int id) {
        for(Note note : notes) {
            if (note.getId() == id){
                notes.remove(note);
            }
        }
    }

    @Override
    public List<Note> getAll() {
        return notes;
    }
}
