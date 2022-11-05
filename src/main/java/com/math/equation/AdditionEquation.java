package com.math.equation;

public class AdditionEquation extends Equation {

    public AdditionEquation(){
        generateEquation('+');
    }

    public AdditionEquation(String str) {//字符串构造加法算式，将字符串算式转换成算式类的对象结构
        int index = str.indexOf("+");//通过index获取加号位置，根据加号位置获取字符串的子串
        int length = str.length();
        this.setLeft_operand(Integer.parseInt(str.substring(0,index)));//获取左运算符
        this.setRight_operand(Integer.parseInt(str.substring(index+1,length)));//获取右运算符
        this.setOperator(str.charAt(index));//设置运算符
        this.setValue(calculate());//调用运算方法获取结果
    }

    public int calculate(){  //实现抽象方法
        return this.getLeft_operand() + this.getRight_operand();
    }

}
