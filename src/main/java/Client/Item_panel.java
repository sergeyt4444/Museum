package Client;

import Items.FullItem;
import Items.Keywords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Item_panel extends JPanel {

    public static FullItem item;
//    public static ArrayList<JLabel> labels;
//    public static ArrayList<JTextArea> texts;
    public static JPanel scroll_panel;
    public static JScrollPane scroll_pane;

    public static JLabel name_label;
    public static JLabel type_label;
    public static JLabel keywords_label;
    public static ArrayList<JPanel> keywords_panels;
    public static JButton add_keyword;
    public static JPanel ann_panel;
    public static JLabel ann_label;
    public static JButton ann_button;
    public static JTextArea ann_textarea;
    public static JPanel param_panel;
    public static JLabel param_label;
    public static JButton param_button;
    public static JTextArea param_textarea;
    public static JPanel lib_panel;
    public static JLabel lib_label;
    public static JButton lib_button;
    public static JTextArea lib_textarea;
    public static JPanel links_panel;
    public static JLabel links_label;
    public static JButton links_button;
    public static JTextArea links_textarea;

    public Item_panel() {

    }

    public  Item_panel(FullItem it) {
        if (it != null) {
            item = it;
            setBackground(Color.darkGray);
            setBorder(BorderFactory.createLineBorder(Color.white, 2));
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            Font header = new Font("Times New Roman", Font.PLAIN, 24);
            Font font = new Font("Times New Roman", Font.PLAIN, 16);

            name_label = new JLabel(item.Name);
            name_label.setFont(header);
            name_label.setForeground(Color.white);
            name_label.setAlignmentX(CENTER_ALIGNMENT);
            type_label = new JLabel("Тип экспоната:" + item.Type);
            type_label.setFont(header);
            type_label.setForeground(Color.white);
            type_label.setAlignmentX(CENTER_ALIGNMENT);
            keywords_label = new JLabel("Ключевые слова:");
            keywords_label.setFont(header);
            keywords_label.setForeground(Color.white);
            keywords_label.setAlignmentX(CENTER_ALIGNMENT);

            keywords_panels = new ArrayList<>();
            for (final String keyword : item.Keywords) {
                JPanel jpanel = new JPanel();
                jpanel.setBackground(Color.darkGray);
                jpanel.setBorder(BorderFactory.createEmptyBorder());
                jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.LINE_AXIS));

                JLabel keyword_label = new JLabel(keyword);
                keyword_label.setFont(font);
                keyword_label.setForeground(Color.white);

                JButton remove_keyword = new JButton("Удалить ключевое слово");
                remove_keyword.setFont(font);
                remove_keyword.setForeground(Color.white);
                remove_keyword.setBackground(Color.DARK_GRAY);

                jpanel.add(keyword_label);
                jpanel.add(Box.createRigidArea(new Dimension(24,0)));
                jpanel.add(remove_keyword);

                keywords_panels.add(jpanel);

                remove_keyword.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Delete " + keyword + " Keyword");
                    }
                });

            }

            add_keyword = new JButton("Добавить ключевое слово");
            add_keyword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            ann_panel = new JPanel();
            ann_panel.setBackground(Color.darkGray);
            ann_panel.setBorder(BorderFactory.createEmptyBorder());
            ann_panel.setLayout(new BoxLayout(ann_panel, BoxLayout.LINE_AXIS));

            ann_label = new JLabel("Описание");
            ann_label.setFont(header);
            ann_label.setForeground(Color.white);
            ann_label.setAlignmentX(CENTER_ALIGNMENT);
            ann_button = new JButton("Редактировать");
            ann_button.setFont(font);
            ann_button.setForeground(Color.white);
            ann_button.setBackground(Color.DARK_GRAY);
            ann_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            ann_panel.add(ann_label);
            ann_panel.add(Box.createHorizontalGlue());
            ann_panel.add(ann_button);

            ann_textarea = new JTextArea();
            ann_textarea.setFont(font);
            ann_textarea.setBackground(Color.DARK_GRAY);
            ann_textarea.setForeground(Color.white);
            ann_textarea.setWrapStyleWord(true);
            ann_textarea.setLineWrap(true);
            ann_textarea.setEditable(false);
            ann_textarea.setText(item.Annotation);

            param_panel = new JPanel();
            param_panel.setBackground(Color.darkGray);
            param_panel.setBorder(BorderFactory.createEmptyBorder());
            param_panel.setLayout(new BoxLayout(param_panel, BoxLayout.LINE_AXIS));

            param_label = new JLabel("Технические параметры");
            param_label.setFont(header);
            param_label.setForeground(Color.white);
            param_label.setAlignmentX(CENTER_ALIGNMENT);
            param_button = new JButton("Редактировать");
            param_button.setFont(font);
            param_button.setForeground(Color.white);
            param_button.setBackground(Color.DARK_GRAY);
            param_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            param_panel.add(param_label);
            param_panel.add(Box.createHorizontalGlue());
            param_panel.add(param_button);

            param_textarea = new JTextArea();
            param_textarea.setFont(font);
            param_textarea.setBackground(Color.DARK_GRAY);
            param_textarea.setForeground(Color.white);
            param_textarea.setWrapStyleWord(true);
            param_textarea.setLineWrap(true);
            param_textarea.setEditable(false);
            param_textarea.setText(item.Parameters);

            lib_panel = new JPanel();
            lib_panel.setBackground(Color.darkGray);
            lib_panel.setBorder(BorderFactory.createEmptyBorder());
            lib_panel.setLayout(new BoxLayout(lib_panel, BoxLayout.LINE_AXIS));

            lib_label = new JLabel("Литература");
            lib_label.setFont(header);
            lib_label.setForeground(Color.white);
            lib_label.setAlignmentX(CENTER_ALIGNMENT);
            lib_button = new JButton("Редактировать");
            lib_button.setFont(font);
            lib_button.setForeground(Color.white);
            lib_button.setBackground(Color.DARK_GRAY);
            lib_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            lib_panel.add(lib_label);
            lib_panel.add(Box.createHorizontalGlue());
            lib_panel.add(lib_button);

            lib_textarea = new JTextArea();
            lib_textarea.setFont(font);
            lib_textarea.setBackground(Color.DARK_GRAY);
            lib_textarea.setForeground(Color.white);
            lib_textarea.setWrapStyleWord(true);
            lib_textarea.setLineWrap(true);
            lib_textarea.setEditable(false);
            lib_textarea.setText(item.Lib);

            links_panel = new JPanel();
            links_panel.setBackground(Color.darkGray);
            links_panel.setBorder(BorderFactory.createEmptyBorder());
            links_panel.setLayout(new BoxLayout(links_panel, BoxLayout.LINE_AXIS));

            links_label = new JLabel("Ссылки");
            links_label.setFont(header);
            links_label.setForeground(Color.white);
            links_label.setAlignmentX(CENTER_ALIGNMENT);
            links_button = new JButton("Редактировать");
            links_button.setFont(font);
            links_button.setForeground(Color.white);
            links_button.setBackground(Color.DARK_GRAY);
            links_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            links_panel.add(links_label);
            links_panel.add(Box.createHorizontalGlue());
            links_panel.add(links_button);

            links_textarea = new JTextArea();
            links_textarea.setFont(font);
            links_textarea.setBackground(Color.DARK_GRAY);
            links_textarea.setForeground(Color.white);
            links_textarea.setWrapStyleWord(true);
            links_textarea.setLineWrap(true);
            links_textarea.setEditable(false);
            links_textarea.setText(item.Links);


            scroll_panel = new JPanel();
            scroll_panel.setBackground(Color.darkGray);
            scroll_panel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            scroll_panel.setLayout(new BoxLayout(scroll_panel, BoxLayout.PAGE_AXIS));


            scroll_pane = new JScrollPane(scroll_panel);
            scroll_pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scroll_pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            scroll_panel.add(name_label);
            scroll_panel.add(type_label);
            scroll_panel.add(keywords_label);
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            for (JPanel jp : keywords_panels) {
                scroll_panel.add(jp);
            }
            scroll_panel.add(add_keyword);
            scroll_panel.add(Box.createRigidArea(new Dimension(0,12)));
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(ann_panel);
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(ann_textarea);
            scroll_panel.add(Box.createRigidArea(new Dimension(0,12)));
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(param_panel);
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(param_textarea);
            scroll_panel.add(Box.createRigidArea(new Dimension(0,12)));
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(lib_panel);
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(lib_textarea);
            scroll_panel.add(Box.createRigidArea(new Dimension(0,12)));
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(links_panel);
            scroll_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
            scroll_panel.add(links_textarea);

            add(scroll_pane);

        }
    }

}
