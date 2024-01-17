package com.zlx.DesignPattern.Factory.AbstractFactory;

// 抽象工厂接口
interface PhoneAbstractFactory {
    Phone createPhone();
    Charger createCharger();
}

// 具体工厂1：华为手机工厂
class HuaweiPhoneAbstractFactory implements PhoneAbstractFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Charger createCharger() {
        return new HuaweiCharger();
    }
}

// 具体工厂2：苹果手机工厂
class IPhoneAbstractFactory implements PhoneAbstractFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }

    @Override
    public Charger createCharger() {
        return new IPhoneCharger();
    }
}

// 抽象产品：手机
interface Phone {
    void produce();
}

// 具体产品：华为手机
class HuaweiPhone implements Phone {
    @Override
    public void produce() {
        System.out.println("生产华为手机。");
    }
}

// 具体产品：苹果手机
class IPhone implements Phone {
    @Override
    public void produce() {
        System.out.println("生产苹果手机。");
    }
}

// 抽象产品：充电器
interface Charger {
    void charge();
}

// 具体产品：华为充电器
class HuaweiCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("使用华为充电器充电。");
    }
}

// 具体产品：苹果充电器
class IPhoneCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("使用苹果充电器充电。");
    }
}

// 客户端使用抽象工厂
public class AbstractFactoryExample {
    public static void main(String[] args) {
        PhoneAbstractFactory huaweiFactory = new HuaweiPhoneAbstractFactory();
        PhoneAbstractFactory iPhoneFactory = new IPhoneAbstractFactory();

        Phone phone1 = huaweiFactory.createPhone();
        Charger charger1 = huaweiFactory.createCharger();

        Phone phone2 = iPhoneFactory.createPhone();
        Charger charger2 = iPhoneFactory.createCharger();

        phone1.produce();
        charger1.charge();

        phone2.produce();
        charger2.charge();
    }
}
