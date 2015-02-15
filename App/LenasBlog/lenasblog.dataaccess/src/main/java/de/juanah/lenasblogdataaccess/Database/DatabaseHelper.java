package de.juanah.lenasblogdataaccess.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jonas on 15.02.15.
 */
public class DatabaseHelper {

    private Context _context;
    private SQLiteDatabase _database;
    private DbHandler _databaseHandler;

    public DatabaseHelper(Context _context) {
        this._context = _context;
        this._context = _context;
        _databaseHandler = new DbHandler(_context);
    }

    public void open()
    {
        _database = _databaseHandler.getWritableDatabase();
    }

    public void close()
    {
        _databaseHandler.close();
    }

    public SQLiteDatabase GetDatabase()
    {
        AutomaticConnect();
        return _database;
    }

    private void AutomaticConnect()
    {
        if(!_database.isOpen())
        {
            open();
        }
    }

}
