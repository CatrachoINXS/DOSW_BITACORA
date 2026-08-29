package main.dosw.semana_4.ejercicio_1;

public class UsaPaymentFactory implements PaymentFactory {

    @Override
    public PaymentStrategy create(String type) {
        if (type.equalsIgnoreCase("tarjeta")) {
            return new TarjetaStrategy();
        } else {
            throw new IllegalArgumentException("Método de pago no valido");
        }
    }
}