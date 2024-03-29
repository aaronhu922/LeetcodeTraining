package com.leetcode.array;

import java.util.ArrayList;

/**
 * 1) ????????????????????
 * 2????????int????
 *
 * Author: Zheng
 * modify: xing, Gsealy
 */
public class Array {
    //??????data????
    public int data[];
    //??????
    private int n;
    //???????
    private int count;

    ArrayList arrayList = new ArrayList();

    //???????????
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count=0;//?????????????0
    }

    //????????????????
    public int find(int index){
        if (index<0 || index>=count) return -1;
        return data[index];
    }

    //????:?????????
    public boolean insert(int index, int value){
        //?????? 

        //if (index == count && count == 0) {
        //    data[index] = value;
        //    ++count;
        //    return true;
        //}

        // ??????
        if (count == n) {
            System.out.println("????????");
            return false;
        }
        // ??count?????????????????
        // ?????
        if (index < 0||index > count ) {
            System.out.println("?????");
            return false;
        }
        // ????
        for( int i = count; i > index; --i){
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }
    //????????????
    public boolean delete(int index){
        if (index<0 || index >=count) return false;
        //????????????????????
        for (int i=index+1; i<count; ++i){
            data[i-1] = data[i];
        }
        //????????  ??????????
        /*int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;*/

        --count;
        return true;
    }
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.insert(3, 11);
        array.printAll();
    }
}
