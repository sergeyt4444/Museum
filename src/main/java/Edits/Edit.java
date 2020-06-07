package Edits;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Table(name = "Edits")
@Entity
public class Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "AuthorID")
    private int AuthorID;

    @Column (name = "ItemID")
    private int ItemID;

    @Column (name = "Edit")
    private String Edit;

    @Column (name = "EditRow")
    private String Editrow;

    @Column (name = "EditDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EditDate;

    public Edit() {

    }

    public Edit(int AID, int IID, String edit, String editrow, Date editDate) {
        AuthorID = AID;
        ItemID = IID;
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

    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int authorID) {
        AuthorID = authorID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
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
