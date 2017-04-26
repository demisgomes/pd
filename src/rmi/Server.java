/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import services.base64.Base64Operations;
import services.base64.Base64OperationsHelper;
import services.base64.IBase64Operations;

/**
 *
 * @author Demis e Lucas
 */
public class Server{
    public Server() throws RemoteException{
        super();
    }
    public static void main(String[] args) throws Exception {
        Registry create=LocateRegistry.createRegistry(2424);
        Registry r = LocateRegistry.getRegistry("localhost",2424);
        Base64Operations server = new Base64Operations();
        r.bind("base64",server);
        System.out.println("rmi.Server.main() Running");
}
    
}
