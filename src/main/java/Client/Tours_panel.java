package Client;

import javax.swing.*;
import java.awt.*;

public class Tours_panel extends JPanel{
    public JFrame frame;
    public JScrollPane scrollpane;

    public Tours_panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        scrollpane = new JScrollPane(this);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        add(Box.createRigidArea(new Dimension(0, 100)));
        add(new Article("Tour1","Tours"));
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(new Article("Tour2","Tours"));
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(new Article("Tour3","Tours"));
    }

    public void ShowPanel() {
        frame = new JFrame("Туры по музею");
        frame.setSize(1280, 1024);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(scrollpane);

        frame.setVisible(true);
    }
}
