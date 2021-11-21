package com.super404.Week1.LeeCode641;

public class MyCircularDeque {
    int[] circularDeque;
    int head=0;//当前需要赋值的头索引位置
    int tail=0;//当前值的尾索引位置
    int count=0;
    int capacity=0;


    public MyCircularDeque(int k) {
        this.circularDeque = new int[k];
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if(this.count == this.capacity){
            return false;
        }

        //先赋值，再改变索引位置
        this.circularDeque[this.head] = value;
        //防止head在0出越界
        this.head = (this.head - 1 + this.capacity)%this.capacity;
        this.count++;
        return true;
    }

    public boolean insertLast(int value) {
        if(this.count == this.capacity){
            return false;
        }
        //先改变索引位置，再赋值
        this.tail = (this.tail + 1)%this.capacity;
        this.circularDeque[this.tail] = value;
        this.count++;
        return true;
    }

    public boolean deleteFront() {
        if(this.count == 0){
            return false;
        }
        this.head = (this.head + 1)%this.capacity;
        this.count--;
        return true;
    }

    public boolean deleteLast() {
        if(this.count == 0){
            return false;
        }
        this.tail = (this.tail - 1  + this.capacity)%this.capacity;
        this.count--;
        return true;
    }

    public int getFront() {
        if(this.count == 0){
            return -1;
        }
        return this.circularDeque[(this.head+1)%this.capacity];
    }

    public int getRear() {
        if(this.count == 0){
            return -1;
        }
        return this.circularDeque[(this.tail)%this.capacity];
    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public boolean isFull() {
        return (this.count == this.capacity);
    }
}
