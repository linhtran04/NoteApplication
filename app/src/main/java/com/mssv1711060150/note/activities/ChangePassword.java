package com.mssv1711060150.note.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mssv1711060150.note.R;
import com.mssv1711060150.note.signinsignup.DatabaseHelper;

public class ChangePassword extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    EditText etMKCu, etMKMoi, etNhapLai;
    Button btDoiMK, btHuyMK;
    DatabaseHelper db;
    String pwdCu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        db = new DatabaseHelper(ChangePassword.this);
        String username = DatabaseHelper.COL_2;
        pwdCu = DatabaseHelper.COL_3;
        etMKCu = findViewById(R.id.editTextMKCU);
        etMKMoi = findViewById(R.id.editTextTextMKMoi);
        etNhapLai = findViewById(R.id.editTextNhapLaiMK);
        btDoiMK = findViewById(R.id.buttonDoiMK);
        btHuyMK = findViewById(R.id.buttonHuyMK);

        btDoiMK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String mkCu = etMKCu.getText().toString();
                String mkMoi = etMKMoi.getText().toString();
                if(!mkCu.equals(pwdCu)){
                    Toast.makeText(ChangePassword.this, "Mật khẩu củ ko đúng", Toast.LENGTH_LONG).show();
                }else {
                    if(db.changePassword(username,mkMoi)){
                        Toast.makeText(ChangePassword.this, "Đổi mật khẩu thành công", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ChangePassword.this, "THẤT BẠI", Toast.LENGTH_LONG).show();
                    }
                }

            }



        });
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
        //Redirect activity to home
        MainAppActivity.redirectActivity(this, Category.class);
    }

    public void  ClickPriority (View view){
        //Recreate activity to priority
        MainAppActivity.redirectActivity( this, Priority.class);
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
        recreate();
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