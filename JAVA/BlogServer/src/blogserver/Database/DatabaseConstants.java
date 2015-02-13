/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Database;

/**
 * Alle Konstanten für die Datenbanken
 * @author jonas
 */
public class DatabaseConstants {
    
    /**
     * General
     */
    public static String USERNAME = "blog_server";
    public static String PASSWORD = "Xlov76&4";
    public static String DatabaseName = "BlogServer";
    public static String ID = "_id";
    
    
    /**
     * Tables
     */
    public static String TABLE_USER = "Users";
    public static String TABLE_ARTICLES = "Articles";
    public static String TABLE_IMAGES = "Images";
    public static String TABLE_ARTICLECOMMENTS = "ArticleComment";
    public static String TABLE_CHATGROUP = "Chatgroup";
    public static String TABLE_MESSAGES = "Messages";
    
    
    /**
     * User Propertynames
     */
    public static String USER_NAME = "Username";
    public static String USER_AUTHENTIFICATION = "Authentification";
    public static String USER_RSAPUBLICKEY = "RSAPublicKey";
    
    
    /**
     * Articles Propertynames
     */
    public static String ARTICLE_CONTENT = "Content";
    public static String ARTICLE_IMAGE = "Image";
    
    /**
     * Image Propertynames
     */
    public static String IMAGE_BYTES = "Bytes";
    
    /**
     * ArticleComments Propertynames
     */
    public static String ACOMMENT_ARTICLEID = "ArticleId";
    public static String ACOMMENT_CREATORID = "CreatorId";
    public static String ACOMMENT_CONTENT = "Content";
    
    /**
     * ChatGroup Propertynames
     */
    public static String CHATGROUP_NAME = "Name";
    public static String CHATGROUP_CREATOR = "Creator";
    public static String CHATGROUP_MEMBER = "Member";
    
    /**
     * Message Prpertynames
     */
    public static String MESSAGE_ISGROUP = "IsGroup";
    public static String MESSAGE_CONTENT = "Content";
    public static String MESSAGE_IMAGE = "Image";
    public static String MESSAGE_CREATOR = "Creator";
    public static String MESSAGE_DESTINATION = "Destination";
    
    
    
}
