package com.math.ui;
import com.math.exercise.genetateExercise;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandUi {

    public static String Mainmenu[]={"�ӷ�","����","���","�˳�ϵͳ"};
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
            String str= in.next();
            while(!str.equals("0")&&!str.equals("1")&&!str.equals("2")&&!str.equals("3")){
                System.out.println("���벻�Ϸ���ֻ������0-3�����֡����������룡");
                str= in.next();
            }
              a=Integer.parseInt(str);
                switch (a){
                    case 0:
                    case 1:
                    case 2:
                        printindex1(a);
                        break;
                    case 3:
                        System.out.println("��ȷ��Ҫ�˳���ϵͳ��[y/n]");
                        exit=in.next();
                        while(!exit.matches("[yY]")&&!exit.matches("[nN]")){
                            System.out.println("���벻�Ϸ�������������");
                           exit=in.next();
                        }
                        if(exit.matches("[yY]")){
                            logout=true;
                            System.out.println("���ѳɹ��˳�����лʹ�ñ�ϵͳ��");
                        }else if(exit.matches("[nN]")){
                            System.out.println("��ѡ���˼���ʹ�ñ�ϵͳ��");
                        }
                        break;
                    default:
                }
        }
    }

    private static void printmenu() {
        System.out.println();
        System.out.println("************************100���ڵĿ�����ϰϵͳ*************************");
        System.out.println();
        System.out.println("====================�����б�(��������ѡ���ܣ����س���)=================");
        for(int i=0;i<Mainmenu.length;i++){
            System.out.println(""+i+": "+Mainmenu[i]);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("��ѡ��.......");
        System.out.println();
    }

    public static void printindex1(int index){
        int quantity=0;
        System.out.println("��ѡ���ˣ�"+Mainmenu[index]);
        System.out.println();
        System.out.println("��ѡ����Ŀ����ģʽ");
        System.out.println("-------------------------------------------------------------------");
        for(int i=0;i< Pattern.length;i++){
            System.out.println(""+i+":"+Pattern[i]);
        }
        System.out.println("-------------------------------------------------------------------");
        String str= in.next();
        while(!str.equals("0")&&!str.equals("1")&&!str.equals("2")){
            System.out.println("���벻�Ϸ���ֻ������0-2�����֡����������룡");
            str= in.next();
        }
        int patternindex=Integer.parseInt(str);
        if(patternindex==0){
            System.out.println("��ѡ������Ŀ����ģʽ��"+Pattern[patternindex]);
            System.out.println();
            System.out.println("��������ʽ����:");
            int count=0;
            while(true){
                try{
                    count=in.nextInt();
                }catch (ArrayIndexOutOfBoundsException e){
                    in.next();
                }catch (InputMismatchException e){
                    in.next();
                }
                if(count>0){
                    g.generateExercise(count,index);
                    break;
                }
                if (count<=0){
                    System.out.println("���벻�Ϸ�,���������룡");
                }
            }
        }else if(patternindex==1){
            System.out.println("��ѡ������Ŀ����ģʽ��"+Pattern[patternindex]);
            System.out.println();
            System.out.println("��������ʽ����:");
            while(true){
                try{
                    quantity=in.nextInt();
                }catch (ArrayIndexOutOfBoundsException e){
                    in.next();
                }catch (InputMismatchException e){
                    in.next();
                }
                if(quantity>0){
                    break;
                }
                if (quantity<=0){
                    System.out.println("���벻�Ϸ�,���������룡");
                }
            }
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
            System.out.println("��ѡ���ˣ�������һ���˵���");
            return;
        }
    }
}
