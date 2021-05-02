package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class types extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);
    }

    public void student(View view) {
        Intent kl = new Intent(types.this,login.class);
        startActivity(kl);
    }

    public void guest(View view) {
        Intent gj = new Intent(types.this, guest.class);
        startActivity(gj);
    }

    public void admin(View view) {
        Intent pj = new Intent(types.this,admin.class);
        startActivity(pj);

    }
}