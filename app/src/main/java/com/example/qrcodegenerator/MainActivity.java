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

    //radiobutton1
    RadioGroup radioGroupone;
    RadioButton radioButtononeyes,radioButtononeno,radioButtonvalue;
    //radiobutton 2
    RadioGroup radioGrouptwo;
    RadioButton radioButtoyestwo,radioButtonnotwo,radioButtontwovalue;
    //radiobutton3
    RadioGroup radioGroupthree;
    RadioButton radioButtoyesthree,radioButtonnothree,radioButtonthreevalue;

    EditText etName,etContact,etoffice,etpurpose,etlocation,etpermanentAddress,etpresentaddress,etemail,etage;
    String gResult,gName,gpermanentaddress,gpresenttaddress,gContact,goffice,gPurpose,glocation,gemail,gage,radiodataone,radiodatatwo,radiodatathree;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //group1
        radioGroupone = findViewById(R.id.radioone);
        radioButtononeyes =findViewById(R.id.yess);
        radioButtononeno =findViewById(R.id.noo);

        //group2
        radioGrouptwo= findViewById(R.id.radiotwo);
        radioButtoyestwo = findViewById(R.id.twoyes);
        radioButtonnotwo = findViewById(R.id.twono);
        //group 3
        radioGroupthree=findViewById(R.id.radiothree);
        radioButtoyesthree=findViewById(R.id.threeyes);
        radioButtonnothree=findViewById(R.id.threeno);

        etName=findViewById(R.id.etName);
        etemail=findViewById(R.id.etemail);
        etage=findViewById(R.id.etage);
        etpurpose=findViewById(R.id.etpurpose);
        etpermanentAddress=findViewById(R.id.etpermanentaddress);
        etpresentaddress = findViewById(R.id.etpresentaddress);
        etContact=findViewById(R.id.etContact);
        etoffice = findViewById(R.id.etoffice);
        etpurpose= findViewById(R.id.etpurpose);
        etlocation = findViewById(R.id.locations);


        sharedPreferences=getSharedPreferences("Userinform",0);
        String mname=sharedPreferences.getString("name","");
        String permanentaddress=sharedPreferences.getString("premanentaddress","");
        String presentaddress=sharedPreferences.getString("presentaddress","");
        String mcontact=sharedPreferences.getString("contact","");
        String memail=sharedPreferences.getString("email","");
        String mage=sharedPreferences.getString("age","");

        etName.setText(mname);
        etpresentaddress.setText(presentaddress);
        etpermanentAddress.setText(permanentaddress);
        etContact.setText(mcontact);
        etemail.setText(memail);
        etage.setText(mage);


    }
    public void generate(View view){
        gName=etName.getText().toString().toLowerCase();
        gContact=etContact.getText().toString().toLowerCase();
        gPurpose=etpurpose.getText().toString().toLowerCase();
        glocation=etlocation.getText().toString().toLowerCase();
        goffice=etoffice.getText().toString().toLowerCase();
        gemail=etemail.getText().toString();
        gpermanentaddress=etpermanentAddress.getText().toString().toLowerCase();
        gpresenttaddress=etpresentaddress.getText().toString().toLowerCase();
        gage=etage.getText().toString().toLowerCase();
        int radioidtwo = radioGrouptwo.getCheckedRadioButtonId();
        int radioidone = radioGroupone.getCheckedRadioButtonId();
        int radioidthree = radioGroupone.getCheckedRadioButtonId();
        radioButtonvalue = findViewById(radioidone);
        radioButtontwovalue = findViewById(radioidtwo);
        radioButtonthreevalue = findViewById(radioidthree);
        if (goffice.isEmpty()&&gPurpose.isEmpty()&&!radioButtononeyes.isChecked()&&!radioButtononeno.isChecked()&&!radioButtoyestwo.isChecked()&&!radioButtonnotwo.isChecked()&&!radioButtoyesthree.isChecked()&&!radioButtonnothree.isChecked()){
            Toast.makeText(this, "fill up all", Toast.LENGTH_SHORT).show();
        }else{
            jsonObject = new JSONObject();
            try {
                jsonObject.put("name",gName);
                jsonObject.put("presentaddress",gpresenttaddress);
                jsonObject.put("permanentaddress",gpermanentaddress);
                jsonObject.put("contact",gContact);
                jsonObject.put("office",goffice);
                jsonObject.put("purpose",gPurpose);
                jsonObject.put("email",gemail);
                jsonObject.put("age",gage);
                jsonObject.put("location",glocation);
                jsonObject.put("radvalues",radioButtonvalue.getText().toString().toLowerCase());
                jsonObject.put("radvaluess",radioButtontwovalue.getText().toString().toLowerCase());
                jsonObject.put("radvaluesss",radioButtonthreevalue.getText().toString().toLowerCase());
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