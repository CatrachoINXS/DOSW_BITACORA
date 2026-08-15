package main.dosw.semana_1.streams;

public class Transaction {
    
    private String id;
    private double amount;
    private boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public String toString() {
        return "Transacción: " + id + ", monto: " 
            + amount + ", estado aprovación: " + approved;
    }
}
