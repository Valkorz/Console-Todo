package com.content;
import com.behavior.DateTime;
import com.root.Main;

public class Task {
    public String name;
    public String description;
    public Difficulty difficulty;
    public DateTime deadline;
    public Boolean completed = false;
    public Boolean late = false;
    public int index; //Index inside the TaskListing list
    private int points;

    public enum Difficulty{
        easy,
        medium,
        hard;
    }

    public Task(String name, String description, Difficulty difficulty, DateTime deadline)
    {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.difficulty = difficulty;

        switch(difficulty){
            case Difficulty.easy:
                points = 2;
                break;
            case Difficulty.medium:
                points = 4;
                break;
            case Difficulty.hard:
                points = 6;
                break;
        }
    }

    public void Complete(){
        completed = true;
        Main.ActiveUser.AddPoints(points);
        TaskListing.UpdateTasks();
    }
}
