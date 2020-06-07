package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.TimeZone;

import Bans.Ban;
import Edits.Edit;
import Items.FullItem;
import Items.Item;
import Items.Keywords;
import Items.Media;
import Users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Server {
    public static ArrayList<DataOutputStream> allOutputs;
    public static ArrayList<Socket> allSockets;
    public static ArrayList<Socket_manager> allManagers;;
    public static model m;

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));

        m = BModel.build();

        allOutputs = new ArrayList<>();
        allSockets = new ArrayList<>();
        allManagers = new ArrayList<>();
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            serverSocket = new ServerSocket(4443);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connected");
                if (socket != null && allSockets != null) {
                    allSockets.add(socket);
                }
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                if (dos != null && allOutputs != null)
                    allOutputs.add(dos);
                Socket_manager sm = new Socket_manager(socket, dis,dos);
                allManagers.add(sm);
                sm.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
                if (allSockets != null) {
                    for (Socket sc : allSockets) {
                        if (sc != null)
                            sc.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
