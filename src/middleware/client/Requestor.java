/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware.client;

import java.io.IOException;
import java.net.UnknownHostException;
import middleware.util.Invocation;
import middleware.util.Marshaller;
import middleware.util.Termination;

/**
 *
 * @author Demis e Lucas
 */
public class Requestor {
    public Termination invoke(Invocation invocation) throws UnknownHostException, IOException, Throwable{
        ClientRequestHandler crh=new ClientRequestHandler(invocation.getIpAddress(), invocation.getPortNumber());
        Marshaller marshaller = new Marshaller();
        Termination termination = new Termination();
        
        byte[] msgMarshalled;
        byte[] msgToBeMarshalled;
        byte[] msgUnmarshalled=new Message();
        return null;
        
    }
    
}
