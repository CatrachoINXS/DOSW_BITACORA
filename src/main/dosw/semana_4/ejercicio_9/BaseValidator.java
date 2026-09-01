package main.dosw.semana_4.ejercicio_9;

import java.nio.file.AccessDeniedException;

public abstract class BaseValidator implements Validator {
    private Validator next;

    @Override
    public Validator setNext(Validator validator) {
        this.next = validator;
        return validator;
    }

    @Override
    public void validate(AuthResult authentication) throws AccessDeniedException {
        if (next != null) {
            next.validate(authentication);
        } else {
            System.out.println("\nSe ha validado correctamente.");
        }
    }
}
