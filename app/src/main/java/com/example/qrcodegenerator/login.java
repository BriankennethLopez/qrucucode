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
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernames = findViewById(R.id.usermane);
        passwords = findViewById(R.id.psswrd);
        sharedPreferences=getSharedPreferences("Userinform",0);
    }

    public void login(View view) {
        String uservalue = usernames.getText().toString();
        String userpass = passwords.getText().toString();

        String registeredusername = sharedPreferences.getString("username","");
        String registeredpassword = sharedPreferences.getString("password","");
        if(uservalue.equals("") ||userpass.equals("") ){
            Toast.makeText(this, "NO Data", Toast.LENGTH_SHORT).show();
        }else if (uservalue.equals(registeredusername) && userpass.equals(registeredpassword)){
            usernames.setText("");
            passwords.setText("");
            Intent fg = new Intent(login.this,types.class);
            startActivity(fg);
        }



        }


    public void signup(View view) {
        Intent jk = new Intent(login.this,register.class);
        startActivity(jk);
    }
}