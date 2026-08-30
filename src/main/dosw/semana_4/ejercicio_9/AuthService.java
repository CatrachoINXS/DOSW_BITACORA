package main.dosw.semana_4.ejercicio_9;

public class AuthService {
    
    private AuthStrategy strategy;

    public AuthService(AuthStrategy strategy) {
        this.strategy = strategy;
    }

    public AuthResult authenticate(Credentials credentials) {
        return strategy.authenticate(credentials);
    }

    public void setStrategy(AuthStrategy strategy) {
        this.strategy = strategy;
    }
    
}
