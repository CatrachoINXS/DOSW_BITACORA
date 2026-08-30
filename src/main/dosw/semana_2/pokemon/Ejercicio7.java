package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio7 {
    
    public static void main(String[] args) {
        
        List<String> pokemones = List.of("Squirtle", "Pikachu", "Mewtwo",
            "Bulbasaur", "Charmander", "Abra");

        System.out.println(pokemones.stream().sorted().toList());
    }
}
