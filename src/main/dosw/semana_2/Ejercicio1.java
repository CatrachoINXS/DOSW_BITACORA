package main.dosw.semana_2;

import java.util.List;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon("Pikachu", "Eléctrico"),
            new Pokemon("Charmander", "Fuego"),
            new Pokemon("Squirtle", "Agua"),
            new Pokemon("Vulpix", "Fuego"),
            new Pokemon("Bulbasaur", "Planta"),
            new Pokemon("Flareon", "Fuego"));

        List<String> pokemonesTipoFuego = pokemones.stream()
            .filter(p -> "Fuego".equals(p.getTipo()))
            .map(Pokemon::getNombre)
            .toList();
        
        System.out.println(pokemonesTipoFuego);
    }
}
