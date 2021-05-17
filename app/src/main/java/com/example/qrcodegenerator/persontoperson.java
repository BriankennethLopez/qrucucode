package com.example.qrcodegenerator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class persontoperson extends AppCompatActivity {
    CodeScanner codeScanner;
    CodeScannerView codeScannerView;
    TextView tvResult;
    String gResult,gName,gpermanentaddress,gpresentaddress,gContact,gemail;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persontoperson);
        codeScannerView=findViewById(R.id.scanner);
        codeScanner=new CodeScanner(this,codeScannerView);
        tvResult=findViewById(R.id.tvResult);

        tvResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                gResult=tvResult.getText().toString();
                try {
                    jsonObject=new JSONObject(gResult);
                    gName=jsonObject.getString("name");
                    gpermanentaddress=jsonObject.getString("permanentaddress");
                    gpresentaddress=jsonObject.getString("presentaddress");
                    gContact=jsonObject.getString("contact");
                    gemail=jsonObject.getString("email");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(persontoperson.this);
                alert.setTitle("Confirm");
                alert.setCancelable(false);
                alert.setMessage("Name: "+gName +"\n"+"Present Address: "+gpresentaddress+"\n"+"Permanent Address: "+gpermanentaddress +"\n"+"Contact: "+gContact);
                alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(persontoperson.this, "Added", Toast.LENGTH_SHORT).show();
                        new MemoryDbHelper(persontoperson.this).addMemory(new Memory(gName,gpermanentaddress,gpresentaddress,gContact,gemail));

                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(persontoperson.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        requestforcamera();
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(result.getText());

                    }
                });
            }
        });
    }
    private void requestforcamera() {
        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                codeScanner.startPreview();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Toast.makeText(persontoperson.this, "Camera Required", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();

            }
        }).check();
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestforcamera();
    }

}