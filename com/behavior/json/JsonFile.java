package com.behavior.json;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class JsonFile {
    private String path;
    private KeyPair[] keyPairs;
    
    public JsonFile(String path, int size){
        this.path = path;
        keyPairs = new KeyPair[size];
    }

    public <T,G> void AddElement(T key, G value){
        
        Rearrange();
        boolean isArrayFull = false;
        
        //Go through each element of KeyPairs[]. If index is null (empty) or the key is the same, add element. Else increase size of array.
        for(int i = 0; i < keyPairs.length; i++){
        
            if(keyPairs[i] == null || keyPairs[i].key == key){
                keyPairs[i] = new KeyPair<T,G>(key, value);
                break;
            }
            isArrayFull = true;
        }
        
        if(isArrayFull){
            KeyPair[] newPairs = new KeyPair[keyPairs.length + 1];
            for(int i = 0; i < keyPairs.length; i++){
                newPairs[i] = keyPairs[i];
            }
            newPairs[newPairs.length - 1] = new KeyPair<T,G>(key, value);
            keyPairs = newPairs;
        }
    }

    public <T> void RemoveElement(T key){

        for(int i = 0; i < keyPairs.length; i++){
            if(keyPairs[i].key == key){
                keyPairs[i] = null;
                break;
            }
        }
        Rearrange();
    }

    public void Rearrange(){
        //Rearrange array so that it pushes null values to the end

        KeyPair[] newPairs = new KeyPair[keyPairs.length];
        int nullCount = 0;
        for(int i = 0; i < keyPairs.length; i++){
            if(keyPairs[i] == null){
                nullCount++;
            }
            else newPairs[i - nullCount] = keyPairs[i];
        }
        keyPairs = newPairs;
    }

    public int Count(){
        int count = 0;
        for(int i = 0; i < keyPairs.length; i++){
            if(keyPairs[i] != null) count++;
        }
        return count;
    }

    public <T> Object GetValueFromKey(T key){
        for(int i = 0; i < keyPairs.length; i++){
            if(keyPairs[i].key == key) return keyPairs[i].value;
        }
        System.out.println("Could not find any objects of key: " + key.toString());
        return null;
    }
}
