package com.math.exercise;
import com.math.equation.Equation;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {

    private Integer res;
    private Equation equation;

    public Exercise(Equation equation, Integer res) {
        this.equation = equation;
        this.res = res;
    }

    @Override
    public String toString() {
        return "题目："+equation.toString() + "\t"+"您的答案："+equation.toString() + res+"\t"+"正确的答案："+equation.toString() + equation.getValue();
    }

}
