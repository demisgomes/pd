/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import communicationManager.ConnectionManager;
import java.net.DatagramPacket;

/**
 *
 * @author guto
 */
public class Server {
    
    
    public static void main(String args[]){
        
        ConnectionManager cm = new ConnectionManager();
        
        cm.startServerUDP(2424);
        System.out.println("Servidor: esperando requisicões...");
           
        
        while (true) {            
            
          DatagramPacket datagramPacket=cm.listenerUDP();
            if(datagramPacket!=null){
                ThreadClient t2 = new ThreadClient(cm,datagramPacket);
                t2.start();
            
}
        }
        
    }
    
}
