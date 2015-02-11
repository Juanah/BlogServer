/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver;

import Entities.Article;
import Entities.Image;
import blogserver.Database.BaseDatabaseHelper;
import blogserver.Database.InsertHelper;
import blogserver.Database.TableHelper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author jonas
 */
public class BlogServer {

    /**
     * Member
     */
    private static Logger _log = Logger.getLogger("Main");
    private static boolean DEBUG = true;
    private static Scanner _scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
       Init();
       _log.info("Starting Server...");
       
       if(DEBUG)
       {
           _log.warn("Soll die Datenbank neu erstellt werden? Y/N");
           String userInput = _scanner.nextLine();
           if(userInput.equals("Y"))
           {
               if(!BaseDatabaseHelper.CreateDatabaseAndTables())
               {
                   _log.info("Database has been created");
               } else {
                   _log.error("Database could not be created");
               }
           }else
           {
               _log.info("Datenbank wurde nicht erstellt");
           }
       }
       
       
       TestDatabase();
    }
    
    private static void Init()
    {
        Logger.getRootLogger().getLoggerRepository().resetConfiguration();
        
          ConsoleAppender console = new ConsoleAppender(); //create appender
        //configure the appender
        String PATTERN = "%d [%p|%c|%C{1}] %m%n";
        console.setLayout(new PatternLayout(PATTERN)); 
        console.setThreshold(Level.ALL);
        console.activateOptions();
        //add appender to any Logger (here is root)
        Logger.getRootLogger().addAppender(console);

        FileAppender fa = new FileAppender();
        fa.setName("FileLogger");
        fa.setFile("BlogServer.log");
        fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
        fa.setThreshold(Level.DEBUG);
        fa.setAppend(true);
        fa.activateOptions();

        //add appender to any Logger (here is root)
        Logger.getRootLogger().addAppender(fa);
    }
    
    private static void TestDatabase() throws IOException
    {
        _log.info("Testing Database");
        
        Article article = new Article();
        article.setContent("TestContent");
        
        Image image = new Image();
        
        image.setImage("/home/jonas/Bilder/DSC05546.JPG");
        
        boolean InsertImage = InsertHelper.Insert(image);
        
        List<Image> images = TableHelper.GetImageTable();
        article.setImage(images.get(0));
        
        boolean InsertArticle = InsertHelper.Insert(article);
        
        if(InsertArticle && InsertImage)
        {
            _log.info("Insert succeded");
        }else
        {
            _log.error("Could not Insert");
        }
    }
    
}
