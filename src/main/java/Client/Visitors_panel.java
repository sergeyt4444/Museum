package Client;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Visitors_panel extends JPanel {

    public JLabel header_label;
    public JTextArea textarea;
    public JFrame frame;
    public JScrollPane scrollpane;

    public Visitors_panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(null);
        Font header = new Font("Times New Roman",Font.PLAIN, 32);
        Font font = new Font("Times New Roman",Font.PLAIN, 20);

        header_label = new JLabel("Посетителям");
        header_label.setFont(header);
        header_label.setForeground(Color.white);
        header_label.setBounds(240, 50, 800, 200);

        textarea = new JTextArea();
        textarea.setFont(font);
        textarea.setBackground(Color.DARK_GRAY);
        textarea.setForeground(Color.white);
        textarea.setWrapStyleWord(true);
        textarea.setLineWrap(true);
        textarea.setEditable(false);


//        char[] txt = new char[1000];
        String txt = "";
        try {
            Reader filereader = new FileReader(new File((getClass().getResource("/Visitors.txt")).getPath()));
            int ch;
            while ((ch = filereader.read()) != -1) {
                txt += (char)ch;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        textarea.setText(txt);

        scrollpane = new JScrollPane(textarea);
        scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBounds(100, 300, 1080, 600);


        add(header_label);
        add(scrollpane);

    }

    public void ShowPanel() {
        frame = new JFrame("Посетителям");
        frame.setSize(1280, 1024);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(this);

        frame.setVisible(true);
    }

}
