package main.dosw.semana_4.ejercicio_9;

import java.nio.file.AccessDeniedException;

public class PermissionValidator extends BaseValidator {
    
    @Override
    public void validate(AuthResult authentication) throws AccessDeniedException {
        System.out.println("    [PermissionValidators] permisos válidos");
        super.validate(authentication);
    }
}
