package com.math.ui;
import com.math.exercise.genetateExercise;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandUi {

    public static String Mainmenu[]={"加法","减法","混合","退出系统"};
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
            String str= in.next();
            while(!str.equals("0")&&!str.equals("1")&&!str.equals("2")&&!str.equals("3")){
                System.out.println("输入不合法：只能输入0-3的数字。请重新输入！");
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
                        System.out.println("您确定要退出本系统吗[y/n]");
                        exit=in.next();
                        while(!exit.matches("[yY]")&&!exit.matches("[nN]")){
                            System.out.println("输入不合法！请重新输入");
                           exit=in.next();
                        }
                        if(exit.matches("[yY]")){
                            logout=true;
                            System.out.println("您已成功退出，感谢使用本系统！");
                        }else if(exit.matches("[nN]")){
                            System.out.println("您选择了继续使用本系统。");
                        }
                        break;
                    default:
                }
        }
    }

    private static void printmenu() {
        System.out.println();
        System.out.println("************************100以内的口算练习系统*************************");
        System.out.println();
        System.out.println("====================功能列表(输入数字选择功能，按回车键)=================");
        for(int i=0;i<Mainmenu.length;i++){
            System.out.println(""+i+": "+Mainmenu[i]);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("请选择.......");
        System.out.println();
    }

    public static void printindex1(int index){
        int quantity=0;
        System.out.println("您选择了："+Mainmenu[index]);
        System.out.println();
        System.out.println("请选择题目类型模式");
        System.out.println("-------------------------------------------------------------------");
        for(int i=0;i< Pattern.length;i++){
            System.out.println(""+i+":"+Pattern[i]);
        }
        System.out.println("-------------------------------------------------------------------");
        String str= in.next();
        while(!str.equals("0")&&!str.equals("1")&&!str.equals("2")){
            System.out.println("输入不合法：只能输入0-2的数字。请重新输入！");
            str= in.next();
        }
        int patternindex=Integer.parseInt(str);
        if(patternindex==0){
            System.out.println("您选择了题目类型模式："+Pattern[patternindex]);
            System.out.println();
            System.out.println("请输入算式数量:");
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
                    System.out.println("输入不合法,请重新输入！");
                }
            }
        }else if(patternindex==1){
            System.out.println("您选择了题目类型模式："+Pattern[patternindex]);
            System.out.println();
            System.out.println("请输入算式数量:");
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
                    System.out.println("输入不合法,请重新输入！");
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
            System.out.println("您选择了：返回上一级菜单栏");
            return;
        }
    }
}
