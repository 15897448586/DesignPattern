package com.zlx.DesignPattern.Singleton;

/**
 * @author zlx
 */
public class Singleton {
    /**
     * 饿汉单例:
     * 优势,线程安全
     * 劣势，在缓存中会存在很多未使用的对象，数量过多会导致OOM
     */
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 懒汉单例
 * 线程不安全
 */
class Singleton1 {
    private static Singleton1 instance ;

    public static Singleton1 getInstance() {
        if(instance == null) {
            instance =  new Singleton1();
        }
        return instance;
    }
}

/**
 * 双重加锁
 * 线程安全，并且
 */
class Singleton2 {
    private volatile static Singleton2 instance ;

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if(instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

/**
 * 当外部类调用 getInstance 方法时，才会触发静态内部类的加载。
 * 静态内部类加载时，会初始化其静态变量 instance，创建一个 Singleton3 实例。
 * 由于类加载过程是线程安全的，因此这种方式实现了线程安全的懒加载。
 */
class Singleton3 {
    private static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }
    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
}

/**
 * 枚举实现
 */
enum Singleton4{
    INSTANCE;
}
