
package com.example.qrcodegenerator;

import android.provider.BaseColumns;

public class MemoryContract {

  private MemoryContract() {
  }

  public static final class MemoryEntry implements BaseColumns {
    public static final String TABLE_NAME = "memoriess";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_CONTACT = "contact";






  }
}