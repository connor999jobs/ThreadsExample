package org.example.example6;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.example5.BarberShopCustomer;

import java.util.concurrent.Phaser;
import java.util.logging.Logger;


@AllArgsConstructor
public class ServerInstance implements Runnable {
    private static final Logger logger = Logger.getLogger(ServerInstance.class.getName());

    private final Phaser phaser = new Phaser(1){
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            logger.warning( () -> "Фаза " + phase + " Зарегестрированные участники " + registeredParties);
            return  registeredParties == 0;
        }
    };

    @Override
    public void run() {

        long starting = System.currentTimeMillis();

        logger.info("Сервер готов к старту \n");

        logger.info("Запускаем первые 3 сервера ...");
        startFirstThreeServices();

        logger.info("Запускаем 2 остальных сервера ...");
        startNextTwoServices();

        logger.info("Все сервера работают ... последля проверка  ...\n");
        finalCheckIn();

        logger.info(() -> "Сервера успешно запустились за  "
                + (System.currentTimeMillis() - starting) / 1000 + " секунд");

        logger.warning(() -> "Terminated: " + phaser.isTerminated()
                + " | " + phaser.getRegisteredParties());

    }

    private void startFirstThreeServices() {
        Thread service1 = new Thread(new ServerService(phaser,"HTTP Listeners"));
        Thread service2 = new Thread(new ServerService(phaser, "JMX"));
        Thread service3 = new Thread(new ServerService(phaser, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        phaser.arriveAndAwaitAdvance(); // phase 0
    }

    private void startNextTwoServices() {
        Thread service4 = new Thread(new ServerService(phaser, "Virtual Hosts"));
        Thread service5 = new Thread(new ServerService(phaser, "Ports"));

        service4.start();
        service5.start();

        phaser.arriveAndAwaitAdvance(); // phase 1
    }


    @SneakyThrows
    private void finalCheckIn() {

            logger.info("Подсчёт времени (приблизительно 2 секунды) ...");
            Thread.sleep(2000);

            phaser.arriveAndDeregister(); // phase 2
        }
    }

