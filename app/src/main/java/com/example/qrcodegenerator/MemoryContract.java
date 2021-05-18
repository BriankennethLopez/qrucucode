
package com.example.qrcodegenerator;

import android.provider.BaseColumns;

public class MemoryContract {

  private MemoryContract() {
  }

  public static final class MemoryEntry implements BaseColumns {
    public static final String TABLE_NAME = "memoriesh";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PERMANENTADDRESS = "permanentaddress";
    public static final String COLUMN_PRESENTADDRESS = "presentaddress";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_CONTACT = "contact";
    public static final String COLUMN_DATE = "date";







  }
}