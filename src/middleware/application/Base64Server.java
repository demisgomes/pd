/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware.application;

import java.io.IOException;
import java.rmi.RemoteException;
import middleware.naming.NamingProxy;
import middleware.server.Base64Invoker;
import middleware.services.Base64OperationsProxy;

/**
 *
 * @author gprt
 */
public class Base64Server {
    
    public static void main(String[]args) throws IOException, RemoteException, InterruptedException{
        Base64Invoker invoker = new Base64Invoker();
        System.out.println("Server running");
        Base64OperationsProxy base64 = new Base64OperationsProxy();
        System.out.println("Server running");
        NamingProxy namingProxy = new NamingProxy("localhost",2017);
        System.out.println("Server running");
        
        namingProxy.bind("Base64", base64);
        System.out.println("middleware.application.Base64Server.main() "+namingProxy.list());
        
        invoker.invoke(base64);
        
        System.out.println("Server running");
    }   
}
