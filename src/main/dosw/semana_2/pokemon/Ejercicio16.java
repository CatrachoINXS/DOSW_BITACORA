package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio16 {
    
    public static void main(String[] args) {
        
        List<Entrenador> entrenadores = List.of(
            new Entrenador(List.of(), 1L, 8, "Ash"),
            new Entrenador(List.of(), 2L, 5, "Misty"),
            new Entrenador(List.of(), 3L, 6, "Brock"),
            new Entrenador(List.of(), 4L, 10, "Gary"),
            new Entrenador(List.of(), 5L, 3, "May"),
            new Entrenador(List.of(), 6L, 7, "Dawn")
        );

        List<String> entrenadoresConMasMedallas = entrenadores.stream()
            .filter(e -> e.getMedallas() > 5)
            .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
            .toList();

        System.out.println("Entrenadores con > 5 medallas:");
        System.out.println(entrenadoresConMasMedallas);
    }
}
