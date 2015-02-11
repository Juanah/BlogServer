/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public static boolean Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + DatabaseConstants.DatabaseName + "?"
                            + "user=" + Username + "&password=" + Password);
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
}
