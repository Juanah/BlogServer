/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Database;

/**
 * Hält alle Erstellungsscripte
 * @author jonas
 */
public class DatabaseCreationConstants {
    //CREATE SCHEMA `new_schema2` ;
    
    public static final String CREATE_DATABASE = "CREATE SCHEMA `" + DatabaseConstants.DatabaseName + "` ;";
    
    /**
     * Tables#
     * CREATE TABLE `BlogServer`.`new_table` (
  `idnew_table` INT NOT NULL AUTO_INCREMENT,
  `new_tablecol` VARCHAR(45) NULL,
  `new_tablecol1` INT NULL,
  PRIMARY KEY (`idnew_table`));
     */
    public static final String CREATE_TABLE_ARTICLE 
            = "CREATE TABLE `" 
            + DatabaseConstants.DatabaseName
            + "`.`" 
            + DatabaseConstants.TABLE_ARTICLES
            + "` (`"
            + DatabaseConstants.ID
            + "` INT NOT NULL AUTO_INCREMENT, `"
            + DatabaseConstants.ARTICLE_CONTENT
            + "` LONGTEXT NULL, `"
            + DatabaseConstants.ARTICLE_IMAGE
            + "` VARCHAR(21844) NULL, "
            + "PRIMARY KEY (`"
            + DatabaseConstants.ID
            + "`));";
    
    public static final String CREATE_TABLE_ARTICLECOMMENTS 
            = "CREATE TABLE `" 
            + DatabaseConstants.DatabaseName
            + "`.`" 
            + DatabaseConstants.TABLE_ARTICLECOMMENTS
            + "` (`"
            + DatabaseConstants.ID
            + "` INT NOT NULL AUTO_INCREMENT, `"
            + DatabaseConstants.ACOMMENT_ARTICLEID
            + "` INT NULL, `"
            + DatabaseConstants.ACOMMENT_CREATORID
            + "` INT NULL, `"
            + DatabaseConstants.ACOMMENT_CONTENT
            + "` LONGTEXT NULL, "
            + "PRIMARY KEY (`"
            + DatabaseConstants.ID
            + "`));";
    
    public static final String CREATE_TABLE_CHATGROUP
            = "CREATE TABLE `" 
            + DatabaseConstants.DatabaseName
            + "`.`" 
            + DatabaseConstants.TABLE_CHATGROUP
            + "` (`"
            + DatabaseConstants.ID
            + "` INT NOT NULL AUTO_INCREMENT, `"
            + DatabaseConstants.CHATGROUP_NAME
            + "` VARCHAR(255) NULL, `"
            + DatabaseConstants.CHATGROUP_CREATOR
            + "` INT NULL, `"
            + DatabaseConstants.CHATGROUP_MEMBER
            + "` VARCHAR(500) NULL, "
            + "PRIMARY KEY (`"
            + DatabaseConstants.ID
            + "`));";
    
    public static final String CREATE_TABLE_USER
            = "CREATE TABLE `" 
            + DatabaseConstants.DatabaseName
            + "`.`" 
            + DatabaseConstants.TABLE_USER
            + "` (`"
            + DatabaseConstants.ID
            + "` INT NOT NULL AUTO_INCREMENT, `"
            + DatabaseConstants.USER_NAME
            + "` VARCHAR(255) NULL, `"
            + DatabaseConstants.USER_AUTHENTIFICATION
            + "` VARCHAR(64) NULL, `"
            + DatabaseConstants.USER_RSAPUBLICKEY
            + "` VARCHAR(21844) NULL, "
            + "PRIMARY KEY (`"
            + DatabaseConstants.ID
            + "`));";
    
    public static final String CREATE_TABLE_IMAGE
            = "CREATE TABLE `" 
            + DatabaseConstants.DatabaseName
            + "`.`" 
            + DatabaseConstants.TABLE_IMAGES
            + "` (`"
            + DatabaseConstants.ID
            + "` INT NOT NULL AUTO_INCREMENT, `"
            + DatabaseConstants.IMAGE_BYTES
            + "` VARCHAR(255) NULL, "
            + "PRIMARY KEY (`"
            + DatabaseConstants.ID
            + "`));";
    
    public static final String CREATE_TABLE_MESSAGE
            = "CREATE TABLE `" 
            + DatabaseConstants.DatabaseName
            + "`.`" 
            + DatabaseConstants.TABLE_MESSAGES
            + "` (`"
            + DatabaseConstants.ID
            + "` INT NOT NULL AUTO_INCREMENT, `"
            + DatabaseConstants.MESSAGE_ISGROUP
            + "` BIT NULL, `"
            + DatabaseConstants.MESSAGE_CONTENT
            + "` LONGTEXT NULL, `"
            + DatabaseConstants.MESSAGE_IMAGE
            + "` VARCHAR(21844) NULL, `"
            + DatabaseConstants.MESSAGE_CREATOR
            + "` INT NULL, `"
            + DatabaseConstants.MESSAGE_DESTINATION
            + "` INT NULL, "
            + "PRIMARY KEY (`"
            + DatabaseConstants.ID
            + "`));";
    
}
