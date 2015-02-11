/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;

/**
 *
 * @author jonas
 */
public class Article extends BaseEntity {
    
    private String Content;

    private Image image;

    private List<ArticleComment> Comments;

    public List<ArticleComment> getComments() {
        return Comments;
    }

    public void setComments(List<ArticleComment> Comments) {
        this.Comments = Comments;
    }
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
}
