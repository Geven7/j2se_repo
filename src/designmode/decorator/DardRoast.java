package designmode.decorator;

public class DardRoast extends Beverage {

    public DardRoast() {
        description = "Dard Roast Coffee";
    }

    @Override
    public double cost() {
        return .98;
    }

}
