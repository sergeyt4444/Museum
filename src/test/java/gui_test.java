import Client.GUI;
import Client.Search_item;
import Client.Search_panel;
import Client.Sign_in_panel;
import Items.FullItem;

import javax.swing.*;
import java.awt.*;


    public class gui_test extends JPanel {

        public static JFrame JFrame;
        public static Sign_in_panel login_panel;
        public static JLabel header;
        public static Search_panel search_panel;

        public gui_test() {
            setLayout(null);
            setBackground(Color.DARK_GRAY);
            Font font = new Font("Times New Roman", Font.ITALIC, 48);
            FullItem fitem = new FullItem();
            fitem.setName("name");
            fitem.setType("Type");
            Search_item item1 = new Search_item(fitem, 1);
            item1.setBounds(50, 50, 400, 100);
            add(item1);
        }

        public static void main(String[] args) {
            JFrame = new JFrame("Собрание экспонатов музея");
            JFrame.setSize(1280, 1024);
            JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JFrame.add(new gui_test());

            JFrame.setVisible(true);
        }
    }

