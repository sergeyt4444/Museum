package Users;

import javax.persistence.*;

@Table(name = "Users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "login", unique = true)
    private String login;

    @Column (name = "password")
    private String password;

    @Column (name = "status")
    private String status;

    public User() {
    }

    public User(String log, String pass, String stat) {
        login = log;
        password = pass;
        if ((stat == "User") || (stat == "Moderator") || (stat == "Admin")) {
            status = stat;
        }
        else {
            status = "User";
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return login;
    }
}
