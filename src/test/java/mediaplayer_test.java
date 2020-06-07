import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class mediaplayer_test extends JPanel {
    public static JFrame JFrame;
    public static Player player;

    public mediaplayer_test() {
        setLayout(new BorderLayout());
        player = null;
        URL url = null;
        try {
            url = new File((getClass().getResource("/Testavi.avi")).getPath()).toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(url.toString());
        try {
            player  = Manager.createRealizedPlayer(url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoPlayerException e) {
            e.printStackTrace();
        } catch (CannotRealizeException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JFrame = new JFrame("TEST");
        JFrame.setSize(1280, 1024);
        JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.add(new mediaplayer_test());

        JFrame.setVisible(true);
    }

}
