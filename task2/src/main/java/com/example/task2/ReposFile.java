package com.example.task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ReposFile implements UserDUO {

    public LinkedList<User> takeList(){
        Gson gson = new Gson();
        TypeToken<LinkedList<User>> linkedListType = new TypeToken<LinkedList<User>>(){};
        LinkedList<User> usersFromFile;

        try(BufferedReader br = new BufferedReader (new FileReader("C:\\Users\\ariro\\Downloads\\IdeaProjects\\task1_\\src\\text.txt"))) {
            usersFromFile = gson.fromJson(br.readLine(), linkedListType);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return usersFromFile;
    }
    public void writeList(User user){
        try(FileWriter fr = new FileWriter("C:\\Users\\ariro\\Downloads\\IdeaProjects\\task1_\\src\\text.txt", Boolean.TRUE))
        {
            Gson gson = new Gson();
            fr.write('\n' + gson.toJson(takeList().add(user)));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
