package Client;

import Items.FullItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Delete_item_panel extends JPanel {

    public JLabel item_label;
    public JComboBox<FullItem> items;
    public JButton item_button;
    public JPanel main_delete_panel;

    public Delete_item_panel() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setPreferredSize(new Dimension(600, 600));
        main_delete_panel = new JPanel();
        main_delete_panel.setLayout(new BoxLayout(main_delete_panel, BoxLayout.LINE_AXIS));
        main_delete_panel.setAlignmentX(CENTER_ALIGNMENT);
        main_delete_panel.setBackground(Color.DARK_GRAY);
        main_delete_panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        main_delete_panel.setMaximumSize(new Dimension(600, 50));
        Font big = new Font("Times New Roman",Font.PLAIN, 20);
        Font font = new Font("Times New Roman",Font.PLAIN, 16);

        item_label = new JLabel("Выберите удаляемый экспонат");
        item_label.setFont(font);
        item_label.setForeground(Color.white);
        item_label.setAlignmentY(CENTER_ALIGNMENT);

        items = new JComboBox<>();
        items.setEditable(false);

        item_button = new JButton("Удалить");
        item_button.setFont(big);
        item_button.setForeground(Color.white);
        item_button.setBackground(Color.DARK_GRAY);
        item_button.setAlignmentY(CENTER_ALIGNMENT);
        item_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FullItem item = (FullItem) items.getSelectedItem();
                Client.commit_delete_object(item.getId());
            }
        });
        main_delete_panel.add(item_label);
        main_delete_panel.add(items);
        main_delete_panel.add(item_button);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(main_delete_panel);
        add(Box.createVerticalGlue());

    }

    public void Init(ArrayList<FullItem> items1) {
        items.removeAllItems();
        for (FullItem fi: items1) {
            items.addItem(fi);
        }
        items.setSelectedIndex(1);
    }


}
