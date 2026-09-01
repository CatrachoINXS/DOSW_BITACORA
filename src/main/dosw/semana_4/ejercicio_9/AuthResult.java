package main.dosw.semana_4.ejercicio_9;

public class AuthResult {

    private final boolean authenticated;
    private final String username;
    
    public AuthResult(boolean authenticated, String username) {
        this.authenticated = authenticated;
        this.username = username;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUsername() {
        return username;
    }
}