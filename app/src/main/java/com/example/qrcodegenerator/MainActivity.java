package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.zxing.client.android.Intents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //CLASSES
    SharedPreferences sharedPreferences;//Creating Xml
    //Fields


    RadioGroup radioGroupone,radioGrouptwo;
    RadioButton radioButtonone,radioButtontwo,radioButtononee,radioButtontwoe;
    EditText etName,etAddress,etContact,etcourse,etpurpose,etlocation;
    String gResult,gName,gAddress,gContact,gCourse,gPurpose,glocation;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupone = findViewById(R.id.radioone);
        radioGrouptwo= findViewById(R.id.radiotwo);
        radioButtonone =findViewById(R.id.yess);
        radioButtontwo =findViewById(R.id.noo);
        etName=findViewById(R.id.etName);
        etAddress=findViewById(R.id.etAddress);
        etContact=findViewById(R.id.etContact);
        etcourse = findViewById(R.id.etCourse);
        etpurpose= findViewById(R.id.etpurpose);
        etlocation = findViewById(R.id.locations);


        sharedPreferences=getSharedPreferences("userinfo",0);
        String mname=sharedPreferences.getString("name","");
        String maddress=sharedPreferences.getString("address","");
        String mcontact=sharedPreferences.getString("contact","");

        etName.setText(mname);
        etAddress.setText(maddress);
        etContact.setText(mcontact);

    }
    public void generate(View view){
        gName=etName.getText().toString().toLowerCase();
        gAddress=etAddress.getText().toString().toLowerCase();
        gContact=etContact.getText().toString().toLowerCase();
        gCourse=etcourse.getText().toString().toLowerCase();
        gPurpose=etpurpose.getText().toString().toLowerCase();
        glocation=etlocation.getText().toString().toLowerCase();
        int radioidtwo = radioGrouptwo.getCheckedRadioButtonId();
        int radioidone = radioGroupone.getCheckedRadioButtonId();
        radioButtononee = findViewById(radioidone);
        radioButtontwoe = findViewById(radioidtwo);
        if (gCourse.isEmpty()&&gPurpose.isEmpty()&&!radioButtonone.isChecked()||!radioButtontwo.isChecked()){
            Toast.makeText(this, "fill up all", Toast.LENGTH_SHORT).show();
        }else{
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

    public void pressoffice(View view) {
        Toast.makeText(this, "OFFICE", Toast.LENGTH_SHORT).show();
    }

    public void POV(View view) {
        Toast.makeText(this, "Purpose of visit", Toast.LENGTH_SHORT).show();
    }

    public void yessir(View view) {
        etlocation.setVisibility(View.VISIBLE);
    }

    public void nosir(View view) {
        etlocation.setVisibility(View.INVISIBLE);
    }

}