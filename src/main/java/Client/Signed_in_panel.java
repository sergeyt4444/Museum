package Client;

import Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signed_in_panel extends JPanel {

    public JLabel login_label;
    public JLabel status_label;
    public JButton quit;
    public User user;

    public Signed_in_panel() {
        setBackground(new Color(20,150,250,255));
        setLayout(null);
        Font bold = new Font("Times New Roman", Font.BOLD, 16);
        Font font = new Font("Times New Roman", Font.PLAIN, 22);
        login_label = new JLabel("");
        status_label = new JLabel("");
        login_label.setBounds(100, 28, 150, 28);
        status_label.setBounds(100, 86, 150, 28);
        login_label.setFont(font);
        status_label.setFont(font);
        add(login_label);
        add(status_label);
        quit = new JButton("Выйти из аккаунта");
        quit.setBounds(100, 144, 100, 28);
        quit.setFont(bold);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client.logout();
            }
        });
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
        quit = new JButton("Выйти из аккаунта");
        quit.setBounds(50, 144, 200, 28);
        quit.setFont(bold);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client.logout();
            }
        });
        add(quit);

    }

    public void insert_user(User us) {
        if (us != null) {
            user = us;
            login_label.setText(user.getLogin());
            status_label.setText(user.getStatus());
        }
    }
}

