package com.math.exercise;
import com.math.equation.Equation;
import com.math.equation.AdditionEquation;
import com.math.equation.SubstractEquation;
import java.util.ArrayList;
import java.util.Random;

public class Exercise {

    private int quantity;
    private int index;
    public ArrayList<Equation> exercise = null;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Exercise(){
        exercise=new ArrayList<Equation>();
    }

    public Exercise(int quantity){
        this.setQuantity(quantity);
        exercise=new ArrayList<Equation>();
    }

    public boolean occursIn(Equation equ) {
        boolean flag = false;
        for(Equation equation: exercise) {
            if(equation.isEqual(equ)) {
                flag= true;
                break;
            }
        }
        return flag;
    }

    //随机生成混合练习题
    public void generateExercise() {
        int i = 0;
        Random random =new Random();
        while(i<quantity) {
            Equation equation;
            int ov=(short)random.nextInt(2);
            if(ov==1) {
                equation = new AdditionEquation();
            }
            else {
                equation = new SubstractEquation();
            }
            if(!occursIn(equation)) {  //判断是否有相同的算式题
                exercise.add(equation);
                i++;
            }
        }
    }

    //随机生成加法练习题
    public void generateAdditionExercise() {
        int i = 0;
        while(i<quantity) {
            Equation equation = new AdditionEquation();
            if(!occursIn(equation)) {  //判断是否有相同的算式题
                exercise.add(equation);
                i++;
            }
        }
    }

    //随机生成减法练习题
    public void generateSubstractExercise() {
        int i = 0;
        while(i<quantity) {
            Equation equation = new SubstractEquation();
            if(!occursIn(equation)) {  //判断是否有相同的算式题
                exercise.add(equation);
                i++;
            }
        }
    }

    public void printExercise() {//输出算式
        int i = 0;
        for(Equation e:exercise) {
            i++;
            System.out.println("("+i+")"+""+e.getLeft_operand()+e.getOperator()+e.getRight_operand()+"="+e.getValue());
            if(i%5 == 0) {
                System.out.println("\t");
            }
        }
    }

    public Equation get(int index) {  //获取第index个算式
        if(index < exercise.size()) {
            return exercise.get(index);
        }
        else {
            return null;
        }
    }

    public Equation next() { //获取下一个算式
        if(index < exercise.size()) {
            return exercise.get(index++);
        }
        else {
            return null;
        }
    }

    public boolean hasNext() {//遍历算式
        return index < exercise.size();
    }

    public boolean add(Equation equation) {//在习题集中加入算式
        if(index < quantity) {
            exercise.add(equation);
            index++;
            return true;
        }
        else {
            return false;
        }
    }
    public int size() {//获取习题数量
        return exercise.size();
    }
}
