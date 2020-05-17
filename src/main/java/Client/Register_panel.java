package Client;

import javax.swing.*;
import java.awt.*;

public class Register_panel extends JPanel {

    public static JLabel login_label;
    public static JLabel pass1_label;
    public static JLabel pass2_label;
    public static JTextField login_ta;
    public static JTextField pass1_ta;
    public static JTextField pass2_ta;
    public static JButton submit;
    public static JLabel header;

    public Register_panel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font head = new Font("Times New Roman", Font.PLAIN, 32);
        Font font = new Font("Times New Roman", Font.PLAIN, 24);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));

        login_label = new JLabel("Login:");
        pass1_label = new JLabel("Password:");
        pass2_label = new JLabel("Repeat password:");
        submit = new JButton("Submit");
        login_ta = new JTextField();
        pass1_ta = new JTextField();
        pass2_ta = new JTextField();
        header = new JLabel("Registration");
        header.setBounds(250, 25,100, 75);
        login_label.setFont(font);
        pass1_label.setFont(font);
        pass2_label.setFont(font);
        login_ta.setFont(font);
        pass1_ta.setFont(font);
        pass2_ta.setFont(font);
        submit.setFont(head);
        header.setFont(head);
        header.setForeground(Color.white);
        submit.setBackground(Color.DARK_GRAY);
        submit.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        submit.setForeground(Color.white);
        pass1_label.setForeground(Color.white);
        login_label.setForeground(Color.white);
        pass2_label.setForeground(Color.white);
        login_ta.setForeground(Color.white);
        pass1_ta.setForeground(Color.white);
        pass2_ta.setForeground(Color.white);
        header.setBounds(200, 25,400, 75);
        login_label.setBounds(100, 125, 200, 40);
        pass1_label.setBounds(100, 190, 200, 40);
        pass2_label.setBounds(100, 255, 200, 40);
        login_ta.setBounds(300, 125, 200, 40);
        pass1_ta.setBounds(300, 190, 200, 40);
        pass2_ta.setBounds(300, 255, 200, 40);
        submit.setBounds(200,325, 200,50);
        add(header);
        add(login_label);
        add(pass1_label);
        add(pass2_label);
        add(login_ta);
        add(pass1_ta);
        add(pass2_ta);
        add(submit);


    }

}
