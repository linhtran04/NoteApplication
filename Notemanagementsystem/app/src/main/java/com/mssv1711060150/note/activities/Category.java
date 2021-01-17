package com.mssv1711060150.note.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mssv1711060150.note.entities.Note;
import com.mssv1711060150.note.R;
import com.mssv1711060150.note.database.NotesDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Category extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    private EditText inputNoteTitle, inputNoteSubtitle, inputNoteText;
    private TextView textDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        ImageView imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        inputNoteTitle = findViewById(R.id.inputNoteTitle);
        inputNoteSubtitle = findViewById(R.id.inputNoteSubtitle);
        inputNoteText =findViewById(R.id.inputNote);
        textDateTime = findViewById(R.id.textDatatime);


        textDateTime.setText(
                new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault())
                .format(new Date())
        );

        ImageView imageSave = findViewById(R.id.imageSave);
        imageSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });


    }

    private void saveNote(){
        if (inputNoteTitle.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Note title can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (inputNoteSubtitle.getText().toString().trim().isEmpty()
        && inputNoteText.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Note can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }


        final Note note = new Note();
        note.setTitle(inputNoteTitle.getText().toString());
        note.setSubtitle(inputNoteSubtitle.getText().toString());
        note.setNoteText(inputNoteText.getText().toString());
        note.setDateTime(textDateTime.getText().toString());

        @SuppressLint("StaticFieldLeak")
        class SaveNoteTask extends AsyncTask<Void, Void, Void>{
            @Override
            protected Void doInBackground(Void... voids) {
                NotesDatabase.getDatabase(getApplicationContext()).noteDao().insertNote(note);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }

        new SaveNoteTask().execute();

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
        //Recreate activity
        recreate();
    }

    public void  ClickPriority (View view){
        //Recreate activity to priority
        MainAppActivity.redirectActivity(this, Priority.class);
    }

    public void  ClickStatus (View view){
        //Redirect activity to dashboard
        MainAppActivity.redirectActivity( this, Status.class);
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
        //Redirect activity to about us
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