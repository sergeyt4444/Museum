package Client;


import javax.swing.*;
import java.awt.*;

public class Sign_in_panel extends JPanel {

    public static JButton accept;
    public static JLabel name_log_in_label;
    public static JLabel password_label;
    public static JTextField name_log_in_ta;
    public static JTextField password_ta;
    public static JButton reg;

    public Sign_in_panel() {
        setBackground(new Color(20,150,250,255));
        setLayout(null);
        reg = new JButton("Register");
        accept = new JButton("Log in");
        name_log_in_ta = new JTextField("");
        name_log_in_label = new JLabel("name_log_label");
        password_label = new JLabel("password_label");
        password_ta = new JTextField("");
        Font font = new Font("Times New Roman",Font.PLAIN, 16);
        Font bold = new Font("Times New Roman", Font.BOLD, 16);
        name_log_in_label.setBounds(40, 37, 80, 24);
        name_log_in_label.setText("Login");
        password_label.setBounds(40, 90, 80, 24);
        password_label.setText("Password");
        name_log_in_ta.setBounds(125, 37, 100, 24);
        password_ta.setBounds(125, 90, 100, 24);
        accept.setBounds(160, 150, 100, 24);
        accept.setText("Log in");
        reg.setBounds(40, 150, 100, 24);
        name_log_in_label.setFont(bold);
        name_log_in_ta.setFont(font);
        password_ta.setFont(font);
        password_label.setFont(bold);
        accept.setFont(font);
        reg.setFont(font);
        add(accept);
        add(reg);
        add(name_log_in_label);
        add(name_log_in_ta);
        add(password_label);
        add(password_ta);
    }



}
