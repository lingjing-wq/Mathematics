package com.math.equation;

public class AdditionEquation extends Equation {

    public AdditionEquation(){
        generateEquation('+');
    }

    public AdditionEquation(String str) {//�ַ�������ӷ���ʽ�����ַ�����ʽת������ʽ��Ķ���ṹ
        int index = str.indexOf("+");//ͨ��index��ȡ�Ӻ�λ�ã����ݼӺ�λ�û�ȡ�ַ������Ӵ�
        int length = str.length();
        this.setLeft_operand(Integer.parseInt(str.substring(0,index)));//��ȡ�������
        this.setRight_operand(Integer.parseInt(str.substring(index+1,length)));//��ȡ�������
        this.setOperator(str.charAt(index));//���������
        this.setValue(calculate());//�������㷽����ȡ���
    }

    public int calculate(){  //ʵ�ֳ��󷽷�
        return this.getLeft_operand() + this.getRight_operand();
    }

}
