/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.server;


import previous.MemoryManager;
import previous.UserManager;
import MemoryCatcherApp.*;
import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;


/**
 *
 * @author pobeirne
 */
public class MemoryCatcherServant  {
    
    private List<User> users;
    private List<User> friends;
    private List<Memory> memories;
    
    private User user;
    private User friend;
    private Memory memory;
    
    private UserManager um; 
    private MemoryManager mm;   
      
    
    
    public String sayHello(){
        return "hello";
    }
    
    

    public boolean userLogin(String userName, String userPwd) {
        try {
            um = new UserManager();                
            return um.userLogin(userName,userPwd);           
            
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

   
    public boolean userRegister(String userName, String userPwd) {
        try {
            um = new UserManager();
            return um.userRegister(userName, userPwd);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return false;
    }


    public boolean userOnlineStatus(String userName) {
        try {
            um = new UserManager();
            return um.isUserOnline(userName);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

   
    public boolean userLogout(User currUser) {
        try {
            um = new UserManager();
            return um.userLogout(currUser);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public User getUserByName(String name) {
        try {
            um = new UserManager();
            return um.getUserByName(name);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return user;
    }
 
    public User[] getAllUsers() {
        try {
            um = new UserManager();
            users = um.getAllUser();
            User[] res = new User[users.size()];
            for (int i = 0; i < users.size(); i++) {
                res[i] = users.get(i);
            }
            return res;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("WTF");
        }
        return null;

    }


    public boolean addFriend(int userA, int userB) {
        try {
            um = new UserManager();
            return um.addFriend(userA, userB);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

   
    public boolean removeFriend(int userA, int userB) {
        try {
            um = new UserManager();
            return um.removeFriend(userA, userB);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public User[] getUserFriends(int userId) {
        try {
            um = new UserManager();
            friends = um.getUserFriends(userId);
            User[] res = new User[friends.size()];
            for (int i = 0; i < friends.size(); i++) {
                res[i] = friends.get(i);
            }
            return res;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public User[] getUserNotFriends(int userId) {
        try {
            um = new UserManager();
            friends = um.getNotUserFriends(userId);
            User[] res = new User[friends.size()];
            for (int i = 0; i < friends.size(); i++) {
                res[i] = friends.get(i);
            }
            return res;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
        
    

    public boolean buyTokens(int userId, int amount) {
         try {
            um = new UserManager();
            return um.buyTokens(userId,amount);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

  
    public boolean transferTokens(int userA, int userB, int amount) {
        try {
            um = new UserManager();
            return um.transferTokens(userA, userB,amount);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }   
    

 
    public boolean addMemory(String title) {
         try {
            mm = new MemoryManager();
            Memory mem = new Memory();
            return mm.addMemory(mem);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

 
    public boolean editMemory(Memory mem) {
        try {
            mm = new MemoryManager();
            return mm.updateMemory(mem);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    public boolean removeMemory(int memId) {

        try {
            mm = new MemoryManager();
            return mm.removeMemory(memId);

        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public Memory getMemory(int memId) {
        try {
            mm = new MemoryManager();
            return mm.getMemory(memId);
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName())
                    .log(Level.SEVERE, null, ex);
        }        
        return memory;
    }

 
    public Memory[] getUserMemories(int userId) {
        try {
            mm = new MemoryManager();
            memories = mm.getAllMemories(userId);
            Memory[] res = new Memory[memories.size()];
            for (int i = 0; i < memories.size(); i++) {
                res[i] = memories.get(i);
            }
            return res;
        } catch (Exception ex) {
            Logger.getLogger(MemoryCatcherServant.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("WTF");
        }
        return null;
    }  
   
}
