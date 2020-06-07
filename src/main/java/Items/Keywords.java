package Items;

import javax.persistence.*;

@Table (name = "Keywords",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ItemID", "Keyword"})})
@Entity
public class Keywords {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "ItemID")
    private int ItemID;

    @Column (name = "Keyword")
    private String Keyword;

    public Keywords() {

    }

    public Keywords(int itemID, String keyword) {
        if(itemID > 0 && keyword != null) {
            ItemID = itemID;
            Keyword = keyword;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public int getItemID() {
        return ItemID;
    }

    public String getKeyword() {
        return Keyword;
    }
}
