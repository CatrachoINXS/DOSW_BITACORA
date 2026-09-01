package main.dosw.semana_4.ejercicio_9;

public class GoogleStrategy implements AuthStrategy {

    @Override
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("Autenticando con google..");
        return new AuthResult(true, credentials.getUsername());
    }
    
}
