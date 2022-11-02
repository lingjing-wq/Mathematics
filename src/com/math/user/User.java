package com.math.user;

import com.math.correction.Check;
import com.math.correction.Key;
import com.math.exercise.Exercise;

import java.util.Scanner;


public class User {
    public static Exercise exercise;
    public Key key;
    public Check check;
    public Scanner in;

    public User(){
        check=new Check();
    }

    public static Exercise getExercise() {
        return exercise;
    }

    public static void setExercise(Exercise exercise) {
        User.exercise = exercise;
    }

    public Key getKey() {
        return key;
    }

    public void setLey(Key ley) {
        this.key = key;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
    public void practice() {//用户可以计算习题
        // TODO Auto-generated method stub
        key = new Key();
        exercise.setIndex(0);
        int i = 1;
        System.out.println("输入答案后回车继续下一题");
        while(exercise.hasNext()) {
            System.out.println("("+ i +")" + exercise.next().toString());
            key.add(in.nextInt());//读取从键盘接收的答案同时加入答案集
        }
        check.check(exercise,key);
        check.printresult();

    }
}
