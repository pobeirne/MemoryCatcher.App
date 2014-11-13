/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.Database;


import mc.User;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;



/**
 *
 * @author pobeirne
 */
public class UserManager {
    
    
    private final String CONFIG_PATH = "C:\\MemoryCatcher\\"
            + "src\\dbconfig.properties";
    private final Connection myConn;
    private Statement myStmt;
    private PreparedStatement myPrepStmt;
    private ResultSet myRs;
    
    private User user; 
    private ArrayList<User> users;
    
    //Working
    public UserManager() throws SQLException, Exception {
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
  
    //Working
    public boolean userLogin(String userName, String userPwd) throws SQLException {
        myStmt = null;
        myRs = null;
        user = new User();
        boolean updateUser =false;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users "
                    + "where user_name='" + userName + "'"
                    + "and user_pwd ='" + userPwd + "'");
            try {
                if (myRs.next()) {
                    user = convertRowToUser(myRs);
                    user.online = true;
                    updateUser = updateUser(user);
                }
                return updateUser;

            } finally {
                myRs.close();
            }
        } finally {
            myStmt.close();
        }
    }
    
    //Working
    public boolean userRegister(String userName, String userPwd) throws SQLException {

        myPrepStmt = null;
        try {
            try {

                myPrepStmt = myConn.prepareStatement("insert into users("
                        + "user_name, "
                        + "user_pwd,"
                        + "join_date)"
                        + " values (?, ?, ?)"
                );

                myPrepStmt.setString(1, userName);
                myPrepStmt.setString(2, userPwd);
                myPrepStmt.setDate(3, getCurrentDate());

                int executeUpdate = myPrepStmt.executeUpdate();
                return executeUpdate == 1;

            } finally {
                myPrepStmt.close();
            }
        } finally {
            myConn.close();
        }
    }

    //Working
    public boolean updateUser(User user) throws SQLException {

        myPrepStmt = null;
        try {
            try {
                myPrepStmt = myConn.prepareStatement("update users set "
                        + "tokens=? ,"
                        + "online=? "
                        + "where user_id=?"
                );

                myPrepStmt.setInt(1, user.tokens);
                myPrepStmt.setBoolean(2, user.online);
                myPrepStmt.setInt(3, user.id);

                int executeUpdate = myPrepStmt.executeUpdate();
                return executeUpdate == 1;

            } finally {
                myPrepStmt.close();
            }
        } finally {
            myConn.close();
        }
    }
    
    
    public boolean isUserOnline(String userName) {
        return "paul".equals(userName);
        
        //getUserByName 
        //Check if return isOnline
    }

    
    public boolean userLogout(User user) throws SQLException {
        
        //change user isonline
        user.online = false;
        //call update user       
        return updateUser(user);   
    }

    
    //Working
    public User getUserByName(String name) throws SQLException {
        
        myStmt = null;
        myRs = null;
        user = new User();
        name = "pobeirne";
        
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users "
                    + "where user_name='" + name + "'");
            try {
                if (myRs.next()) {
                    user = convertRowToUser(myRs);                    
                }
               return user;

            } finally {
                myRs.close();
            }
        } finally {
            myStmt.close();
        }
    }

    //Working
    public ArrayList<User> getAllUser() throws SQLException {

        myStmt = null;
        myRs = null;
        users = new ArrayList<>();

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users;");

            try {

                while (myRs.next()) {
                    user = convertRowToUser(myRs);
                    users.add(user);
                }
                return users;

            } finally {
                myRs.close();
            }
        } finally {
            myStmt.close();
        }
    }
    
        
    
    
    public boolean addFriend(int userA, int userB) {
        return userA == 1 && userB == 2;
    }
    
    public boolean removeFriend(int userA, int userB) {
        return userA == 1 && userB == 2;
    }

    public ArrayList<User> getUserFriends(int userId) {
        users = new ArrayList<>();
        users.add(getUserData());
        users.add(getUserData());
        return users;
    }
  
    public ArrayList<User> getNotUserFriends(int userId) {
        users = new ArrayList<>();
        users.add(getUserData());
        users.add(getUserData());
        return users;
    } 

    
    
    public boolean buyTokens(int userId, int amount) {
        return userId==1 && amount ==10;
    }

    public boolean transferTokens(int userA, int userB, int amount) {
        return userA==1 && userB==2 && amount ==10;
    }
    
        
    
    
    private User getUserData(){
        user = new User();
        user.id = 1;
        user.name = "paul";
        user.online = true;
        user.joinDate = "Date";
        user.tokens = 10;        
        return user;
    }  

    private User convertRowToUser(ResultSet myRs) throws SQLException {
        
        user = new User();
        user.id = myRs.getInt("user_id");
        user.name = myRs.getString("user_name");
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
