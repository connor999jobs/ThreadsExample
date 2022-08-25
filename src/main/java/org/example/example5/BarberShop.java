package org.example.example5;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BarberShop {
    private static final Logger logger = Logger.getLogger(BarberShop.class.getName());
    private final Semaphore seats;

    public BarberShop(int seatsCount) {
        this.seats = new Semaphore(seatsCount, true);
    }

    @SneakyThrows
    public boolean acquireSeat(int customerId){
        logger.info(() -> "Клиент " + customerId + " пытается занять кресло");
        boolean acquire = seats.tryAcquire(5*1000, TimeUnit.MILLISECONDS);
        if (!acquire){
            logger.info( () -> "Клиент " + customerId + " покинул барбершоп");
            return false;
        }
        logger.info( () -> "Клиент " + customerId + " занял кресло ");
        return true;

    }

    public void releaseSeat(int customerId) {

        logger.info(() -> "Клиент " + customerId + " освободил кресло");
        seats.release();
    }
}
