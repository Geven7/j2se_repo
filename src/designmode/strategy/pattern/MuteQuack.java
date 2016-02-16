package designmode.strategy.pattern;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<<silence>>");
    }

}
