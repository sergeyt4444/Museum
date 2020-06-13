package Client;

import Items.NShortItems;

import javax.swing.*;
import java.awt.*;

public class Search_Full_panel extends JPanel {

//    public static Search_panel search_panel;
    public Search_page search_page;
    public Search_Nav_Panel search_nav_panel;

    public  Search_Full_panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    }

    public Search_Full_panel(NShortItems nsitems, int num) {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//        search_panel = new Search_panel();
//        search_panel.setBounds(0, 0, 600, 200);
        search_page = new Search_page(nsitems, num);
        search_page.setBounds(0, 0, 600, 550);
        search_nav_panel = new Search_Nav_Panel();
        search_nav_panel.setBounds(0, 550, 600, 50);
//        add(search_panel);
        add(search_page);
        add(search_nav_panel);
    }

    void Init(NShortItems nsitems, int num) {
        search_page.Init(nsitems, num);
        Search_Nav_Panel.page.setText("1");
    }

    void SoftInit(NShortItems nsitems,int num) {
        search_page.SoftInit(nsitems, num);
    }

}
