/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 * Stellt ein Kommentar für einen Article dar
 * @author jonas
 */
public class ArticleComment extends BaseEntity {
    
    /**
     * Artikel welchem der Kommentar angehört
     */
    private Article Article;
    
    private User Creator;
    
    private String Content;

    public Article getArticle() {
        return Article;
    }

    public void setArticle(Article Article) {
        this.Article = Article;
    }

    public User getCreator() {
        return Creator;
    }

    public void setCreator(User Creator) {
        this.Creator = Creator;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
    
    
    
}
