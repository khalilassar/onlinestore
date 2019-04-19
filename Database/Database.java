package soeq.app.soeq.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database extends SQLiteAssetHelper {
    private  static  final String  Dbname = "mydb.db";
    private  static  final int  version = 1;

    public Database(Context context) {
        super(context, Dbname, null, version);
    }
}
