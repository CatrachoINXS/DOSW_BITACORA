package main.dosw.semana_2;

import java.util.List;

public class Ejercicio15 {
    
    public static void main(String[] args) {
        
        List<Entrenador> entrenadores = List.of(
            new Entrenador(List.of(), 1L, 8, "Ash"),
            new Entrenador(List.of(), 2L, 5, "Misty"),
            new Entrenador(List.of(), 3L, 6, "Brock"),
            new Entrenador(List.of(), 4L, 10, "Gary")
        );

        Entrenador maestroDeGimnasios = entrenadores.stream()
            .max((a, b) -> Integer.compare(a.getMedallas(), b.getMedallas()))
            .orElse(null);
        
        System.out.println("Campeón de gimnasios: " + maestroDeGimnasios.getNombre());
        System.out.println("Medallas obtenidas: " + maestroDeGimnasios.getMedallas());
    }
}
