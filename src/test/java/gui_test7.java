import Client.Item_panel;
import Items.FullItem;
import Items.Item;

import javax.swing.*;
import java.awt.*;

public class gui_test7 extends JPanel {

    public static javax.swing.JFrame JFrame;
    public static Item_panel item_panel;

    public gui_test7() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 32);

        Item item = new Item("Name", "Type", "Annot", "Param", "link", "lib");
        String str = "Parameters";

        FullItem fitem = new FullItem();
        fitem.Fill_item(item);
//        fitem.Add_Keyword("Test");
//        fitem.Add_Keyword("Test2");
//        fitem.Add_Keyword("Test3");

        Item_panel ipanel = new Item_panel(fitem, null);
        ipanel.setBounds(100, 100, 500, 600);
        add(ipanel);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new gui_test7());

        JFrame.setVisible(true);
    }
}
