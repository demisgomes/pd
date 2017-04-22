/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import communicationManager.ConnectionManager;
import java.net.DatagramPacket;
import java.net.InetAddress;
import services.base64.Base64OperationsHelper;
import services.calculator.Calculator;
import services.calculator.CalculatorHelper;

/**
 *
 * @author guto
 */
public class ThreadClient extends Thread{
    DatagramPacket receiveData;
    ConnectionManager cm;

   
    
    
    public ThreadClient(ConnectionManager connectionManager, DatagramPacket datagramPacket){
        this.receiveData=datagramPacket;
        this.cm=connectionManager;
}
    
    public void run(){
        
        
        try {
            
             System.out.println("Uma requisição!");
             DatagramPacket clientPacket=this.receiveData;
             byte[] data = clientPacket.getData();
             int clientPort=clientPacket.getPort();
             InetAddress clientAddress=clientPacket.getAddress();
             String msg = new String(data, "UTF-8");
             //String[] datas = msg.split(" ");
             String response = "";
             
            Base64OperationsHelper b64Helper=new Base64OperationsHelper();
            response=b64Helper.readMessage(msg);
             
             //this.cm.sendDataTCP(response.getBytes());        
            this.cm.sendDataUDP(response.getBytes(),clientAddress,clientPort); 
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
