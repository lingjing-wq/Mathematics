package com.math.correction;

import java.util.ArrayList;

public class Key {
    public ArrayList<Integer> key;//�洢��
    public int index;

    public Key() {//���췽��
        key = new ArrayList<Integer>();//��ʼ��
        index = 0;
    }
    public void reset() {//���ô�
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
