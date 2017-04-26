/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import services.base64.Base64Operations;
import services.base64.IBase64Operations;

/**
 *
 * @author Demis e Lucas
 */
public class Client {
    public static void main(String[]args) throws RemoteException, NotBoundException{
    String s = "";
    Registry r =LocateRegistry.getRegistry("localhost",2424);
    while (!s.equals("exit")) {            
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite a operação e os caracteres\nPara codificar: E string\nPara decodificar: D string\nDigite 'exit' para sair:");
            s = scanner.nextLine();

            if(!s.equals("exit")){
                String[]arrayMessage=s.split(" ");
                String response="";
                 IBase64Operations ib64=(IBase64Operations)r.lookup("base64");
               
                if(arrayMessage[0].equals("D")){
                    response=ib64.decode(arrayMessage[1]);
                }
                else{
                    response=ib64.encode(arrayMessage[1]);
                  }
                
                    System.out.println(response);
                }
        }
    }
   
}
