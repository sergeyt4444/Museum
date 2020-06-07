package Items;


import javax.persistence.*;

@Table (name = "Items")
@Entity
public class Item {

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

    public Item() {

    }

    public Item(String name, String type, String annotation, String parameters, String links, String lib) {
        if (name != null && type != null) {
            Name = name;
            Type = type;
            Annotation = annotation;
            Parameters = parameters;
            Links = links;
            Lib = lib;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setAnnotation(String annotation) {
        Annotation = annotation;
    }

    public void setParameters(String parameters) {
        Parameters = parameters;
    }

    public void setLinks(String links) {
        Links = links;
    }

    public void setLib(String lib) {
        Lib = lib;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getAnnotation() {
        return Annotation;
    }

    public String getParameters() {
        return Parameters;
    }

    public String getLinks() {
        return Links;
    }

    public String getLib() {
        return Lib;
    }
}
