package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.client.android.Intents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

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



    EditText etName,etAddress,etContact,etcourse,etpurpose;
    String gResult,gName,gAddress,gContact,gCourse,gPurpose;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.etName);
        etAddress=findViewById(R.id.etAddress);
        etContact=findViewById(R.id.etContact);
        etcourse = findViewById(R.id.etCourse);
        etpurpose= findViewById(R.id.etpurpose);

        sharedPreferences=getSharedPreferences(myPref,MODE_PRIVATE);
        String mname=sharedPreferences.getString(myname,"");
        String maddress=sharedPreferences.getString(myaddress,"");
        String mcontact=sharedPreferences.getString(mycontact,"");
        String mcourse=sharedPreferences.getString(mycourse,"");

        etName.setText(mname);
        etAddress.setText(maddress);
        etContact.setText(mcontact);
        etcourse.setText(mcourse);

    }
    public void generate(View view){
        gName=etName.getText().toString().toLowerCase();
        gAddress=etAddress.getText().toString().toLowerCase();
        gContact=etContact.getText().toString().toLowerCase();
        gCourse=etcourse.getText().toString().toLowerCase();
        gPurpose=etpurpose.getText().toString().toLowerCase();
        if (gName.isEmpty()&&gAddress.isEmpty()&&gContact.isEmpty()&&gCourse.isEmpty()&&gPurpose.isEmpty()){
            Toast.makeText(this, "fill up all", Toast.LENGTH_SHORT).show();
        }else {
            //generate qr code
            jsonObject = new JSONObject();
            try {
                jsonObject.put("name",gName);
                jsonObject.put("address",gAddress);
                jsonObject.put("contact",gContact);
                jsonObject.put("course",gCourse);
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
    public void scan(View view){
        startActivity(new Intent(this, showallscan.class));
    }
}