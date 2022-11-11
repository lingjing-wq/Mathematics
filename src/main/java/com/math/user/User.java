package com.math.user;


import com.math.exercise.Exercise;
import org.junit.Test;

import java.util.Scanner;


public class User {
    public static Exercise exercise;

    public Scanner in;
    private String username;
    private String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    @Override
    public String toString() {
        return this.username+"\t"+this.password;
    }

}
