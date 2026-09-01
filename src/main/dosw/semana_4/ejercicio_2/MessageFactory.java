package main.dosw.semana_4.ejercicio_2;

public interface MessageFactory {
    Message build(OrderEvent event);
}
