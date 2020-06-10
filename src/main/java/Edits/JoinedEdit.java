package Edits;

import Items.Item;
import Users.User;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Table(name = "Edits")
@Entity
public class JoinedEdit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private User Author;

    @ManyToOne
    @JoinColumn(name = "ItemID")
    private Item item;

    @Column (name = "Edit")
    private String Edit;

    @Column (name = "EditRow")
    private String Editrow;

    @Column (name = "EditDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EditDate;

    public JoinedEdit() {

    }

    public JoinedEdit(User Auth, Item item1, String edit, String editrow, Date editDate) {
        Author = Auth;
        item = item1;
        Edit = edit;
        editrow = editrow;
        EditDate = editDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User author) {
        Author = author;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getEdit() {
        return Edit;
    }

    public void setEdit(String edit) {
        Edit = edit;
    }

    public String getEditrow() {
        return Editrow;
    }

    public void setEditrow(String editrow) {
        Editrow = editrow;
    }

    public Date getEditDate() {
        return EditDate;
    }

    public void setEditDate(Date editDate) {
        EditDate = editDate;
    }
}
