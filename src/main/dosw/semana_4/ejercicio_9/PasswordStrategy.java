package main.dosw.semana_4.ejercicio_9;

public class PasswordStrategy implements AuthStrategy {

    @Override
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("Autenticando con contraseña..");
        if (credentials.getUsername() != null && credentials.getPassword() != null) {
            return new AuthResult(true, credentials.getUsername());
        }
        return new AuthResult(false, credentials.getUsername());
    }
    
}
