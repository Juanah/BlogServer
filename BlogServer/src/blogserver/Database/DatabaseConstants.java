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
    public static String TABLE_ARTICLES = "Articles";
    public static String TABLE_IMAGES = "Images";
    
    
    /**
     * Articles Propertynames
     */
    public static String ARTICLE_CONTENT = "Content";
    public static String ARTICLE_IMAGE = "Image";
    
    /**
     * Image Propertynames
     */
    public static String IMAGE_BYTES = "Bytes";
    
}
