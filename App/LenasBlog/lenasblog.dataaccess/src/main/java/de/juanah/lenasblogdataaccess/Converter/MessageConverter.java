package de.juanah.lenasblogdataaccess.Converter;

import android.database.Cursor;

import de.juanah.lenasblogdataaccess.Entities.Message;
import de.juanah.lenasblogdataaccess.Repositories.UserRepository;

/**
 * Created by jonas on 15.02.15.
 */
public class MessageConverter {

    public static UserRepository _userRepository;

    public static Message toMessage(Cursor cursor)
    {
        Message message = new Message();
        message.Id = cursor.getInt(0);
        message.setCreator(_userRepository.GetUserById(cursor.getInt(1)));
        message.setCreator(_userRepository.GetUserById(cursor.getInt(2)));
        message.setContent(cursor.getString(3));
        message.setImagePath(cursor.getString(4));
        return message;
    }


}
