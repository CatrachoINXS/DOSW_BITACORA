package main.dosw.semana_4.ejercicio_1;

public class TarjetaStrategy implements PaymentStrategy {

    @Override
    public void process(double amount) {
        System.out.printf("Procesando $ %f con tarjeta", amount);
    }
}
