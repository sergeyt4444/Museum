package Client;

import Bans.Ban;
import Bans.JoinedBan;
import Edits.JoinedEdit;
import Items.FullItem;
import Items.Item;
import Items.NShortItems;
import Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

public class Client {

    public static int number_of_objects;
    public static JFrame jFrame;
    public static DataOutputStream output;
    public static DataInputStream input;

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));

        String adress = "127.0.0.1";
        InetAddress ip = null;
        Socket socket = null;
        try {
            ip = InetAddress.getByName(adress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket = new Socket(ip, 4443);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream sin = null;
        OutputStream sout = null;
        input = null;
        output = null;
        try {
            sin = socket.getInputStream();
            sout = socket.getOutputStream();
            input = new DataInputStream(sin);
            output = new DataOutputStream(sout);
            System.out.println("Connected");

        } catch (IOException e) {
            e.printStackTrace();
        }


        jFrame = new JFrame("Собрание экспонатов музея");
        jFrame.setSize(1280, 1024);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Socket finalSocket = socket;
        jFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (finalSocket != null) {
                    try {
                        finalSocket.close();
                        FileUtils.deleteDirectory(new File("src/main/resources/tmp"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        jFrame.add(new GUI());


        jFrame.setVisible(true);

    }


    public static void mainpage() {
        GUI.central_panel.removeAll();
        GUI.central_panel.add(GUI.header);
        GUI.central_panel.add(Box.createRigidArea(new Dimension(0, 100)));
        Search_panel.search_ta.setText("");
        GUI.central_panel.add(GUI.search_panel);
        GUI.central_panel.add(Box.createRigidArea(new Dimension(0, 270)));
        jFrame.repaint();
    }

    public static void login(String login, String password) {
        //send req
        //recieve user
//        User s_user = new User("login", "password", "Admin");
        try {
            User s_user;
            output.writeUTF("login");
            output.writeUTF(login);
            output.writeUTF(password);

            String response = input.readUTF();
            if (response == "null") {
                s_user = null;
            }
            else {
                Gson json = new GsonBuilder().setPrettyPrinting().create();
                Type type1 = new TypeToken<User>(){}.getType();
                s_user = json.fromJson(response, type1);
            }


            if (s_user == null) {
                GUI.login_panel.clear();
                jFrame.repaint();
            } else {
                GUI.login_panel.clear();
                GUI.user_panel.remove(GUI.login_panel);
                if (GUI.signed_in_panel == null) {
                    GUI.signed_in_panel = new Signed_in_panel(s_user);
                    GUI.signed_in_panel.setBounds(0, 0, 300, 200);
                } else {
                    GUI.signed_in_panel.insert_user(s_user);
                }
                GUI.user_panel.add(GUI.signed_in_panel);
                if (Signed_in_panel.user.getStatus().equals("Moderator")) {
                    if (GUI.moderator_panel == null) {
                        GUI.moderator_panel = new Moderator_panel();
                    }
                    GUI.special_panel.add(GUI.moderator_panel);
                }
                else if (Signed_in_panel.user.getStatus().equals("Admin")) {
                    if (GUI.admin_panel == null) {
                        GUI.admin_panel = new Admin_panel();
                    }
                    GUI.special_panel.add(GUI.admin_panel);
                }
                jFrame.validate();
                jFrame.repaint();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logout() {
        Signed_in_panel.user = new User();
        GUI.user_panel.remove(GUI.signed_in_panel);
        GUI.user_panel.add(GUI.login_panel);
        GUI.special_panel.removeAll();
        jFrame.repaint();
        mainpage();
    }

    public static void register() {
        GUI.central_panel.removeAll();
        if (GUI.register_panel == null) {
            GUI.register_panel = new Register_panel();
            GUI.register_panel.setBounds(0, 0, 600, 400);
        }
        else {
            GUI.register_panel.clear();
        }
        GUI.central_panel.add(GUI.register_panel);
        jFrame.repaint();
    }

    public static int create_user(String login, String password) {
        int exists = 1;
        try {
            output.writeUTF("create_user");
            output.writeUTF(login);
            output.writeUTF(password);
            exists = input.read();

    } catch (IOException e) {
        e.printStackTrace();
    }
        if (exists == 0) {
            return 1;
        }
        return 0;
    }

    public static void bans() {
        //send parameters and get results
        try {
            GUI.central_panel.removeAll();
            output.writeUTF("bans");
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            String response = input.readUTF();
            Type type1 = new TypeToken<ArrayList<JoinedBan>>(){}.getType();
            ArrayList<JoinedBan> jbans = json.fromJson(response, type1);
            if (GUI.bans_view == null) {
                GUI.bans_view = new Bans_view_panel();
            }
            GUI.bans_view.Init(jbans);
            GUI.central_panel.add(GUI.bans_view);
            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create_ban(int UserID, int ModID, Date date, String reason) {
        try {
            output.writeUTF("create_ban");
            Date now = new Date();
            Ban ban = new Ban(UserID, now, date, ModID, reason);
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            output.writeUTF(json.toJson(ban));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void ban_panel() {
        try {
            GUI.central_panel.removeAll();
            output.writeUTF("users");
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            String response = input.readUTF();
            Type type1 = new TypeToken<ArrayList<User>>(){}.getType();
            ArrayList<User> users = json.fromJson(response,type1);
            if (GUI.ban_panel == null) {
                GUI.ban_panel = new Ban_panel();
            }
            GUI.ban_panel.Init(users, Signed_in_panel.user.getId());
            GUI.central_panel.add(GUI.ban_panel);
            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void edits() {
        try {
            GUI.central_panel.removeAll();
            output.writeUTF("edits");
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            String response = input.readUTF();
            Type type1 = new TypeToken<ArrayList<JoinedEdit>>(){}.getType();
            ArrayList<JoinedEdit> jedits = json.fromJson(response, type1);
            if (GUI.edit_view_panel == null) {
                GUI.edit_view_panel = new Edit_view_panel();
            }
            GUI.edit_view_panel.Init(jedits);
            GUI.central_panel.add(GUI.edit_view_panel);
            jFrame.validate();
            jFrame.repaint();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void delete_edit(int EditID) {
        try {
            output.writeUTF("delete_edit");
            output.write(EditID);
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            String response = input.readUTF();
            Type type1 = new TypeToken<ArrayList<JoinedEdit>>(){}.getType();
            ArrayList<JoinedEdit> jedits = json.fromJson(response, type1);
            GUI.edit_view_panel.Init(jedits);

            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void delete_ban(int BanID) {
        try {
            output.writeUTF("delete_ban");
            output.write(BanID);
            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void search(String request, int search_type) {
        try {
            GUI.central_panel.removeAll();
            //send parameters and get results
            output.writeUTF("search");
            output.writeUTF(request);
            output.write(search_type);
            //get number_of_objects from server
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            number_of_objects = input.read();
            String response = input.readUTF();
            Type type1 = new TypeToken<NShortItems>(){}.getType();
            NShortItems nsi = json.fromJson(response, type1);


            if (GUI.search_full_panel == null) {
                GUI.search_full_panel = new Search_Full_panel(nsi, number_of_objects);
            }
            else {
                GUI.search_full_panel.Init(nsi, number_of_objects);
            }
            GUI.central_panel.add(GUI.search_full_panel);
            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void search_nav_first() {
        if (Search_page.page != 0) {
            //send server 0
            //get nsi from server
            try {
                output.writeUTF("search_nav_first");
                Gson json = new GsonBuilder().setPrettyPrinting().create();
                String response = input.readUTF();
                Type type1 = new TypeToken<NShortItems>(){}.getType();
                NShortItems nsi = json.fromJson(response, type1);
                Search_page.page = 0;
                Search_Nav_Panel.page.setText(Integer.toString(Search_page.page + 1));
                if (GUI.search_full_panel == null) {
                    GUI.search_full_panel = new Search_Full_panel(nsi, number_of_objects);
                }
                else {
                    GUI.search_full_panel.SoftInit(nsi, number_of_objects);
                }
                jFrame.validate();
                jFrame.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void search_nav_prev() {
        if (Search_page.page != 0) {
            //send server (page - 1)
            //get nsi from server
            try {
                output.writeUTF("search_nav_prev");
                Gson json = new GsonBuilder().setPrettyPrinting().create();
                String response = input.readUTF();
                Type type1 = new TypeToken<NShortItems>(){}.getType();
                NShortItems nsi = json.fromJson(response, type1);
                Search_page.page -= 1;
                Search_Nav_Panel.page.setText(Integer.toString(Search_page.page + 1));
                if (GUI.search_full_panel == null) {
                    GUI.search_full_panel = new Search_Full_panel(nsi, number_of_objects);
                }
                else {
                    GUI.search_full_panel.SoftInit(nsi, number_of_objects);
                }
                jFrame.validate();
                jFrame.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void search_nav_next() {
        if (Search_page.page < (number_of_objects/NShortItems.N)) {
            //send server (page + 1)
            //get nsi from server
            try {
                output.writeUTF("search_nav_next");
                Gson json = new GsonBuilder().setPrettyPrinting().create();
                String response = input.readUTF();
                Type type1 = new TypeToken<NShortItems>(){}.getType();
                NShortItems nsi = json.fromJson(response, type1);
                Search_page.page += 1;
                Search_Nav_Panel.page.setText(Integer.toString(Search_page.page + 1));
                if (GUI.search_full_panel == null) {
                    GUI.search_full_panel = new Search_Full_panel(nsi, number_of_objects);
                }
                else {
                    GUI.search_full_panel.SoftInit(nsi, number_of_objects);
                }
                jFrame.validate();
                jFrame.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void search_nav_last() {
        if (Search_page.page < (number_of_objects/NShortItems.N)) {
            //send server number - number%n
            //get nsi from server
            try {
                output.writeUTF("search_nav_last");
                Gson json = new GsonBuilder().setPrettyPrinting().create();
                String response = input.readUTF();
                Type type1 = new TypeToken<NShortItems>(){}.getType();
                NShortItems nsi = json.fromJson(response, type1);
                Search_page.page = (number_of_objects/NShortItems.N);
                Search_Nav_Panel.page.setText(Integer.toString(Search_page.page + 1));
                if (GUI.search_full_panel == null) {
                    GUI.search_full_panel = new Search_Full_panel(nsi, number_of_objects);
                }
                else {
                    GUI.search_full_panel.SoftInit(nsi, number_of_objects);
                }
                jFrame.validate();
                jFrame.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void view(int number) {
        GUI.central_panel.removeAll();
        //send number, get FullItem
        try {
            output.writeUTF("fullitem");
            output.write(number);
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            String response = input.readUTF();
            Type type1 = new TypeToken<FullItem>(){}.getType();
            FullItem fitem = json.fromJson(response, type1);
            response = input.readUTF();
            Type type2 = new TypeToken<ArrayList<File>>(){}.getType();
            ArrayList<File> files = json.fromJson(response, type2);
            List<byte[]> file_list = new ArrayList<>();


            for (File fl : files) {
                String filename = fl.getName();
                String ext = (Optional.ofNullable(filename).filter(f -> f.contains("."))
                        .map(f -> f.substring(filename.lastIndexOf(".") + 1))).orElse("");
                switch (ext) {
                    case "jpg":{

                    }
                    case "bmp": {

                    }
                    case "png": {
                        byte[] buffer = new byte[100*1024];
                        String adress = "127.0.0.1";
                        InetAddress ip = null;
                        Socket socket = null;
                        DataOutputStream dos = null;
                        ip = InetAddress.getByName(adress);

                        socket = new Socket(ip, 4443);
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("load_file");
                        dos.writeUTF(fl.toPath().toString());

                        BufferedInputStream in =
                                new BufferedInputStream(socket.getInputStream());
                        File temp_dir = new File("src/main/resources/tmp");
                        File temp = new File(temp_dir + "/"+ filename);
                        temp.getParentFile().mkdirs();
                        temp.createNewFile();
                        BufferedOutputStream out =
                                new BufferedOutputStream(new FileOutputStream(temp));

                        int len = 0;
                        while ((len = in.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                            System.out.print("#");
                        }
                        in.close();
                        out.flush();
                        out.close();
                        socket.close();
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            if (GUI.item_panel == null) {
                GUI.item_panel = new Item_panel(fitem, files);
            }
            else {
                GUI.item_panel.Init(fitem, files);
            }
            GUI.central_panel.add(GUI.item_panel);
            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void add_media() {
        if (Signed_in_panel.user == null)
            Signed_in_panel.user = new User();
        if(Signed_in_panel.user.getStatus() == null)
            Signed_in_panel.user.setStatus("");
        if (Signed_in_panel.user.getStatus().equals("User")|| Signed_in_panel.user.getStatus().equals("Admin" )
                || Signed_in_panel.user.getStatus().equals("Moderator") ) {
            //send data to see bans
            try {
                output.writeUTF("check_for_bans");
                output.write(Signed_in_panel.user.getId());
                int banned = input.read();
                if (banned == 0) {
                    JFileChooser uploader = new JFileChooser();
                    uploader.setFileSelectionMode(JFileChooser.FILES_ONLY);

                    uploader.setDialogTitle("Upload file");

                    int approved = uploader.showSaveDialog(null);
                    if (approved == JFileChooser.APPROVE_OPTION) {
                        String url = uploader.getSelectedFile().toString();
                        byte[] buffer = new byte[100*1024];
                        String adress = "127.0.0.1";
                        InetAddress ip = null;
                        Socket socket = null;
                        DataOutputStream dos = null;
                        ip = InetAddress.getByName(adress);

                        socket = new Socket(ip, 4443);
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("upload_file");
                        dos.writeUTF(new File(url).getName());
                        dos.write(Signed_in_panel.user.getId());
                        dos.write(Item_panel.item.id);

                        BufferedInputStream in =
                                new BufferedInputStream(
                                        new FileInputStream(url));
                        BufferedOutputStream out =
                                new BufferedOutputStream(socket.getOutputStream());
                        int len = 0;
                        while ((len = in.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                            System.out.print("#");
                        }
                        in.close();
                        out.flush();
                        out.close();
                        dos.close();
                        socket.close();
                    }
                    view(Item_panel.item.id);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Доступ заблокирован");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Только авторизированные пользователи могут вносить правки");
        }

    }

    public static void delete_media(File file) {
        try {
            output.writeUTF("delete_media");
            output.writeUTF(file.toString());
            output.write(Signed_in_panel.user.getId());
            output.write(Item_panel.item.id);
            jFrame.validate();
            jFrame.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void edit(FullItem item, String EditType) {
        if (Signed_in_panel.user == null)
            Signed_in_panel.user = new User();
        if(Signed_in_panel.user.getStatus() == null)
            Signed_in_panel.user.setStatus("");
        if (Signed_in_panel.user.getStatus().equals("User")|| Signed_in_panel.user.getStatus().equals("Admin" )
                || Signed_in_panel.user.getStatus().equals("Moderator") ) {
            //send data to see bans
            try {
                output.writeUTF("check_for_bans");
                output.write(Signed_in_panel.user.getId());
                int banned = input.read();
                if (banned == 0) {
                    GUI.central_panel.removeAll();
                    if (item != null && EditType != null) {
                        Item item1 = new Item(item.Name, item.Type, item.Annotation, item.Parameters, item.Links, item.Lib);
                        if (GUI.edit_panel == null) {
                            GUI.edit_panel = new Edit_panel(item1, EditType);
                        } else {
                            GUI.edit_panel.Init(item1, EditType);
                        }
                        GUI.central_panel.add(GUI.edit_panel);
                        jFrame.validate();
                        jFrame.repaint();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Доступ заблокирован");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Только авторизированные пользователи могут вносить правки");
        }
    }

    public static void close_edit() {
        GUI.central_panel.removeAll();
        if (GUI.item_panel != null) {
            GUI.central_panel.add(GUI.item_panel);
        }
        jFrame.validate();
        jFrame.repaint();
    }

    public static void commit_edit(String name, String type, String edit) {
        //send and confirm
        try {
            output.writeUTF("commit_edit");
            output.writeUTF(name);
            output.writeUTF(type);
            output.writeUTF(edit);
            output.write(Signed_in_panel.user.getId());


            int accepted = input.read();
            if (accepted != 1) {
                JOptionPane.showMessageDialog(null, "Изменение отклонено");
            }
            else {
                GUI.central_panel.removeAll();
                if (GUI.item_panel != null) {
                    GUI.central_panel.add(GUI.item_panel);
                }

                if (type != null) {
                    switch (type) {
                        case "Тип": {
                            Item_panel.item.Type = edit;
                            Item_panel.type_label.setText("Тип: " + edit);
                            break;
                        }
                        case "Название": {
                            Item_panel.item.Name = edit;
                            Item_panel.name_label.setText(edit);
                            break;
                        }
                        case "Технические параметры": {
                            Item_panel.item.Parameters = edit;
                            Item_panel.param_textarea.setText(edit);
                            break;
                        }
                        case "Литература": {
                            Item_panel.item.Lib = edit;
                            Item_panel.lib_textarea.setText(edit);
                            break;
                        }
                        case "Ссылки": {
                            Item_panel.item.Links = edit;
                            Item_panel.links_textarea.setText(edit);
                            break;
                        }
                        case "Описание": {
                            Item_panel.item.Annotation = edit;
                            Item_panel.ann_textarea.setText(edit);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }

                jFrame.validate();
                jFrame.repaint();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void remove_keyword(FullItem item, String keyword, ArrayList<File> files) {
        if (GUI.signed_in_panel == null) {
            JOptionPane.showMessageDialog(null, "Не хватает привелегий");
        }
        else {
            if (Signed_in_panel.user.getStatus().equals("Admin" ) || Signed_in_panel.user.getStatus().equals("Moderator")) {
                //send to delete
                try {
                    output.writeUTF("delete_keyword");
                    output.write(item.id);
                    output.write(Signed_in_panel.user.getId());
                    output.writeUTF(keyword);

                    item.Delete_Keyword(keyword);
                    GUI.item_panel.Init(item, files);
                    jFrame.validate();
                    jFrame.repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Только пользователи с правами модератора и выше могут удалять ключевые слова.");
            }
        }
    }

    public static void add_keyword(FullItem item, ArrayList<File> files) {
        if (GUI.signed_in_panel == null) {
            JOptionPane.showMessageDialog(null, "Не хватает привелегий");
        }
        else {
            if (Signed_in_panel.user.getStatus().equals("Admin" ) || Signed_in_panel.user.getStatus().equals("Moderator")) {
                String new_keyword = JOptionPane.showInputDialog("Введите добавляемое ключевое слово");
                if (new_keyword.length() < 2) {
                    JOptionPane.showMessageDialog(null, "Слишком короткое ключевое слово");
                }
                else {
                    int exists = 0;
                    for (String keyword1 : item.Keywords) {
                        if (keyword1.equals(new_keyword)) {
                            exists = 1;
                            JOptionPane.showMessageDialog(null, "Такое ключевое слово уже существует");
                        }
                    }
                    if (exists == 0) {
                        //send to add
                        try {
                            output.writeUTF("add_keyword");
                            output.write(item.id);
                            output.write(Signed_in_panel.user.getId());
                            output.writeUTF(new_keyword);
                            item.Add_Keyword(new_keyword);
                            GUI.item_panel.Init(item, files);
                            jFrame.validate();
                            jFrame.repaint();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Только пользователи с правами модератора и выше могут удалять ключевые слова.");
            }
        }
    }

}
