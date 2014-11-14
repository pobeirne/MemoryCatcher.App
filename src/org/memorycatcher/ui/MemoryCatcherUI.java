/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.ui;

import org.memorycatcher.client.MemoryCatcherClient;

/**
 *
 * @author pobeirne
 */
public class MemoryCatcherUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            MemoryCatcherClient client = new MemoryCatcherClient(null);

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

}
