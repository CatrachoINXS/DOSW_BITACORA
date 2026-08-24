package main.dosw.semana_2;

import java.util.List;

public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon("Pikachu", "Eléctrico", 45),
            new Pokemon("Charmander", "Fuego", 62),
            new Pokemon("Squirtle", "Agua", 38),
            new Pokemon("Snorlax", "Normal", 90),
            new Pokemon("Mewtwo", "Psiquico", 88));

        Pokemon pokemonAlfa = pokemones.stream()
            .max((a, b) -> Integer.compare(a.getNivel(), b.getNivel()))
            .orElse(null);

        System.out.println("Pokemon Alfa: " + pokemonAlfa.getNombre() + 
            " (nivel " + pokemonAlfa.getNivel() + ")");
    }
}
