package com.leetcode.array;

import java.util.Arrays;

public class GenericArrayAhu<T> {
    private T[] data;
    private int size;

    public GenericArrayAhu(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArrayAhu() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T e) {
        for (T t : data) {
            if (t.equals(e))
                return true;
        }
        return false;
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public void add(int index, T e) {
        checkIndexForAdd(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (size == data.length) {
            resize(2 * data.length);
        }

        //index后面的元素后移,倒序
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public T remove(int index) {
        checkIndex(index);


        T e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        //resize
        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }


        return e;
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    private void resize(int i) {
        T[] newdata = (T[]) new Object[i];
        for (int j = 0; j < size; j++) {
            newdata[j] = data[j];
        }
        data = newdata;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));

        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
