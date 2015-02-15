package de.juanah.lenasblogdataaccess.Converter;

import android.database.Cursor;

import de.juanah.lenasblogdataaccess.Entities.Article;
import de.juanah.lenasblogdataaccess.Repositories.UserRepository;

/**
 * Created by jonas on 15.02.15.
 */
public class ArticleConverter {

    public static UserRepository _userRepo;

    public static Article toArticle(Cursor cursor)
    {
        Article article = new Article();
        article.Id = cursor.getInt(0);
        article.setCreator(_userRepo.GetUserById(cursor.getInt(1)));
        article.setContent(cursor.getString(2));
        article.setTempId(cursor.getInt(3));
        return article;
    }

}
