package Server;

import Bans.Ban;
import Items.FullItem;
import Items.Item;
import Items.Keywords;
import Items.NShortItems;
import Users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Socket_manager extends Thread {
    public Socket socket;
    public DataInputStream input;
    public DataOutputStream output;
    public ArrayList<Item> items;
    public int number_of_objects;
    public int page;

    public Socket_manager() {
        socket = null;
        input = null;
        output = null;
        items = new ArrayList<>();
    }

    public Socket_manager(Socket sock, DataInputStream dis, DataOutputStream dos) {
        socket = sock;
        input = dis;
        output = dos;
        items = new ArrayList<>();

    }

    public void run() {
        int works = 1;
        while (works ==1) {
            try {
                String request = input.readUTF();
                switch (request) {
                    case "kwords": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        String response = json.toJson(Server.m.getKeywords());
                        output.writeUTF(response);
                        break;
                    }
                    case "login": {
                        String login = input.readUTF();
                        String password = input.readUTF();
                        User user = Server.m.getUserbyLogPass(login,password);
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        if (user == null) {
                            output.writeUTF("null");
                        }
                        else {
                            output.writeUTF(json.toJson(user));
                        }
                        break;
                    }
                    case "bans": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        output.writeUTF(json.toJson(Server.m.getJoinedBans()));
                        break;
                    }
                    case "delete_ban": {
                        int BanID = input.read();
                        Server.m.DeleteBan(BanID);
                        break;
                    }
                    case "add_object": {
                        String name = input.readUTF();
                        String type = input.readUTF();
                        int unique = Server.m.InsertItem(name, type);
                        output.write(unique);
                        break;
                    }
                    case "fullitems": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        output.writeUTF(json.toJson(Server.m.getFullItems()));
                        break;
                    }
                    case "users": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        output.writeUTF(json.toJson(Server.m.getOnlyUsers()));
                        break;
                    }
                    case "moderators": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        output.writeUTF(json.toJson(Server.m.getOnlyMods()));
                        break;
                    }
                    case "demote": {
                        int ModID = input.read();
                        Server.m.DemoteModerator(ModID);
                        break;
                    }
                    case "promote": {
                        int ModID = input.read();
                        Server.m.PromoteModerator(ModID);
                        break;
                    }
                    case "delete_object": {
                        int ItemID = input.read();
                        Server.m.DeleteItem(ItemID);
                        break;
                    }
                    case "edits": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        output.writeUTF(json.toJson(Server.m.getJoinedEdits()));
                        break;
                    }
                    case "delete_edit": {
                        int EditID = input.read();
                        Server.m.DeleteEdit(EditID);
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        output.writeUTF(json.toJson(Server.m.getJoinedEdits()));
                        break;
                    }
                    case "create_ban": {
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        Type type1 = new TypeToken<Ban>(){}.getType();
                        String str = input.readUTF();
                        Ban ban = json.fromJson(str, type1);
                        Server.m.InsertBan(ban);

                        break;
                    }
                    case "search" : {
                        String search_request = input.readUTF();
                        int request_type = input.read();
                        switch (request_type) {
                            case 1: {
                                items = Server.m.SearchbyName(search_request);
                                break;
                            }
                            case 2: {
                                items = Server.m.SearchbyKeyword(search_request);
                                break;
                            }
                            case 3: {
                                items = Server.m.SearchbyType(search_request);
                                break;
                            }
                            default: {
                                items = new ArrayList<>();
                                break;
                            }
                        }
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        number_of_objects = items.size();
                        page = 0;
                        NShortItems nsi = new NShortItems(items, 0, number_of_objects);
                        output.write(number_of_objects);
                        output.writeUTF(json.toJson(nsi));

                        break;
                    }
                    case "create_user" : {
                        String login = input.readUTF();
                        String password = input.readUTF();
                        int exists = Server.m.userExists(login);
                        if (exists == 0) {
                            Server.m.InsertUser(login, password);
                        }
                        output.write(exists);
                        break;
                    }
                    case "search_nav_first" : {
                        page = 0;
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        NShortItems nsi = new NShortItems(items, 0, number_of_objects);
                        output.writeUTF(json.toJson(nsi));
                        break;
                    }
                    case "search_nav_prev" : {
                        page-=1;
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        NShortItems nsi = new NShortItems(items, NShortItems.N*(page), number_of_objects);
                        output.writeUTF(json.toJson(nsi));
                        break;
                    }
                    case "search_nav_next" : {
                        page +=1;
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        NShortItems nsi = new NShortItems(items, NShortItems.N*(page), number_of_objects);
                        output.writeUTF(json.toJson(nsi));
                        break;
                    }
                    case "search_nav_last" : {
                        page = number_of_objects/NShortItems.N;
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        NShortItems nsi = new NShortItems(items, NShortItems.N*(number_of_objects/NShortItems.N), number_of_objects);
                        output.writeUTF(json.toJson(nsi));
                        break;
                    }
                    case "fullitem" : {
                        int number = input.read();
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        Item target_item = items.get(number - 1);
                        FullItem fullItem = Server.m.getFullItembyID(target_item.getId());
//                        FullItem fullItem = new FullItem();
//                        fullItem.Fill_item(target_item);
//                        ArrayList<Keywords> keywords = Server.m.getKeywords();
//                        for (Keywords keyword: keywords) {
//                            if (keyword.getItemID() == fullItem.id) {
//                                fullItem.Add_Keyword(keyword.getKeyword());
//                            }
//                        }
                        ArrayList<File> files = Server.m.getMediabyIID(fullItem.getId());
                        output.writeUTF(json.toJson(fullItem));

                        output.writeUTF(json.toJson(files));

                        break;
                    }
                    case "delete_media": {
                        String response = input.readUTF();
                        int UserID = input.read();
                        int ItemID = input.read();
                        Server.m.DeleteMedia(ItemID, response);
                        Date now = new Date();
                        Server.m.InsertEdit(UserID, response+ " - deleted", ItemID, "Media", now);
                        break;
                    }
                    case "load_file": {
                        byte[] buffer = new byte[100*1024];

                        String file_req = input.readUTF();
                        BufferedInputStream in =
                            new BufferedInputStream(
                                    new FileInputStream(file_req));
                        BufferedOutputStream out =
                                new BufferedOutputStream(socket.getOutputStream());
                        int len = 0;
                        while ((len = in.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                        in.close();
                        out.flush();
                        out.close();
                        socket.close();
                        works = 0;
                        break;
                    }
                    case "upload_file": {
                        byte[] buffer = new byte[100*1024];
                        String filename = input.readUTF();
                        int uid = input.read();
                        int iid = input.read();
                        Item item = Server.m.getItembyID(iid);
                        String item_name = item.getName();
                        BufferedInputStream in =
                                new BufferedInputStream(socket.getInputStream());
                        File temp_dir = new File("src/main/resources/media");
                        File temp = new File(temp_dir + "/" + item.getId() + "/"+ filename);
                        System.out.println(temp.toString());
                        temp.getParentFile().mkdirs();
                        temp.createNewFile();
                        Server.m.InsertMedia(temp.toString(), iid);
                        Date now = new Date();
                        Server.m.InsertEdit(uid, temp.toString() + " - added", iid, "Media", now);
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
                        works = 0;
                        break;

                    }
//                    case "load_file": {
//                        String file_req = input.readUTF();
//
//                        byte[] file_arr = new byte[4096];
//                        FileInputStream fis = new FileInputStream(new File(file_req));
//                        BufferedInputStream bis = new BufferedInputStream(fis);
//                        DataInputStream file_dis = new DataInputStream(bis);
//
//                        int read;
//                        while ((read = file_dis.read(file_arr)) != -1) {
//                            output.write(file_arr, 0, read);
//                            break;
//                        }
//                        output.flush();
//                        socket.close();
//                        break;
//                    }
                    case "check_for_bans" : {
                        int user_id = input.read();
                        output.write(Server.m.CheckForBans(user_id));
                        break;
                    }
                    case "commit_edit" : {
                        String item_name = input.readUTF();
                        String type = input.readUTF();
                        String edit = input.readUTF();
                        int uid = input.read();
                        Date now = new Date();
                        String EditType;
                        switch (type) {
                            case "Тип": {
                                EditType = "Type";
                                break;
                            }
                            case "Название": {
                                EditType = "Name";
                                break;
                            }
                            case "Технические параметры" : {
                                EditType = "Parameters";
                                break;
                            }
                            case "Описание" : {
                                EditType = "Annotation";
                                break;
                            }
                            case "Ссылки": {
                                EditType = "Links";
                                break;
                            }
                            case "Литература": {
                                EditType = "Lib";
                                break;
                            }
                            default: {
                                EditType = "Error";
                                break;
                            }
                        }
                        int iid = Server.m.UpdateItem(item_name, EditType, edit);
                        Server.m.InsertEdit(uid, edit, iid, EditType, now);
                        int accepted = 1;
                        output.write(accepted);
                        break;
                    }
                    case "add_keyword" : {
//                        int item_id = input.read();
//                        int uid = input.read();
//                        String new_keyword = input.readUTF();
                        Gson json = new GsonBuilder().setPrettyPrinting().create();
                        Type type1 = new TypeToken<FullItem>(){}.getType();
                        String resp = input.readUTF();
                        FullItem item = json.fromJson(resp, type1);
                        int uid = input.read();
                        String new_keyword = input.readUTF();
                        Date now = new Date();
                        Server.m.AddKeyword(item);
                        Server.m.InsertEdit(uid, new_keyword + " - added", item.getId() , "Keyword", now);
                        break;
                    }
                    case "delete_keyword" : {
                        int iid = input.read();
                        int uid = input.read();
                        String deleted_keyword = input.readUTF();
                        Date now = new Date();
                        Server.m.DeleteKeyword(iid, deleted_keyword);
                        Server.m.InsertEdit(uid, deleted_keyword + " - deleted", iid, "Keyword", now);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } catch (IOException e) {
                works = 0;
                e.printStackTrace();
            }
        }

    }

}
