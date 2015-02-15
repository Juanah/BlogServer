package de.juanah.lenasblogdataaccess.Repositories;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import de.juanah.lenasblogdataaccess.Converter.MessageConverter;
import de.juanah.lenasblogdataaccess.Database.DatabaseContants;
import de.juanah.lenasblogdataaccess.Database.DatabaseHelper;
import de.juanah.lenasblogdataaccess.Entities.Message;

/**
 * Created by jonas on 15.02.15.
 */
public class MessageRepository {

    private DatabaseHelper _dbHelper;
    private List<Message> _messages = new ArrayList<>();

    public MessageRepository(DatabaseHelper _dbHelper) {
        this._dbHelper = _dbHelper;
    }

    public Message Add(Message message)
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseContants.COLUMN_MESSAGES_CREATOR, message.getCreator().getTempId());
        values.put(DatabaseContants.COLUMN_MESSAGES_RECEIVER, message.getReceiver().getTempId());
        values.put(DatabaseContants.COLUMN_MESSAGES_CONTENT,message.getContent());
        values.put(DatabaseContants.COLUMN_MESSAGES_IMAGE, message.getImagePath());


        long id = _dbHelper.GetDatabase().insert(DatabaseContants.TABLE_MESSAGES, null, values);
        Cursor cursor = _dbHelper.GetDatabase().query(DatabaseContants.TABLE_MESSAGES,
                DatabaseContants.MESSAGE_COLUMNS,
                DatabaseContants.COLUMN_ID + " = " + id,
                null, null, null, null);
        Message readMessage = MessageConverter.toMessage(cursor);
        cursor.close();
        GetAllMessages();
        return readMessage;
    }

    public List<Message> get_messages() {
        return _messages;
    }

    private void GetAllMessages()
    {
        _messages = new ArrayList<>();
        Cursor cursor = _dbHelper.GetDatabase().query(
                DatabaseContants.TABLE_MESSAGES,
                DatabaseContants.MESSAGE_COLUMNS,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Message tempMessage = MessageConverter.toMessage(cursor);
            _messages.add(tempMessage);
            cursor.moveToNext();
        }
        cursor.close();
    }
}
