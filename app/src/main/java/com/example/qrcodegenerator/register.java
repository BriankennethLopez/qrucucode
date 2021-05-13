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
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpassword);
        name = findViewById(R.id.etname);
        address = findViewById(R.id.etaddress);
        contact = findViewById(R.id.etcontact);
        sharedPreferences=getSharedPreferences("userinfo",0);



    }

    public void reg(View view) {
        String uservalue= user.getText().toString();
        String passvalue= pass.getText().toString();
        String namevalue= name.getText().toString();
        String addressvalue= address.getText().toString();
        String contactvalue= contact.getText().toString();
        String coursevalue= course.getText().toString();

        if(user.equals("")||pass.equals("")||name.equals("")||address.equals("")||contact.equals("")||course.equals("")){
            Toast.makeText(this, "Please fill all the requirements", Toast.LENGTH_SHORT).show();
        }else if (uservalue.length()>1) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", uservalue);
            editor.putString("password", passvalue);
            editor.putString("name", namevalue);
            editor.putString("address", addressvalue);
            editor.putString("contact", contactvalue);
            editor.putString("course", coursevalue);
            editor.apply();
            Toast.makeText(this, "user registered", Toast.LENGTH_SHORT).show();
            Intent ig = new Intent(register.this,login.class);
            startActivity(ig);
        }else{
            Toast.makeText(this, "Enter values in the field", Toast.LENGTH_SHORT).show();
        }
    }
}