/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.servant;

import org.memorycatcher.database.MemoryRepository;
import org.memorycatcher.database.UserRepository;
import org.memorycatcher.database.FriendRepository;
import MemoryCatcherApp.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.memorycatcher.database.ResourceRepository;

/**
 *
 * @author pobeirne
 */
public class MemoryCatcherServant extends _MemoryCatcherImplBase {

    //Users
    private UserRepository uRep;
    private User user;
    private User[] userArr;
    private List<User> userList;

    //Friends
    private FriendRepository fRep;
    private User friend;
    private User[] friendArr;
    private List<User> friendList;

    //Memory
    private MemoryRepository mRep;
    private Memory memory;
    private Memory[] memoryArr;
    private List<Memory> memoryList;

    //Resources
    private ResourceRepository rRep;
    private Resource resource;
    private Resource[] resourceArr;
    private List<Resource> resourceList;

    
    
    
    //Users
    @Override
    public User[] getAllUsers() {
        try {
            uRep = new UserRepository();
            userList = uRep.getAllUsers();
            userArr = new User[userList.size()];
            for (int i = 0; i < userList.size(); i++) {
                userArr[i] = userList.get(i);
            }
            return userArr;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return userArr;
        }
    }

    @Override
    public User getUserByName(String name) {
        try {
            uRep = new UserRepository();
            user = uRep.getUserByName(name);
            return user;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return user;
        }
    }

    @Override
    public User getUserById(int userId) {
        try {
            uRep = new UserRepository();
            user = uRep.getUserById(userId);
            return user;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return user;
        }
    }

    @Override
    public boolean addUser(String name, String pass) {
        try {
            uRep = new UserRepository();
            return uRep.addUser(name, pass);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            uRep = new UserRepository();
            return uRep.updateUser(user);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removeUser(int userId) {
        try {
            uRep = new UserRepository();
            return uRep.removeUser(userId);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    
    
    //Friends
    @Override
    public User[] getAllFriends(int userId) {
        try {
            fRep = new FriendRepository();
            friendList = fRep.getAllFriends(userId);
            friendArr = new User[friendList.size()];
            for (int i = 0; i < friendList.size(); i++) {
                friendArr[i] = friendList.get(i);
            }
            return friendArr;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return friendArr;
        }
    }

    @Override
    public boolean addFriend(int user_a, int user_b) {
        try {
            fRep = new FriendRepository();
            return fRep.addFriend(user_a, user_b);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateFriend(int user_a, int user_b, boolean active) {
        try {
            fRep = new FriendRepository();
            return fRep.updateFriend(user_a, user_b, active);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removeFriend(int user_a, int user_b) {
        try {
            fRep = new FriendRepository();
            return fRep.removeFriend(user_a, user_b);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    
    
    //Memories    
    @Override
    public Memory[] getAllMemories() {
        try {
            mRep = new MemoryRepository();
            memoryList = mRep.getAllMemories();
            memoryArr = new Memory[memoryList.size()];
            for (int i = 0; i < memoryList.size(); i++) {
                memoryArr[i] = memoryList.get(i);
            }
            return memoryArr;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return memoryArr;
        }
    }

    @Override
    public Memory[] getAllUserMemories(int userId) {
        try {
            mRep = new MemoryRepository();
            memoryList = mRep.getAllUserMemories(userId);
            memoryArr = new Memory[memoryList.size()];
            for (int i = 0; i < memoryList.size(); i++) {
                memoryArr[i] = memoryList.get(i);
            }
            return memoryArr;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return memoryArr;
        }
    }

    @Override
    public boolean addMemory(int ownerId, String title, String desc) {
        try {
            mRep = new MemoryRepository();
            return mRep.addMemory(ownerId, title, desc);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateMemory(Memory memory) {
        try {
            mRep = new MemoryRepository();
            return mRep.updateMemory(memory);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removeMemory(int memoryId) {
        try {
            mRep = new MemoryRepository();
            return mRep.removeMemory(memoryId);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    
    
    //Resources
    @Override
    public Resource[] getAllResources(int memoryId) {
        try {
            rRep = new ResourceRepository();
            resourceList = rRep.getAllResourcesById(memoryId);
            resourceArr = new Resource[resourceList.size()];
            for (int i = 0; i < resourceList.size(); i++) {
                resourceArr[i] = resourceList.get(i);
            }
            return resourceArr;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return resourceArr;
        }
    }

    @Override
    public boolean addResource(int memoryId, int ownerId, String type, String location) {
        try {
            rRep = new ResourceRepository();
            return rRep.addResource(memoryId, ownerId, type, location);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateResource(Resource res) {
        try {
            rRep = new ResourceRepository();
            return rRep.updateResource(res);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removeResource(int resId) {
        try {
            rRep = new ResourceRepository();
            return rRep.removeResource(resId);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    //Private
    private boolean userLogIn(String name, String pwd) {
        if (!"".equals(pwd) || !"".equals(name)) {
            User currUser = getUserByName(name);
            if (pwd == null ? currUser.pwd == null : pwd.equals(currUser.pwd)) {
                currUser.online = true;
                boolean updateUser = updateUser(currUser);
                return updateUser;
            }
        }
        return false;
    }
    
    private boolean userLogOut(User currUser) {
        if (currUser.name != null) {            
            boolean updateUser = updateUser(currUser);
            return updateUser;
        }
        return false;
    }

    private boolean userRegister(String name, String pwd) {
        if (!"".equals(pwd) || !"".equals(name)) {
            User currUser = getUserByName(name);
            if (currUser.name == null) {
                return addUser(name, pwd);
            }
        }
        return false;
    }


    
    
    public static void main(String[] args) throws IOException, SQLException {

        MemoryCatcherServant ser = new MemoryCatcherServant();
        
        String userName = "pobeirne";
        String pwd = "hdfx85j9";
        
        User currUser = null;
        boolean userLoggedIn;
        boolean updateUser;
        boolean userRegister;
        
        
        // #Step 1 user login       
        userLoggedIn = ser.userLogIn(userName, pwd);
        if (userLoggedIn) {
            System.out.println("user login success");
            currUser = ser.getUserByName(userName);
        } else {
            System.out.println("user login fail");
        }

        // #Step 2 user logout
        if (currUser.online) {
            currUser.online = false;
            updateUser = ser.userLogOut(currUser);
            if (updateUser) {
                System.out.println("user logged out ");
            } else {
                System.out.println("user logout fail ");
            }
        }

        // #Step 3 User Register
        userRegister = ser.userRegister("pobeiruhyunfe", "hdiuir");
        if (userRegister) {
            System.out.println("user registered success");
        } else {
            System.out.println("user registered fail");
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Show all users
        //Show all friends
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                
//        
//        //getAllUsers()
//        User[] users = ser.getAllUsers();
//        System.out.println("get all users count : " +users.length);
//        
//        //getUserByName(String name)
//        ser = new MemoryCatcherServant();
//        User userByName = ser.getUserByName("pobeirne");
//        System.out.println("get user by name : " +userByName.name);
//        
//        //getUserById(int userId)
//        ser = new MemoryCatcherServant();
//        User userById = ser.getUserById(1);
//        System.out.println("get username by id : " +userById.name);
//        
//        //addUser(String name, String pass)
//        //ser = new MemoryCatcherServant();      
//        //boolean addUser = ser.addUser("test","pass");
//        //System.out.println("add new user t/f : " +addUser);
//        
//        //updateUser(User user)
//        ser = new MemoryCatcherServant();       
//        userByName.tokens = 50;
//        boolean updateUser = ser.updateUser(userByName);
//        System.out.println("update user t/f : " +updateUser);        
//        //removeUser(int userId)
//        int user_a = 1;
//        int user_b = 4;
//
//        //addFriend(int user_a, int user_b)
//        ser = new MemoryCatcherServant();
//        boolean addFriend = ser.addFriend(user_b, user_a);
//        System.out.println("add friendship t/f : " +addFriend);     
//
//        //updateFriend(int user_a, int user_b, boolean active)
//        ser = new MemoryCatcherServant();
//        boolean updateFriend = ser.updateFriend(user_a, user_b, true);
//        System.out.println("update friendship t/f : " +updateFriend);     
//
//        //getAllFriends(int userId)
//        ser = new MemoryCatcherServant();
//        User[] allFriends = ser.getAllFriends(user_a);
//        System.out.println("friend count : " +allFriends.length);
//
//        //removeFriend(int user_a, int user_b) 
//        ser = new MemoryCatcherServant();
//        boolean removeFriend = ser.removeFriend(user_a, user_b);
//        System.out.println("remove friend : " +removeFriend); 
//        Memory[] allMemories = ser.getAllMemories();
//        System.out.println("all memories : " + allMemories.length);
//
//        Memory[] allUserMemories = ser.getAllUserMemories(1);
//        System.out.println("all user memories : " + allUserMemories.length);
//
//        Resource[] allResources = ser.getAllResources(1);
//        System.out.println("all memory resources : " + allResources.length);

    }

   
   
}
