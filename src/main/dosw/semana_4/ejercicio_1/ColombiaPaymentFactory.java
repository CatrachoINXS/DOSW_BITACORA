package main.dosw.semana_4.ejercicio_1;

public class ColombiaPaymentFactory implements PaymentFactory {

    @Override
    public PaymentStrategy create(String type) {
        if (type.equalsIgnoreCase("tarjeta")) {
            return new TarjetaStrategy();
        } else if (type.equalsIgnoreCase("nequi")) {
            return new NequiStrategy();
        } else if (type.equalsIgnoreCase("pse")) {
            return new PseStrategy();
        } else {
            throw new IllegalArgumentException("Método de pago no valido");
        }
    }
}