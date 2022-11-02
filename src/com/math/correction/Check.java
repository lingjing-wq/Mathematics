package com.math.correction;

import com.math.exercise.Exercise;

public class Check {

    private int AllQuantity;
    private int RightQuantity;
    private int WrongQuantity;

    public int getAllQuantity() {
        return AllQuantity;
    }

    public void setAllQuantity(int allQuantity) {
        AllQuantity = allQuantity;
    }

    public int getRightQuantity() {
        return RightQuantity;
    }

    public void setRightQuantity(int rightQuantity) {
        RightQuantity = rightQuantity;
    }

    public int getWrongQuantity() {
        return WrongQuantity;
    }

    public void setWrongQuantity(int wrongQuantity) {
        WrongQuantity = wrongQuantity;
    }

    public void check(Exercise exercise,Key key){
        AllQuantity =exercise.size();
        int right=0;
        int wrong=0;
        exercise.setIndex(0);
        key.reset();
        while(exercise.hasNext()){
            if(exercise.next().getValue()==key.next()){
                right++;
            }else{
                wrong++;
            }
        }
        this.setRightQuantity(right);
        this.setWrongQuantity(wrong);

    }
    public void printresult(){
        System.out.println("本次练习批改结果：");
        System.out.println("算式总数：" + AllQuantity);
        System.out.println("正确：" + RightQuantity);
        System.out.println("错误：" + WrongQuantity);
    }
}
