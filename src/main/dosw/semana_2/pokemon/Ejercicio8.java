package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio8 {

    public static void main(String[] args) {
        
        List<String> pokemones = List.of(
            "Pikachu(true)",
            "Raichu(false)",
            "Charmander(true)",
            "Charizard(false)",
            "Squirtle(true)",
            "Blastoise(false)"
        );

        List<String> pokemonesQuePuedenEvolucionar = pokemones.stream()
            .filter(p -> p.endsWith("true)"))
            .map(p -> p.substring(0, p.indexOf("(")))
            .toList();
        
        System.out.println("Listos para evolucionar:");
        System.out.println(pokemonesQuePuedenEvolucionar);
    }
}