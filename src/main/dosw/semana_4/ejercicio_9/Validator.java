package main.dosw.semana_4.ejercicio_9;

import java.nio.file.AccessDeniedException;

public interface Validator {

    public Validator setNext(Validator validator);
    public void validate(AuthResult authentication) throws AccessDeniedException;

}