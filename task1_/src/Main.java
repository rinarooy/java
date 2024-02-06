import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        Scanner in = new Scanner(System.in);
        boolean ex = true;
        ServiceUser sU = new ServiceUser(new JDBCPostgres());
        String num;
        while (ex){
            System.out.println("Введите команду");
            if ((num = in.nextLine()).equals("exit")){
                ex=false;
            }

            switch (num) {
                case "signUp" -> {
                    System.out.println("Введите логин:");
                    String log = in.next();
                    System.out.println("Введите пароль:");
                    String password = in.next();
                    System.out.println("Введите год рождения:");
                    Integer bday = Integer.valueOf(in.next());
                    System.out.println("Введите почту:");
                    String email = in.next();
                    System.out.println(sU.signUp(log, password, bday, email));
                }
                case "signIn" -> {
                    System.out.println("Введите логин:");
                    String login = in.next();
                    System.out.println("Введите пароль:");
                    String pass = in.next();
                    System.out.println(sU.signIn(login, pass));
                }
                default -> System.out.println("Такой команды не cуществует");
            }
        }

    }

}