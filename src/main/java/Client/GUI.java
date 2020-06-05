package Client;

import Users.User;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    public static JFrame JFrame;
    public static JPanel user_panel;
    public static Sign_in_panel login_panel;
    public static Signed_in_panel signed_in_panel;
    public static Register_panel register_panel;
    public static JPanel central_panel;
    public static JLabel header;
    public static Search_panel search_panel;
    public static Search_Full_panel search_full_panel;
    public static Search_page search_page;
    public static Search_Nav_Panel search_nav_panel;
    public static Nav_panel nav_panel;
//    public static Moderator_panel moderator_panel;
    public static Admin_panel admin_panel;


    public GUI() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 48);

        user_panel = new JPanel();
        user_panel.setBounds(960, 0, 300, 200);
        user_panel.setLayout(new BoxLayout(user_panel, BoxLayout.PAGE_AXIS));
        login_panel = new Sign_in_panel();
        nav_panel = new Nav_panel();
        nav_panel.setBounds(20, 40, 200, 400);
        header = new JLabel("Музей А. М. Горького", JLabel.CENTER);
//        header.setBounds(240, 250, 800, 200);
        header.setForeground(Color.white);
        header.setFont(font);
        header.setAlignmentX(CENTER_ALIGNMENT);
        search_panel = new Search_panel();
        search_panel.setAlignmentX(CENTER_ALIGNMENT);
//        search_panel.setBounds(340, 450, 600, 200);
        central_panel = new JPanel();
        central_panel.setLayout(new BoxLayout(central_panel, BoxLayout.PAGE_AXIS));
        central_panel.setBounds(340, 250, 600, 600);
        central_panel.setBackground(Color.DARK_GRAY);
        central_panel.add(header);
        central_panel.add(Box.createRigidArea(new Dimension(0, 100)));
        central_panel.add(search_panel);
        central_panel.add(Box.createRigidArea(new Dimension(0, 270)));

        user_panel.add(login_panel);
//        moderator_panel = new Moderator_panel();
//        moderator_panel.setBounds(960, 300, 300, 200);
//        admin_panel = new Admin_panel();
//        admin_panel.setBounds(960,300,300,300);
        add(user_panel);
        add(nav_panel);
        add(central_panel);
//        add(moderator_panel);
//        add(admin_panel);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new GUI());

        JFrame.setVisible(true);
    }

//    public static void login(String login, String password) {
//        //send req
//        //recieve user
//        User s_user = new User("login", "password", "User");
//
//        if (s_user == null) {
//            login_panel.clear();
//            JFrame.repaint();
//        }
//        else {
//            user_panel.remove(login_panel);
//            if (signed_in_panel == null) {
//                signed_in_panel = new Signed_in_panel(s_user);
//                signed_in_panel.setBounds(0, 0, 300, 200);
//            }
//            else {
//                signed_in_panel.insert_user(s_user);
//            }
//            user_panel.add(signed_in_panel);
//            JFrame.repaint();
//        }
//    }
//
//    public static void logout() {
//        user_panel.remove(signed_in_panel);
//        user_panel.add(login_panel);
//        JFrame.repaint();
//    }
}
