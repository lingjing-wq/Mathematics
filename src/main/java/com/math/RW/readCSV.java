package com.math.RW;

import java.io.*;
import java.util.Scanner;

public class readCSV {

    public void readCSVExercise(File writeFile){
        int n=1;
        try{
            BufferedReader textFile = new BufferedReader(new FileReader(writeFile));
            Scanner sc =new Scanner(textFile);
            String line=null;
            while((line=textFile.readLine())!=null){
                String[] line1=line.split(":");
                System.out.printf(n+":"+line1[1]+" \t\t\t");
                if(n%5==0) {
                    System.out.println();
                }
                n++;
            }
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
    }
}
