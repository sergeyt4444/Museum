package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_panel extends JPanel {

    public static JButton search;
    public static JTextField search_ta;
    public static JLabel search_label;
//    public static JLabel sort_label;
//    public static JComboBox sort_cbox;
    public static JRadioButton rb1;
    public static JRadioButton rb2;
    public static JRadioButton rb3;
    public static ButtonGroup group;


    public Search_panel() {
        setLayout(null);
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setPreferredSize(new Dimension(600, 200));
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        Font small = new Font("Times New Roman", Font.PLAIN, 16);
        String[] sort_options = new String[] {"По алфавиту", "По популярности"};
        search = new JButton("Search");
        search_label = new JLabel("Искать");
        search_ta = new JTextField();
//        sort_label = new JLabel("Сортировать");
//        sort_cbox = new JComboBox(sort_options);
        group = new ButtonGroup();
        rb1 = new JRadioButton("По названию", true);
        rb2 = new JRadioButton("<html>По ключевым<br> словам</html>");
        rb3 = new JRadioButton("По экспозиции");
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);

        search_label.setFont(font);
        search.setFont(font);
        search_ta.setFont(font);
        rb1.setFont(small);
        rb2.setFont(small);
        rb3.setFont(small);

        search_ta.setBounds(40, 25, 400, 50);
        search.setBounds(450, 25, 100, 50);
        search_label.setBounds(40, 100, 100, 50);
        rb1.setBounds(150, 100, 140, 50);
        rb2.setBounds(300, 100, 140, 50);
        rb3.setBounds(450, 100, 140, 50);
        search_label.setForeground(Color.white);
        rb1.setForeground(Color.white);
        rb1.setBackground(Color.DARK_GRAY);
        rb2.setForeground(Color.white);
        rb2.setBackground(Color.DARK_GRAY);
        rb3.setForeground(Color.white);
        rb3.setBackground(Color.DARK_GRAY);
        add(search_ta);
        add(search);
        add(search_label);
        add(rb1);
        add(rb2);
        add(rb3);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search_request = search_ta.getText();
                int selected = 0;
                if (rb1.isSelected()) {
                    selected = 1;
                }
                else {
                    if (rb2.isSelected()) {
                        selected = 2;
                    }
                    else {
                        selected = 3;
                    }
                }
                Client.search(search_request, selected);
            }
        });
    }

}
