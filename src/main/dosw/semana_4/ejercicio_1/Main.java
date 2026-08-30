package main.dosw.semana_4.ejercicio_1;

public class Main {
    
    public static void main(String[] args) {
        
        PaymentFactory factory = new ColombiaPaymentFactory();
        Checkout checkout = new Checkout(factory.create("pse"));
        checkout.pay(219086.8);
    }
}
