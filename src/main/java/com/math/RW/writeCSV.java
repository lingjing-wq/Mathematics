package com.math.RW;

import com.math.equation.Equation;
import com.math.equation.MyMap;

import java.io.*;

public class writeCSV {


    public void writeCSVExercise(MyMap<Integer,Equation> map, File writeFile){

        try{
            BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));
            writeText.write(map.toString());
            writeText.flush();
            writeText.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
    }

}
