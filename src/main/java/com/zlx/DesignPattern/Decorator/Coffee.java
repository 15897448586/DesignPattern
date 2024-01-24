package com.zlx.DesignPattern.Decorator;

// 1. Component（组件）
interface Coffee {
    String getDescription();
    double cost();
}

// 2. ConcreteComponent（具体组件）
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}

// 3. Decorator（装饰器抽象类）
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// 4. ConcreteDecorator（具体装饰器）
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 2.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }
}

// 客户端代码
class Main {
    public static void main(String[] args) {
        // 制作一个简单的咖啡
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Description: " + simpleCoffee.getDescription());
        System.out.println("Cost: $" + simpleCoffee.cost());

        // 在简单咖啡上加牛奶
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Description: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.cost());

        // 在加牛奶的咖啡上再加糖
        Coffee sweetCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Description: " + sweetCoffee.getDescription());
        System.out.println("Cost: $" + sweetCoffee.cost());
    }
}
