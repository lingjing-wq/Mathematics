package com.math.correction;

import java.util.ArrayList;

public class Key {
    public ArrayList<Integer> key;//存储答案
    public int index;

    public Key() {//构造方法
        key = new ArrayList<Integer>();//初始化
        index = 0;
    }
    public void reset() {//重置答案
        index = 0;
    }
    public boolean add(int a) {
        return key.add(a);
    }
    public int next() {
        if(index<key.size()) {
            return key.get(index++);
        }
        else {
            return -1;
        }
    }

}
