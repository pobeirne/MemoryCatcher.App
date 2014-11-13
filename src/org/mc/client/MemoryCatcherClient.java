/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mc.client;


import mc.MemoryCatcherHelper;
import mc.MemoryCatcher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.omg.CORBA.ORB;

/**
 *
 * @author pobeirne
 */
public class MemoryCatcherClient {

    public MemoryCatcher servantRef;

    public static void main(String args[]) {
        new MemoryCatcherClient(args);
    }

    public MemoryCatcherClient(String args[]) {
        init(args);
    }
    
    private void init(String args[]) {

        try {

            ORB orb = ORB.init(args, null);
            BufferedReader br = new BufferedReader(new FileReader("MCIOR"));
            String ior = br.readLine();
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            servantRef = MemoryCatcherHelper.narrow(obj);

        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

    public MemoryCatcher getServant() {
        return servantRef;
    }

    public void Close() {
        System.exit(0);
    }

}
