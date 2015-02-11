/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Database;

import Entities.Article;
import Entities.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Liefert die Entities zurück
 * @author jonas
 */
public class TableHelper {
    
    private static Logger _log = Logger.getLogger("DeleteHelper");

    
    public static List<Article> GetArticleTable()
    {
        ResultSet resultset;
        
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return null;
        }
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_ARTICLES );
            resultset = preparedStatement.executeQuery();
            if(resultset == null)
            {
                _log.error("Articles: resultset is null");
                return null;
            }
            return Parser.GetArticles(resultset);
            
        } catch (Exception e) {
            _log.error(e);
            return null;
        }
    }
    
    public static List<Article> GetArticleTable(String whereclausle)
    {
        ResultSet resultset;
        
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return null;
        }
        
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("select * from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_ARTICLES + " " + whereclausle);
            resultset = preparedStatement.executeQuery();
            if(resultset == null)
            {
                _log.error("Articles: resultset is null");
                return null;
            }
            return Parser.GetArticles(resultset);
            
        } catch (Exception e) {
            _log.error(e);
            return null;
        }
    }
    
    
    public static Image GetImage(int id)
    {
        ResultSet resultset;
        
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return null;
        }
        
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_IMAGES +" where Id = ?");
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            if(resultset == null)
            {
                _log.error("Articles: resultset is null");
                return null;
            }
            return Parser.GetImages(resultset).get(0);
            
        } catch (Exception e) {
            _log.error(e);
            return null;
        }
    }
    
    public static List<Image> GetImageTable()
    {
        ResultSet resultset;
        
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return null;
        }
        
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_IMAGES );
            resultset = preparedStatement.executeQuery();
            if(resultset == null)
            {
                _log.error("Articles: resultset is null");
                return null;
            }
            return Parser.GetImages(resultset);
            
        } catch (Exception e) {
            _log.error(e);
            return null;
        }
    }
    
    public static List<Image> GetImageTable(String whereclausle)
    {
        ResultSet resultset;
        
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return null;
        }
        
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("select * from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_ARTICLES + " " + whereclausle);
            resultset = preparedStatement.executeQuery();
            if(resultset == null)
            {
                _log.error("Articles: resultset is null");
                return null;
            }
            return Parser.GetImages(resultset);
            
        } catch (Exception e) {
            _log.error(e);
            return null;
        }
    }
    
    
}
