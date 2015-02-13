/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogserver.Service;

import java.net.ServerSocket;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jonas
 */
public class ServiceHandler implements Runnable {
    private volatile ServerSocket _serverSocket;
    private volatile  int _port = 55568;
    public volatile Boolean Continue = true;
    private org.slf4j.Logger _log = LoggerFactory.getLogger("ServiceHandler");
    
    
    private void InitializeServerSocket()
    {
        try {
            _serverSocket = new ServerSocket(_port);
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
    }

    @Override
    public void run() {
    }
    
    private void RunService()
    {
        while (Continue) {            
            
        }
        
    }
    
    
}
