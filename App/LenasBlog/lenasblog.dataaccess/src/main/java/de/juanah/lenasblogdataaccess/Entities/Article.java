package de.juanah.lenasblogdataaccess.Entities;

/**
 * Created by jonas on 15.02.15.
 */
public class Article extends BaseEntity {

    private String Content;
    private String ImagePath;
    private int TempId;
    private User Creator;

    public User getCreator() {
        return Creator;
    }

    public void setCreator(User creator) {
        Creator = creator;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getTempId() {
        return TempId;
    }

    public void setTempId(int tempId) {
        TempId = tempId;
    }
}
