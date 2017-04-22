/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import communicationManager.ConnectionManager;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guto
 */
public class Client {
    
    public static void main(String args[]) throws UnsupportedEncodingException{
        String s = "";
        while (!s.equals("exit")) {            
              
              ConnectionManager cm = new ConnectionManager();
              Scanner scanner = new Scanner(System.in);

             System.out.println("Digite a operação e os caracteres\nPara codificar: E string\nPara decodificar: D string\nDigite 'exit' para sair:");
              s = scanner.nextLine();

              if(!s.equals("exit")){
                  try {
                      cm.sendDataUDP(s.getBytes(), InetAddress.getByName("localhost"),2424);
                  } catch (UnknownHostException ex) {
                      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                  }

                  System.out.println("ClienteUDP: Enviando operação. Esperando resposta...");

                  byte[] data = cm.getDataUDP().getData();
                  String msg = new String(data, "UTF-8");
                  System.out.println(msg);
                  cm.closeConnectionTCP();
              }

        }
      
    }
    
}
