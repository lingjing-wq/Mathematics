package com.math.user;

import com.math.RW.writeCSV;
import com.math.equation.MyMap;
import com.math.ui.CommandUi;

import java.io.*;
import java.util.Scanner;

public class UserTest {

    CommandUi ui=new CommandUi();
    public void UserUI() {

        UserDao ud = new UserDaoImpl();
        MyMap<Integer, User> usermap=new MyMap<>();
        writeCSV write=new writeCSV();
        String userfile="src/main/resources/userlist.csv";

        while (true) {
            System.out.println("---------------------------欢迎使用本系统----------------------------");
            System.out.println("1 登录");
            System.out.println("2 注册");
            System.out.println("3 退出");
            System.out.println("请选择要执行的功能：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            int i=0;
            while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3")){
                System.out.println("输入不合法：只能输入1-3的数字。请重新输入！");
                choice= sc.nextLine();
            }
            switch (choice) {
                case "1":
                    // 登录功能
                    System.out.println("-------------------------------登录--------------------------------");
                    System.out.print("请输入用户名：");
                    String username = sc.nextLine();
                    while(true){
                        if(username.length()==0){
                            System.out.println("用户名输入不能为空！请重新输入");
                            username = sc.nextLine();
                        }else{
                            break;
                        }
                    }
                    System.out.print("请输入密码：");
                    String password = sc.nextLine();
                    while(true){
                        if(password.length()==0){
                            System.out.println("密码输入不能为空！请重新输入");
                            password = sc.nextLine();
                        }else{
                            break;
                        }
                    }
                    if (ud.isLogin(userfile,username,password)) {
                        System.out.println("登录成功！");

                        // 登录成功开始
                        System.out.println("是否进入答题界面y/n");
                        while (true) {
                            String res = sc.nextLine();
                            if (res.equalsIgnoreCase("y")) {
                                ui.execute();
                            } else {
                                break;
                            }
                        }
                        sc.close();
                        System.exit(0);
                    } else {
                        System.out.println("用户名或密码错误！请重新登录或注册！");
                    }
                    break;
                case "2":
                    // 注册功能
                    System.out.println("------------------------------注册---------------------------------");
                    System.out.print("请输入用户名：");
                    String newUsername = sc.nextLine();
                    while(true){
                        if(newUsername.length()==0){
                            System.out.println("用户名输入不能为空！请重新输入");
                            newUsername = sc.nextLine();
                        }else{
                            break;
                        }
                    }
                    System.out.print("请输入密码：");
                    String newPassword = sc.nextLine();
                    while(true){
                        if(newPassword.length()==0){
                            System.out.println("密码输入不能为空！请重新输入");
                            newPassword = sc.nextLine();
                        }else{
                            break;
                        }
                    }
                    User user=new User(newUsername,newPassword);
                    // 注册信息写入
                    usermap.put(i,user);
                    input(usermap,userfile);
                    System.out.println("注册成功！");
                    break;
                case "3":
                default:
                    System.out.println("-----------------------------感谢本次使用--------------~-----------");
                    System.exit(0);
                    break;
            }
            i++;

        }
    }

    public void input( MyMap<Integer, User> usermap, String userfile){
        File file = new File(userfile);
        try {
            FileWriter fileWriter=new FileWriter(file,true);
            BufferedWriter writer=new BufferedWriter(fileWriter);
            writer.write(usermap.toString());
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
