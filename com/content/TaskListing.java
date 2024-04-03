package com.content;
import com.behavior.DateTime;
import java.util.LinkedList;
import com.content.Task;

public abstract class TaskListing {
    public static LinkedList<Task> tasks = new LinkedList<Task>();

    public static void AddTask(Task task){
        boolean canAdd = true;
        for(int i = 0; i < tasks.size(); i++){
            if(i > 0 && tasks.get(i).name == tasks.get(i - 1).name){
                System.out.println("Could not add element " + task.toString() + "because a similar already exists.");
                canAdd = false;
                break;
            }
        }

        if(canAdd) tasks.add(task);
    }

    public static void UpdateTasks(){
        for(int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            if(task.completed == true){
                
            }
        }
    }
}
