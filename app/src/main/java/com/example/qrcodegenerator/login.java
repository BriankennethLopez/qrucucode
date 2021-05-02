package com.example.qrcodegenerator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText usernames,passwords;

    SharedPreferences sharedPreferences;//Creating Xml
    SharedPreferences.Editor editor;// Input Data SharedPref

    //Fields
    private static final String myPref="Info";//Info.xml
    private static final String myuser="Username";
    private static final String mypassword="Password";
    private static final String myname="Name";
    private static final String myaddress="Address";
    private static final String mycontact="Contact";
    private static final String mycourse="Course";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernames = findViewById(R.id.usermane);
        passwords = findViewById(R.id.psswrd);





    }

    public void login(View view) {
        sharedPreferences=getSharedPreferences(myPref,MODE_PRIVATE);
        String gName=sharedPreferences.getString(myuser,"");
        String gpassword=sharedPreferences.getString(mypassword,"");


        if (usernames.equals(gName)&&passwords.equals(gpassword)){
            Intent y = new Intent(login.this, MainActivity.class);
            startActivity(y);
        }else {
            Toast.makeText(this, "invalid", Toast.LENGTH_SHORT).show();
        }


        }


    public void signup(View view) {
        Intent jk = new Intent(login.this,register.class);
        startActivity(jk);
    }
}