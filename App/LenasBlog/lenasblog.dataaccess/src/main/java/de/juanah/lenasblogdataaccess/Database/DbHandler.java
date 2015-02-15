package de.juanah.lenasblogdataaccess.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jonas on 15.02.15.
 */
public class DbHandler extends SQLiteOpenHelper {

    public DbHandler(Context context)
    {
        super(context,DatabaseContants.DATABASE_NAME,null,DatabaseContants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(DatabaseContants.DATABASE_CREATE_USER);
            database.execSQL(DatabaseContants.DATABASE_CREATE_ARTICLE);
            database.execSQL(DatabaseContants.DATABASE_CREATE_MESSAGES);
        } catch (Exception e) {
            Log.d("SQL", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContants.TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContants.TABLE_MESSAGES);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContants.TABLE_ARTICLE);

    }
}
