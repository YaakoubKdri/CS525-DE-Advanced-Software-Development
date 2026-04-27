package application;

public class CalculatorImpl implements Calculator{
    private int calcValue = 0;

    @Override
    public void reset() {
        calcValue = 0;
    }

    @Override
    public int add(int newValue) {
        calcValue = calcValue + newValue;
        return calcValue;
    }

    @Override
    public int subtract(int newValue) {
        calcValue = calcValue - newValue;
        return calcValue;
    }
}
