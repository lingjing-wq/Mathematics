package com.math.ui;
import com.math.RW.readCSV;
import com.math.exercise.Exercise;
import com.math.exercise.genetateExercise;
import com.math.user.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandUi {

    public static String Mainmenu[]={"进入刷题","退出系统"};
    public static String Menu[][]={{"加法","减法","混合","返回上一级的菜单栏"},{}};
    public static String Pattern[]={"挑战模式","试卷模式","返回上一级的菜单栏"};
    public static  Scanner in=new Scanner(System.in);
    static genetateExercise g=new genetateExercise();
    public int mark=0;

    public static void execute() {
        int a;
        int b=0;
        String exit="n";
        boolean logout=false;
        while(!logout){
                printmenu();
                a=in.nextInt();
                while(a<0||a>1){
                    System.out.println("输入不合法：只能输入0-1的数字！");
                    a=in.nextInt();
                }
                switch (a){
                    case 0:
                        printindex(a);
                        b=in.nextInt();
                        printindex1(b);
                        break;
                    case 1:
                        System.out.println("您确定要退出本系统吗[y/n]");
                        exit=in.next();
                        if(exit.matches("[yY]")){
                            logout=true;
                            System.out.println("您已成功退出，感谢使用本系统！");
                        }else{
                            System.out.println("您选择了继续使用本系统。");
                        }
                        break;
                        default:
                }

        }
    }

    private static void printmenu() {
        System.out.println();
        System.out.println("*************100以内的口算练习系统*************");
        System.out.println();
        System.out.println("=================功能列表====================");
        for(int i=0;i<Mainmenu.length;i++){
            System.out.println(""+i+": "+Mainmenu[i]);
        }
        System.out.println("-------------------------------------------");
        System.out.println("输入数字选择功能，按回车键");
        System.out.println("请选择.......");
        System.out.println();
    }

    private static void printindex(int index) {
        System.out.println();
        System.out.println("您选择了功能："+Mainmenu[index]);
        if(Menu[index]!=null && Menu[index].length>0){
            System.out.println("请选择题目类型");
            for(int i=0;i<Menu[index].length;i++){
                System.out.println(""+i+":"+Menu[index][i]);
            }
        }
    }

    public static void printindex1(int index){
        int quantity;
        System.out.println();
        System.out.println("您选择了题目类型：" +Menu[0][index]);
        if(index==3){
            return;
        }else {
            System.out.println("请选择题目类型模式");
            for(int i=0;i< Pattern.length;i++){
                System.out.println(""+i+":"+Pattern[i]);
            }
            int patternindex =in.nextInt();
            if(patternindex==0){
                System.out.println("您选择了题目类型模式："+Pattern[patternindex]);
                System.out.println("请输入算式数量");
                int count = in.nextInt();
                g.generateExercise(count,index);
            }else if(patternindex==1){
                System.out.println("您选择了题目类型模式："+Pattern[patternindex]);
                System.out.println("请输入算式数量");
                quantity = in.nextInt();
                if(index == 0){
                    g.genetateAddExercise(quantity);
                    g.readAddExercise();
                }else if (index == 1) {
                    g.genetateSubExercise(quantity);
                    g.readSubExercise();
                } else {
                    g.genetateMixExercise(quantity);
                    g.readmixExercise();
                }

            }else if(patternindex==2){
                return;
            }
        }
    }
}
