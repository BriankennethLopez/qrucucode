package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class guest extends AppCompatActivity {
    SharedPreferences sharedPreferences;//Creating Xml
    EditText etgName,etpermanentddress,etpresentaddress,etgContact,etemail,etage;
    String gResult,gName,gpermanentaddress,gpresentaddress,gContact,gemail,gage;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        etgName=findViewById(R.id.etname1);
        etpermanentddress=findViewById(R.id.etpermanentaddress1);
        etpresentaddress=findViewById(R.id.presentaddress1);
        etgContact=findViewById(R.id.etcontact1);
        etemail = findViewById(R.id.email1);
        etage = findViewById(R.id.age1);
        sharedPreferences=getSharedPreferences("Userinform",0);
        String mname=sharedPreferences.getString("name","");
        String permanentaddress=sharedPreferences.getString("premanentaddress","");
        String presentaddress=sharedPreferences.getString("presentaddress","");
        String mcontact=sharedPreferences.getString("contact","");
        String memail=sharedPreferences.getString("email","");
        String mage=sharedPreferences.getString("age","");
        etgName.setText(mname);
        etpermanentddress.setText(m);

    }

    public void guestid(View view) {
        gName=etgName.getText().toString().toLowerCase();
        gpresentaddress=etpresentaddress.getText().toString().toLowerCase();
        gpermanentaddress=etpermanentddress.getText().toString().toLowerCase();
        gContact=etgContact.getText().toString().toLowerCase();
        gemail=etemail.getText().toString().toLowerCase();
        gage=etage.getText().toString().toLowerCase();
        if (gName.isEmpty()&&gpermanentaddress.isEmpty()&&gpresentaddress.isEmpty()&&gemail.isEmpty()&&gage.isEmpty()&&gContact.isEmpty()){
            Toast.makeText(this, "fill up all", Toast.LENGTH_SHORT).show();
        }else {
            //generate qr code
            jsonObject = new JSONObject();
            try {
                jsonObject.put("name",gName);
                jsonObject.put("permanentaddress",gpermanentaddress);
                jsonObject.put("presentaddress",gpresentaddress);
                jsonObject.put("contact",gContact);
                jsonObject.put("email",gemail);
                jsonObject.put("gage",gage);
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