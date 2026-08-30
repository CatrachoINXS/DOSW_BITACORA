package main.dosw.semana_4.ejercicio_1;

public interface PaymentFactory {
    PaymentStrategy create(String type);
}
