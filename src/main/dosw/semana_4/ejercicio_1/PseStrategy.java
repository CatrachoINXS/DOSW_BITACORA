package main.dosw.semana_4.ejercicio_1;

public class PseStrategy implements PaymentStrategy {

    @Override
    public void process(double amount) {
        System.out.printf("Procesando $ %f con PSE", amount);
    }
}
