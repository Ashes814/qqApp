package com.oo.qqClient.view;

import com.oo.qqClient.utils.Utility;

/**
 * @author 欧欧
 * @version 1.0
 * 客户端的登录菜单
 */
public class QQView {
    private boolean loop = true; // control menus visibility
    private String key = ""; // accept user input
    // show main menu
    private void mainMenu() {
        while (loop) {
            System.out.println("===========Welcome to Log OO===========");
            System.out.println("\t\t 1 Log in");
            System.out.println("\t\t 9 Exit");

            key = Utility.readString(1); // using Utility Tool to read users keyboard input
            switch (key) {
                case "1":
                    System.out.println("Log in>>>");
                case "9":
                    loop = false;
                    System.out.println("Exit>>>");
                    break;
            }

        }
    }
}
