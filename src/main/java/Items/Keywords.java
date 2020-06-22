package Items;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table (name = "Collections")
@Entity
public class Keywords {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "Collection")
    private String Collection;

    @Column (name = "left")
    private double left;

    @Column (name = "right")
    private double right;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Items_Collections",
            joinColumns = { @JoinColumn(name = "KeywordID") },
            inverseJoinColumns = { @JoinColumn(name = "ItemID") }
    )
    private transient List<FullItem> items = new ArrayList<>();


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCollection() {
        return Collection;
    }

    public void setCollection(String collection) {
        Collection = collection;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public ArrayList<FullItem> getItems() {
        return (ArrayList<FullItem>) items;
    }

    public void setItems(ArrayList<FullItem> items) {
        this.items = items;
    }

    public String toString() {
        return Collection;
    }
}
