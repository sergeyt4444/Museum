import Client.*;
import Items.FullItem;
import Items.Item;
import Items.NShortItems;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class gui_test6 extends JPanel {

    public static JFrame JFrame;
    public static Sign_in_panel login_panel;
    public static JLabel header;
    public static Search_panel search_panel;

    public gui_test6() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 48);
        ArrayList<Item> itmes = new ArrayList<Item>(10);
        for (int i = 0; i < 10; i++) {
            Item fi = new Item();
            fi.setName("Name" + i);
            fi.setType("Type" + i);
            itmes.add(fi);
        }
        NShortItems nsi = new NShortItems(itmes, 0, 10);
        Search_Full_panel item1 = new Search_Full_panel(nsi, 10);
        item1.setBounds(50, 50, 500, 800);
        add(item1);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new gui_test6());

        JFrame.setVisible(true);
    }
}

