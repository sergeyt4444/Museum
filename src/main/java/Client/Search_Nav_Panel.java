package Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Search_Nav_Panel extends JPanel {

    public static JButton first;
    public static JButton prev;
    public static JButton next;
    public static JButton last;
    public static JLabel page;


    public Search_Nav_Panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        Font font = new Font("Times New Roman",Font.PLAIN, 32);
        setSize(new Dimension(600, 50));
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
