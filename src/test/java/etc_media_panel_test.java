import Client.Media_panel.Abstract_Media_panel;
import Client.Media_panel.Etc_media_panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class etc_media_panel_test extends JPanel {

    public static JFrame JFrame;
    public static Abstract_Media_panel test_subject;

    public etc_media_panel_test() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 32);

        test_subject = new Etc_media_panel();
        ((Etc_media_panel) test_subject).setFilename("Unknown.doc");
        test_subject.Init();
        ((Etc_media_panel)test_subject).setBounds(300, 400, 400, 200);
        add((Etc_media_panel)test_subject);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new etc_media_panel_test());

        JFrame.setVisible(true);
    }
}
