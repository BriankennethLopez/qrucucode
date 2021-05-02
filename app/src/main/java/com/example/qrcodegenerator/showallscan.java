package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.GridView;

public class showallscan extends AppCompatActivity{
    private MemoryDbHelper dbHelper;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showallscan);
        this.gridView = (GridView) findViewById(R.id.activity_main_grid_view);
        this.dbHelper = new MemoryDbHelper(this);
        this.gridView.setAdapter(new MemoriesAdapter(this, this.dbHelper.readAllMemories(), false));
        this.gridView.setEmptyView(findViewById(R.id.activity_main_empty_view));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ((CursorAdapter)gridView.getAdapter()).swapCursor(this.dbHelper.readAllMemories());
    }


    public void addNewMemory(View view) {
        Intent ko = new Intent(showallscan.this,persontoperson.class);
        startActivity(ko);
    }
}