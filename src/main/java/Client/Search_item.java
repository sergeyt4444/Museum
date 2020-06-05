package Client;

import Items.FullItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Search_item extends JPanel{
    public FullItem item;
    public int number;
    public JLabel number_label;
    public JLabel name;
    public JLabel type;

    public Search_item() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
    }

    public Search_item(FullItem it, int num) {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        number = num;
        item = it;
        DrawItem();
    }

    public Search_item(String namestring, String typestring, int num) {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        number = num;
        item = new FullItem();
        item.Name = namestring;
        item.Type = typestring;
        DrawItem();
    }

    private void DrawItem() {
        number_label = new JLabel(Integer.toString(number));
        name = new JLabel(item.Name);
        type = new JLabel(item.Type);

        Font font = new Font("Times New Roman", Font.PLAIN, 32);

        number_label.setFont(font);
        name.setFont(font);
        type.setFont(font);

        number_label.setForeground(Color.white);
        number_label.setBackground(Color.DARK_GRAY);
        name.setForeground(Color.white);
        name.setBackground(Color.DARK_GRAY);
        type.setForeground(Color.white);
        type.setBackground(Color.DARK_GRAY);

        add(Box.createHorizontalGlue());
        add(number_label);
        add(Box.createHorizontalGlue());
        add(name);
        add(Box.createHorizontalGlue());
        add(type);
        add(Box.createHorizontalGlue());

        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
