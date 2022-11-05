package com.math.equation;

import org.junit.Test;

public class operationBase {
    public static final int UPPER=100;
    public static final int LOWER=0;
    public int count=0;
    MyMap<Integer,Equation> map=new MyMap();



    public MyMap<Integer,Equation> addBase() {
        for (int i = 0; i <= UPPER; i++) {
            for (int j = 0; j <= UPPER; j++) {
                if (i + j <= UPPER) {
                    Equation equation = new Equation(i, '+',j, (i + j));
                    map.put(count, equation);//加法：[0,5150]
                    count++;
                }
            }
        }
        for (int i = 0; i <= UPPER; i++) {
            for (int j = 0; j <= UPPER; j++) {
                if (i - j >=LOWER) {
                    Equation equation = new Equation(i,'-', j, (i - j));
                    map.put(count, equation);//减法：[5151,10301]
                    count++;
                }
            }
        }
        return map;
    }

}

