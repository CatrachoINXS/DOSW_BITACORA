package main.dosw.semana_4.ejercicio_8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    
    private final Size size;
    private final Meat meat;
    private final List<String> toppings;
    private final List<String> sides;

    private List<Observer> observers;
    
    public Order(Size size, Meat meat, List<String> toppings, List<String> sides) {
        this.size = size;
        this.meat = meat;
        this.toppings = toppings;
        this.sides = sides;
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void confirm() {
        System.out.println("Pedido confirmado:");
        System.out.println("    Tamaño: " + size);
        System.out.println("    Carne: " + meat);
        System.out.println("    Toppings: " + toppings.stream().collect(Collectors.joining(", ")));
        System.out.println("    Sides: " + sides.stream().collect(Collectors.joining(", ")));
        System.out.println();
        observers.forEach(o -> o.onOrderConfirmed());
    }
    
}