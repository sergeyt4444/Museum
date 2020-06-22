package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class New_item_panel extends JPanel {

    public JLabel name_label;
    public JTextField name_tf;
    public JLabel type_label;
    public JTextField type_tf;
    public JButton add_obj;

    public New_item_panel() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.PLAIN, 24);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));

        name_label = new JLabel("Введите название");
        type_label = new JLabel("Введите тип");
        add_obj = new JButton("Добавить экспонат");
        name_tf = new JTextField();
        type_tf = new JTextField();

        name_label.setFont(font);
        name_label.setForeground(Color.white);
        name_label.setBounds(100, 125, 200, 40);
        add(name_label);
        type_label.setFont(font);
        type_label.setForeground(Color.white);
        type_label.setBounds(100, 200, 200, 40);
        add(type_label);
        name_tf.setFont(font);
        name_tf.setForeground(Color.white);
        name_tf.setBackground(Color.DARK_GRAY);
        name_tf.setBounds(300, 125, 200, 40);
        add(name_tf);
        type_tf.setFont(font);
        type_tf.setForeground(Color.white);
        type_tf.setBackground(Color.DARK_GRAY);
        type_tf.setBounds(300, 200, 200, 40);
        add(type_tf);
        add_obj.setFont(font);
        add_obj.setForeground(Color.white);
        add_obj.setBackground(Color.DARK_GRAY);
        add_obj.setBounds(120, 325, 360, 50);
        add(add_obj);

        name_tf.setDocument(new JTextLengthLimit(50));
        type_tf.setDocument(new JTextLengthLimit(25));
        add_obj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name_tf.getText();
                String type = type_tf.getText();
                if (!(name.equals("") || type.equals(""))) {
                    Client.commit_add_object(name_tf.getText(), type_tf.getText());
                }
                else {
                    JOptionPane.showMessageDialog(null, "Некорректные данные");
                }
            }
        });
    }

    public void clear() {
        if (name_tf != null) {
            name_tf.setText("");
        }
        if (type_tf != null) {
            type_tf.setText("");
        }
    }


}
