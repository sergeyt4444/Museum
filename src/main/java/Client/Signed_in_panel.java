package Client;

import Users.User;

import javax.swing.*;
import java.awt.*;

public class Signed_in_panel extends JPanel {

    public static JLabel login_label;
    public static JLabel status_label;
    public static JButton quit;
    public static User user;

    public Signed_in_panel() {
        setBackground(new Color(20,150,250,255));
        setLayout(null);
        Font bold = new Font("Times New Roman", Font.BOLD, 16);
        quit = new JButton("Sign out");
        quit.setBounds(100, 144, 100, 28);
        quit.setFont(bold);
        add(quit);
    }

    public Signed_in_panel(User us) {
        setBackground(new Color(20,150,250,255));
        setLayout(null);
        Font bold = new Font("Times New Roman", Font.BOLD, 16);
        Font font = new Font("Times New Roman", Font.PLAIN, 22);
        if (us != null) {
            user = us;
            login_label = new JLabel(user.getLogin());
            status_label = new JLabel(user.getStatus());
            login_label.setBounds(100, 28, 150, 28);
            status_label.setBounds(100, 86, 150, 28);
            login_label.setFont(font);
            status_label.setFont(font);
            add(login_label);
            add(status_label);
        }
        quit = new JButton("Sign out");
        quit.setBounds(100, 144, 100, 28);
        quit.setFont(bold);
        add(quit);

    }
}
