/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 * Representiert ein Bild, welches von BlogEntities abonniert werden können
 * @author jonas
 */
public class Image extends BaseEntity {
    
    
    
    private byte[] _Image;

    
    public byte[] getImage() {
        return _Image;
    }

    public void setImage(byte[] _Image) {
        this._Image = _Image;
    }
    
    
    
}
