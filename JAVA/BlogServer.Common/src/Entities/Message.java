/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 * Stellt eine Normale Nachricht zwischen 2 Clients, oder Gruppe dar
 * @author jonas
 */
public class Message extends BaseEntity {
    
    /**
     * Beschreibt ob es sich um eine Gruppennachricht, oder eine Private handelt
     */
    private boolean IsGroup;
    
    /**
     * Der Inhalt der Message
     */
    private String Content;
    
    /**
     * Nachricht mit Bild
     */
    private Image Image;
    
    /**
     * Ersteller der Nachricht
     */
    private User Creator;
    
    /**
     * Empfänger
     */
    private User Destination;

    public boolean isIsGroup() {
        return IsGroup;
    }

    public void setIsGroup(boolean IsGroup) {
        this.IsGroup = IsGroup;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image Image) {
        this.Image = Image;
    }

    public User getCreator() {
        return Creator;
    }

    public void setCreator(User Creator) {
        this.Creator = Creator;
    }

    public User getDestination() {
        return Destination;
    }

    public void setDestination(User Destination) {
        this.Destination = Destination;
    }
    
    
    
}
