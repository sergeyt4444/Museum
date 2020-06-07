package Client;

import Items.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit_panel extends JPanel {

    public static JLabel name_label;
    public static JLabel type_label;
    public static JTextArea edit_ta;
    public static JPanel buttons_panel;
    public static JButton confirm;
    public static JButton cancel;
    public static String Name;
    public static String Type;
    public static String Placeholder;

    public Edit_panel() {
        Name = "Placeholder name";
        Type = "Edit type placeholder";
        Placeholder = "Placeholder text";

        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Font header_font = new Font("Times New Roman",Font.PLAIN, 32);
        Font font = new Font("Times New Roman",Font.PLAIN, 20);
        name_label = new JLabel(Name);
        name_label.setFont(header_font);
        name_label.setForeground(Color.white);
        type_label = new JLabel(Type);
        type_label.setFont(header_font);
        type_label.setForeground(Color.white);
        edit_ta = new JTextArea(Placeholder);
        edit_ta.setFont(font);
        edit_ta.setBackground(Color.DARK_GRAY);
        edit_ta.setForeground(Color.white);
        edit_ta.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        buttons_panel = new JPanel();
        confirm = new JButton("Подтвердить");
        cancel = new JButton("Отменить");
        confirm.setBackground(Color.DARK_GRAY);
        confirm.setForeground(Color.white);
        confirm.setFont(font);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.white);
        cancel.setFont(font);
        buttons_panel.setBackground(Color.DARK_GRAY);
        buttons_panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        buttons_panel.add(confirm);
        buttons_panel.add(cancel);
        edit_ta.setDocument(new JTextLengthLimit(10));
        name_label.setAlignmentX(CENTER_ALIGNMENT);
        type_label.setAlignmentX(0.2f);
        edit_ta.setAlignmentX(0.2f);
        buttons_panel.setAlignmentX(0.2f);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.commit_edit(Name, Type, edit_ta.getText());
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.close_edit();
            }
        });

        add(name_label);
        add(type_label);
        add(edit_ta);
        add(buttons_panel);

    }

    public Edit_panel(Item item, String EditType) {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Font header_font = new Font("Times New Roman", Font.PLAIN, 32);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        name_label = new JLabel();
        name_label.setFont(header_font);
        name_label.setForeground(Color.white);
        type_label = new JLabel();
        type_label.setFont(header_font);
        type_label.setForeground(Color.white);
        edit_ta = new JTextArea();
        edit_ta.setFont(font);
        edit_ta.setBackground(Color.DARK_GRAY);
        edit_ta.setForeground(Color.white);
        edit_ta.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        edit_ta.setLineWrap(true);
        edit_ta.setWrapStyleWord(true);
        buttons_panel = new JPanel();
        confirm = new JButton("Подтвердить");
        cancel = new JButton("Отменить");
        confirm.setBackground(Color.DARK_GRAY);
        confirm.setForeground(Color.white);
        confirm.setFont(font);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.white);
        cancel.setFont(font);
        buttons_panel.setBackground(Color.DARK_GRAY);
        buttons_panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        buttons_panel.add(confirm);
        buttons_panel.add(cancel);
        edit_ta.setDocument(new JTextLengthLimit(500));
        name_label.setAlignmentX(CENTER_ALIGNMENT);
        type_label.setAlignmentX(0.2f);
        edit_ta.setAlignmentX(0.2f);
        buttons_panel.setAlignmentX(0.2f);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.commit_edit(Name, Type, edit_ta.getText());
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.close_edit();
            }
        });

        add(name_label);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(type_label);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(edit_ta);
        add(buttons_panel);

        if (item != null) {
            Name = item.getName();

            if (EditType != null) {
                switch (EditType) {
                    case "Type": {
                        Type = "Тип";
                        if (item.getType() == null) {
                            item.setType("");
                        }
                        Placeholder = item.getType();
                        edit_ta.setDocument(new JTextLengthLimit(25));
                        break;
                    }
                    case "Name": {
                        Type = "Название";
                        Placeholder = item.getName();
                        edit_ta.setDocument(new JTextLengthLimit(50));
                        break;
                    }
                    case "Parameters": {
                        Type = "Технические параметры";
                        if (item.getParameters() == null) {
                            item.setParameters("");
                        }
                        Placeholder = item.getParameters();
                        edit_ta.setDocument(new JTextLengthLimit(250));
                        break;
                    }
                    case "Lib": {
                        Type = "Литература";
                        if (item.getLib() == null) {
                            item.setLib("");
                        }
                        Placeholder = item.getLib();
                        edit_ta.setDocument(new JTextLengthLimit(250));
                        break;
                    }
                    case "Links": {
                        Type = "Ссылки";
                        if (item.getLinks() == null) {
                            item.setLinks("");
                        }
                        Placeholder = item.getLinks();
                        edit_ta.setDocument(new JTextLengthLimit(250));
                        break;
                    }
                    case "Annotation": {
                        Type = "Описание";
                        if (item.getAnnotation() == null) {
                            item.setAnnotation("");
                        }
                        Placeholder = item.getAnnotation();
                        edit_ta.setDocument(new JTextLengthLimit(500));
                        break;
                    }
                    default: {
                        Type = "Error";
                        Placeholder = "Error";
                        edit_ta.setDocument(new JTextLengthLimit(10));
                        break;
                    }
                }
            }
            name_label.setText(Name);
            type_label.setText(Type);
            edit_ta.setText(Placeholder);
        }
    }

    public void Init(Item item, String EditType) {
        if (item != null && EditType != null) {
            Name = item.getName();
            switch (EditType) {
                case "Type": {
                    Type = "Тип";
                    if (item.getType() == null) {
                        item.setType("");
                    }
                    Placeholder = item.getType();
                    edit_ta.setDocument(new JTextLengthLimit(25));
                    break;
                }
                case "Name": {
                    Type = "Название";
                    Placeholder = item.getName();
                    edit_ta.setDocument(new JTextLengthLimit(50));
                    break;
                }
                case "Parameters": {
                    Type = "Технические параметры";
                    if (item.getParameters() == null) {
                        item.setParameters("");
                    }
                    Placeholder = item.getParameters();
                    edit_ta.setDocument(new JTextLengthLimit(250));
                    break;
                }
                case "Lib": {
                    Type = "Литература";
                    if (item.getLib() == null) {
                        item.setLib("");
                    }
                    Placeholder = item.getLib();
                    edit_ta.setDocument(new JTextLengthLimit(250));
                    break;
                }
                case "Links": {
                    Type = "Ссылки";
                    if (item.getLinks() == null) {
                        item.setLinks("");
                    }
                    Placeholder = item.getLinks();
                    edit_ta.setDocument(new JTextLengthLimit(250));
                    break;
                }
                case "Annotation": {
                    Type = "Описание";
                    if (item.getAnnotation() == null) {
                        item.setAnnotation("");
                    }
                    Placeholder = item.getAnnotation();
                    edit_ta.setDocument(new JTextLengthLimit(500));
                    break;
                }
                default: {
                    Type = "Error";
                    Placeholder = "Error";
                    edit_ta.setDocument(new JTextLengthLimit(10));
                    break;
                }
            }

        }
        name_label.setText(Name);
        type_label.setText(Type);
        edit_ta.setText(Placeholder);
    }

}
