package de.juanah.lenasblogdataaccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import de.juanah.lenasblogdataaccess.Converter.UserConverter;
import de.juanah.lenasblogdataaccess.Database.DatabaseContants;
import de.juanah.lenasblogdataaccess.Database.DatabaseHelper;
import de.juanah.lenasblogdataaccess.Database.DbHandler;
import de.juanah.lenasblogdataaccess.Entities.User;

/**
 * Created by jonas on 15.02.15.
 */
public class UserRepository {

    private List<User> _users = new ArrayList<>();
    private DatabaseHelper _dbHelper;

    public UserRepository(DatabaseHelper _dbHelper) {
        this._dbHelper = _dbHelper;
    }


    public User Add(User user)
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseContants.COLUMN_USER_NAME,user.getUsername());
        values.put(DatabaseContants.COLUMN_USER_AUTHENTIFICATION,user.getAuthentification());
        values.put(DatabaseContants.COLUMN_USER_TEMPID,user.getAuthentification());

        long id = _dbHelper.GetDatabase().insert(DatabaseContants.TABLE_USER, null, values);
        Cursor cursor = _dbHelper.GetDatabase().query(DatabaseContants.TABLE_USER,
                DatabaseContants.USER_COLUMNS,
                DatabaseContants.COLUMN_ID + " = " + id,
                null,null,null,null);
        User readUser = UserConverter.toUser(cursor);
        GetUsers();
        cursor.close();
        return readUser;
    }

    public List<User> get_users() {
        return _users;
    }


    public User GetUserById(int id)
    {
        for(User user: _users)
        {
            if(user.getTempId() == id)
            {
                return user;
            }
        }
        return null;
    }

    private void GetUsers()
    {
        _users = new ArrayList<>();
        Cursor cursor = _dbHelper.GetDatabase().query(
                DatabaseContants.TABLE_USER,
                DatabaseContants.USER_COLUMNS,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User tempUser = UserConverter.toUser(cursor);
            _users.add(tempUser);
            cursor.moveToNext();
        }
        cursor.close();
    }



}
