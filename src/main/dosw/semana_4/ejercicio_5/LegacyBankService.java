package main.dosw.semana_4.ejercicio_5;

public class LegacyBankService {
    
    public void executeTransaction(String accountType, int amount) {
        System.out.println("Ejecutando transaccion en LegacyBankService...");
        System.out.printf("Monto: %d centavos   Cuenta: %s", amount, accountType);
    }
}
