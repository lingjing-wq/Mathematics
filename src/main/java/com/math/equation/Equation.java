package com.math.equation;

public  class Equation {

    public static final int UPPER=100;
    public static final int LOWER=0;
    private int left_operand=0;
    private int right_operand=0;
    private char operator='+';
    private int value=0;
    public Equation(){}
    public Equation(int left_operand,char operator, int right_operand,int value){
        this.left_operand=left_operand;
        this.operator=operator;
        this.right_operand=right_operand;
        this.value=value;
    }

    public int getLeft_operand() {
        return left_operand;
    }

    public int getRight_operand() {
        return right_operand;
    }

    public char getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return ""+this.getLeft_operand()+this.getOperator()+this.getRight_operand()+"=";
    }
}
