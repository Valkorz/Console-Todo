package com.root;
import java.util.LinkedList;
import com.content.Task;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
        File dataFile = new File(path + "dataFile.txt");

        try{
            if(dataFile.createNewFile()){
                System.out.println("File created: " + dataFile.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }   
    }

    public void LoadData(String path){
        File dataFile = new File(path + "dataFile.txt");

        try{
            Scanner fileReader = new Scanner(dataFile);
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                
            }
        }
        catch(IOException e){

        }
    }
    
}
