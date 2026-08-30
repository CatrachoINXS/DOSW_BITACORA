package main.dosw.semana_4.ejercicio_5;

public class BankFacade {
    public void processPayment(double amount) {
        //Métodos para inicializar conexión, sesión y contexto
        LegacyBankService context = new LegacyBankService();
        PaymentProcessor adapter = new LegacyBankAdapter(context);
        adapter.pay(amount);
    }
}