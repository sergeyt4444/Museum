package Bans;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Bans")
@Entity
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "UserID")
    private int UserID;

    @Column (name = "received")
    @Temporal(TemporalType.TIMESTAMP)
    private Date received;

    @Column (name = "expired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expired;

    @Column (name = "moderator")
    private int moderator;

    @Column (name = "reason")
    private String reason;

    public Ban() {

    }

    public Ban(int uid, Date rec, Date exp, int mod, String reasn) {
        UserID = uid;
        received = rec;
        expired = exp;
        moderator = mod;
        reason = reasn;
    }

    public int getId() {
        return id;
    }


    public Date getRecieved() {
        return received;
    }

    public Date getExpired() {
        return expired;
    }

    public int getModerator() {
        return moderator;
    }

    public String getReason() {
        return reason;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setRecieved(Date recieved) {
        this.received = recieved;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public void setModerator(int moderator) {
        this.moderator = moderator;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }
}
