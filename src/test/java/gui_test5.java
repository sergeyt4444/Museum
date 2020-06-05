import Client.Edit_panel;
import Client.Register_panel;
import Client.Sign_in_panel;
import Client.Signed_in_panel;
import Items.Item;
import Users.User;

import javax.swing.*;
import java.awt.*;



public class gui_test5 extends JPanel {

    public static JFrame JFrame;
    public static Edit_panel edit_panel;

    public gui_test5() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 32);

        Item item = new Item("Name", "Type", "Annot", "Param", "link", "lib");
        String str = "Parameters";

        edit_panel = new Edit_panel(item, str);
        edit_panel.setBounds(100, 100, 500, 600);
        add(edit_panel);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new gui_test5());

        JFrame.setVisible(true);
    }
}

