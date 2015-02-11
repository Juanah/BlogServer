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
import org.apache.log4j.Logger;

/**
 * Schreibt Entities in die Datenbank
 * @author jonas
 */
public class InsertHelper {
    
    private static Logger _log = Logger.getLogger("InsertHelper"); 
    
    public static boolean Insert(Object entity)
    {
        if(entity instanceof Article) return InsertArticle((Article)entity);
        if(entity instanceof Image)return InsertImage((Image)entity);
        return false;
    }
    
    /**
     * Schreibt einen Article in die Datenbank
     * @param article
     * @return success
     */
    private static boolean InsertArticle(Article article)
    {
        Connection connection = BaseDatabaseHelper.getConnection();
        
        if(connection == null)
        {
            _log.error("connection object is null");
            return false;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
            ("insert into ABlog.Articles values (default, ?, ?)");
            //Content
            preparedStatement.setString(1, article.getContent());
            preparedStatement.setInt(2, article.getImage().getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return false;
    }
    
    /**
     * Schreibt ein ImageEntity in die Datenbank
     * @param image
     * @return 
     */
    private static boolean InsertImage(Image image)
    {
        Connection connection = BaseDatabaseHelper.getConnection();
        if(connection == null)
        {
            _log.error("connection object is null");
            return false;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
            ("insert into  ABlog.Images values (default, ?)");
            //Content
            preparedStatement.setBytes(1, image.getImage());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return false;
    }
    
    
}
