package Client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Sign_in_panel extends JPanel {

    public JButton accept;
    public JLabel name_log_in_label;
    public JLabel password_label;
    public JTextField name_log_in_ta;
    public JPasswordField password_ta;
    public JButton reg;


    public void clear() {
        name_log_in_ta.setText("");
        password_ta.setText("");
    }

    public Sign_in_panel() {
        setBackground(new Color(20,150,250,255));
        setLayout(null);
        reg = new JButton("Регистрация");
        accept = new JButton("Войти");
        name_log_in_ta = new JTextField("");
        name_log_in_label = new JLabel("Логин");
        password_label = new JLabel("Пароль");
        password_ta = new JPasswordField("");
        Font font = new Font("Times New Roman",Font.PLAIN, 16);
        Font bold = new Font("Times New Roman", Font.BOLD, 16);
        name_log_in_label.setBounds(40, 37, 80, 24);
        password_label.setBounds(40, 90, 80, 24);
        name_log_in_ta.setBounds(125, 37, 100, 24);
        password_ta.setBounds(125, 90, 100, 24);
        accept.setBounds(160, 150, 120, 24);
        reg.setBounds(20, 150, 120, 24);
        name_log_in_label.setFont(bold);
        name_log_in_ta.setFont(font);
        password_ta.setFont(font);
        password_label.setFont(bold);
        accept.setFont(font);
        reg.setFont(font);
        accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client.login(name_log_in_ta.getText(), password_ta.getText());
            }
        });
        reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client.register();
            }
        });
        name_log_in_ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Client.login(name_log_in_ta.getText(), password_ta.getText());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        password_ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Client.login(name_log_in_ta.getText(), password_ta.getText());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        add(accept);
        add(reg);
        add(name_log_in_label);
        add(name_log_in_ta);
        add(password_label);
        add(password_ta);
    }



}
