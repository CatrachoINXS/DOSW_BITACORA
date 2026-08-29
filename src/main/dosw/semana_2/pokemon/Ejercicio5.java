package main.dosw.semana_2;

import java.util.List;

public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon("Pikachu", "Eléctrico", 45),
            new Pokemon("Charmander", "Fuego", 62),
            new Pokemon("Squirtle", "Agua", 38),
            new Pokemon("Dragonite", null, 82),
            new Pokemon("Mewtwo", "Psiquico", 88),
            new Pokemon("Mew", null, 85));

        long cantidadPokemonesLegendarios = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .count();

        System.out.println("Pokémon con nivel > 80: " + cantidadPokemonesLegendarios);
    }
}
