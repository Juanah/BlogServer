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
 *
 * @author jonas
 */
public class DeleteHelper {

    private static Logger _log = Logger.getLogger("DeleteHelper");

    public static boolean Delete(Object entity) {
        if (entity instanceof Article) {
            return Delete((Article) entity);
        }
        return false;
    }
    private static boolean DeleteArticle(Article article) {
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return false;
        }
        try {

            String query = "delete from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_ARTICLES +" where Id = ?";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setInt(1, article.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return false;
    }
    
     private static boolean DeleteImage(Image image) {
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return false;
        }
        try {

            String query = "delete from "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_IMAGES +" where Id = ?";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setInt(1, image.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return false;
    }

}
