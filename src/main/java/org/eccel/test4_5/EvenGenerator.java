package org.eccel.test4_5;

public class EvenGenerator extends IntGenerator{
    private int currentValue = 0;

    @Override
    public int next() {
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
