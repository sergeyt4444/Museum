package Client;

import Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Ban_panel extends JPanel {
    ArrayList<User> user_arr;
    int mod;

    public Ban_panel() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setPreferredSize(new Dimension(600, 600));

    }

    public void Init(ArrayList<User> users, int moderator) {
        removeAll();
        Font font = new Font("Times New Roman", Font.PLAIN, 16);
        Font header = new Font("Times New Roman", Font.PLAIN, 32);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        mod = moderator;

        Vector<String> names = new Vector<>();
        for (User user: users) {
            names.add(user.getLogin());
        }

        JLabel header_label = new JLabel("Меню блокировок");
        header_label.setForeground(Color.white);
        header_label.setBackground(Color.DARK_GRAY);
        header_label.setFont(header);
        header_label.setAlignmentX(CENTER_ALIGNMENT);

        JList<String> user_list = new JList<String>(names);
        user_list.setFont(font);
        user_list.setBackground(Color.DARK_GRAY);
        user_list.setForeground(Color.white);
        user_list.setMaximumSize(new Dimension(200, 200));
        user_list.setAlignmentX(CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(user_list);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMaximumSize(new Dimension(200, 60));

        String[] time_options = {"Секунд","Минут","Часов","Дней","Месяцев", "Лет"};

        JPanel time_panel = new JPanel();
        time_panel.setLayout(new BoxLayout(time_panel, BoxLayout.LINE_AXIS));
        time_panel.setBackground(Color.DARK_GRAY);
        time_panel.setBorder(BorderFactory.createEmptyBorder());
        time_panel.setMaximumSize(new Dimension(600, 100));
        time_panel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label = new JLabel("Заблокировать на");
        label.setFont(font);
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.white);

        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.white);
        textField.setMaximumSize(new Dimension(100, 50));

        JList<String> options_list = new JList<>(time_options);
        options_list.setFont(font);
        options_list.setBackground(Color.DARK_GRAY);
        options_list.setForeground(Color.white);

        JScrollPane scrollPane2 = new JScrollPane(options_list);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setMaximumSize(new Dimension(200, 80));

        time_panel.add(Box.createRigidArea(new Dimension(25, 0)));
        time_panel.add(label);
        time_panel.add(Box.createRigidArea(new Dimension(12, 0)));
        time_panel.add(textField);
        time_panel.add(Box.createRigidArea(new Dimension(50, 0)));
        time_panel.add(scrollPane2);
        time_panel.add(Box.createRigidArea(new Dimension(25, 0)));


        JPanel reason_panel = new JPanel();
        reason_panel.setLayout(new BoxLayout(reason_panel, BoxLayout.LINE_AXIS));
        reason_panel.setBackground(Color.DARK_GRAY);
        reason_panel.setBorder(BorderFactory.createEmptyBorder());
        reason_panel.setMinimumSize(new Dimension(600, 100));
        reason_panel.setMaximumSize(new Dimension(600, 200));
        reason_panel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel reason_label = new JLabel("Причина:");
        reason_label.setFont(font);
        reason_label.setBackground(Color.DARK_GRAY);
        reason_label.setForeground(Color.white);

        JTextField reason_field = new JTextField();
        reason_field.setFont(font);
        reason_field.setBackground(Color.DARK_GRAY);
        reason_field.setForeground(Color.white);
        reason_field.setMinimumSize(new Dimension(200, 50));

        reason_panel.add(Box.createRigidArea(new Dimension(25, 0)));
        reason_panel.add(reason_label);
        reason_panel.add(Box.createRigidArea(new Dimension(25, 0)));
        reason_panel.add(reason_field);
        reason_panel.add(Box.createRigidArea(new Dimension(25, 0)));

        JButton button = new JButton("Заблокировать");
        button.setFont(font);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.white);
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                int selected_user = user_list.getSelectedIndex();
                int UID = users.get(selected_user).getId();
                String selected_time = options_list.getSelectedValue();

                int duration = Integer.parseInt(textField.getText());
                if (selected_user != -1 && options_list.getSelectedIndex() != -1 && duration > 0) {
                    Date then;
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(now);
                    switch (selected_time) {
                        case "Секунд": {
                            calendar.add(Calendar.SECOND, duration);
                            break;
                        }
                        case "Минут": {
                            calendar.add(Calendar.MINUTE, duration);
                            break;
                        }
                        case "Часов": {
                            calendar.add(Calendar.HOUR, duration);
                            break;
                        }
                        case "Дней": {
                            calendar.add(Calendar.DATE, duration);
                            break;
                        }
                        case "Месяцев": {
                            calendar.add(Calendar.MONTH, duration);
                            break;
                        }
                        case "Лет":{
                            calendar.add(Calendar.YEAR, duration);
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    then = calendar.getTime();
                    Client.create_ban(UID, moderator, then, reason_field.getText() );
                    Client.mainpage();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Некорректные данные");
                }
            }
        });


        add(Box.createVerticalGlue());
        add(header_label);
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(Box.createVerticalGlue());
        add(scrollPane);
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(time_panel);
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(reason_panel);
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(button);
        add(Box.createVerticalGlue());



    }


}
