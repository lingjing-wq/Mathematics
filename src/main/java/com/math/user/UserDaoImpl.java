package com.math.user;

import com.math.equation.MyMap;
import com.math.exercise.Exercise;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    private static ArrayList<User> array = new ArrayList<User>();

    @Override
    public boolean isLogin(String userfile,String username,String password) {
        boolean flag = false;
        try{
            BufferedReader textFile = new BufferedReader(new FileReader(userfile));
            Scanner sc =new Scanner(textFile);
            String line=null;
            while((line=textFile.readLine())!=null) {
                String[] line1 = line.split(":");
                String[] line2 = line1[1].split("\t");
                if(line2[1].equals(username)&&line2[2].equals(password)){
                    flag = true;
                    break;
                }
            }
        }catch (
        FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }
}