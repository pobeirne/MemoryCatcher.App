/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.database;



import org.memorycatcher.interfaces.IMemoryRepository;
import MemoryCatcherApp.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author pobeirne
 */
public class MemoryRepository implements IMemoryRepository{
    
    
     private final String CONFIG_PATH = "C:\\MemoryCatcherApp\\"
            + "src\\dbconfig.properties";
    private final Connection myConn;
    private Statement myStmt;
    private PreparedStatement myPrepStmt;
    private ResultSet myRs;

    private Memory memory;
    private List<Memory> memoryList;

    public MemoryRepository() throws SQLException, Exception {
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



    @Override
    public List<Memory> getAllMemories() throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from memories");
            memoryList = new ArrayList<>();
            while (myRs.next()) {
                memory = convertRowToMemory(myRs);
                memoryList.add(memory);
            }
            return memoryList;

        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public List<Memory> getAllUserMemories(int ownerId) throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from memories where owner_id ="+ownerId+"");
            memoryList = new ArrayList<>();
            while (myRs.next()) {
                memory = convertRowToMemory(myRs);
                memoryList.add(memory);
            }
            return memoryList;

        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public Memory getMemoryById(int memoryId) throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from memories where memory_id ="+memoryId+"");           
            while (myRs.next()) {
                memory = convertRowToMemory(myRs);                
            }
            return memory;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public boolean addMemory(int ownerId, String title, String desc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateMemory(Memory memory) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeMemory(int memoryId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close(Connection connection, Statement statement, ResultSet rs) {
          if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    
    
    
    private Memory convertRowToMemory(ResultSet myRs) throws SQLException {
        memory = new Memory();
        memory.id = myRs.getInt("memory_id");
        memory.ownerId =myRs.getInt("owner_id");
        memory.title = myRs.getString("memory_title");
        memory.desc = myRs.getString("memory_desc");
        memory.active = myRs.getBoolean("active");
        memory.createDate = myRs.getString("create_date");
        
        return memory;
    }
    
}
