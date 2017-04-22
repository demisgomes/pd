/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import communicationManager.ConnectionManager;
import services.base64.Base64OperationsHelper;

/**
 *
 * @author guto
 */
public class ThreadClient extends Thread{
    
    ConnectionManager cm;

    public ThreadClient() {
    }
    
    
    
    public ThreadClient(ConnectionManager cm){
        this.cm = cm;
    }
    
    public void run(){
        
        
        try {
            
            System.out.println("Uma requisição!");
            byte[] data = cm.getDataTCP();
            String msg = new String(data, "UTF-8");
            String response = "";
             
            Base64OperationsHelper b64Helper=new Base64OperationsHelper();
            response=b64Helper.readMessage(msg);
            this.cm.sendDataTCP(response.getBytes());
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
