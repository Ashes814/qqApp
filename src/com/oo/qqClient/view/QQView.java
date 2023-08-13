package com.oo.qqClient.view;

import com.oo.qqClient.service.UserClientService;
import com.oo.qqClient.utils.Utility;

/**
 * @author 欧欧
 * @version 1.0
 * 客户端的登录菜单
 */
public class QQView {
    private boolean loop = true; // control menus visibility
    private String key = ""; // accept user input
    private UserClientService userClientService = new UserClientService(); // for sign in and sign up

    public static void main(String[] args) {
        new QQView().mainMenu();
    }
    // show main menu
    private void mainMenu() {
        while (loop) {
            System.out.println("===========Welcome to Log OO===========");
            System.out.println("\t\t 1 Log in");
            System.out.println("\t\t 9 Exit");
            System.out.println("Please Input Your Choice");

            key = Utility.readString(1); // using Utility Tool to read users keyboard input
            switch (key) {
                case "1":
                    System.out.print("User ID: ");
                    String userId = Utility.readString(50);
                    System.out.print("Password: ");
                    String password = Utility.readString(50);
                    // Go to Server for validation
                    if (userClientService.checkUser(userId, password)) {
                        System.out.println("==========Welcome" + userId+"==========");
                        // level 2 menu
                        while (loop) {
                            System.out.println("\n====Net Communication System Menu Level 2 (User: " + userId +")====");
                            System.out.println("\t\t 1 Current user");
                            System.out.println("\t\t 2 Group Message");
                            System.out.println("\t\t 3 Private Message");
                            System.out.println("\t\t 4 File");
                            System.out.println("\t\t 9 Exit");
                            System.out.print("Your choice:");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    System.out.println("");
                                    break;
                                case "2":
                                    System.out.println("");
                                    break;
                                case "3":
                                    System.out.println("");
                                    break;
                                case "4":
                                    System.out.println("");
                                    break;

                                case "9":
                                    loop = false;
                                    break;
                            }

                        }

                    } else {
                        System.out.println("Logging failed");
                    }

                    break;
                case "9":
                    loop = false;
                    System.out.println("Exit>>>");
                    break;
            }

        }
    }
}
