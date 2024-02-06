import java.util.LinkedList;

public class ServiceUser {

    UserDUO userDUO;
    public ServiceUser(UserDUO userDUO){
        this.userDUO = userDUO;
    }
    public boolean signUp(String login, String pass, Integer birthday, String email) {
        LinkedList<User> userb = userDUO.takeList();

        for (User item: userb)
                if (login.equals(item.Login)){
                    return false;
                }
        userDUO.writeList(new User(login, pass, birthday, email));
        return true;
    }

    public boolean signIn(String login, String pass) {
        LinkedList<User> userb = userDUO.takeList();
        for (User item: userb)
            if (login.equals(item.Login) && pass.equals(item.Password)){
                return true;
            }
        return false;
    }
}
