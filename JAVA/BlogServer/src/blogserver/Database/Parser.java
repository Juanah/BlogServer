/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Database;

import Entities.Article;
import Entities.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * wandelt Datenbank objekte in Entities um
 * @author jonas
 */
public class Parser {
    
    private static Logger _log = Logger.getLogger("Parser");

    
    public static List<Article> GetArticles(ResultSet resultset)
    {
        List<Article> articles = new ArrayList<Article>();
        
        try {
            while (resultset.next()) {                
                Article article = new Article();
                article.setId(resultset.getInt(DatabaseConstants.ID));
                article.setContent(resultset.getString(DatabaseConstants.ARTICLE_CONTENT));
                article.setImage(TableHelper.GetImage(resultset.getInt(DatabaseConstants.ARTICLE_IMAGE)));
                articles.add(article);
            }
        } catch (Exception e) {
            _log.error("Parsing error Article:" + e.getMessage());
        }
        return articles;
    }
    
    public static List<Image> GetImages(ResultSet resultset)
    {
        List<Image> images = new ArrayList<Image>();
        
        try {
            while (resultset.next()) {  
                Image image = new Image();
                image.setId(resultset.getInt(DatabaseConstants.ID));
                image.setImage(resultset.getString(DatabaseConstants.IMAGE_BYTES));
                images.add(image);
            }
        } catch (Exception e) {
            _log.error("Parsing error Images:" + e.getMessage());
            return null;
        }
        
        return images;
    }
    
}
