package org.shield.exchanger;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;

public class MakeString extends Thread{
    Exchanger<String> ex;
    String str;

    public MakeString(Exchanger<String> ex ) {
        this.ex = ex;
        str = new String();
    }

    @Override
    @SneakyThrows
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }
            str = ex.exchange(str);
        }
    }
}
