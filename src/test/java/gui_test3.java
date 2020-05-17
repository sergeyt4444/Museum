import Client.*;
import Users.User;

import javax.swing.*;
import java.awt.*;


public class gui_test3 extends JPanel {

    public static JFrame JFrame;
    public static Register_panel rpanel;

    public gui_test3() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 32);
        rpanel = new Register_panel();
        rpanel.setBounds(340, 150, 600, 400);
        add(rpanel);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new gui_test3());

        JFrame.setVisible(true);
    }
}

