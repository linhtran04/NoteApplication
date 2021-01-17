package com.mssv1711060150.note.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mssv1711060150.note.R;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingactionbutton;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingactionbutton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        button = (Button) findViewById(R.id.button);

        floatingactionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpActivity();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainAppActivity();
            }
        });



    }

    //open Sign Up Form
    public void  openSignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    //open Main App Activity
    public void  openMainAppActivity(){
        Intent intent = new Intent(this, MainAppActivity.class);
        startActivity(intent);
    }
}