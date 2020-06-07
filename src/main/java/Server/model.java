package Server;

import Bans.Ban;
import Edits.Edit;
import Items.FullItem;
import Items.Item;
import Items.Keywords;
import Items.Media;
import Users.User;

import java.util.ArrayList;
import java.util.Date;

public class model {

    infr inf = new infr();

    public ArrayList<User> getUsers() {
        return inf.getUsers();
    }

    public ArrayList<Ban> getBans() {
        return inf.getBans();
    }

    public ArrayList<Item> getItems() {
        return inf.getItems();
    }

    public ArrayList<Keywords> getKeywords() {
        return inf.getKeywords();
    }

    public ArrayList<Media> getMedia() {
        return inf.getMedia();
    }

    public ArrayList<Edit> getEdits() {
        return inf.getEdits();
    }

    public User getUserbyLogPass(String login, String password) {
        return inf.getUserbyLogPass(login, password);
    }

    public int userExists(String login) {
        return inf.userExists(login);
    }

    public void InsertUser(String login, String password) {
        inf.InsertUser(login,password);
    }

    public ArrayList<FullItem> getFullItems() {
        ArrayList<Item> items = getItems();
        ArrayList<Keywords> keywords = getKeywords();
        ArrayList<FullItem> fullitems = new ArrayList<>();
        for (Item item: items) {
            FullItem fi = new FullItem();
            fi.Fill_item(item);
            for (Keywords keyword: keywords) {
                if (keyword.getItemID() == fi.id) {
                    fi.Add_Keyword(keyword.getKeyword());
                }
            }
            fullitems.add(fi);
        }
        return fullitems;
    }

    public ArrayList<Item> SearchbyName(String search_req) {
        return inf.SearchbyName(search_req);
    }

    public ArrayList<Item> SearchbyType(String search_req) {
        return inf.SearchbyType(search_req);
    }

    public ArrayList<Item> SearchbyKeyword(String search_req) {
        return inf.SearchbyKeyword(search_req);
    }

    public int CheckForBans(int uid) {
        return inf.CheckForBans(uid);
    }

    public void InsertKeyword(int iid, String kword) {
        inf.InsertKeyword(iid, kword);
    }

    public void DeleteKeyword(int ItemID, String kword) {
        inf.DeleteKeyword(ItemID, kword);
    }

    public int UpdateItem(String itemName, String editType, String edit) {
        return inf.UpdateItem(itemName, editType, edit);
    }

    public void InsertEdit(int aid, String editText, int iid, String editRow, Date date) {
        inf.InsertEdit(aid, editText, iid, editRow, date);
    }
}