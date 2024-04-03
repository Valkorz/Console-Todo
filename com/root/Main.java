package com.root;

public abstract class mainClass{
    public static void main(String[] args){
        System.out.println("Test");
        byte[] b = new byte[256];
        try{
            System.in.read(b);
        }
        catch(Exception ex){
            System.out.println("exceptinon");
        }
    }
}