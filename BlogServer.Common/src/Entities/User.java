/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 * Stellt einen Nutzer dar
 * @author jonas
 */
public class User extends BaseEntity {
    
    private String Username;
    /**
     * Die Authentifikation stellt einen String dar
     * er ist dafür dar den Nutzer eindeutig zu Identifizieren
     */
    private String Authentification;
    /**
     * Der RSAPublic Key wird benötigt um eine RSAVerschlüsselung 
     * zu gewehrleisten
     */
    private String RSAPublicKey;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getAuthentification() {
        return Authentification;
    }

    public void setAuthentification(String Authentification) {
        this.Authentification = Authentification;
    }

    public String getRSAPublicKey() {
        return RSAPublicKey;
    }

    public void setRSAPublicKey(String RSAPublicKey) {
        this.RSAPublicKey = RSAPublicKey;
    }
    
    
    
    
}
