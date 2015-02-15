package de.juanah.lenasblogdataaccess.Entities;

/**
 * Created by jonas on 15.02.15.
 */
public class User extends BaseEntity {

    private String Username;
    private String Authentification;
    private int TempId;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getAuthentification() {
        return Authentification;
    }

    public void setAuthentification(String authentification) {
        Authentification = authentification;
    }

    public int getTempId() {
        return TempId;
    }

    public void setTempId(int tempId) {
        TempId = tempId;
    }
}
