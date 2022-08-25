package org.example.example5;

public class Main {
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop(3);

        for (int i = 1; i <=10; i++) {
            BarberShopCustomer barberShopCustomer = new BarberShopCustomer(barberShop, i);
            new Thread(barberShopCustomer).start();

        }
    }
}
