package main.dosw.semana_4.ejercicio_9;

import java.nio.file.AccessDeniedException;

public class CredentialValidator extends BaseValidator {
    
    @Override
    public void validate(AuthResult authentication) throws AccessDeniedException {
        System.out.println("    [CredentialValidators] validando las credenciales..");
        if (!authentication.isAuthenticated()) {
            throw new AccessDeniedException("Credenciales invalidas");
        }

        System.out.println("    Credenciales válidas\n");
        super.validate(authentication);
    }
}