/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.interfaces;

import MemoryCatcherApp.*;
import java.sql.*;
import java.util.List;

/**
 *
 * @author pobeirne
 */
public interface IFriendRepository {
    
    List<User> getAllFriends(int userId) throws SQLException;    
    
    boolean checkFriendsExist(int user_a,int user_b)throws SQLException; 

    boolean addFriend(int user_a, int user_b) throws SQLException;

    boolean updateFriend(int user_a, int user_b ,boolean active) throws SQLException;

    boolean removeFriend(int user_a, int user_b ) throws SQLException;    
    
    void close (Connection connection, Statement statement, ResultSet rs);      
}
