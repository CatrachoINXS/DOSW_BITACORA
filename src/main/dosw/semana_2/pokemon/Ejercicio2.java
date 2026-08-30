package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon("Pikachu", "Eléctrico"),
            new Pokemon("Charmander", "Fuego"),
            new Pokemon("Squirtle", "Agua"),
            new Pokemon("Bulbasaur", "Planta"));

        List<String> pokemonesMayusculas = pokemones.stream()
            .map(p -> p.getNombre().toUpperCase())
            .toList();
        
        System.out.println(pokemonesMayusculas);
    }
}
