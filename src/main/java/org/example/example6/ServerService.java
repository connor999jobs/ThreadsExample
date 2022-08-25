package org.example.example6;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.logging.Logger;

@AllArgsConstructor

public class ServerService implements  Runnable{
    private static final Logger logger = Logger.getLogger(ServerService.class.getName());

    private final Phaser phaser;
    private final String serviceName;

    private final Random rnd = new Random();


    @Override
    @SneakyThrows
    public void run() {
        int startingIn = rnd.nextInt(10) * 1000;
            logger.info(() -> "Старт сервера " + serviceName + "' ...");
            Thread.sleep(startingIn);

            logger.info(() -> "Сервер " + serviceName
                    + " была запущена за " + startingIn / 1000
                    + " секунд (ожидаем остальные сервера )");
            phaser.arriveAndDeregister();
    }
}
