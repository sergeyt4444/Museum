package Client;

import Items.Item;
import Items.NShortItems;
import Users.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Client {

    public static JFrame jFrame;
    public static void main(String[] args) {
        jFrame = new JFrame("Собрание экспонатов музея");
        jFrame.setSize(1280, 1024);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(new GUI());

        jFrame.setVisible(true);

    }


    public static void mainpage() {
        GUI.central_panel.removeAll();
        GUI.central_panel.add(GUI.header);
        GUI.central_panel.add(Box.createRigidArea(new Dimension(0, 100)));
        Search_panel.search_ta.setText("");
        GUI.central_panel.add(GUI.search_panel);
        GUI.central_panel.add(Box.createRigidArea(new Dimension(0, 270)));
        jFrame.repaint();
    }

    public static void login(String login, String password) {
        //send req
        //recieve user
        User s_user = new User("login", "password", "User");

        if (s_user == null) {
            GUI.login_panel.clear();
            jFrame.repaint();
        } else {
            GUI.login_panel.clear();
            GUI.user_panel.remove(GUI.login_panel);
            if (GUI.signed_in_panel == null) {
                GUI.signed_in_panel = new Signed_in_panel(s_user);
                GUI.signed_in_panel.setBounds(0, 0, 300, 200);
            } else {
                GUI.signed_in_panel.insert_user(s_user);
            }
            GUI.user_panel.add(GUI.signed_in_panel);
            jFrame.repaint();
        }
    }

    public static void logout() {
        GUI.user_panel.remove(GUI.signed_in_panel);
        GUI.user_panel.add(GUI.login_panel);
        jFrame.repaint();
    }

    public static void register() {
        GUI.central_panel.removeAll();
        if (GUI.register_panel == null) {
            GUI.register_panel = new Register_panel();
            GUI.register_panel.setBounds(0, 0, 600, 400);
        }
        GUI.central_panel.add(GUI.register_panel);
        jFrame.repaint();
    }

//    public static void search(String request, int search_type) {
//        GUI.central_panel.removeAll();
//        //send parameters and get results
//        ArrayList<Item> items = new ArrayList<Item>(10);
//        for (int i = 0; i < 10; i++) {
//            Item fi = new Item();
//            fi.setName("Name" + i);
//            fi.setType("Type" + i);
//            items.add(fi);
//        }
//        NShortItems nsi = new NShortItems(items, 0);
//        if (GUI.search_full_panel == null) {
//            GUI.search_full_panel = new Search_Full_panel(nsi, 10);
//        }
//        else {
//            GUI.search_full_panel.Init(nsi, 10);
//        }
//        JPanel jpanel = new JPanel();
//        jpanel.setLayout(null);
//        jpanel.setBounds(0,0, 600,600);
//        jpanel.setBackground(Color.DARK_GRAY);
//        GUI.search_full_panel.setBounds(0,0,600,600);
//        jpanel.add(GUI.search_full_panel);
//        GUI.central_panel.add(jpanel);
////        GUI.central_panel.add(GUI.search_full_panel);
//
//        jFrame.repaint();
//    }

    public static void search(String request, int search_type) {
        GUI.central_panel.removeAll();
        //send parameters and get results
        ArrayList<Item> items = new ArrayList<Item>(10);
        for (int i = 0; i < 10; i++) {
            Item fi = new Item();
            fi.setName("Name" + i);
            fi.setType("Type" + i);
            items.add(fi);
        }
        NShortItems nsi = new NShortItems(items, 0);
//        if (GUI.search_nav_panel == null) {
//            GUI.search_nav_panel = new Search_Nav_Panel();
//        }
        //GUI.search_nav_panel.setBounds(0, 550, 600, 50);
//        GUI.central_panel.add(GUI.search_nav_panel);
        jFrame.repaint();
    }

}
