package main.dosw.semana_4.ejercicio_9;

public class BiometricStrategy implements AuthStrategy {

    @Override
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("Autenticando con huella..");
        return new AuthResult(true, credentials.getUsername());
    }
    
}
