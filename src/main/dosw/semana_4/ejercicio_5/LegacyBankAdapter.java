package main.dosw.semana_4.ejercicio_5;

public class LegacyBankAdapter implements PaymentProcessor {

    private final LegacyBankService legacy;

    public LegacyBankAdapter(LegacyBankService legacy) {
        this.legacy = legacy;
    }

    @Override
    public void pay(double amount) {
        int cents = (int) (amount * 100);
        legacy.executeTransaction("ACC", cents);
    }
}
