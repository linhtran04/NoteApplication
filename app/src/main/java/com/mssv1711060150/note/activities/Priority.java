package com.mssv1711060150.note.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.mssv1711060150.note.adapters.NotesAdapter;
import com.mssv1711060150.note.database.NotesDatabase;

import java.util.ArrayList;
import java.util.List;
import com.mssv1711060150.note.entities.Note;

import com.mssv1711060150.note.R;

import org.jetbrains.annotations.Nullable;

public class Priority extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    public static final int REQUEST_CODE_ADD_NOTE = 1;
    private RecyclerView notesRecyclerview;
    private List<Note> noteList;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);


        //Assign variable
        drawerLayout =findViewById(R.id.drawer_layout);

        ImageView imageAddNoteMain = findViewById(R.id.imageAddNoteMain);
        imageAddNoteMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivityForResult(
                        new Intent(getApplicationContext(), Category.class),
                        REQUEST_CODE_ADD_NOTE
                );
            }
        });


        notesRecyclerview = findViewById(R.id.notesRecyclerView);
        notesRecyclerview.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );

        noteList = new ArrayList<>();
        notesAdapter = new NotesAdapter(noteList);
        notesRecyclerview.setAdapter(notesAdapter);



        getNotes();
    }


    private void getNotes(){

        @SuppressLint("StaticFieldLeak")
        class GetNotesTask extends AsyncTask<Void, Void, List<Note>>{


            @Override
            protected List<Note> doInBackground(Void... voids) {
                return NotesDatabase.getDatabase(getApplicationContext()).noteDao().getAllNotes();
            }

            @Override
            protected void onPostExecute(List<Note> notes) {
                super.onPostExecute(notes);
                Log.d("MY_NOTES", notes.toString());
                if(noteList.size() == 0){
                    noteList.addAll(notes);
                    notesAdapter.notifyDataSetChanged();
                }else {
                    noteList.add(0, notes.get(0));
                    notesAdapter.notifyItemInserted(0);
                }
                notesRecyclerview.smoothScrollToPosition(0);
            }
        }

        new GetNotesTask().execute();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ADD_NOTE && resultCode == RESULT_OK){
            getNotes();

        }
    }


























    public void ClickMenu(View view){
        //Open drawer
        MainAppActivity.openDrawer(drawerLayout);
    }


    public void ClickLogo(View view){
        //Close drawer
        MainAppActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        MainAppActivity.redirectActivity(this, MainAppActivity.class);
    }

    public void  ClickCategory (View view){
        //Redirect activity to category
        MainAppActivity.redirectActivity( this, Category.class);
    }

    public void  ClickPriority (View view){
        //Recreate activity to priority
        MainAppActivity.redirectActivity(this, Priority.class);
    }

    public void  ClickStatus (View view){
        //Redirect activity to dashboard
        recreate();
    }

    public void  ClickNote (View view){
        //Redirect activity to dashboard
        MainAppActivity.redirectActivity( this, Note.class);
    }


    public void  ClickDashboard (View view){
        //Redirect activity to dashboard
        MainAppActivity.redirectActivity( this, Dashboard.class);
    }

    public void  ClickEditprofile (View view){
        //Redirect activity to edit profile
        MainAppActivity.redirectActivity( this, EditProfile.class);
    }

    public void  ClickChangepassword (View view){
        //Redirect activity to change password
        MainAppActivity.redirectActivity( this, ChangePassword.class);
    }


    public void ClickAboutUs(View view){
        //Recreate activity
        MainAppActivity.redirectActivity( this, AboutUs.class);

    }

    public void ClickLogout(View view){
        //Close app
        MainAppActivity.logout(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainAppActivity.closeDrawer(drawerLayout);
    }
}