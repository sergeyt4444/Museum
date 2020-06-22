package Client;


import Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Mods_panel extends JPanel {
    public int mnum;
    ArrayList<User> mod_arr;

    public Mods_panel() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setPreferredSize(new Dimension(600, 600));
    }

    public void Init(ArrayList<User> mods) {
        removeAll();
        mod_arr = mods;
        Font font = new Font("Times New Roman", Font.PLAIN, 16);
        mnum = mods.size();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        jPanel.setAlignmentY(TOP_ALIGNMENT);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setMaximumSize(new Dimension(600, 500));

        JTextField id_header = new JTextField("ID");
        id_header.setFont(font);
        id_header.setEditable(false);
        id_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(id_header, c);
        JTextField user_header = new JTextField("Модератор");
        user_header.setFont(font);
        user_header.setEditable(false);
        user_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        jPanel.add(user_header,c);
        JTextField rec_header = new JTextField("Понижение");
        rec_header.setFont(font);
        rec_header.setEditable(false);
        rec_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 0;
        jPanel.add(rec_header,c);

        int i = 0;
        for (User mod: mod_arr) {
            i++;
            JTextField id_field = new JTextField(Integer.toString(mod.getId()));
            id_field.setFont(font);
            id_field.setEditable(false);
            id_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 0;
            c.gridy = i;
            jPanel.add(id_field,c);
            JTextField user_field = new JTextField(mod.getLogin());
            user_field.setFont(font);
            user_field.setEditable(false);
            user_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = i;
            jPanel.add(user_field,c);
            JButton remove = new JButton("Лишить прав модератора");
            remove.setFont(font);
            remove.setHorizontalAlignment(SwingConstants.CENTER);
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //delete ban
                    mod_arr.remove(mod);
                    Init(mod_arr);
                    Client.demote(mod.getId());
                }
            });
            c.gridx = 2;
            c.gridy = i;
            jPanel.add(remove, c);

        }
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.weighty = 1.0;
        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(Color.DARK_GRAY);
        jPanel1.setBorder(BorderFactory.createEmptyBorder());
        jPanel.add(jPanel1, c);
        add(jScrollPane);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.DARK_GRAY);
        jPanel2.setBorder(BorderFactory.createEmptyBorder());
        jPanel2.setLayout(new BoxLayout(jPanel2,BoxLayout.PAGE_AXIS));
        JButton promote = new JButton("Добавить модератора");
        promote.setFont(font);
        promote.setBackground(Color.DARK_GRAY);
        promote.setForeground(Color.white);
        promote.setAlignmentX(CENTER_ALIGNMENT);
        promote.setHorizontalAlignment(SwingConstants.CENTER);
        promote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.promote();
            }
        });
        jPanel2.add(promote);
        add(jPanel2);
    }

}
