package Items;

import java.util.ArrayList;

public class FullItem {

    public int id;
    public String Name;
    public String Type;
    public String Annotation;
    public String Parameters;
    public String Links;
    public String Lib;
    public ArrayList<String> Keywords;

    public FullItem() {
        Keywords = new ArrayList<>();
    }

    public void Fill_item(Item item) {
        id = item.getId();
        Name = item.getName();
        Type = item.getType();
        Annotation = item.getAnnotation();
        Parameters = item.getParameters();
        Links = item.getLinks();
        Lib = item.getLib();
    }

    public void Fill_Keywords(ArrayList<String> kwords) {
        Keywords = kwords;
    }

    public void Add_Keyword(String str) {
        Keywords.add(str);
    }

    public void Delete_Keyword(String str) {
        for (String string : Keywords) {
            if (str == string) {
                Keywords.remove(string);
            }
        }
    }

}
