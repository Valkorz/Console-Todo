package com.behavior.json;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.lang.reflect.ParameterizedType;

/*
 * This class handles Json files. Uses keypairs to pair a key and a value of any type.
 */

public class JsonFile<T> {
    private String path;
    private ArrayList<KeyPair<T,Object>> elements;
    
    public JsonFile(String path){
        this.path = path;
        elements = new ArrayList<KeyPair<T,Object>>();
    }

    public void addElement(T key, Object value){
        
        boolean hasKey = false;
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).key == key){
                hasKey = true;
                System.out.println("Element " + key.toString() + " already exists.");
                break;
            }         
        }

        if(!hasKey){
            elements.add(new KeyPair<T,Object>(key, value));
        }
    }

    public void removeElement(T key){
        
        boolean foundKey = false;
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).key == key){
                foundKey = true;
                elements.remove(i);
                break;
            }         
        }

        if(!foundKey){
            System.out.println("Element " + key.toString() + " not found.");
        }
    }

    private String formatElement(KeyPair<T,Object> keyPair){
        return String.format("{\"%s\":%s}", keyPair.key, keyPair.value);
    }

    public void serialize(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            for(int i = 0; i < elements.size(); i++){
                writer.write(formatElement(elements.get(i)) + "\n");
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Saved data at " + path);
    }

    public static <T> JsonFile<T> deserialize(String path){
        
        JsonFile<T> json = new JsonFile<T>(path);

        try{
            List<String> lines = Files.readAllLines(Paths.get(path));
            System.out.println("Reading from file: " + path + "...");
            for(String line : lines){

                KeyPair<T,Object> pair = stringToKeyValue(line);
                json.addElement(pair.key, pair.value);

                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return json;
    }

    private static <T> KeyPair<T,Object> stringToKeyValue(String str){
        str = str.substring(1, str.length() -1);

        Class<T> typeofKey = (Class<T>) ((ParameterizedType) KeyPair.class.getGenericSuperclass()).getActualTypeArguments()[0];

        String[] keyValue = str.split(":");
        String cleanedKey = keyValue[0].trim().replace("\"", "");
        String cleanedValue = keyValue[1].trim();

        return new KeyPair<T,Object>(castGenericTo(cleanedKey, typeofKey), cleanedValue);     
    }

    private static <T> T castGenericTo(Object val, Class<T> type){
        if(type == String.class){
            return type.cast(val);
        }
        else if(type == Integer.class || type == int.class){
            return type.cast(Integer.parseInt(val.toString()));
        }
        else if(type == Double.class || type == double.class){
            return type.cast(Double.parseDouble(val.toString()));
        }
        else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}
