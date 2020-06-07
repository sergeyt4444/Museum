import Client.Media_panel.Abstract_Media_panel;
import Client.Media_panel.Image_media_panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class image_media_panel_test extends JPanel {

    public static JFrame JFrame;
    public static Abstract_Media_panel test_subject;

    public image_media_panel_test() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        Font font = new Font("Times New Roman", Font.ITALIC, 32);

        test_subject = new Image_media_panel();
//        ((Image_media_panel) test_subject).setFilename("ImageMediaTest.doc");
//        try {
//            ((Image_media_panel) test_subject).setImage(ImageIO.read(getClass().getResource("/ImagePanelTest.png")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ((Image_media_panel) test_subject).setImage(new File(getClass().getResource("/ImagePanelTest.png").getPath()));
        test_subject.Init();
        ((Image_media_panel)test_subject).setBounds(300, 400, 400, 200);
        add((Image_media_panel)test_subject);
    }

    public static void main(String[] args) {
        JFrame = new JFrame("Собрание экспонатов музея");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new image_media_panel_test());

        JFrame.setVisible(true);
    }
}