/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.server;

import org.memorycatcher.servant.Servant;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.omg.CORBA.ORB;

/**
 *
 * @author pobeirne
 */
public class MemoryCatcherServer {

    public static void main(String args[]) {
        // Add the try-catch block here in the next step.
        try {
            //Initialize the ORB
            ORB orb = ORB.init(args, null);
            //Instantiate the FundraisingAppServant on the server
            Servant servantRef = new Servant();            
            //Connect the FundraisingServant to the orb
            orb.connect(servantRef);
            //Store an object Reference to the FundraisingServant in a
            //String format
            String ior = orb.object_to_string(servantRef);
            //Write the object reference to the fundraisingServant to a
            //file called FundraisingIOR
            FileOutputStream fos = new FileOutputStream("MCIOR");
            try (PrintStream ps = new PrintStream(fos)) {
                ps.print(ior);
            }
            //Run the orb so that it waits for requests from the
            System.out.println("Server running waiting for requests ...");
            //client
            orb.run();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }   
   
}
