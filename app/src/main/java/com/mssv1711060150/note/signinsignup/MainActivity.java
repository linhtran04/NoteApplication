package com.mssv1711060150.note.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mssv1711060150.note.R;
import com.mssv1711060150.note.activities.MainAppActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);

        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent (MainActivity.this, SignUpActivity.class );
                startActivity(registerIntent);

            }
        });

        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                //Intent HomePage = new Intent(MainActivity.this, MainAppActivity.class);
                //startActivity(HomePage);
                if(res == true)
                {
                    Toast.makeText(MainActivity.this, "Successfully Logged", Toast.LENGTH_SHORT).show();
                    Intent HomePage = new Intent(MainActivity.this, MainAppActivity.class);
                    startActivity(HomePage);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }


    }


