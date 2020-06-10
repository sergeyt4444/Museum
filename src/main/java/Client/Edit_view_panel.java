package Client;

import Edits.JoinedEdit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Edit_view_panel extends JPanel{

    ArrayList<JoinedEdit> edit_arr;

    public Edit_view_panel() {
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setPreferredSize(new Dimension(600, 600));
    }

    public void Init(ArrayList<JoinedEdit> edits) {
        removeAll();
        Font font = new Font("Times New Roman", Font.PLAIN, 16);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        jPanel.setAlignmentY(TOP_ALIGNMENT);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        JTextField id_header = new JTextField("ID");
        id_header.setFont(font);
        id_header.setEditable(false);
        id_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(id_header, c);
        JTextField user_header = new JTextField("Автор");
        user_header.setFont(font);
        user_header.setEditable(false);
        user_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        jPanel.add(user_header,c);
        JTextField edit_header = new JTextField("Содержание изменения");
        edit_header.setFont(font);
        edit_header.setEditable(false);
        edit_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 0;
        jPanel.add(edit_header,c);
        JTextField exp_header = new JTextField("Экспонат");
        exp_header.setFont(font);
        exp_header.setEditable(false);
        exp_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 3;
        c.gridy = 0;
        jPanel.add(exp_header,c);
        JTextField edittype_header = new JTextField("Измененное поле");
        edittype_header.setFont(font);
        edittype_header.setEditable(false);
        edittype_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 4;
        c.gridy = 0;
        jPanel.add(edittype_header, c);
        JTextField date_header = new JTextField("Дата");
        date_header.setFont(font);
        date_header.setEditable(false);
        date_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 5;
        c.gridy = 0;
        jPanel.add(date_header,c);
        JTextField button_header = new JTextField("Отмена");
        button_header.setEditable(false);
        button_header.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 6;
        c.gridy = 0;
        jPanel.add(button_header, c);
        int i = 0;
        for (JoinedEdit edit: edits) {
            i++;
            JTextField id_field = new JTextField(Integer.toString(edit.getId()));
            id_field.setFont(font);
            id_field.setEditable(false);
            id_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 0;
            c.gridy = i;
            jPanel.add(id_field,c);
            JTextField user_field = new JTextField(edit.getAuthor().getLogin());
            user_field.setFont(font);
            user_field.setEditable(false);
            user_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = i;
            jPanel.add(user_field,c);
            JTextField edit_field = new JTextField(edit.getEdit());
            edit_field.setFont(font);
            edit_field.setEditable(false);
            edit_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 2;
            c.gridy = i;
            jPanel.add(edit_field,c);
            JTextField exp_field = new JTextField(edit.getItem().getName());
            exp_field.setFont(font);
            exp_field.setEditable(false);
            exp_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 3;
            c.gridy = i;
            jPanel.add(exp_field,c);
            JTextField edittype_field = new JTextField(edit.getEditrow());
            edittype_field.setFont(font);
            edittype_field.setEditable(false);
            edittype_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 4;
            c.gridy = i;
            jPanel.add(edittype_field, c);
            JTextField date_field = new JTextField(edit.getEditDate().toString());
            date_field.setFont(font);
            date_field.setEditable(false);
            date_field.setHorizontalAlignment(SwingConstants.CENTER);
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.gridx = 5;
            c.gridy = i;
            jPanel.add(date_field, c);
            JButton remove = new JButton("Отменить");
            remove.setFont(font);
            remove.setHorizontalAlignment(SwingConstants.CENTER);
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //delete edit
                    Client.delete_edit(edit.getId());
                    System.out.println("Delete edit, edit id: " + edit.getId());
                }
            });
            c.gridx = 6;
            c.gridy = i;
            jPanel.add(remove, c);

        }
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.weighty = 1.0;
        JPanel jPanel1 = new JPanel();
        jPanel.add(jPanel1, c);
        add(jScrollPane);

    }

}
