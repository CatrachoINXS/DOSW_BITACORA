package main.dosw.semana_4.ejercicio_9;

import java.nio.file.AccessDeniedException;

public class Main {
    
    public static void main(String[] args) {
        AuthService service = new AuthService(new BiometricStrategy());
        Validator chain = new CredentialValidator();

        chain.setNext(new PermissionValidator())
            .setNext(new LocationValidator())
            .setNext(new TimeValidator());

        AuthResult result = service.authenticate(new Credentials("CatrachoINXS", "contraseña123"));
        
        try {
            chain.validate(result);
        } catch (AccessDeniedException e) {
            System.out.println("\nACCESS DENIED EXCEPTION");
            e.printStackTrace();
        }
    }
}
