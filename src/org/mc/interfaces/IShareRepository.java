/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mc.interfaces;

import java.sql.*;

/**
 *
 * @author pobeirne
 */
public interface IShareRepository {

    boolean addShare(int userId, int memoryId) throws SQLException;

    boolean updateShare(int userId, int memoryId, boolean active) throws SQLException;

    boolean removeShare(int userId, int memoryId) throws SQLException;

    void close(Connection connection, Statement statement, ResultSet rs);

}
