package Client;

import Items.NShortItems;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Search_page_new extends JPanel {
    public NShortItems items;
    public int number;
    public static int page;
    public int n;
    public ArrayList<Search_item> sitems;

    public Search_page_new() {
        sitems = new ArrayList<Search_item>();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
    }

    public void Draw_searchpage (NShortItems nsitems, int num) {
        sitems = new ArrayList<Search_item>();
        number = num;
        items = nsitems;
        page = 0;
        n = NShortItems.N;
        sitems.clear();
        for (int i = 0; i < n && i < number - page*n; i++) {
            if (items.names.get(i + page*n) == null || items.types.get(i + page*n) == null) {
                break;
            }
            sitems.add(new Search_item(items.names.get(i + page*n), items.types.get(i + page*n), i));
            sitems.get(i).setPreferredSize(new Dimension(400, 100));
            add(sitems.get(i));
        }

    }

}
