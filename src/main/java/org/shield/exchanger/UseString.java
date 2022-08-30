package org.shield.exchanger;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;


public class UseString extends Thread{
    Exchanger<String> ex;
    String str;

    public UseString(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 3; i++) {
            str = ex.exchange(new String());
            System.out.println("Получено: " + str);
        }
    }
}
