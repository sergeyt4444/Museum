package Server;

import Bans.Ban;
import Bans.JoinedBan;
import Edits.Edit;
import Edits.JoinedEdit;
import Items.FullItem;
import Items.Item;
import Items.Keywords;
import Items.Media;
import Users.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class infr {

    private SessionFactory sessionFactory;

    public infr() {getSessionFactory();}

    public void getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().
                        //        configure("/hibernate.cfg.xml");
                                configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Ban.class);
                configuration.addAnnotatedClass(Item.class);
                configuration.addAnnotatedClass(Keywords.class);
                configuration.addAnnotatedClass(Media.class);
                configuration.addAnnotatedClass(Edit.class);
                configuration.addAnnotatedClass(JoinedBan.class);
                configuration.addAnnotatedClass(JoinedEdit.class);
                configuration.addAnnotatedClass(FullItem.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!  " + e);
            }
        }

    }

    public ArrayList<Keywords> getKeywords() {
        List<Keywords> list = sessionFactory.openSession().createQuery("From Keywords").list();
        ArrayList<Keywords> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }


    public ArrayList<User> getUsers() {
        List<User> list = sessionFactory.openSession().createQuery("From User").list();
        ArrayList<User> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<User> getOnlyUsers() {
        List<User> list = sessionFactory.openSession().createQuery("From User where status = 'User'").list();
        ArrayList<User> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<User> getOnlyMods() {
        List<User> list = sessionFactory.openSession().createQuery("From User where status = 'Moderator'").list();
        ArrayList<User> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<Item> getItems() {
        List<Item> list = sessionFactory.openSession().createQuery("From Item").list();
        ArrayList<Item> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public Item getItembyID(int ItemID) {
        Session session = sessionFactory.openSession();
        Item item = (Item) session.get(Item.class, ItemID);
        session.close();
        return item;
    }

//    public ArrayList<Keywords> getKeywords() {
//        List<Keywords> list = sessionFactory.openSession().createQuery("From Keywords").list();
//        ArrayList<Keywords> arr = new ArrayList<>(list.size());
//        arr.addAll(list);
//        return arr;
//    }

    public ArrayList<Ban> getBans() {
        List<Ban> list = sessionFactory.openSession().createQuery("From Ban").list();
        ArrayList<Ban> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<Media> getMedia() {
        List<Media> list = sessionFactory.openSession().createQuery("From Media").list();
        ArrayList<Media> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<Edit> getEdits() {
        List<Edit> list = sessionFactory.openSession().createQuery("From Edit").list();
        ArrayList<Edit> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<FullItem> getFullItems() {
        List<FullItem> list = sessionFactory.openSession().createQuery("From FullItem").list();
        ArrayList<FullItem> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public FullItem getFullItembyID(int ItemID) {
        Session session = sessionFactory.openSession();
        FullItem item = (FullItem) session.get(FullItem.class, ItemID);
        session.close();
        return item;
    }

    public ArrayList<Media> getMediabyIID(int item_id) {
        Query query = sessionFactory.openSession().createQuery("From Media where ItemID = :iid");
        query.setParameter("iid", item_id);
        List<Media> list = query.list();
        ArrayList<Media> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public User getUserbyLogPass(String login, String password) {
//        List<User> list = sessionFactory.openSession().createQuery("From User where login = :log and password = :pass").list();
        Query query = sessionFactory.openSession().createQuery("From User where login = :log and password = :pass");
        query.setParameter("log", login);
        query.setParameter("pass", password);
        List<User> list = query.list();
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    public int userExists(String login) {
        Query query = sessionFactory.openSession().createQuery("From User where login = :log");
        query.setParameter("log", login);
        List<User> list = query.list();
        if (list.isEmpty())
            return 0;
        return 1;
    }

    public void InsertUser(String login, String password) {
        User user = new User(login, password, "User");
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public ArrayList<Item> SearchbyName(String name) {
        Query query = sessionFactory.openSession().createQuery("From Item where Name like :name");
        query.setParameter("name", "%" + name + "%");
        List<Item> items = query.list();
        ArrayList<Item> arr = new ArrayList<>(items.size());
        arr.addAll(items);
        return arr;
    }

    public ArrayList<Item> SearchbyType(String type) {
//        Query query = sessionFactory.openSession().createQuery("From Item where Type = :type");
//        query.setParameter("type", type);
//        List<Item> items = query.list();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Item.class);
        criteria.add(Restrictions.ilike("Type", type, MatchMode.ANYWHERE));
        List<Item> items = criteria.list();
        ArrayList<Item> arr = new ArrayList<>(items.size());
        arr.addAll(items);
        return arr;
    }

    public ArrayList<Item> SearchbyKeyword( String keyword) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Keywords.class);
        criteria.add(Restrictions.ilike("Keyword", keyword, MatchMode.ANYWHERE));
//        Query query = sessionFactory.openSession().createQuery("From Keywords where Keyword = :kword");
//        query.setParameter("kword", keyword);
//        List<Keywords> kwords = query.list();
        List<Keywords> kwords = criteria.list();
        System.out.println(kwords.size());
        ArrayList<Item> items = new ArrayList<>();
//        for (Keywords kword: kwords) {
//            if (kword.getKeyword().toLowerCase().equals(keyword.toLowerCase())) {
//                items.add((Item)sessionFactory.openSession().get(Item.class, kword.getItemID()));
//            }
//        }
        return items;
    }

    public int CheckForBans(int uid) {
        Date now = new Date();
        Query query = sessionFactory.openSession().createQuery("From Ban where UserID = :uid");
        query.setParameter("uid", uid);
        List<Ban> list = query.list();
        System.out.println(list.size());
        int isBanned = 0;
        for (Ban ban : list) {
            if (now.after(ban.getRecieved()) && now.before(ban.getExpired())) {
                isBanned = 1;
                break;
            }
        }
        return isBanned;
    }

    public void InsertKeyword(int iid, String kword) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Keywords keyword = new Keywords();
//        keyword.setItemID(iid);
//        keyword.setKeyword(kword);
        session.save(keyword);
        tx1.commit();
        session.close();

    }

    public void InsertEdit(int aid, String editText, int iid, String editRow, Date date) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Edit edit = new Edit();
        edit.setAuthorID(aid);
        edit.setItemID(iid);
        edit.setEdit(editText);
        edit.setEditrow(editRow);
        edit.setEditDate(date);
        session.save(edit);
        tx1.commit();
        session.close();
    }

    public void InsertMedia(String med_path, int iid) {
        Media media = new Media(med_path, iid);
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(media);
        tx1.commit();
        session.close();
    }

    public void DeleteEdit(int EditID) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Edit edit = (Edit)session.get(Edit.class, EditID);
        tx1.commit();
        if (edit.getEditrow().equals("Keyword")) {
            String edit_string = edit.getEdit();
            int separator = edit_string.lastIndexOf(" - added");
            if (separator != -1) {
                String edit_body = edit_string.substring(0,separator);
//                Server.m.DeleteMedia(edit.getItemID(), edit_body);
                Server.m.DeleteKeyword(edit.getItemID(), edit_body);
                Transaction tx2 = session.beginTransaction();
                session.delete(edit);
                tx2.commit();
            }
            else {
                separator = edit_string.lastIndexOf(" - deleted");
                if (separator != -1) {
                    String edit_body = edit_string.substring(0,separator);
  //                      Server.m.InsertMedia(edit_body, edit.getItemID());
                    FullItem item = Server.m.getFullItembyID(edit.getItemID());
                    Keywords kword = new Keywords();
                    ArrayList<Keywords> keywords = Server.m.getKeywords();
                    for (Keywords kw: keywords) {
                        if (kw.getCollection().equals(edit_body)) {
                            kword = kw;
                        }
                    }
                    item.Add_Keyword(kword);
                    Server.m.AddKeyword(item);
                    Transaction tx2 = session.beginTransaction();
                    session.delete(edit);
                    tx2.commit();
                }
            }
        }
        else
            if (edit.getEditrow().equals("Media")) {
                String edit_string = edit.getEdit();
                int separator = edit_string.lastIndexOf(" - added");
                if (separator != -1) {
                    String edit_body = edit_string.substring(0,separator);
                    Server.m.DeleteMedia(edit.getItemID(), edit_body);
                    Transaction tx2 = session.beginTransaction();
                    session.delete(edit);
                    tx2.commit();
                }
                else {
                    separator = edit_string.lastIndexOf(" - deleted");
                    if (separator != -1) {
                        String edit_body = edit_string.substring(0,separator);
                        File file = new File(edit_body);
                        if (file.isFile() == true) {
                            Server.m.InsertMedia(edit_body, edit.getItemID());
                            Transaction tx2 = session.beginTransaction();
                            session.delete(edit);
                            tx2.commit();
                        }

                    }
                }

        }
            else {
                Query query = session.createQuery("From Edit where ItemID = :iid and EditRow = :erow and EditDate >= :edate");
                query.setParameter("iid", edit.getItemID());
                query.setParameter("erow", edit.getEditrow());
                query.setParameter("edate", edit.getEditDate());
                List<Edit> list = query.list();
                for (Edit edit1: list) {
                    Transaction tx2 = session.beginTransaction();
                    session.delete(edit1);
                    tx2.commit();
                }
                Transaction tx3 = session.beginTransaction();
                Item edited_item = (Item) session.get(Item.class, edit.getItemID());
                tx3.commit();
                Edit recent = (Edit) session.createCriteria(Edit.class)
                        .add(Restrictions.eq("Editrow", edit.getEditrow()))
                        .add(Restrictions.eq("ItemID", edit.getItemID()))
                        .addOrder(Order.desc("EditDate"))
                        .setMaxResults(1)
                        .uniqueResult();
                switch (edit.getEditrow()) {
                    case "Parameters": {
                        if (recent == null) {
                            edited_item.setParameters("");
                        }
                        else {
                            edited_item.setParameters(recent.getEdit());
                        }
                        break;
                    }
                    case "Lib": {
                        if (recent == null) {
                            edited_item.setLib("");
                        }
                        else {
                            edited_item.setLib(recent.getEdit());
                        }
                        break;
                    }
                    case "Links": {
                        if (recent == null) {
                            edited_item.setLinks("");
                        }
                        else {
                            edited_item.setLinks(recent.getEdit());
                        }
                        break;
                    }
                    case "Annotation": {
                        if (recent == null) {
                            edited_item.setAnnotation("");
                        }
                        else {
                            edited_item.setAnnotation(recent.getEdit());
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
                Transaction tx4 = session.beginTransaction();
                session.update(edited_item);
                tx4.commit();
        }

        session.close();

    }

    public void InsertBan(Ban ban) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(ban);
        tx1.commit();
        session.close();
    }

    public void DeleteKeyword(int itemID, String kword) {
        FullItem item = getFullItembyID(itemID);
        item.Delete_Keyword(kword);
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(item);
        tx1.commit();
        session.close();
    }

    public void AddKeyword(FullItem item) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(item);
        tx1.commit();
        session.close();
    }

    public void DeleteBan(int banID) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Ban ban = (Ban)session.load(Ban.class, banID);
        session.delete(ban);
        tx1.commit();
        session.close();
    }

    public void DemoteModerator(int ModID) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        User demoted = (User)session.load(User.class, ModID);
        demoted.setStatus("User");
        session.update(demoted);
        tx1.commit();
        session.close();
    }

    public void PromoteModerator(int ModID) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        User demoted = (User)session.load(User.class, ModID);
        demoted.setStatus("Moderator");
        session.update(demoted);
        tx1.commit();
        session.close();
    }

    public int InsertItem(String name, String type) {
        Query query = sessionFactory.openSession().createQuery("From Item where Name = :name");
        query.setParameter("name", name);
        List<User> list = query.list();
        if (list.isEmpty()) {
            Item item = new Item();
            item.setName(name);
            item.setType(type);
            Session session = sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(item);
            tx1.commit();
            session.close();
            return 1;
        }
        return 0;
    }

    public void DeleteMedia(int iid, String file) {
        Query query = sessionFactory.openSession().createQuery("From Media where item_id = :iid and media_path = :file");
        query.setParameter("iid", iid);
        query.setParameter("file", file);
        if (!(query.list().isEmpty())) {
            Media media = (Media) query.list().get(0);
            Session session = sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(media);
            tx1.commit();
            session.close();
        }
    }

    public int UpdateItem(String itemName, String editType, String edit) {
        Query query = sessionFactory.openSession().createQuery("From Item where Name = :name");
        query.setParameter("name", itemName);
        Item item = (Item)query.list().get(0);
        if (item != null) {
            switch (editType) {
                case "Name": {
                    item.setName(edit);
                    break;
                }
                case "Type": {
                    item.setType(edit);
                    break;
                }
                case "Annotation": {
                    item.setAnnotation(edit);
                    break;
                }
                case "Parameters": {
                    item.setParameters(edit);
                    break;
                }
                case "Links": {
                    item.setLinks(edit);
                    break;
                }
                case "Lib": {
                    item.setLib(edit);
                    break;
                }
            }
            Session session = sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(item);
            tx1.commit();
            session.close();
            return item.getId();
        }
        return -1;
    }

    public ArrayList<JoinedBan> getJoinedBans() {
        List<JoinedBan> list = sessionFactory.openSession().createQuery("From JoinedBan").list();
        ArrayList<JoinedBan> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

    public ArrayList<JoinedEdit> getJoinedEdits() {
        List<JoinedEdit> list = sessionFactory.openSession().createQuery("From JoinedEdit").list();
        ArrayList<JoinedEdit> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

}
