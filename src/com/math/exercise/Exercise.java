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

    //������ɻ����ϰ��
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
            if(!occursIn(equation)) {  //�ж��Ƿ�����ͬ����ʽ��
                exercise.add(equation);
                i++;
            }
        }
    }

    //������ɼӷ���ϰ��
    public void generateAdditionExercise() {
        int i = 0;
        while(i<quantity) {
            Equation equation = new AdditionEquation();
            if(!occursIn(equation)) {  //�ж��Ƿ�����ͬ����ʽ��
                exercise.add(equation);
                i++;
            }
        }
    }

    //������ɼ�����ϰ��
    public void generateSubstractExercise() {
        int i = 0;
        while(i<quantity) {
            Equation equation = new SubstractEquation();
            if(!occursIn(equation)) {  //�ж��Ƿ�����ͬ����ʽ��
                exercise.add(equation);
                i++;
            }
        }
    }

    public void printExercise() {//�����ʽ
        int i = 0;
        for(Equation e:exercise) {
            i++;
            System.out.println("("+i+")"+""+e.getLeft_operand()+e.getOperator()+e.getRight_operand()+"="+e.getValue());
            if(i%5 == 0) {
                System.out.println("\t");
            }
        }
    }

    public Equation get(int index) {  //��ȡ��index����ʽ
        if(index < exercise.size()) {
            return exercise.get(index);
        }
        else {
            return null;
        }
    }

    public Equation next() { //��ȡ��һ����ʽ
        if(index < exercise.size()) {
            return exercise.get(index++);
        }
        else {
            return null;
        }
    }

    public boolean hasNext() {//������ʽ
        return index < exercise.size();
    }

    public boolean add(Equation equation) {//��ϰ�⼯�м�����ʽ
        if(index < quantity) {
            exercise.add(equation);
            index++;
            return true;
        }
        else {
            return false;
        }
    }
    public int size() {//��ȡϰ������
        return exercise.size();
    }
}
