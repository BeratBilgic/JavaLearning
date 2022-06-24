package com.company;

import java.util.Arrays;

public class MyList<T> {
    T[] arr;

    public MyList(){
        this.arr = (T[]) new Object[10];
    }

    public MyList(int capacity){
        this.arr = (T[]) new Object[capacity];
    }

    public int size(){
        int counter = 0;
        for (T i: arr) {
            if (i != null){
                counter++;
            }
        }
        return counter;
    }

    public int getCapacity(){
        return arr.length;
    }

    public void add(T data){
        if (size() != getCapacity()){
            arr[size()] = data;
        }else{
            arr = Arrays.copyOf(arr, arr.length*2);
            arr[arr.length/2] = data;
        }
    }

    public T get(int index){
        if(index >= 0 && index < size()) {
            return this.arr[index];
        }
        else {
            return null;
        }
    }

    public T remove(int index){
        T data;
        if (index >= 0 && index < size()){
            data = arr[index];
            for (int i = index; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            return data;
        }else{
            return null;
        }
    }

    public T set(int index, T data){
        if(index >= 0 && index < size()) {
            return arr[index]=data;
        }else {
            return null;
        }
    }

    public String toString(){
        if(size() > 0){
            StringBuilder str = new StringBuilder("[");
            for (int i = 0; i < size(); i++) {
                if (i == size() -1 ){
                    str.append(arr[i]).append("]");
                }else{
                    str.append(arr[i]).append(",");
                }
            }
            return str.toString();
        }
        return "[]";
    }

    public int indexOf(T data){
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (arr[i] == data){
                index = i;
                return index;
            }
        }
        return index;
    }

    public int lastIndexOf(T data) {
        int index = -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (arr[i] == data) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T[] toArray(){
        return Arrays.copyOf(arr,size());
    }

    public void clear(){
        this.arr = (T[]) new Object[10];
    }

    public MyList<T> subList(int start,int finish){
        MyList<T> newList = new MyList();
        for (int i = start; i <= finish; i++) {
            newList.add(arr[i]);
        }
        return newList;
    }

    public boolean contains(T data){
        if (indexOf(data) == -1){
            return false;
        }
        return true;
    }
}
