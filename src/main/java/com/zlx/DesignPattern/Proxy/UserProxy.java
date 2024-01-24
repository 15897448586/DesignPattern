package com.zlx.DesignPattern.Proxy;

/**
 * 代理模式，通过一个类来代理另一个类，来给类增加功能
 * @author zlx
 */
public class UserProxy implements Animals {

    private User user;

    public UserProxy(User user) {
        this.user = user;
    }

    @Override
    public void eat() {
        System.out.println("111111");
        user.eat();
        System.out.println("22222");
    }


    public static void main(String[] args) {
        User user = new User();
        UserProxy proxy = new UserProxy(user);
        proxy.eat();
    }
}

interface Animals{
    void eat();
}

class User  implements Animals{

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}



