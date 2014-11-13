/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mc.interfaces;


import mc.User;
import java.sql.*;
import java.util.List;

/**
 *
 * @author pobeirne
 */
public interface IUserRepository {

    List<User> getAllUsers() throws SQLException;

    User getUserByName(String name) throws SQLException;
    
    User getUserById(int userId) throws SQLException;

    boolean addUser(String name, String pass) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    boolean removeUser(int userId) throws SQLException;    
    
    void close (Connection connection, Statement statement, ResultSet rs);     
}
