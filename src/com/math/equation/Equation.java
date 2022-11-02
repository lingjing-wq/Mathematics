package com.math.equation;

import java.util.Random;

public abstract class Equation {

    public static final int UPPER=100;
    public static final int LOWER=0;
    private int left_operand=0;
    private int right_operand=0;
    private char operator='+';
    private int value=0;

    public int getLeft_operand() {
        return left_operand;
    }

    public void setLeft_operand(int left_operand) {
        this.left_operand = left_operand;
    }

    public int getRight_operand() {
        return right_operand;
    }

    public void setRight_operand(int right_operand) {
        this.right_operand = right_operand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void generateEquation(char operator) {      //构造算式
        do {
            left_operand = generateOperand();
            right_operand= generateOperand();
            value = calculate();
        }while(!isCheck(value,LOWER,UPPER));
        this.setOperator(operator);
    }


    //	生成随机操作数
    public static int generateOperand(){
        Random random =new Random();
        int operand=(short)random.nextInt(101);
        return operand;
    }

    //	生成随机的操作符
    public static char generateOperator(){
        Random random =new Random();
        char o;
        int ov=(short)random.nextInt(2);
        if(ov==1){
            o='+';
        }else{
            o='-';
        }
        return o;
    }

    //	检验数据
    public static boolean isCheck(int n,int a,int b){
        if(n>=a&&n<=b){
            return true;
        }
        return false;
    }

    //判断等式是否相同
    public boolean isEqual(Equation equation) {
        return (equation.getLeft_operand()==this.getLeft_operand()) && (equation.getRight_operand()==this.getRight_operand()) && equation.getOperator()==this.getOperator();
    }
    public String toString(){
        return ""+this.getLeft_operand()+this.getOperator()+this.getRight_operand()+"=";
    }
    public abstract int calculate();
}
