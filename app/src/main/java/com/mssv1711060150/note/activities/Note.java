package com.mssv1711060150.note.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;

import android.view.View;


import com.mssv1711060150.note.R;


public class Note extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);


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
        MainAppActivity.redirectActivity( this, Priority.class);
    }

    public void  ClickStatus (View view){
        //Redirect activity to about us
        MainAppActivity.redirectActivity( this, Status.class);
    }

    public void  ClickNote (View view){
        //Recreate activity
        recreate();
    }


    public void  ClickDashboard (View view){
        //Redirect activity to about us
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