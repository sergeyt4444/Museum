package Client;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    public static JFrame JFrame;
    public static Sign_in_panel login_panel;
    public static JLabel header;
    public static Search_panel search_panel;

    public GUI() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 48);

        login_panel = new Sign_in_panel();
        login_panel.setBounds(980, 0, 300, 200);
        header = new JLabel("Музей А. М. Горького", JLabel.CENTER);
        header.setBounds(240, 250, 800, 200);
        header.setForeground(Color.white);
        header.setFont(font);
        search_panel = new Search_panel();
        search_panel.setBounds(340, 450, 600, 200);

        add(login_panel);
        add(header);
        add(search_panel);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new GUI());

        JFrame.setVisible(true);
    }
}
