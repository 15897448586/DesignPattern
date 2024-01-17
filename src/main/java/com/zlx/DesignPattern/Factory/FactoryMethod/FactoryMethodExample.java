package com.zlx.DesignPattern.Factory.FactoryMethod;

// 工厂接口
interface PhoneFactory {
    Phone createPhone();
}

// 具体工厂：华为手机工厂
class HuaweiPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }
}

// 具体工厂：苹果手机工厂
class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

// 客户端使用工厂方法
public class FactoryMethodExample {
    public static void main(String[] args) {
        PhoneFactory huaweiFactory = new HuaweiPhoneFactory();
        PhoneFactory iPhoneFactory = new IPhoneFactory();

        Phone phone1 = huaweiFactory.createPhone();
        Phone phone2 = iPhoneFactory.createPhone();

        phone1.produce();
        phone2.produce();
    }
}

interface Phone{
    void produce();
}

class IPhone implements Phone {

    @Override
    public void produce() {
        System.out.println("iphone");
    }
}

class HuaweiPhone implements Phone {

    @Override
    public void produce() {
        System.out.println("huawei");
    }
}