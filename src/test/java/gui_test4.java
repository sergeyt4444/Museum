import Client.Register_panel;
import Client.Sign_in_panel;
import Client.Signed_in_panel;
import Users.User;

import javax.swing.*;
import java.awt.*;



public class gui_test4 extends JPanel {

    public static JFrame JFrame;
    public static Signed_in_panel sinpanel;

    public gui_test4() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 32);

        sinpanel = new Signed_in_panel(new User("Login", "Password", "User"));
        sinpanel.setBounds(980, 0, 300, 200);
        add(sinpanel);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new gui_test4());

        JFrame.setVisible(true);
    }
}

