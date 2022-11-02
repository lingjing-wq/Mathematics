package com.math.ui;
import com.math.exercise.Exercise;
import com.math.user.User;

import java.util.Scanner;

public class CommandUi {

    public static String Mainmenu[]={"刷题","退出"};
    public static String Menu[][]={{"加法","减法","混合","返回上一级的菜单栏"},{}};
    public static  Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        String Mainmenu[]={"刷题","退出"};
        String Menu[][]={{"加法","减法","混合","返回上一级的菜单栏"},{}};

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
                    System.out.println("您已成功退出，感谢使用本系统！");
                    break;
                    default:
            }
        }
    }

    private static void printmenu() {
        System.out.println("************一百以内的算式加减法*************");
        System.out.println();
        System.out.println("==============一级菜单栏===================");
        for(int i=0;i<Mainmenu.length;i++){
            System.out.println(""+i+":"+Mainmenu[i]);
        }
    }

    private static void printindex(int index) {
        System.out.println("您选择了功能："+ index +Mainmenu[index]);
        if(Menu[index]!=null && Menu[index].length>0){
            System.out.println("请选择题型");
            for(int i=0;i<Menu[index].length;i++){
                System.out.println(""+i+":"+Menu[index][i]);
            }
        }
    }

    public static void printindex1(int index){
        int quantity;
        System.out.println("您选择了" + index +Menu[0][index]);
        if(index==3){
            return;
        }else {
            System.out.println("请输入算式数量");
            quantity = in.nextInt();
            Exercise exercise = new Exercise(quantity);
            if (index == 0) {
                exercise.generateAdditionExercise();//生成加法练习
            } else if (index == 1) {
                exercise.generateSubstractExercise();//生成减法练习
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
