package com.math.ui;
import com.math.exercise.Exercise;
import com.math.user.User;

import java.util.Scanner;

public class CommandUi {

    public static String Mainmenu[]={"ˢ��","�˳�"};
    public static String Menu[][]={{"�ӷ�","����","���","������һ���Ĳ˵���"},{}};
    public static  Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        String Mainmenu[]={"ˢ��","�˳�"};
        String Menu[][]={{"�ӷ�","����","���","������һ���Ĳ˵���"},{}};

//        Scanner in=new Scanner(System.in);
        int a;
        int b;
        boolean logout=false;
        while(!logout){
            printmenu();
            a=in.nextInt();
            switch (a){
                case 0:
                    printindex(a);
                    b=in.nextInt();
                    printindex1(b);
                    break;
                case 1:
                    logout=true;
                    System.out.println("���ѳɹ��˳�����лʹ�ñ�ϵͳ��");
                    break;
                    default:
            }
        }
    }

    private static void printmenu() {
        System.out.println("************һ�����ڵ���ʽ�Ӽ���*************");
        System.out.println();
        System.out.println("==============һ���˵���===================");
        for(int i=0;i<Mainmenu.length;i++){
            System.out.println(""+i+":"+Mainmenu[i]);
        }
    }

    private static void printindex(int index) {
        System.out.println("��ѡ���˹��ܣ�"+ index +Mainmenu[index]);
        if(Menu[index]!=null && Menu[index].length>0){
            System.out.println("��ѡ������");
            for(int i=0;i<Menu[index].length;i++){
                System.out.println(""+i+":"+Menu[index][i]);
            }
        }
    }

    public static void printindex1(int index){
        int quantity;
        System.out.println("��ѡ����" + index +Menu[0][index]);
        if(index==3){
            return;
        }else {
            System.out.println("��������ʽ����");
            quantity = in.nextInt();
            Exercise exercise = new Exercise(quantity);
            if (index == 0) {
                exercise.generateAdditionExercise();//���ɼӷ���ϰ
            } else if (index == 1) {
                exercise.generateSubstractExercise();//���ɼ�����ϰ
            } else {
                exercise.generateExercise();
            }
            User user = new User();
            user.setIn(in);
            user.setExercise(exercise);
            user.practice();
        }
    }
}
