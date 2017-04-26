/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware.naming;

import java.util.ArrayList;
import middleware.client.ClientProxy;

/**
 *
 * @author gprt
 */
public class NamingProxy implements INaming {
    private NamingRepository namingRepository=NamingRepository.getInstance();
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public NamingProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    
    

    @Override
    public ClientProxy lookup(String serviceName) {
        return this.namingRepository.getRecord(serviceName);
    }

    @Override
    public ArrayList<String> list() {
        ArrayList<String> serviceNames = new ArrayList<String>();
        for(int i=0;i<this.namingRepository.getRecords().size();i++){
            serviceNames.add(this.namingRepository.getRecords().get(i).getServiceName());
        }
        return serviceNames;
    }

    @Override
    public void bind(String serviceName, ClientProxy clientProxy) {
        this.namingRepository.addRecord(serviceName, clientProxy);
        System.out.println("middleware.naming.NamingProxy.bind() "+this.namingRepository.getRecord(serviceName));
    }
    
}
