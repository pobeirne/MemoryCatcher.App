/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mc.interfaces;

import mc.Memory;
import java.sql.*;
import java.util.List;

/**
 *
 * @author pobeirne
 */
public interface IMemoryRepository {
    
    List<Memory> getAllMemories() throws SQLException;
    
    List<Memory> getAllUserMemories(int ownerId) throws SQLException;
         
    Memory getMemoryById(int memoryId) throws SQLException;

    boolean addMemory(int ownerId, String title, String desc) throws SQLException;

    boolean updateMemory(Memory memory) throws SQLException;

    boolean removeMemory(int memoryId) throws SQLException;    
    
    void close (Connection connection, Statement statement, ResultSet rs);  
    
        
}
