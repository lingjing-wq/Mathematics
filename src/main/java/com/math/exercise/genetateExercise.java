package com.math.exercise;

import com.math.RW.writeCSV;
import com.math.RW.readCSV;
import com.math.equation.Equation;
import com.math.equation.MyMap;
import com.math.equation.operationBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.TimeZone;

public class genetateExercise {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    operationBase base=new operationBase();
    MyMap<Integer,Equation> map=base.addBase();
    writeCSV write=new writeCSV();
    readCSV read=new readCSV();
    String filepath="src/main/java/com/math/file/";

//    生成试卷练习文件
    public void genetateAddExercise(int count){
        MyMap<Integer,Equation> map1=new MyMap();
        MyMap<Integer,Equation> map2=new MyMap();
        File writeFile =new File(filepath+"addition_exercise_count_001.csv");
        File checkingFile=new File(filepath+"addition_checkingFile_001.csv");
        int ra1=0;
        for(int i=0;i<count;i++){
            ra1 = random.nextInt(5151);
            Equation o = (Equation) map.get(ra1);
            map1.put(i,o);
//          生成对应的答案批改文件
            map2.put(i,o+""+o.getValue());
        }
        write.writeCSVExercise(map1,writeFile);
        write.writeCSVExercise(map2,checkingFile);
    }
    public void genetateSubExercise(int count){
        MyMap<Integer,Equation> map2=new MyMap();
        MyMap<Integer,Equation> map1=new MyMap();
        File writeFile =new File(filepath+"subtraction_exercise_count_002.csv");
        File checkingFile=new File(filepath+"subtraction_checkingFile_002.csv");
        int ra2=0;
        for(int i=0;i<count;i++){
            ra2 =random.nextInt(5151) + 5151;
            Equation o = (Equation) map.get(ra2);
            map2.put(i,o);
            // 生成对应的答案批改文件
            map1.put(i,o+""+o.getValue());
        }
        write.writeCSVExercise(map2,writeFile);
        write.writeCSVExercise(map1,checkingFile);
    }
    public void genetateMixExercise(int count){
        MyMap<Integer,Equation> map3=new MyMap();
        MyMap<Integer,Equation> map1=new MyMap();
        File writeFile =new File(filepath+"mix_exercise_count_003.csv");
        File checkingFile=new File(filepath+"mix_checkingFile_003.csv");
        int ra2=0;
        for(int i=0;i<count;i++){
            ra2 =random.nextInt(10302);
            Equation o = (Equation) map.get(ra2);
            map3.put(i,o);
            // 生成对应的答案批改文件
            map1.put(i,o+""+o.getValue());
        }
        write.writeCSVExercise(map3,writeFile);
        write.writeCSVExercise(map1,checkingFile);
    }

//    读取试卷练习文件
    public void readAddExercise(){
        File writeFile =new File(filepath+"addition_exercise_count_001.csv");
        File checkingFile=new File(filepath+"addition_checkingFile_001.csv");
        read.readCSVExercise(writeFile);
        genetateExercise.display(checkingFile);
    }

    public void readSubExercise(){
        File writeFile =new File(filepath+"subtraction_exercise_count_002.csv");
        File checkingFile=new File(filepath+"subtraction_checkingFile_002.csv");
        read.readCSVExercise(writeFile);
        genetateExercise.display(checkingFile);
    }
    public void readmixExercise(){
        File writeFile =new File(filepath+"mix_exercise_count_003.csv");
        File checkingFile=new File(filepath+"mix_checkingFile_003.csv");
        read.readCSVExercise(writeFile);
        genetateExercise.display(checkingFile);
    }

//    生成挑战练习文件
    public void generateExercise(int count ,int status) {
        int correct_answers=0;
        int wrong_answer=0;
        int res;
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
            res = sc.nextInt();
            if (res == o.getValue()) {
                System.out.println("true");
                System.out.println();
                correct_answers++;
            } else {
                System.out.println("your answer is :" + res);
                System.out.println("The right answer is :" + o.getValue());
                System.out.println();
            }
        }
        long end=System.currentTimeMillis();//一次答题结束
        System.out.println();
        System.out.println("------------------The answer results are follows------------------");
        System.out.println("correct answers :  "+correct_answers+"\n"+
                "wrong answers :  "+wrong_answer+"\n"+
                "correct rate :  "+((correct_answers*1.0)*100)/count+"%"+"\n"+
                "total duration off all question:  "+ genetateExercise.time(end-begin));
        System.out.println();
    }

    public static void display( File checkingFile){
        readCSV read=new readCSV();
        System.out.println();
        System.out.println();
        System.out.println("The following is the reference answer.How munch did you do right?");
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
}
