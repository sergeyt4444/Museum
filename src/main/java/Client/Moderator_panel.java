package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moderator_panel extends JPanel {

    public JLabel header_label;
    public JPanel container;
    public JButton changes_button;
    public JButton ban_history_button;
    public JButton ban_button;

    public Moderator_panel() {
        setBackground(Color.orange);
        setBorder(BorderFactory.createLineBorder(Color.orange, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Font header = new Font("Times New Roman",Font.PLAIN, 20);
        Font font = new Font("Times New Roman",Font.PLAIN, 16);

        header_label = new JLabel("Панель модератора");
        header_label.setFont(header);
        header_label.setAlignmentX(CENTER_ALIGNMENT);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setAlignmentX(CENTER_ALIGNMENT);
        container.setBorder(BorderFactory.createLineBorder(Color.black, 1));


        changes_button = new JButton("Последние правки");
        changes_button.setFont(font);
        changes_button.setAlignmentX(CENTER_ALIGNMENT);
        changes_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.edits();
            }
        });
        ban_history_button = new JButton("История банов");
        ban_history_button.setFont(font);
        ban_history_button.setAlignmentX(CENTER_ALIGNMENT);
        ban_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.bans();
            }
        });
        ban_button = new JButton("Забанить пользователя");
        ban_button.setFont(font);
        ban_button.setAlignmentX(CENTER_ALIGNMENT);
        ban_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.ban_panel();
            }
        });

        container.add(Box.createHorizontalGlue());
        container.add(Box.createVerticalGlue());
        container.add(changes_button);
        container.add(Box.createVerticalGlue());
        container.add(ban_history_button);
        container.add(Box.createVerticalGlue());
        container.add(ban_button);
        container.add(Box.createVerticalGlue());
        container.add(Box.createHorizontalGlue());

        add(Box.createRigidArea(new Dimension(0, 10)));
        add(header_label);
        add(Box.createVerticalGlue());
        add(container);
        add(Box.createRigidArea(new Dimension(0, 10)));

    }

}
