package com.math.user;

public interface UserDao {

    /**
     * 登录检测，成功返回true，失败返回false
     *
     * @param username
     * @return
     */
    boolean isLogin(String userfile,String username,String password);


}
