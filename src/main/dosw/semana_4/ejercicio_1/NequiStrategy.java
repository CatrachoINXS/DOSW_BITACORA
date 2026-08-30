package main.dosw.semana_4.ejercicio_1;

public class NequiStrategy implements PaymentStrategy {

    @Override
    public void process(double amount) {
        System.out.printf("Procesando $ %f con Nequi", amount);
    }
}
