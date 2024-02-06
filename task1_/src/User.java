import java.io.*;
import com.google.gson.Gson;

public class User {
    String Login;
    String Password;
    Integer Birthday;
    String Email;

    public User(String login, String password, Integer birthday, String email) {
        Login = login;
        Password = password;
        Birthday = birthday;
        Email = email;
    }


    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public Integer getBirthday() {
        return Birthday;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Login='" + Login + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }


}
