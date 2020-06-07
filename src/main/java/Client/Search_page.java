package Client;

import Items.NFullItems;
import Items.NShortItems;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Search_page extends JPanel{

    public NShortItems items;
    public int number;
    public static int page;
    public int n;
    public ArrayList<Search_item> sitems;
    public static JScrollPane jScrollPane;
    public static JPanel jPanel;

    public Search_page() {
        sitems = new ArrayList<Search_item>();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane);
    }


    public Search_page(NShortItems nsitems, int num) {
        sitems = new ArrayList<Search_item>();
        number = num;
        items = nsitems;
        page = 0;
        n = NShortItems.N;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane);
        sitems.clear();
        jPanel.removeAll();
        for (int i = 0; i < n && i < number - page*n; i++) {
            if (items.names.get(i ) == null) {
                break;
            }
            if ( items.types.get(i ) == null) {
                break;
            }
            sitems.add(new Search_item(items.names.get(i + page*n), items.types.get(i + page*n), i + page*n + 1));
//            sitems.get(i).setPreferredSize(new Dimension(400, 100));
            jPanel.add(sitems.get(i));
        }
    }

    public void Init(NShortItems nsitems, int num) {
        number = num;
        items = nsitems;
        page = 0;
        n = NShortItems.N;
        sitems.clear();
        jPanel.removeAll();
        for (int i = 0; i < n && i < number - page*n; i++) {
            if (items.names.get(i ) == null) {
                break;
            }
            if (items.types.get(i ) == null) {
                break;
            }
            sitems.add(new Search_item(items.names.get(i + page*n), items.types.get(i + page*n), i + page*n + 1));
 //           sitems.get(i).setPreferredSize(new Dimension(400, 100));
            jPanel.add(sitems.get(i));
        }

    }

    public void SoftInit(NShortItems nsitems, int num) {
        number = num;
        items = nsitems;
        n = NShortItems.N;
        sitems.clear();
        jPanel.removeAll();
        for (int i = 0; i < n && i < number - page * n; i++) {
            if (items.names.get(i ) == null) {
                break;
            }
            if (items.types.get(i ) == null) {
                break;
            }
            sitems.add(new Search_item(items.names.get(i ), items.types.get(i ), i + page * n + 1));
            //           sitems.get(i).setPreferredSize(new Dimension(400, 100));
            jPanel.add(sitems.get(i));
        }
    }


}
