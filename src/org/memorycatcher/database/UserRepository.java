/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.database;

import org.memorycatcher.interfaces.IUserRepository;
import MemoryCatcherApp.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

/**
 *
 * @author pobeirne
 */
public class UserRepository implements IUserRepository {

    private final String CONFIG_PATH = "C:\\MemoryCatcherApp\\"
            + "src\\dbconfig.properties";
    private final Connection myConn;
    private Statement myStmt;
    private PreparedStatement myPrepStmt;
    private ResultSet myRs;

    private User user;
    private List<User> users;

    public UserRepository() throws SQLException, Exception {
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
    public List<User> getAllUsers() throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users");
            users = new ArrayList<>();
            while (myRs.next()) {
                user = convertRowToUser(myRs);
                users.add(user);
            }
            return users;

        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users where user_name='" + name + "'");
            user = new User();
            if (myRs.next()) {
                user = convertRowToUser(myRs);
            }
            return user;

        } finally {
            close(myConn, myPrepStmt, myRs);
        }
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users where user_id='" + userId + "'");
            user = new User();
            if (myRs.next()) {
                user = convertRowToUser(myRs);
            }
            return user;

        } finally {
            close(myConn, myPrepStmt, myRs);
        }
    }

    @Override
    public boolean addUser(String name, String pass) throws SQLException {

        myPrepStmt = null;
        myRs = null;
        try {
            myPrepStmt = myConn.prepareStatement("insert into users("
                    + "user_name, "
                    + "user_pwd,"
                    + "join_date)"
                    + " values (?, ?, ?)"
            );

            myPrepStmt.setString(1, name);
            myPrepStmt.setString(2, pass);
            myPrepStmt.setDate(3, getCurrentDate());          
            return myPrepStmt.executeUpdate()==1;
        } finally {
            close(myConn, myPrepStmt, myRs);
        }       
    }

    @Override
    public boolean updateUser(User user) throws SQLException {

        myPrepStmt = null;
        myRs = null;
        try {

            myPrepStmt = myConn.prepareStatement("update users set "
                    + "tokens=? ,"
                    + "online=? "
                    + "where user_id=?"
            );
            myPrepStmt.setInt(1, user.tokens);
            myPrepStmt.setBoolean(2, user.online);
            myPrepStmt.setInt(3, user.id);           
            return myPrepStmt.executeUpdate()==1;
            
        } finally {
            close(myConn, myPrepStmt, myRs);
        }
    }

    @Override
    public boolean removeUser(int userId) throws SQLException {

        myPrepStmt = null;
        myRs = null;
        try {
            myPrepStmt = myConn.prepareStatement("delete from users "
                    + "where user_id=?"
            );
            myPrepStmt.setInt(1, userId);            
            return myPrepStmt.executeUpdate()==1;

        } finally {
            close(myConn, myPrepStmt, myRs);
        }
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

    private User convertRowToUser(ResultSet myRs) throws SQLException {

        user = new User();
        user.id = myRs.getInt("user_id");
        user.name = myRs.getString("user_name");
        user.pwd = myRs.getString("user_pwd");
        user.tokens = myRs.getInt("tokens");
        user.online = myRs.getBoolean("online");
        user.joinDate = myRs.getDate("join_date").toString();

        return user;
    }

    private static java.sql.Date getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        java.sql.Date createDate = new java.sql.Date(calendar.getTime().getTime());
        return createDate;

    }

}
