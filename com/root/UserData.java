package com.root;
import com.behavior.json.*;
import java.util.LinkedList;
import com.content.Task;

public class UserData {
    public String name;
    private int points;
    public LinkedList<Task> tasks;

    public UserData(String name){
        this.name = name;
        tasks = new LinkedList<Task>();
    }

    public void AddPoints(int points){
        points += points;
    }

    public void SaveData(String path){
        JsonFile<String> file = new JsonFile<String>(path);
        file.addElement("Points", points);
        file.addElement("Name", name);
        file.addElement("tasks", tasks);
    }

    public void LoadData(String path){
        
    }
    
}
