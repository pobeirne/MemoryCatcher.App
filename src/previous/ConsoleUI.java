/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previous;

import MemoryCatcherApp.*;
import java.io.*;
import java.util.Scanner;
import org.memorycatcher.client.MemoryCatcherClient;

/**
 *
 * @author pobeirne
 */
public class ConsoleUI {

    public static void main(String[] args) throws IOException {

//        try {//
//
//            //
//            MemoryCatcherClient client = new MemoryCatcherClient(null);
//            //
//            Scanner input = new Scanner(System.in);
//
//            //
//            char homeMenu;
//            char userMenu;
//
//            //
//            String username;
//            String password;
//
//            //
//            User currUser;
//
//            
//            do {//Loop for home menu
//
//                System.out.println("Home Menu");
//                System.out.println("1 Login; 2 Register; 3 Quit; \n");
//
//                homeMenu = (char) (System.in.read());
//                input.nextLine();
//
//                switch (homeMenu) {
//                    case '1':
//
//                        System.out.println("Login:");
//                        System.out.println("Enter username: ");
//                        username = input.nextLine();
//
//                        System.out.println("Enter password: ");
//                        password = input.nextLine();
//
//                        if (client.getServant().userLogin(username, password)) {
//                            System.out.println("Login success !!!");
//                            currUser = client.getServant().getUserByName(username);
//                            homeMenu = '4';
//                        } else {
//                            System.out.println("Login failed !!!");
//                            homeMenu = '1';
//                        }
//                        break;
//                    case '2':
//                        System.out.println("Register:");
//                        System.out.println("Enter username: ");
//                        username = input.nextLine();
//
//                        System.out.println("Enter password: ");
//                        password = input.nextLine();
//                        if ("".equals(username) || "".equals(password)) {
//                            System.out.println("Invalid input !!!");
//                            homeMenu = '2';
//                        } else {
//                            if (client.getServant().userRegister(username, password)) {
//                                System.out.println("Register success !!!");
//                                homeMenu = '1';
//                            } else {
//                                System.out.println("Register failed!!!");
//                                homeMenu = '2';
//                            }
//                        }
//                        break;
//                    case '3':
//                        System.out.println("Exit 3...2...1");
//                        client.Close();
//                        System.exit(0);
//                }
//
//            } while (homeMenu != (char) '4');
//
//            do {//Loop for user menu 
//
//                System.out.println("User Menu");
//                System.out.println("1 View Profile; 2 Memory Menu; 3 Token Menu; 4 Log-out;");
//                userMenu = (char) (System.in.read());
//                input.nextLine();
//
//                switch (userMenu) {
//                    case '1':
//                        break;
//                    case '2':
//                        break;
//                    case '3':
//                        break;
//                }
//            } while (userMenu != (char) '4');
//
//            
//            System.out.println("Exit 3...2...1");
//            client.Close();
//            System.exit(0);
//            
//        } catch (Exception e) {
//            System.out.println("ERROR : " + e);
//            e.printStackTrace(System.out);
//        }


        
        
        
        
        
        
//
//        try {
//
//            //Open a new client            
//           
//            
//            
//            
//         
//            
//            
//            
//            
//            
//            
            
//            input = new Scanner(System.in);
//
//            do {
//
//                System.out.println("Index Menu choice");
//                System.out.println("1 Login;"+" 2 Register; 3 Quit; \n");
//
//                indexMenu = (char) (System.in.read());
//                input.nextLine();
//
//                if (indexMenu == (char) '1') {
//
//                    System.out.println("Login:");
//                    System.out.println("Enter username: ");
//                    username = input.nextLine();
//
//                    System.out.println("Enter password: ");
//                    password = input.nextLine();
//
//                    if (client.getServant().userLogin(username, password)) {
//                        System.out.println("Login success !!!");
//                        currUser = client.getServant().getUserByName(username);
//                        indexMenu = '4';
//                    } else {
//                        System.out.println("Login failed !!!");
//                        indexMenu = '1';
//                    }
//
//                } else if (indexMenu == (char) '2') {
//
//                    System.out.println("Register:");
//                    System.out.println("Enter username: ");
//                    username = input.nextLine();
//
//                    System.out.println("Enter password: ");
//                    password = input.nextLine();
//
//                    if (client.getServant().userRegister(username, password)) {
//                        System.out.println("Register success !!!");
//                        indexMenu = '1';
//                    } else {
//                        System.out.println("Register failed!!!");
//                        indexMenu = '2';
//                    }
//                } else if (indexMenu == (char) '3') {
//                    System.out.println("Exit 3...2...1");
//                    client.Close();
//                    System.exit(0);
//                }
//
//            } while (indexMenu != (char) '4');
//
//            //Home menu
//            do {
//                //Validat user
//                //Welcome user
//
//                System.out.println("\nHome Menu choice");
//                System.out.println("1 User Menu; 2 Share Menu; 3 Token Menu; 4 Quit;");
//                homeMenu = (char) (System.in.read());
//                input.nextLine();
//
//                if (homeMenu == (char) '1') {
//
//                    do {
//                        
//                        System.out.println("\nUser Menu");
//                        System.out.println("1 User Profile; 2 MemoryList; 3 FriendList; 4 Back To Main;");
//                        userMenu = (char) (System.in.read());
//                        input.nextLine();
//
//                        if (userMenu == (char) '1') {
//
//                            System.out.println("\n" + "User Profile");
//                            System.out.println(
//                                      "UserId    : " + currUser.id + "\n"
//                                    + "UserName  : " + currUser.name + "\n"
//                                    + "Online    : " + currUser.isOnline + "\n"
//                                    + "Tokens    : " + currUser.tokens + "\n"
//                                    + "Join Date : " + currUser.joinDate + "\n"
//                            );
//
//                        } else if (userMenu == (char) '2') {
//
//                        } else if (userMenu == (char) '3') {
//
//                        }
//                    } while (userMenu != (char) '4');
//
//                    homeMenu = '1';
//
//                } else if (homeMenu == (char) '2') {
//
//                } else if (homeMenu == (char) '3') {
//
//                } else if (homeMenu == (char) '4') {
//                    System.out.println("Exit 3...2...1");
//                    client.Close();
//                    System.exit(0);
//                }
//            } while (homeMenu != (char) '6');
//
//            //Log current user out
//            System.out.println("User logout");
//            boolean logout = client.getServant().userLogout(currUser);
//            System.out.println(logout);
//
//            System.out.println("Exit 3...2...1");
//            client.Close();
//            System.exit(0);
//
//       
        
        
        
        
        
    }
}



//Login
//Register

//View Profile
//View FriendList
//View memories
//View memory tokens

//Add memory
//Remove memory




//Buy memory tokens
//Transfer memory tokens



