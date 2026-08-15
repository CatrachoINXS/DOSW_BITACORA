package main.dosw.semana_2;

import java.util.List;

public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", "Eléctrico", 45, 0, null, false),
            new Pokemon(null, "Charmander", "Fuego", 62, 0, null, false),
            new Pokemon(null, "Squirtle", "Agua", 38, 0, null, false),
            new Pokemon(null, "Snorlax", "Normal", 90, 0, null, false),
            new Pokemon(null, "Mewtwo", "Psiquico", 88, 0, null, false));

        Pokemon pokemonAlfa = pokemones.stream()
            .max((a, b) -> Integer.compare(a.getNivel(), b.getNivel()))
            .orElse(null);

        System.out.println("Pokemon Alfa: " + pokemonAlfa.getNombre() + 
            " (nivel " + pokemonAlfa.getNivel() + ")");
    }
}
