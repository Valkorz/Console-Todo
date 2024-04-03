package com.behavior.json;

public class KeyPair<T, G> {
    public T key;
    public G value;
    public KeyPair(T key, G value){
        this.key = key;
        this.value = value;
    }
}
