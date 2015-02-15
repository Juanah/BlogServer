package de.juanah.lenasblogdataaccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import de.juanah.lenasblogdataaccess.Converter.ArticleConverter;
import de.juanah.lenasblogdataaccess.Database.DatabaseContants;
import de.juanah.lenasblogdataaccess.Database.DatabaseHelper;
import de.juanah.lenasblogdataaccess.Database.DbHandler;
import de.juanah.lenasblogdataaccess.Entities.Article;

/**
 * Created by jonas on 15.02.15.
 */
public class ArticleRepository {

    private DatabaseHelper _dbHelper;
    private List<Article> _articles = new ArrayList<>();
    public ArticleRepository(DatabaseHelper _dbHelper) {
        this._dbHelper = _dbHelper;
    }

    public Article Add(Article article)
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseContants.COLUMN_ARTICLE_CREATOR,article.getCreator().getTempId());
        values.put(DatabaseContants.COLUMN_ARTICLE_CONTENT,article.getContent());
        values.put(DatabaseContants.COLUMN_ARTICLE_IMAGE,article.getImagePath());
        values.put(DatabaseContants.COLUMN_ARTICLE_TEMPID,article.getTempId());


        long id = _dbHelper.GetDatabase().insert(DatabaseContants.TABLE_ARTICLE, null, values);
        Cursor cursor = _dbHelper.GetDatabase().query(DatabaseContants.TABLE_ARTICLE,
                DatabaseContants.ARTICLE_COLUMNS,
                DatabaseContants.COLUMN_ID + " = " + id,
                null, null, null, null);
        Article readArticle = ArticleConverter.toArticle(cursor);
        cursor.close();
        GetAllArticles();
        return readArticle;
    }

    public List<Article> get_articles() {
        return _articles;
    }

    private void GetAllArticles()
    {
        _articles = new ArrayList<>();
        Cursor cursor = _dbHelper.GetDatabase().query(
                DatabaseContants.TABLE_ARTICLE,
                DatabaseContants.ARTICLE_COLUMNS,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Article tempArticle = ArticleConverter.toArticle(cursor);
            _articles.add(tempArticle);
            cursor.moveToNext();
        }
        cursor.close();
    }
}
