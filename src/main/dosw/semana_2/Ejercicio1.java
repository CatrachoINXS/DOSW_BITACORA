package main.dosw.semana_2;

import java.util.List;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", "Eléctrico", 0, 0, null, false),
            new Pokemon(null, "Charmander", "Fuego", 0, 0, null, false),
            new Pokemon(null, "Squirtle", "Agua", 0, 0, null, false),
            new Pokemon(null, "Vulpix", "Fuego", 0, 0, null, false),
            new Pokemon(null, "Bulbasaur", "Planta", 0, 0, null, false),
            new Pokemon(null, "Flareon", "Fuego", 0, 0, null, false));

        List<String> pokemonesTipoFuego = pokemones.stream()
            .filter(p -> p.getTipo() == "Fuego")
            .map(Pokemon::getNombre)
            .toList();
        
        System.out.println(pokemonesTipoFuego);
    }
}
