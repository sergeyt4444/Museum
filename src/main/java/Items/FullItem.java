package Items;


import javax.persistence.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "Items")
@Entity
public class FullItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "Name", unique = true)
    private String Name;

    @Column (name = "Type")
    private String Type;

    @Column (name = "Annotation")
    private String Annotation;

    @Column (name = "Parameters")
    private String Parameters;

    @Column (name = "Links")
    private String Links;

    @Column (name = "Lib")
    private String Lib;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Items_Collections",
            joinColumns = { @JoinColumn(name = "ItemID") },
            inverseJoinColumns = { @JoinColumn(name = "KeywordID") }
    )
    private List<Keywords> Kwords;

    public FullItem() {
        Kwords = new ArrayList<>();
    }

    public FullItem(int ItemID, String name, String type, String annotation, String param, String links, String lib, ArrayList<Keywords> keywords) {
        id = ItemID;
        Name = name;
        Type = type;
        Annotation = annotation;
        Parameters = param;
        Links = links;
        Lib = lib;
        if (keywords==null) {
            Kwords = new ArrayList<>();
        }
        else {
           Kwords = keywords;
        }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAnnotation() {
        return Annotation;
    }

    public void setAnnotation(String annotation) {
        Annotation = annotation;
    }

    public String getParameters() {
        return Parameters;
    }

    public void setParameters(String parameters) {
        Parameters = parameters;
    }

    public String getLinks() {
        return Links;
    }

    public void setLinks(String links) {
        Links = links;
    }

    public String getLib() {
        return Lib;
    }

    public void setLib(String lib) {
        Lib = lib;
    }

    public ArrayList<Keywords> getKwords() {
        return (ArrayList<Keywords>) Kwords;
    }

    public void setKwords(ArrayList<Keywords> kwords) {
        Kwords = kwords;
    }

    public void Delete_Keyword(String kword) {
        Keywords kword_del = null;
        for (Keywords kw : Kwords) {
            if (kw.getCollection().equals(kword)) {
                kword_del = kw;
            }
        }
        if (kword_del != null) {
            Kwords.remove(kword_del);
        }
    }

    public void Add_Keyword(Keywords kword) {
        Kwords.add(kword);
    }

    public String toString() {
        return Name;
    }
}
