package com.example.qrcodegenerator;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Memory {
    private static final float PREFERRED_WIDTH = 250;
    private static final float PREFERRED_HEIGHT = 250;
    private String name;
    private String address;
    private String contact;
    private String type;
    private String image;


    public static final int COL_ID = 0;
    public static final int COL_NAME = 1;
    public static final int COL_ADDRESS = 2;
    public static final int COL_CONTACT = 3;






    public Memory(Cursor cursor) {
        this.name = cursor.getString(COL_NAME);
        this.contact = cursor.getString(COL_CONTACT);
        this.address = cursor.getString(COL_ADDRESS);






    }

    public Memory(String name,String address,String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;






    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }

    public String getContact(){ return this.contact;}





//    private static String bitmapToString(Bitmap bitmap) {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] b = baos.toByteArray();
//        return Base64.encodeToString(b, Base64.DEFAULT);
//    }
//
//    private static Bitmap stringToBitmap(String encodedString) {
//        try {
//            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
//            return BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
//        } catch (Exception e) {
//            e.getMessage();
//            return null;
//        }
//    }
//
//    public static Bitmap resizeBitmap(Bitmap bitmap) {
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        float scaleWidth = PREFERRED_WIDTH / width;
//        float scaleHeight = PREFERRED_HEIGHT / height;
//
//        Matrix matrix = new Matrix();
//        matrix.postScale(scaleWidth, scaleHeight);
//        Bitmap resizedBitmap = Bitmap.createBitmap(
//                bitmap, 0, 0, width, height, matrix, false);
//        bitmap.recycle();
//        return resizedBitmap;
//    }
}