package Client;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navigation_panel extends JPanel {

    public JButton main_button;
    public JButton info_button;
    public JButton visit_button;
    public JButton tours_button;
    public JButton exibitions_button;
    public JButton events_button;

    public Navigation_panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Font font = new Font("Times New Roman",Font.PLAIN, 20);

        main_button = new JButton("Главная страница");
        main_button.setFont(font);
        main_button.setBackground(Color.DARK_GRAY);
        main_button.setForeground(Color.white);
        main_button.setAlignmentX(CENTER_ALIGNMENT);
        info_button = new JButton("О музее");
        info_button.setFont(font);
        info_button.setBackground(Color.DARK_GRAY);
        info_button.setForeground(Color.white);
        info_button.setAlignmentX(CENTER_ALIGNMENT);
        visit_button = new JButton("Посетителям");
        visit_button.setFont(font);
        visit_button.setBackground(Color.DARK_GRAY);
        visit_button.setForeground(Color.white);
        visit_button.setAlignmentX(CENTER_ALIGNMENT);
        tours_button = new JButton("Туры по музею");
        tours_button.setFont(font);
        tours_button.setBackground(Color.DARK_GRAY);
        tours_button.setForeground(Color.white);
        tours_button.setAlignmentX(CENTER_ALIGNMENT);
        exibitions_button = new JButton("Выставки");
        exibitions_button.setFont(font);
        exibitions_button.setBackground(Color.DARK_GRAY);
        exibitions_button.setForeground(Color.white);
        exibitions_button.setAlignmentX(CENTER_ALIGNMENT);
        events_button = new JButton("События");
        events_button.setFont(font);
        events_button.setBackground(Color.DARK_GRAY);
        events_button.setForeground(Color.white);
        events_button.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
        add(main_button);
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(Box.createVerticalGlue());
        add(info_button);
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(Box.createVerticalGlue());
        add(visit_button);
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(Box.createVerticalGlue());
        add(tours_button);
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(Box.createVerticalGlue());
        add(exibitions_button);
        add(Box.createVerticalGlue());
        add(new JSeparator(SwingConstants.HORIZONTAL));
        add(Box.createVerticalGlue());
        add(events_button);
        add(Box.createVerticalGlue());

        main_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.mainpage();
            }
        });

        info_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Info_panel ipanel = new Info_panel();
                ipanel.ShowPanel();
            }
        });

        visit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visitors_panel vpanel = new Visitors_panel();
                vpanel.ShowPanel();
            }
        });

        tours_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tours_panel tours_panel = new Tours_panel();
                tours_panel.ShowPanel();
            }
        });

        exibitions_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exhibitions_panel exhibitions_panel = new Exhibitions_panel();
                exhibitions_panel.ShowPanel();
            }
        });

        events_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Events_panel events_panel = new Events_panel();
                events_panel.ShowPanel();
            }
        });
    }

}
