package com.math.ui;
import com.math.RW.readCSV;
import com.math.exercise.Exercise;
import com.math.exercise.genetateExercise;
import com.math.user.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandUi {

    public static String Mainmenu[]={"����ˢ��","�˳�ϵͳ"};
    public static String Menu[][]={{"�ӷ�","����","���","������һ���Ĳ˵���"},{}};
    public static String Pattern[]={"��սģʽ","�Ծ�ģʽ","������һ���Ĳ˵���"};
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
                    System.out.println("���벻�Ϸ���ֻ������0-1�����֣�");
                    a=in.nextInt();
                }
                switch (a){
                    case 0:
                        printindex(a);
                        b=in.nextInt();
                        printindex1(b);
                        break;
                    case 1:
                        System.out.println("��ȷ��Ҫ�˳���ϵͳ��[y/n]");
                        exit=in.next();
                        if(exit.matches("[yY]")){
                            logout=true;
                            System.out.println("���ѳɹ��˳�����лʹ�ñ�ϵͳ��");
                        }else{
                            System.out.println("��ѡ���˼���ʹ�ñ�ϵͳ��");
                        }
                        break;
                        default:
                }

        }
    }

    private static void printmenu() {
        System.out.println();
        System.out.println("*************100���ڵĿ�����ϰϵͳ*************");
        System.out.println();
        System.out.println("=================�����б�====================");
        for(int i=0;i<Mainmenu.length;i++){
            System.out.println(""+i+": "+Mainmenu[i]);
        }
        System.out.println("-------------------------------------------");
        System.out.println("��������ѡ���ܣ����س���");
        System.out.println("��ѡ��.......");
        System.out.println();
    }

    private static void printindex(int index) {
        System.out.println();
        System.out.println("��ѡ���˹��ܣ�"+Mainmenu[index]);
        if(Menu[index]!=null && Menu[index].length>0){
            System.out.println("��ѡ����Ŀ����");
            for(int i=0;i<Menu[index].length;i++){
                System.out.println(""+i+":"+Menu[index][i]);
            }
        }
    }

    public static void printindex1(int index){
        int quantity;
        System.out.println();
        System.out.println("��ѡ������Ŀ���ͣ�" +Menu[0][index]);
        if(index==3){
            return;
        }else {
            System.out.println("��ѡ����Ŀ����ģʽ");
            for(int i=0;i< Pattern.length;i++){
                System.out.println(""+i+":"+Pattern[i]);
            }
            int patternindex =in.nextInt();
            if(patternindex==0){
                System.out.println("��ѡ������Ŀ����ģʽ��"+Pattern[patternindex]);
                System.out.println("��������ʽ����");
                int count = in.nextInt();
                g.generateExercise(count,index);
            }else if(patternindex==1){
                System.out.println("��ѡ������Ŀ����ģʽ��"+Pattern[patternindex]);
                System.out.println("��������ʽ����");
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
