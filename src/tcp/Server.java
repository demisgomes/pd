/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import communicationManager.ConnectionManager;

/**
 *
 * @author guto
 */
public class Server {
    
    
    public static void main(String args[]){
        
        ConnectionManager cm = new ConnectionManager();
        
        cm.startServerTCP(2424);
        System.out.println("Servidor: esperando requisicões...");
           
        
        while (true) {            
            
            if(cm.listenerTCP() == true){
               
                ThreadClient t2 = new ThreadClient(cm);
                t2.start();
                
            }
        }
        
    }
    
}
