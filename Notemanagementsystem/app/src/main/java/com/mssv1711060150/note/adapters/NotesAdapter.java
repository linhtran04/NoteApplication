package com.mssv1711060150.note.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mssv1711060150.note.R;
import com.mssv1711060150.note.entities.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewMolder>{

    private List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewMolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewMolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_note,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewMolder holder, int position) {
        holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }







    static class NoteViewMolder extends RecyclerView.ViewHolder{

        TextView textTitle, textSubTitle, textDateTime;


        NoteViewMolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textSubTitle = itemView.findViewById(R.id.textSubTitle);
            textDateTime = itemView.findViewById(R.id.textDateTime);
        }


        void setNote(Note note){
            textTitle.setText(note.getTitle());
            if(note.getSubtitle().trim().isEmpty()){
                textSubTitle.setVisibility(View.GONE);
            }else {
                textSubTitle.setText(note.getSubtitle());
            }
            textDateTime.setText(note.getDateTime());
        }
    }
}
