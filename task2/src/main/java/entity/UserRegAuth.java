package entity;
import jakarta.persistence.*;
@Entity
@Table(name = "UserRegAuth")

public class UserRegAuth {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public UserRegAuth(String login, String password) {
//      this.id = id;
        this.login = login;
        this.password = password;
    }
}
