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
 * Updated Entities in der Datenbank
 *
 * @author jonas
 */
public class UpdateHelper {

    private static Logger _log = Logger.getLogger("UpdateHelper");

    public static boolean Update(Object entity) {
        if (entity instanceof Article) {
            return UpdateArticle((Article) entity);
        }
        if (entity instanceof Image) {
            return UpdateImage((Image) entity);
        }
        return false;
    }

    private static boolean UpdateArticle(Article article) {
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return false;
        }
        try {

            String query = "update "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_ARTICLES +" set Content = ? , Image = ?  where Id = ?";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setString(1, article.getContent());
            preparedStatement.setInt(2, article.getImage().getId());
            preparedStatement.setInt(3, article.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return false;
    }

    private static boolean UpdateImage(Image image) {
        Connection connection = BaseDatabaseHelper.getConnection();
        if (connection == null) {
            _log.error("connection object is null");
            return false;
        }
        try {
            String query = "update "+DatabaseConstants.DatabaseName +"." + DatabaseConstants.TABLE_IMAGES +" set imageBytes = ? where Id = ?";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
            preparedStatement.setBytes(1, image.getImage());
            preparedStatement.setInt(3, image.getId());
            preparedStatement.executeUpdate();
            return true;

        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return false;
    }

}
