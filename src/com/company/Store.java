package com.company;

public class Store {
    private int goods;
    public synchronized void put() {
        if (goods >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        goods++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе " + goods);
        notify();
    }
    public synchronized void buy() {
        while (goods < 1) {

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        goods--;
        System.out.println("Покупатель купил 1 товар ");
        System.out.println("Производитель добавил 1 товар "+goods);
        notify();
    }
}


