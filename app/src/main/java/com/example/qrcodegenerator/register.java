package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText user,pass,name,address,contact,course;

    //CLASSES
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
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpassword);
        name = findViewById(R.id.etname);
        address = findViewById(R.id.etaddress);
        contact = findViewById(R.id.etcontact);
        course =findViewById(R.id.etcourse);

        sharedPreferences=getSharedPreferences(myPref,MODE_PRIVATE);
        editor=sharedPreferences.edit();


    }

    public void reg(View view) {
        String Newuser= user.getText().toString();
        String Newpass= pass.getText().toString();
        String Newname= name.getText().toString();
        String Newaddress= address.getText().toString();
        String Newcontact= contact.getText().toString();
        String Newcourse= course.getText().toString();

        editor.putString(myuser,Newuser);
        editor.putString(mypassword,Newpass);
        editor.putString(myname,Newname);
        editor.putString(myaddress,Newaddress);
        editor.putString(mycontact,Newcontact);
        editor.putString(mycourse,Newcourse);
        editor.commit();

        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        Intent f = new Intent(register.this,login.class);
        startActivity(f);


    }

    public void sas(View view) {
        String gName=sharedPreferences.getString(myuser,"");
        String gpassword=sharedPreferences.getString(mypassword,"");

        Toast.makeText(this, gName + gpassword, Toast.LENGTH_SHORT).show();
    }
}