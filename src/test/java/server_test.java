import Bans.Ban;
import Bans.JoinedBan;
import Edits.Edit;
import Items.FullItem;
import Items.Item;
import Items.Keywords;
import Items.Media;
import Server.BModel;
import Server.model;
import Users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.TimeZone;

public class server_test {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));

        model m = BModel.build();
        ArrayList<User> user_list = m.getUsers();
        ArrayList<Item> item_list = m.getItems();
        ArrayList<Ban> ban_list = m.getBans();
        ArrayList<Keywords> keyword_list = m.getKeywords();
        ArrayList<Media> media_list = m.getMedia();
        ArrayList<FullItem> fullItems = m.getFullItems();
        ArrayList<Edit> edit_list = m.getEdits();
        ArrayList<JoinedBan> jbans = m.getJoinedBans();

        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String test = json.toJson(user_list);
        System.out.println(test);
        test = json.toJson(item_list);
        System.out.println(test);
        test = json.toJson(ban_list);
        System.out.println(test);
        test = json.toJson(keyword_list);
        System.out.println(test);
        test = json.toJson(media_list);
        System.out.println(test);
        test = json.toJson(fullItems);
        System.out.println(test);
        test = json.toJson(edit_list);
        System.out.println(test);
        test = json.toJson(jbans);
        System.out.println(test);

        User us = m.getUserbyLogPass("Admin", "Admin");
        test = json.toJson(us);
        System.out.println(test);





    }

}

