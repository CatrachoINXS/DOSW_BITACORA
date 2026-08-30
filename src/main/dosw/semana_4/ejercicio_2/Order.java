package main.dosw.semana_4.ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private List<NotificationObserver> subscribers;
    private String state;

    public Order(String state) {
        this.state = state;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(NotificationObserver observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(NotificationObserver observer) {
        subscribers.remove(observer);
    }

    public void changeState(String state) {
        this.state = state;
        OrderEvent event = new OrderEvent(state);
        notifyObservers(event);
    }

    public void printOrderState() {
        System.out.println("El estado de la orden es: " + state);
    }

    private void notifyObservers(OrderEvent event) {
        subscribers.stream().forEach(s -> s.notify(event));
    }
}