package Client;

import Bans.JoinedBan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bans_view_panel extends JPanel {
    public int bnum;
    ArrayList<JoinedBan> ban_arr;

    public Bans_view_panel() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setPreferredSize(new Dimension(600, 600));

    }

    public void Init(ArrayList<JoinedBan> bans) {
        removeAll();
        ban_arr = bans;
        Font font = new Font("Times New Roman", Font.PLAIN, 16);
        bnum = bans.size();
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


        JTextField id_header = new JTextField("ID");
        id_header.setFont(font);
        id_header.setEditable(false);
        id_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(id_header, c);
        JTextField user_header = new JTextField("Пользователь");
        user_header.setFont(font);
        user_header.setEditable(false);
        user_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        jPanel.add(user_header,c);
        JTextField rec_header = new JTextField("Получен");
        rec_header.setFont(font);
        rec_header.setEditable(false);
        rec_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 0;
        jPanel.add(rec_header,c);
        JTextField exp_header = new JTextField("Закончится");
        exp_header.setFont(font);
        exp_header.setEditable(false);
        exp_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 3;
        c.gridy = 0;
        jPanel.add(exp_header,c);
        JTextField mod_header = new JTextField("Модератор");
        mod_header.setFont(font);
        mod_header.setEditable(false);
        mod_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 4;
        c.gridy = 0;
        jPanel.add(mod_header, c);
        JTextField reason_header = new JTextField("Причина");
        reason_header.setFont(font);
        reason_header.setEditable(false);
        reason_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 5;
        c.gridy = 0;
        jPanel.add(reason_header,c);
        JTextField button_header = new JTextField("Удаление");
        button_header.setEditable(false);
        button_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 6;
        c.gridy = 0;
        jPanel.add(button_header, c);
        int i = 0;
        for (JoinedBan ban: bans) {
            i++;
            JTextField id_field = new JTextField(Integer.toString(ban.getId()));
            id_field.setFont(font);
            id_field.setEditable(false);
            id_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 0;
            c.gridy = i;
            jPanel.add(id_field,c);
            JTextField user_field = new JTextField(ban.getUser().getLogin());
            user_field.setFont(font);
            user_field.setEditable(false);
            user_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = i;
            jPanel.add(user_field,c);
            JTextField rec_field = new JTextField(ban.getRecieved().toString());
            rec_field.setFont(font);
            rec_field.setEditable(false);
            rec_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 2;
            c.gridy = i;
            jPanel.add(rec_field,c);
            JTextField exp_field = new JTextField(ban.getExpired().toString());
            exp_field.setFont(font);
            exp_field.setEditable(false);
            exp_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 3;
            c.gridy = i;
            jPanel.add(exp_field,c);
            JTextField mod_field = new JTextField(ban.getModerator());
            mod_field.setFont(font);
            mod_field.setEditable(false);
            mod_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 4;
            c.gridy = i;
            jPanel.add(mod_field, c);
            JTextField reason_field = new JTextField(ban.getReason());
            reason_field.setFont(font);
            reason_field.setEditable(false);
            reason_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 5;
            c.gridy = i;
            jPanel.add(reason_field, c);
            JButton remove = new JButton("Отменить бан");
            remove.setFont(font);
            remove.setHorizontalAlignment(SwingConstants.CENTER);
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //delete ban
                    bans.remove(ban);
                    Init(bans);
                    Client.delete_ban(ban.getId());
                    System.out.println("Delete ban, ban id: " + ban.getId());
                }
            });
            c.gridx = 6;
            c.gridy = i;
            jPanel.add(remove, c);

        }
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.weighty = 1.0;
        JPanel jPanel1 = new JPanel();
        jPanel.add(jPanel1, c);
        add(jScrollPane);
    }

}
