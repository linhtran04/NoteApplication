package com.mssv1711060150.note.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mssv1711060150.note.R;
import com.mssv1711060150.note.activities.AboutUs;
import com.mssv1711060150.note.activities.Category;
import com.mssv1711060150.note.activities.ChangePassword;
import com.mssv1711060150.note.activities.Dashboard;
import com.mssv1711060150.note.activities.EditProfile;
import com.mssv1711060150.note.activities.Note;
import com.mssv1711060150.note.activities.Priority;
import com.mssv1711060150.note.activities.Status;

public class MainAppActivity extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);


        drawerLayout = findViewById(R.id.drawer_layout);

    }


    public void ClickMenu (View view){
        //Open drawer

        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout

        drawerLayout.openDrawer(GravityCompat.START);
    }


    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static  void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }





    public void  ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void  ClickCategory (View view){
        //Redirect activity to category
        redirectActivity( this, Category.class);
    }

    public void  ClickPriority (View view){
        //Recreate activity to priority
        redirectActivity(this, Priority.class);
    }


    public void  ClickStatus (View view){
        //Redirect activity to about us
        redirectActivity( this, Status.class);
    }

    public void  ClickNote (View view){
        //Redirect activity to about us
        redirectActivity( this, Note.class);
    }
    public void ClickDashboard(View view){
        //Redirect activity to dashboard
        redirectActivity(this, Dashboard.class);
    }

    public void  ClickEditprofile (View view){
        //Redirect activity to edit profile
        redirectActivity( this, EditProfile.class);
    }

    public void  ClickChangepassword (View view){
        //Redirect activity to change password
        redirectActivity( this, ChangePassword.class);
    }

    public  void ClickAboutUs (View view){
        //Redirect activity to about us
        redirectActivity(this, AboutUs.class);
    }

    public void ClickLogout (View view){
        //Close app
        logout(this);
    }






    public static void logout(Activity activity) {
        //Iitialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set massage
        builder.setMessage("Are you sure you want to logout ?");
        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });
        //Negative to button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });

        //Show dialog
        builder.show();
    }


    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}




































