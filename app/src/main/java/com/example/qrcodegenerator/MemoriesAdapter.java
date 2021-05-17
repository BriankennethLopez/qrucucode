package com.example.qrcodegenerator;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MemoriesAdapter extends CursorAdapter {

    public MemoriesAdapter(Context context, Cursor cursor, boolean autoRequery) {
        super(context, cursor, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.memory_list_item, viewGroup, false);
        view.setTag(new ViewHolder(view));
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder)view.getTag();

        Memory memory = new Memory(cursor);

        holder.titleTextView.setText(memory.getName());
        holder.textView.setText(memory.getContact());
        holder.permanentaddresstextView.setText(memory.getPermanentaddress());
        holder.presentaddress.setText(memory.getPresentaddress());
        holder.email.setText(memory.getEmail());



    }

    private class ViewHolder {

        final TextView titleTextView;
        final TextView textView;
        final TextView permanentaddresstextView;
        final TextView presentaddress;
        final TextView email;

        ViewHolder(View view) {

            titleTextView = view.findViewById(R.id.list_item_text_name);
            textView = view.findViewById(R.id.list_item_text_contact);
            permanentaddresstextView=view.findViewById(R.id.list_view_permanentaddress);
            presentaddress=view.findViewById(R.id.list_view_presentaddress);
            email=view.findViewById(R.id.list_view_email);




        }
    }
}