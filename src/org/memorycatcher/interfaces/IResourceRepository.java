/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.interfaces;



import MemoryCatcherApp.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author pobeirne
 */
public interface IResourceRepository {
    

    List<Resource> getAllResourcesById(int memoryId) throws SQLException;       

    boolean addResource(int memoryId,int ownerId, String type, String location) throws SQLException;

    boolean updateResource(Resource resource) throws SQLException;

    boolean removeResource(int resourceId) throws SQLException;    
    
    void close (Connection connection, Statement statement, ResultSet rs);     
}
