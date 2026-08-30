package main.dosw.semana_4.ejercicio_8;

public class Main {
    public static void main(String[] args) {
        Order order = new OrderBuilder()
            .setSize(Size.LARGE)
            .setMeat(Meat.DOUBLE_BEEF)
            .addTopping("queso")
            .addTopping("lechuga")
            .addSide("papas")
            .addSide("gaseosa")
            .build();

        order.addObserver(new KitchenService());
        order.addObserver(new BillingService());
        order.addObserver(new DeliveryService());
        order.confirm();
    }
}
