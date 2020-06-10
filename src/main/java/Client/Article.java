package Client;

import javax.imageio.ImageIO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Article extends JPanel {

    public JLabel img;
    public JPanel jPanel;
    public JScrollPane scrollPane;
    public JLabel header_label;
    public JTextArea textarea;
    public String tour_name;

    public Article(String str, String type) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        Font header = new Font("Times New Roman",Font.PLAIN, 32);
        Font font = new Font("Times New Roman",Font.PLAIN, 16);
        tour_name = str;

        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(BorderFactory.createEmptyBorder());


        header_label = new JLabel(tour_name);
        header_label.setFont(header);
        header_label.setForeground(Color.white);
        header_label.setBorder(BorderFactory.createEmptyBorder());

        textarea = new JTextArea();
        textarea.setFont(font);
        textarea.setBackground(Color.DARK_GRAY);
        textarea.setForeground(Color.white);
        textarea.setWrapStyleWord(true);
        textarea.setLineWrap(true);
        textarea.setEditable(false);
        textarea.setBorder(BorderFactory.createEmptyBorder());
        String txt = "";
        try {
            Reader filereader = new FileReader(new File((getClass().getResource("/"+type+"/"+tour_name+".txt")).getPath()));
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
        scrollPane = new JScrollPane(textarea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollPane.getVerticalScrollBar().setValue(0);
            }
        });
        try {
            Image image = ImageIO.read(getClass().getResource("/"+type+"/"+tour_name+".jpg"));
            setMaximumSize(new Dimension(Integer.MAX_VALUE, image.getHeight(null) + 40));
            img = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }



        jPanel.add(Box.createVerticalGlue());
        jPanel.add(Box.createRigidArea(new Dimension(0, 24)));
        jPanel.add(header_label);
        jPanel.add(Box.createRigidArea(new Dimension(0, 24)));
        jPanel.add(scrollPane);
        jPanel.add(Box.createRigidArea(new Dimension(0, 24)));
        jPanel.add(Box.createVerticalGlue());

        add(Box.createRigidArea(new Dimension(40, 0)));
        add(img);
        add(Box.createRigidArea(new Dimension(40, 0)));
        add(jPanel);
        add(Box.createHorizontalGlue());

    }

}
