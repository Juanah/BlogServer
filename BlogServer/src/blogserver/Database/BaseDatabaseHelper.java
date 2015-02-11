/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *  Kümmert sich um die Basicdatenbank funktionen wie Connection erstellen und halten
 * @author jonas
 */
public class BaseDatabaseHelper {

    private static Connection connection;
    private static Logger _log = Logger.getLogger("BaseDatabaseHelper");
    /**
     * ConnectionInfo
     */
    private static final String Username = DatabaseConstants.USERNAME;
    private static final String Password = DatabaseConstants.PASSWORD;
    private static final String ConnectionString = "jdbc:mysql://localhost/";
    public static boolean Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            _log.info("ConnectionString:" + ConnectionString);
            connection = DriverManager
                    .getConnection(ConnectionString,Username,Password);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            _log.error(e);
            return false;
        }
    }
    
    /**
     * Gibt die Datenbankverbindung zurück
     * @return 
     */
    public static Connection getConnection() {
        if (connection == null) {
            Connect();
        }
        try {
            if (connection.isClosed()) {
                if (!Connect()) {
                   _log.error("Could not reconnect to Database");
                }
            }
        } catch (Exception e) {
            _log.error(e);
        }
        return connection;
    }
    
    
    public static boolean CreateDatabaseAndTables()
    {
        Connection localConnection = getConnection();
        try {
            _log.info("CreateDB:" + DatabaseCreationConstants.CREATE_DATABASE);
            Statement db = connection.createStatement();
            db.executeUpdate(DatabaseCreationConstants.CREATE_DATABASE);
            
            Statement article = connection.createStatement();
            _log.info("CreateTable:" + DatabaseCreationConstants.CREATE_TABLE_ARTICLE);
            article.executeUpdate(DatabaseCreationConstants.CREATE_TABLE_ARTICLE);
            Statement articleComments = connection.createStatement();
            _log.info("CreateTable:" + DatabaseCreationConstants.CREATE_TABLE_ARTICLECOMMENTS);
            articleComments.executeUpdate(DatabaseCreationConstants.CREATE_TABLE_ARTICLECOMMENTS);
            Statement ChatGroup = connection.createStatement();
            _log.info("CreateTable:" + DatabaseCreationConstants.CREATE_TABLE_CHATGROUP);
            ChatGroup.executeUpdate(DatabaseCreationConstants.CREATE_TABLE_CHATGROUP);
            Statement image = connection.createStatement();
            _log.info("CreateTable:" + DatabaseCreationConstants.CREATE_TABLE_IMAGE);
            image.executeUpdate(DatabaseCreationConstants.CREATE_TABLE_IMAGE);
            Statement message = connection.createStatement();
            _log.info("CreateTable:" + DatabaseCreationConstants.CREATE_TABLE_MESSAGE);
            message.executeUpdate(DatabaseCreationConstants.CREATE_TABLE_MESSAGE);
            Statement user = connection.createStatement();
            _log.info("CreateTable:" + DatabaseCreationConstants.CREATE_TABLE_USER);
            user.executeUpdate(DatabaseCreationConstants.CREATE_TABLE_USER);
            
            return true;
        } catch (Exception e) {
            _log.error("Could not Create Database and Tables" +e);
            return false;
        }
    }
    
}
