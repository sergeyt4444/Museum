package Items;

import javax.persistence.*;

@Table(name = "Media")
@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "Media")
    private String media_path;

    @Column (name = "ItemID")
    private int item_id;

    public Media() {

    }

    public Media(String path, int id) {
        media_path = path;
        item_id = id;
    }

    public int getId() {
        return id;
    }

    public String getMedia_path() {
        return media_path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedia_path(String media_path) {
        this.media_path = media_path;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
