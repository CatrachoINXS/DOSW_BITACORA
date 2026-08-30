package main.dosw.semana_4.ejercicio_8;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    
    private Size size;
    private Meat meat;
    private List<String> toppings;
    private List<String> sides;

    public OrderBuilder() {
        this.toppings = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public OrderBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public OrderBuilder setMeat(Meat meat) {
        this.meat = meat;
        return this;
    }

    public OrderBuilder addTopping(String topping) {
        toppings.add(topping);
        return this;
    }

    public OrderBuilder addSide(String side) {
        sides.add(side);
        return this;
    }

    public Order build() {
        return new Order(size, meat, toppings, sides);
    }
}
