package org.example.example5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.logging.Logger;


@Data
@AllArgsConstructor
public class BarberShopCustomer implements Runnable{
    private static final Logger logger = Logger.getLogger(BarberShopCustomer.class.getName());
    public static final Random random = new Random();

    private BarberShop barberShop;
    private int customerId;


    @Override
    @SneakyThrows
    public void run() {
        boolean acquired = barberShop.acquireSeat(customerId);
        if (acquired){
            Thread.sleep(random.nextInt(10 * 1000));
            barberShop.releaseSeat(customerId);
        }
    }
}
