package de.juanah.lenasblogdataaccess.Database;

/**
 * Created by jonas on 15.02.15.
 */
public class DatabaseContants {

    public static final String DATABASE_NAME = "lenasblog.db";
    public static final int DATABASE_VERSION = 1;


    //region Tables

    public static final String TABLE_USER = "User";
    public static final String COLUMN_USER_NAME = "Name";
    public static final String COLUMN_USER_AUTHENTIFICATION = "Authentification";
    public static final String COLUMN_USER_TEMPID = "TempId";


    public static final String TABLE_ARTICLE = "Article";
    public static final String COLUMN_ARTICLE_CREATOR = "Creator";
    public static final String COLUMN_ARTICLE_CONTENT = "Content";
    public static final String COLUMN_ARTICLE_IMAGE = "ImagePath";
    public static final String COLUMN_ARTICLE_TEMPID = "TempID";

    public static final String TABLE_MESSAGES = "Messages";
    public static final String COLUMN_MESSAGES_CREATOR = "Creator";
    public static final String COLUMN_MESSAGES_RECEIVER = "Receiver";
    public static final String COLUMN_MESSAGES_CONTENT = "Content";
    public static final String COLUMN_MESSAGES_IMAGE = "ImagePath";
    //endregion

    public static final String COLUMN_ID = "_id";

    //region Create
    public static final String DATABASE_CREATE_USER = "create table "
            + TABLE_USER + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_USER_NAME+ " text, "
            + COLUMN_USER_AUTHENTIFICATION+ " text, "
            + COLUMN_USER_TEMPID + " integer)";

    public static final String DATABASE_CREATE_ARTICLE = "create table "
            + TABLE_ARTICLE + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_ARTICLE_CREATOR + " int, "
            + COLUMN_ARTICLE_CONTENT + " text, "
            + COLUMN_ARTICLE_IMAGE + " text, "
            + COLUMN_ARTICLE_TEMPID + " integer)";


    public static final String DATABASE_CREATE_MESSAGES = "create table "
            + TABLE_MESSAGES + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_MESSAGES_CREATOR + " integer, "
            + COLUMN_MESSAGES_RECEIVER+ " integer, "
            + COLUMN_MESSAGES_CONTENT+ " text, "
            + COLUMN_MESSAGES_IMAGE + " text)";

    //endregion

    //region AllColumns
    public static final String[] USER_COLUMNS = new String[]{
        COLUMN_USER_NAME,
            COLUMN_USER_AUTHENTIFICATION,
            COLUMN_USER_TEMPID
    };

    public static final String[] ARTICLE_COLUMNS = new String[]{
            COLUMN_ARTICLE_CREATOR,
            COLUMN_ARTICLE_CONTENT,
            COLUMN_ARTICLE_IMAGE,
            COLUMN_ARTICLE_TEMPID
    };

    public static final String[] MESSAGE_COLUMNS = new String[]{
            COLUMN_MESSAGES_CREATOR,
            COLUMN_MESSAGES_RECEIVER,
            COLUMN_MESSAGES_CONTENT,
            COLUMN_MESSAGES_IMAGE
    };
    //endregion

}
