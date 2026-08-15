package main.dosw.semana_2;

import java.util.List;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", "Eléctrico", 0, 0, null, false),
            new Pokemon(null, "Charmander", "Fuego", 0, 0, null, false),
            new Pokemon(null, "Squirtle", "Agua", 0, 0, null, false),
            new Pokemon(null, "Bulbasaur", "Planta", 0, 0, null, false));

        List<String> pokemonesMayusculas = pokemones.stream()
            .map(p -> p.getNombre().toUpperCase())
            .toList();
        
        System.out.println(pokemonesMayusculas);
    }
}
