package Bans;

import Users.User;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Bans")
@Entity
public class JoinedBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column (name = "received")
    @Temporal(TemporalType.TIMESTAMP)
    private Date received;

    @Column (name = "expired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expired;

    @ManyToOne
    @JoinColumn (name = "moderator")
    private User moderator;

    @Column (name = "reason")
    private String reason;

    public JoinedBan() {
        id = 0;
        user = new User();
        received = new Date();
        expired = new Date();
        moderator = new User();
        reason = "";
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

    public User getModerator() {
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

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
