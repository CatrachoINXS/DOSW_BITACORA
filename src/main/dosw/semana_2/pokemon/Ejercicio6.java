package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio6 {
    
    public static void main(String[] args) {
        
        List<String> pokemones = List.of("Pikachu", "Charmander", "Pikachu", "Squirtle", "Charmander", "Mewtwo");

        System.out.println(pokemones.stream()
            .distinct()
            .toList()
        );
    }
}
