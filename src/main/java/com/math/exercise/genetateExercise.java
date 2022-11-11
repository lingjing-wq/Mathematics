package com.math.exercise;

import com.math.RW.writeCSV;
import com.math.RW.readCSV;
import com.math.equation.Equation;
import com.math.equation.MyMap;
import com.math.equation.operationBase;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class genetateExercise {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    operationBase base=new operationBase();
    MyMap<Integer,Equation> map=base.addBase();
    writeCSV write=new writeCSV();
    readCSV read=new readCSV();
    MyMap<Integer,Exercise> checkmap=new MyMap<>();
    Scanner in=new Scanner(System.in);

    //    生成试卷练习文件
    public void genetateAddExercise(int count,String pattern){
        MyMap<Integer,Equation> map1=new MyMap();
        MyMap<Integer,Equation> map2=new MyMap();
        int ra1=0;
        for(int i=0;i<count;i++){
            ra1 = random.nextInt(5151);
            Equation o = (Equation) map.get(ra1);
            map1.put(i,o);
//          生成对应的答案批改文件
            map2.put(i,o+""+o.getValue());
        }
        File file1=writeRightFile1(map1,pattern);
        genetateExercise.display(file1);
        System.out.println();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        File file2=writeRightFile(map2,pattern);
        System.out.println("以下是本套试卷的正确答案，您做对了多少呢?");
        genetateExercise.display(file2);
    }

    public void genetateSubExercise(int count,String pattern){
        MyMap<Integer,Equation> map2=new MyMap();
        MyMap<Integer,Equation> map1=new MyMap();
        int ra2=0;
        for(int i=0;i<count;i++){
            ra2 =random.nextInt(5151) + 5151;
            Equation o = (Equation) map.get(ra2);
            map2.put(i,o);
            // 生成对应的答案批改文件
            map1.put(i,o+""+o.getValue());
        }
        File file1=writeRightFile1(map2,pattern);
        genetateExercise.display(file1);
        System.out.println();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        File file2=writeRightFile(map1,pattern);
        System.out.println("以下是本套试卷的正确答案，您做对了多少呢?");
        genetateExercise.display(file2);
    }

    public void genetateMixExercise(int count,String pattern){
        MyMap<Integer,Equation> map3=new MyMap();
        MyMap<Integer,Equation> map1=new MyMap();
        int ra2=0;
        for(int i=0;i<count;i++){
            ra2 =random.nextInt(10302);
            Equation o = (Equation) map.get(ra2);
            map3.put(i,o);
            // 生成对应的答案批改文件
            map1.put(i,o+""+o.getValue());
        }
        File file1=writeRightFile1(map3,pattern);
        genetateExercise.display(file1);
        System.out.println();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        File file2=writeRightFile(map1,pattern);
        System.out.println("以下是本套试卷的正确答案，您做对了多少呢?");
        genetateExercise.display(file2);
    }

//    生成挑战练习文件
    public int generateExercise(int count ,int status) {
        int correct_answers=0;
        int res=0;
        int r=0;
        long begin =System.currentTimeMillis();//开始计时
        for (int i = 0; i < count; i++) {
            if (status == 0) {
                r = random.nextInt(5151); //加法：[0,5150]
            } else if (status == 1) {
                r = random.nextInt(5151) + 5151; //减法：[5151,10301]
            } else if (status == 2) {
                r = random.nextInt(10302);
            }
            Equation o = (Equation) map.get(r);
            System.out.println((i+1)+": "+o);
            while(true) {
                try {
                    res = in.nextInt();
                    if(res<0){
                        System.out.println("输入不合法,请重新输入！");
                        continue;
                    }else {
                        Exercise e =new Exercise(o,res);
                        checkmap.put(i+1,e);//加入批改文件中
                        break;
                    }
                } catch (Exception exception) {
                    System.out.println("输入不合法,请重新输入！");
                    in.next();
                }
            }
            if (res == o.getValue()) {
                System.out.println("√");
                System.out.println();
                correct_answers++;
            } else {
                System.out.println("×");
                System.out.println("您的答案是: " + res);
                System.out.println("正确的答案为: " + o.getValue());
                System.out.println();
            }
        }
        long end=System.currentTimeMillis();//一次答题结束
        System.out.println();
        System.out.println("----------------------------本次答题结果如下--------------------------");
        System.out.println("答题总个数 :  "+count+"个"+"\n"+
                "正确题个数 :  "+correct_answers+"个"+"\n"+
                "错误题个数:  "+(count-correct_answers)+"个"+"\n"+
                "正确率为 :  "+((correct_answers*1.0)*100)/count+"%"+"\n"+
                "本次答题总时长:  "+ genetateExercise.time(end-begin));
        System.out.println();
        checkingMap();
        return status;
    }

    public static void display( File checkingFile){
        readCSV read=new readCSV();
        System.out.println();
        read.readCSVExercise(checkingFile);
        System.out.println();
    }

    //调整计时格式
    public static String time(long ms){
        SimpleDateFormat formatter =new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms=formatter.format(ms);
        return hms;
    }

    public MyMap<Integer,Exercise> checkingMap(){
        return checkmap;
    }

    public void writeCheckFile(String pattern){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH.mm.ss");
        String time = dateTime.format(formatter);
        String exerciseFile = ".\\src\\main\\resources\\" + pattern +"批改文件_"+ time + ".csv";
        System.out.println("导出的文件名为："+pattern +"批改文件_"+time + ".csv");

        File file = new File(exerciseFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = getFileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(checkmap.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FileWriter getFileWriter(File file) throws IOException {
        return new FileWriter(file);
    }

    public File writeRightFile(MyMap<Integer,Equation> map,String pattern){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH.mm.ss");
        String time = dateTime.format(formatter);
        String exerciseFile = ".\\src\\main\\resources\\" + pattern +"挑战模式试题答案_"+  time + ".csv";
        System.out.println();
        System.out.println("本次挑战试题答案文件："+"挑战模式试题答案_"+ time + ".csv");

        File file = new File(exerciseFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = getFileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            write.writeCSVExercise(map,file);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    public File writeRightFile1(MyMap<Integer,Equation> map,String pattern){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH.mm.ss");
        String time = dateTime.format(formatter);
        String exerciseFile = ".\\src\\main\\resources\\" + pattern +"挑战模式试题_"+  time + ".csv";
        System.out.println();
        System.out.println("本次挑战试题文件："+"挑战模式试题_"+ time + ".csv");

        File file = new File(exerciseFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = getFileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            write.writeCSVExercise(map,file);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
