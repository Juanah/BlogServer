package de.juanah.lenasblogdataaccess.Converter;

import android.database.Cursor;

import de.juanah.lenasblogdataaccess.Entities.User;

/**
 * Created by jonas on 15.02.15.
 */
public class UserConverter {

    public static User toUser(Cursor cursor)
    {
        User user = new User();
        user.Id = cursor.getInt(0);
        user.setUsername(cursor.getString(1));
        user.setAuthentification(cursor.getString(2));
        user.setTempId(cursor.getInt(3));
        return user;
    }
}
