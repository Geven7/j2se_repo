package designmode.strategy.pattern;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("swim...");
    }

    public void display() {
        System.out.println("display...");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}
