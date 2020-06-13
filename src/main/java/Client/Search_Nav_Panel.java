package Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_Nav_Panel extends JPanel {

    public JButton first;
    public JButton prev;
    public JButton next;
    public JButton last;
    public static JLabel page;


    public Search_Nav_Panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        Font font = new Font("Times New Roman",Font.PLAIN, 32);
        setSize(new Dimension(600, 50));
        setMaximumSize(new Dimension(600, 50));
        setPreferredSize(new Dimension(600, 50));

        first = new JButton();
        first.setMargin(new Insets(0, 0, 0, 0));
        first.setBackground(Color.DARK_GRAY);
        first.setBorder(null);
        try {
            Image img = ImageIO.read(getClass().getResource("/FirstIcon.jpg"));
            first.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.search_nav_first();
            }
        });
        prev = new JButton();
        prev.setMargin(new Insets(0, 0, 0, 0));
        prev.setBackground(Color.DARK_GRAY);
        prev.setBorder(null);
        try {
            Image img = ImageIO.read(getClass().getResource("/PrevIcon.jpg"));
            prev.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.search_nav_prev();
            }
        });
        next = new JButton();
        next.setMargin(new Insets(0, 0, 0, 0));
        next.setBackground(Color.DARK_GRAY);
        next.setBorder(null);
        try {
            Image img = ImageIO.read(getClass().getResource("/NextIcon.jpg"));
            next.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.search_nav_next();
            }
        });
        last = new JButton();
        last.setMargin(new Insets(0, 0, 0, 0));
        last.setBackground(Color.DARK_GRAY);
        last.setBorder(null);
        try {
            Image img = ImageIO.read(getClass().getResource("/LastIcon.jpg"));
            last.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.search_nav_last();
            }
        });
        page = new JLabel(Integer.toString(Search_page.page + 1));
        page.setForeground(Color.white);
        page.setFont(font);

        add(first);
        add(prev);
        add(Box.createRigidArea(new Dimension(10,0)));
        add(page);
        add(Box.createRigidArea(new Dimension(10,0)));
        add(next);
        add(last);


    }

}
