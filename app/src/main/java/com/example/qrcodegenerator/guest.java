package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class guest extends AppCompatActivity {
    EditText etgName,etgAddress,etgContact,etgpurpose;
    String gResult,gName,gAddress,gContact,gCourse,gPurpose;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        etgName=findViewById(R.id.ettmame);
        etgAddress=findViewById(R.id.ettaddress);
        etgContact=findViewById(R.id.ettcontract);
        etgpurpose=findViewById(R.id.ettpurpose);
    }

    public void guestid(View view) {
        gName=etgName.getText().toString().toLowerCase();
        gAddress=etgAddress.getText().toString().toLowerCase();
        gContact=etgContact.getText().toString().toLowerCase();
        gPurpose=etgpurpose.getText().toString().toLowerCase();
        if (gName.isEmpty()&&gAddress.isEmpty()&&gContact.isEmpty()&&gPurpose.isEmpty()){
            Toast.makeText(this, "fill up all", Toast.LENGTH_SHORT).show();
        }else {
            //generate qr code
            jsonObject = new JSONObject();
            try {
                jsonObject.put("name",gName);
                jsonObject.put("address",gAddress);
                jsonObject.put("contact",gContact);
                jsonObject.put("purpose",gPurpose);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray=new JSONArray();
            jsonArray.put(jsonObject);

            //convert json to string for reading
            result=jsonObject.toString();
            startActivity(new Intent(this,QRcode.class).putExtra("result",result));
        }
    }
}