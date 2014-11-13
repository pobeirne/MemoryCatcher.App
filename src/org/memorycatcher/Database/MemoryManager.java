/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.Database;


import mc.Memory;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;


/**
 *
 * @author pobeirne
 */
public class MemoryManager {
    
      private final String CONFIG_PATH = "C:\\MemoryCatcher\\"
            + "src\\dbconfig.properties";
    private final Connection myConn;
    private Statement myStmt;
    private PreparedStatement myPrepStmt;
    private ResultSet myRs;
    
    private Memory memory;
    private ArrayList<Memory> memories;

    public MemoryManager() throws SQLException, Exception {
        Properties props = new Properties();

        props.load(new FileInputStream(CONFIG_PATH));
        String theUser = props.getProperty("user");
        String thePassword = props.getProperty("password");
        String theDBurl = props.getProperty("dburl");

        myConn = DriverManager.getConnection(
                theDBurl,
                theUser,
                thePassword);

    }

    public boolean addMemory(Memory addMem) throws SQLException {
          myPrepStmt = null;
        try {
            try {

                myPrepStmt = myConn.prepareStatement("insert into memories("
                        + "mem_title, "
                        + "mem_desc,"
                        + "owner_id)"
                        + " values (?, ?, ?)"
                );
                
                myPrepStmt.setString(1, addMem.title);
                myPrepStmt.setString(2, addMem.desc);
                myPrepStmt.setInt(3, addMem.ownerId);

                int executeUpdate = myPrepStmt.executeUpdate();
                return executeUpdate == 1;

            } finally {
                myPrepStmt.close();
            }
        } finally {
            myConn.close();
        }
    }

    public boolean updateMemory(Memory mem) {
          return mem!=null;        
    }

    public boolean removeMemory(int memId) {
        return memId==1;
    }

    public Memory getMemory(int memId) {
        if (memId==1) {
            return getOneMemory();
        }
          return null;
    }

    public ArrayList<Memory> getAllMemories(int userId) {
        memories = new ArrayList<>();
        memories.add(getOneMemory());
        memories.add(getOneMemory());
        return memories;
    }
    
    
    private Memory getOneMemory(){
        memory = new Memory();
        memory.id = 1;
        memory.title = "Tilte";
        memory.desc = "Description";
        memory.ownerId = 1;
        memory.createDate = "10/20/2014";
        return memory;
    }   

    private static java.sql.Date getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        java.sql.Date createDate = new java.sql.Date(calendar.getTime().getTime());
        return createDate;

    }

}
