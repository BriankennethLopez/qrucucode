package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class admin extends AppCompatActivity {

    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        username=findViewById(R.id.adminusername);
        password=findViewById(R.id.adminpassword);

    }

    public void submit(View view) {
        String uservalue = username.getText().toString();
        String userpass = password.getText().toString();
        if(uservalue.equals("Student")&&userpass.equals("Student")){
            Intent rt = new Intent(admin.this,Scanner.class);
            startActivity(rt);
        }else {
            Toast.makeText(this, "invalid", Toast.LENGTH_SHORT).show();
        }
    }
}