package Client.Media_panel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Etc_media_panel extends JPanel implements Abstract_Media_panel{
    public JButton icon;
    public JPanel jPanel;
    public JLabel filename_label;
    public JButton upload;
    public JButton delete;
    public Image img;
    public String filename;
    public File file;

    public Etc_media_panel() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        try {
            setImage(ImageIO.read(getClass().getResource("/EtcIcon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        filename = "";
    }

    public void setImage(Image image) {
        img = image;
    }

    public void setFilename(String str) {
        filename = str;
    }

    public void setImage(File f) {
        try {
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        filename = f.getName();
    }

    public void setFile(File f) {
        file = f;
    }

    public void Init() {
        if (img != null) {
            Font font = new Font("Times New Roman", Font.PLAIN, 16);
            icon = new JButton(new ImageIcon(img));
            icon.setMargin(new Insets(0, 0, 0, 0));
            icon.setBackground(Color.DARK_GRAY);
            icon.setBorder(null);
            icon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            jPanel = new JPanel();
            jPanel.setBackground(Color.darkGray);
            jPanel.setBorder(BorderFactory.createEmptyBorder());
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));

            filename_label = new JLabel(filename);
            filename_label.setFont(font);
            filename_label.setBackground(Color.DARK_GRAY);
            filename_label.setForeground(Color.white);

            upload = new JButton("Скачать");
            upload.setFont(font);
            upload.setBackground(Color.DARK_GRAY);
            upload.setForeground(Color.white);
            upload.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            delete = new JButton("Удалить");
            delete.setFont(font);
            delete.setBackground(Color.DARK_GRAY);
            delete.setForeground(Color.white);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            jPanel.add(Box.createVerticalGlue());
            jPanel.add(filename_label);
            jPanel.add(Box.createVerticalGlue());
            jPanel.add(upload);
            jPanel.add(Box.createVerticalGlue());
            jPanel.add(delete);
            jPanel.add(Box.createVerticalGlue());

            add(Box.createRigidArea(new Dimension(50, 0)));
            add(icon);
            add(Box.createHorizontalGlue());
            add(jPanel);
            add(Box.createHorizontalGlue());

        }
    }

    public void clear() {
        removeAll();
    }

}
