package main.dosw.semana_2;

import java.util.List;

public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", "Eléctrico", 45, 0, null, false),
            new Pokemon(null, "Charmander", "Fuego", 62, 0, null, false),
            new Pokemon(null, "Squirtle", "Agua", 38, 0, null, false),
            new Pokemon(null, "Dragonite", null, 82, 0, null, false),
            new Pokemon(null, "Mewtwo", "Psiquico", 88, 0, null, false),
            new Pokemon(null, "Mew", null, 85, 0, null, false));

        long cantidadPokemonesLegendarios = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .count();

        System.out.println("Pokémon con nivel > 80: " + cantidadPokemonesLegendarios);
    }
}
