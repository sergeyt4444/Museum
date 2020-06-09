package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Register_panel extends JPanel {

    public static JLabel login_label;
    public static JLabel pass1_label;
    public static JLabel pass2_label;
    public static JTextField login_ta;
    public static JPasswordField pass1_ta;
    public static JPasswordField pass2_ta;
    public static JButton submit;
    public static JLabel header;

    public void clear() {
        if(login_ta != null)
            login_ta.setText("");
        if(pass1_ta!= null)
            pass1_ta.setText("");
        if (pass2_ta != null)
            pass2_ta.setText("");
    }

    public Register_panel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font head = new Font("Times New Roman", Font.PLAIN, 32);
        Font font = new Font("Times New Roman", Font.PLAIN, 24);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));

        login_label = new JLabel("Логин:");
        pass1_label = new JLabel("Пароль:");
        pass2_label = new JLabel("Повторите пароль:");
        submit = new JButton("Submit");
        login_ta = new JTextField();
        pass1_ta = new JPasswordField();
        pass2_ta = new JPasswordField();
        header = new JLabel("Регистрация");
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
        login_ta.setDocument(new JTextLengthLimit(25));
        pass1_ta.setDocument(new JTextLengthLimit(25));
        pass2_ta.setDocument(new JTextLengthLimit(25));

        login_ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String login, pass1, pass2;
                    login = login_ta.getText();
                    pass1 = pass1_ta.getText();
                    pass2 = pass2_ta.getText();
                    if (login.length() < 5 || pass1.length() <5 || pass2.length() <5) {
                        JOptionPane.showMessageDialog(null, "Пароль и логин должны выключать в себя не менее 5 символов");
                    }
                    if (!(pass1.equals(pass2))) {
                        JOptionPane.showMessageDialog(null, "Проверьте написание пароля");
                    }
                    //send and check
                    int check = Client.create_user(login, pass1);
                    if (check == 1) {
                        Client.login(login, "User");
                        Client.mainpage();
                    }
                    else {
                        login_ta.setText("");
                        pass1_ta.setText("");
                        pass2_ta.setText("");
                        JOptionPane.showMessageDialog(null, "Пользователь с таким логином уже существует");
                    }

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        pass1_ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String login, pass1, pass2;
                    login = login_ta.getText();
                    pass1 = pass1_ta.getText();
                    pass2 = pass2_ta.getText();
                    if (login.length() < 5 || pass1.length() <5 || pass2.length() <5) {
                        JOptionPane.showMessageDialog(null, "Пароль и логин должны выключать в себя не менее 5 символов");
                    }
                    if (!(pass1.equals(pass2))) {
                        JOptionPane.showMessageDialog(null, "Проверьте написание пароля");
                    }
                    //send and check
                    int check = Client.create_user(login, pass1);
                    if (check == 1) {
                        Client.login(login, "User");
                        Client.mainpage();
                    }
                    else {
                        login_ta.setText("");
                        pass1_ta.setText("");
                        pass2_ta.setText("");
                        JOptionPane.showMessageDialog(null, "Пользователь с таким логином уже существует");
                    }

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        pass2_ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String login, pass1, pass2;
                    login = login_ta.getText();
                    pass1 = pass1_ta.getText();
                    pass2 = pass2_ta.getText();
                    if (login.length() < 5 || pass1.length() <5 || pass2.length() <5) {
                        JOptionPane.showMessageDialog(null, "Пароль и логин должны выключать в себя не менее 5 символов");
                    }
                    if (!(pass1.equals(pass2))) {
                        JOptionPane.showMessageDialog(null, "Проверьте написание пароля");
                    }
                    //send and check
                    int check = Client.create_user(login, pass1);
                    if (check == 1) {
                        Client.login(login, "User");
                        Client.mainpage();
                    }
                    else {
                        login_ta.setText("");
                        pass1_ta.setText("");
                        pass2_ta.setText("");
                        JOptionPane.showMessageDialog(null, "Пользователь с таким логином уже существует");
                    }

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login, pass1, pass2;
                login = login_ta.getText();
                pass1 = pass1_ta.getText();
                pass2 = pass2_ta.getText();
                if (login.length() < 5 || pass1.length() < 5 || pass2.length() < 5) {
                    JOptionPane.showMessageDialog(null, "Пароль и логин должны выключать в себя не менее 5 символов");
                } else {
                    if (!(pass1.equals(pass2))) {
                        JOptionPane.showMessageDialog(null, "Проверьте написание пароля");
                    } else {
                        //send and check
                        int check = Client.create_user(login, pass1);
                        if (check == 1) {
                            Client.login(login, "User");
                            Client.mainpage();
                        } else {
                            login_ta.setText("");
                            pass1_ta.setText("");
                            pass2_ta.setText("");
                            JOptionPane.showMessageDialog(null, "Пользователь с таким логином уже существует");
                        }
                    }
                }
            }
        });
    }

}
