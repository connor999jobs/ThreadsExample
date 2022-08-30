package org.shield.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<String>();
        new UseString(stringExchanger).start();
        new MakeString(stringExchanger).start();
    }
}
