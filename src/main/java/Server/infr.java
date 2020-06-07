package Server;

import Bans.Ban;
import Edits.Edit;
import Items.FullItem;
import Items.Item;
import Items.Keywords;
import Items.Media;
import Users.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!  " + e);
            }
        }

    }


    public ArrayList<User> getUsers() {
        List<User> list = sessionFactory.openSession().createQuery("From User").list();
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

    public ArrayList<Keywords> getKeywords() {
        List<Keywords> list = sessionFactory.openSession().createQuery("From Keywords").list();
        ArrayList<Keywords> arr = new ArrayList<>(list.size());
        arr.addAll(list);
        return arr;
    }

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
        for (Keywords kword: kwords) {
            if (kword.getKeyword().toLowerCase().equals(keyword.toLowerCase())) {
                items.add((Item)sessionFactory.openSession().get(Item.class, kword.getItemID()));
            }
        }
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
        keyword.setItemID(iid);
        keyword.setKeyword(kword);
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


    public void DeleteKeyword(int itemID, String kword) {
        Query query = sessionFactory.openSession().createQuery("delete Keywords where Keyword = :word and ItemID = :iid");
        query.setParameter("word", kword);
        query.setParameter("iid", itemID);
        query.executeUpdate();

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

}
