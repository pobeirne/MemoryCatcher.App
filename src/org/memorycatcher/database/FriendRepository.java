/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.database;

import org.memorycatcher.interfaces.IFriendRepository;
import MemoryCatcherApp.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author pobeirne
 */
public class FriendRepository implements IFriendRepository {

    private final String CONFIG_PATH = "C:\\MemoryCatcherApp\\"
            + "src\\dbconfig.properties";
    private final Connection myConn;
    private Statement myStmt;
    private PreparedStatement myPrepStmt;
    private ResultSet myRs;

    private User user;
    private List<User> users;

    private User friend;
    private List<User> friendList;

    public FriendRepository() throws SQLException, Exception {
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
    public List<User> getAllFriends(int userId) throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from users where users.user_id in "
                    + "(select friends.user_b from friends where friends.user_a="
                    + userId + " and active = 1) "
                    + "union all "
                    + "select * from users where users.user_id in "
                    + "(select friends.user_a from friends where friends.user_b ="
                    + userId + " and active = 1)"
            );
            friendList = new ArrayList<>();
            while (myRs.next()) {
                friend = convertRowToUser(myRs);
                friendList.add(friend);
            }
            return friendList;

        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public boolean checkFriendsExist(int user_a, int user_b) throws SQLException {
        myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from friends "
                    + "where (user_a = " + user_a + " and user_b =" + user_b + ") "
                    + "or (user_a =" + user_b + " and user_b=" + user_a + ")"
            );
            return myRs.next();

        } finally {
            myStmt.close();
            myRs.close();
        }
    }

    @Override
    public boolean addFriend(int user_a, int user_b) throws SQLException {
        myPrepStmt = null;
        myRs = null;
        try {
            boolean checkFriendsExist = checkFriendsExist(user_a, user_b);
            if (checkFriendsExist == true) {
                return false;
            } else {
                myPrepStmt = myConn.prepareStatement("insert into friends("
                        + "user_a, "
                        + "user_b,"
                        + "create_date)"
                        + " values (?, ?, ?)"
                );

                myPrepStmt.setInt(1, user_a);
                myPrepStmt.setInt(2, user_b);
                myPrepStmt.setDate(3, getCurrentDate());

                return myPrepStmt.executeUpdate() == 1;
            }
        } finally {
            close(myConn, myPrepStmt, myRs);
        }
    }

    @Override
    public boolean updateFriend(int user_a, int user_b, boolean active) throws SQLException {
        myPrepStmt = null;
        myRs = null;
        try {
            boolean checkFriendsExist = checkFriendsExist(user_a, user_b);
            if (checkFriendsExist != true) {
                return false;
            } else {
                myPrepStmt = myConn.prepareStatement("update friends set active=? "
                        + "where (user_a = " + user_a + " and user_b =" + user_b + ") "
                        + "or (user_a =" + user_b + " and user_b=" + user_a + ")");

                myPrepStmt.setBoolean(1, active);

                return myPrepStmt.executeUpdate() == 1;
            }

        } finally {
            close(myConn, myPrepStmt, myRs);
        }
    }

    @Override
    public boolean removeFriend(int user_a, int user_b) throws SQLException {
        myPrepStmt = null;
        myRs = null;
        try {
            myPrepStmt = myConn.prepareStatement("delete from friends "
                    + "where (user_a = " + user_a + " and user_b =" + user_b + ") "
                    + "or (user_a =" + user_b + " and user_b=" + user_a + ")"
            );

            return myPrepStmt.executeUpdate() == 1;

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
