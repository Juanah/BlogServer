package de.juanah.lenasblogdataaccess.Entities;

/**
 * Created by jonas on 15.02.15.
 */
public class Message extends BaseEntity {

    private User Creator;
    private User Receiver;
    private String Content;
    private String ImagePath;

    public User getReceiver() {
        return Receiver;
    }

    public void setReceiver(User receiver) {
        Receiver = receiver;
    }

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
}
