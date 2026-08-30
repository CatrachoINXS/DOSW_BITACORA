# **Bitácora**

# SEMANA No 1 — DOSW Manejo de Streams 
 
## Datos personales: 
- Nombre y Apellido: Cristian Camilo Ortiz Sanchez
- Código de Estudiante: 1000105286
- Curso: DOSW-1

--- 

### Ejercicio 01 — Número Pares mayores a diez 

Dada una lista de números enteros, necesitamos obtener una nueva lista solo con los números pares mayores a 10.

| DATOS DE ENTRADA | SALIDA ESPERADA |
|----------|----------|
| [3, 8, 10, 12, 15, 18, 20]    | [12, 18, 20]    |

**Código implementado:**

```java
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {

        List<Integer> numeros = List.of(3,8,10,12,15,18,20);
        List<Integer> mayoresADiez = numeros.stream()
            .filter(n -> n > 10)
            .filter(n -> n % 2 == 0)
            .toList();

        System.out.println(mayoresADiez);
    }   
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_1.png)

**Explicación:** Primero se convierte la lista a un stream, usando `numeros.stream()`, despues aplicamos dos filter, uno para que los números sean mayores a 10, y otros para que sean pares. Finalmente, se convierte en una lista, con el método `toList()` y se imprime.

---

### Ejercicio 02 — Cantidad de Palabras con más de 4 caracteres

Dada una lista de palabras, se requiere: 

- Filtrar las palabras que tengan más de 4 caracteres 
- Convertirlas en Mayúsculas 
- Ordenarlas alfabéticamente 
- Obtener la cantidad total de palabras resultantes 

| DATOS DE ENTRADA | SALIDA ESPERADA |
|----------|----------|
| ["java","stream","api","functional","code", “git”]    | Cantidad de palabras resultantes: 2    |

**Código implementado:**

```java
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        List<String> palabras = List.of("java","stream","api",
            "functional","code","git");

        long cantidaPalabrasFiltradas = palabras.stream()
            .filter(p -> p.length() > 4)
            .map(String::toUpperCase)
            .sorted()
            .count();

        System.out.println("Cantidad de palabras resultantes: " 
            + cantidaPalabrasFiltradas);
    }
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_2.png)

**Explicación:** Se convierte la lista a un stream, aplicamos un `filter()` para las palabras con longitud mayor a 4, usamos map para convertir a mayusculas mediante el metodo `toUpperCase()` y con `count()`, devolvemos la cantidad de elementos.

---

### Ejercicio 03 — Obtener nombres de los Usuarios

Dada una lista de usuarios con los atributos: id, name, age, active 

Filtra únicamente los usuarios activos, obtén una lista con los nombres en mayúscula y ordenada alfabéticamente. 

| DATOS DE ENTRADA | SALIDA ESPERADA |
|----------|----------|
| `users = List<User>`   | `sortedUsers = List<String>`    |

**Código implementado:**

```java
public class User {

    private int id;
    private String name;
    private int age;
    private boolean active;

    public User(int id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}

import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {
        
        List<User> users = List.of(new User(1, "Cristian", 18, false),
            new User(2, "Camilo", 18, true),
            new User(3, "Pathfinder", 19, true),
            new User(4, "Mirage", 21, true));

        List<String> sortedUsers = users.stream()
            .filter(u -> u.isActive())
            .map(u -> u.getName().toUpperCase())
            .sorted()
            .toList();

        System.out.println(sortedUsers.toString());
    }  
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_3.png)

**Explicación:** Para ordenar los usuarios activos se convierte la lista de usuarios a un Stream, despues se filtran los activos, y mediante el método `map()` obtenemos el nombre de cada usuario y lo transformamos en mayusculas, ordenamos usando `sorted()` y lo convertimos a lista usando `toList()`.

---

### Ejercicio 04 — Personas mayores de edad 

Dado un listado de Usuarios y utilizando los mismo atributos anteriores, filtrar las personas mayores de edad y obtener sus nombres.

**Código implementado:**

```java
public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        List<User> users = List.of(new User(1, "Cristian", 15, false),
            new User(2, "Camilo", 18, true),
            new User(3, "Pathfinder", 16, true),
            new User(4, "Mirage", 21, true));

        users.stream()
            .filter(u -> u.getAge() >= 18)
            .map(u -> u.getName())
            .forEach(System.out::println);
    }
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_4.png)

**Explicación:** Se convierte la lista a un stream, aplicamos un `filter()` para los usuarios con edad mayor o igual a 18, usamos map para obtener el nombre e imprimimos cada uno.

---

### Ejercicio 05 — Transacciones Bancarias

Dada una lista de transacciones bancarias representadas por objetos: 

`class Transaction { String id; double amount; boolean approved; }` 

Se requiere procesar la lista usando Streams para: 

- Usar peek para ver cada transacción procesada (Utilizar System.out.println para ver la transacción) 
- Verificar si existe al menos una transacción no aprobada 
- Retornar true o false indicando si el lote de transacciones es válido.

**Código implementado:**

```java
public class Transaction {
    
    private String id;
    private double amount;
    private boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public String toString() {
        return "Transacción: " + id + ", monto: " 
            + amount + ", estado aprovación: " + approved;
    }
}

public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        List<Transaction> transacciones = List.of(
            new Transaction("A01", 1400 , true),
            new Transaction("A03", 2100 , true),
            new Transaction("A02", 400, true),
            new Transaction("A04", 243, false));

        boolean loteValido = transacciones.stream()
            .peek(t -> System.out.println(t.toString()))
            .allMatch(t -> t.isApproved() == true);

        System.out.println("\nValidez del lote: " + loteValido);
    }
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_5.png)

**Explicación:** Se transforma la lista de transacciones en un Stream, se hace peek de sus elementos para imprimirlos y al final se hace uso de `allMatch()` para retornar si todas las transacciones han sido aprovadas. 

---

# SEMANA No 2 — Bitácora Pokémon 

## Datos de Entrenador: 

- Nombre y Apellido: Cristian Camilo Ortiz Sanchez
- Código de Estudiante: 1000105286
- Curso: DOSW-1

--- 

### Ejercicio 01 — Pokemon Tipo Fuego

Dada una lista de Pokémon con nombre y tipo, obtener únicamente aquellos cuyo tipo sea Fuego.

**Código implementado:**

```java
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
            .filter(p -> p.getTipo() == "Fuego")
            .map(Pokemon::getNombre)
            .toList();
        
        System.out.println(pokemonesTipoFuego);
    }
}

public class Pokemon {
    
    private String nombre;
    private String tipo;

    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    } 

    public String getTipo() {
        return tipo;
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_1.png)

**Explicación:** Se usa un `filter()` para obtener unicamente los tipo Fuego y un `map()` para obtener los nombres de los pokemones.

---

### Ejercicio 02 — Pokédex Gritona

Transformar todos los nombres de Pokémon a mayúsculas. 

**Código implementado:**

```java
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
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_2.png)

**Explicación:** Se usa un `map()` transformar los nombres a mayusculas usando `toUpperCase()`.

---

### Ejercicio 03 — Poder Total del Equipo

Dada una lista de niveles de Pokémon, calcular la suma total de niveles del equipo.  

**Código implementado:**

```java
public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        List<Integer> niveles = List.of(45, 62, 38, 71, 55, 29);

        int sumaTotalNiveles = niveles.stream()
            .reduce(0, Integer::sum);

        System.out.println("Suma total de niveles: " + sumaTotalNiveles);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_3.png)

**Explicación:** Se usa `reduce()` junto con `Integer::sum` para sumar los elementos de la lista.

---

### Ejercicio 04 — Pokémon Alfa

Encontrar el Pokémon con el nivel más alto dentro del equipo.  

**Código implementado:**

```java
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
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_4.png)

**Explicación:** Se usa la función max() y se comparan los niveles de los pokemones mediante una lambda.

---

### Ejercicio 05 — Pokémon Legendarios 

Encontrar el Pokémon con el nivel más alto dentro del equipo.  

**Código implementado:**

```java
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
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_5.png)

**Explicación:** Se usa un `filter()` para escoger los pokemon con nivel mayor a 80 y despues se usa `count()`.

---

### Ejercicio 06 — Pokédex sin Duplicados

Dada una lista de Pokémon con elementos repetidos, generar una nueva colección donde cada Pokémon aparezca una sola vez.   

**Código implementado:**

```java
public class Ejercicio6 {
    
    public static void main(String[] args) {
        
        List<String> pokemones = List.of("Pikachu", "Charmander", "Pikachu", "Squirtle", "Charmander", "Mewtwo");

        System.out.println(pokemones.stream()
            .distinct()
            .toList()
        );
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_6.png)

**Explicación:** Se usa un `distinct()` en el stream para remover los elementos duplicados.

---

### Ejercicio 07 — Orden del Profesor Oak

El Profesor Oak quiere su Pokédex organizada. Ordenar alfabéticamente los nombres de los Pokémon.    

**Código implementado:**

```java
public class Ejercicio7 {
    
    public static void main(String[] args) {
        
        List<String> pokemones = List.of("Squirtle", "Pikachu", "Mewtwo",
            "Bulbasaur", "Charmander", "Abra");

        System.out.println(pokemones.stream().sorted().toList());
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_7.png)

**Explicación:** Se usa un `sorted()` en el stream para ordenar los nombres de los pokemon.

---

### Ejercicio 08 — Evoluciones Preparadas

Dada una lista de Pokémon que incluye si pueden evolucionar (boolean puedeEvolucionar), obtener únicamente los que estén listos para evolucionar.    

**Código implementado:**

```java
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
        
        System.out.println(pokemonesQuePuedenEvolucionar);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_8.png)

**Explicación:** Se usa un `filter()` en el stream para obtener únicamente los que pueden evolucionar y también un map para dejar solo el nombre.

---

### Ejercicio 09 — Equipo Élite

Mostrar únicamente los Pokémon cuyo poderCombate sea superior a 500.     

**Código implementado:**

```java
public class Ejercicio9 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", null, 0, 320, null, false),
            new Pokemon(null, "Mewtwo", null, 0, 680, null, false),
            new Pokemon(null, "Dragonite", null, 0, 530, null, false),
            new Pokemon(null, "Squirtle", null, 0, 210, null, false),
            new Pokemon(null, "Gengar", null, 0, 495, null, false),
            new Pokemon(null, "Charizard", null, 0, 610, null, false)
        );

        List<String> pokemonesElite = pokemones.stream()
            .filter(p -> p.getPoderCombate() > 500)
            .map(p -> p.getNombre() + "(" + (int) p.getPoderCombate() + ")")
            .toList();
        
        System.out.println("Equipo Élite (PC > 500): ");
        System.out.println(pokemonesElite);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_9.png)

**Explicación:** Se usa un `filter()` para obtener los que tengan poder mayor a 500 y un map para guardar la informacion en la lista.

---

### Ejercicio 10 — Pokédex Compacta

Generar una lista que contenga únicamente los nombres de todos los Pokémon del equipo.     

**Código implementado:**

```java
public class Ejercicio10 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", null, 0, 320, null, false),
            new Pokemon(null, "Mewtwo", null, 0, 680, null, false),
            new Pokemon(null, "Dragonite", null, 0, 530, null, false),
            new Pokemon(null, "Squirtle", null, 0, 210, null, false),
            new Pokemon(null, "Gengar", null, 0, 495, null, false),
            new Pokemon(null, "Charizard", null, 0, 610, null, false)
        );

        List<String> pokedexCompacta = pokemones.stream()
            .map(Pokemon::getNombre)
            .collect(Collectors.toList());

        System.out.println(pokedexCompacta);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_10.png)

**Explicación:** Se usa un `map()` para obtener el nombre de cada pokemon y despues se guarda en una lista.

---

### Ejercicio 11 — Poder Promedio

Calcular el promedio de poderCombate de todos los Pokémon del equipo     

**Código implementado:**

```java
public class Ejercicio11 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(3L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(4L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(5L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false),
            new Pokemon(6L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false)
        );

        double poderPromedio = pokemones.stream()
            .mapToDouble(Pokemon::getPoderCombate)
            .average()
            .orElse(0);

        System.out.printf("Poder de combate promedio: %f", poderPromedio);
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_11.png)

**Explicación:** Se usa `mapToDouble()` para extraer el poder de combate de cada pokemon y luego con `average()` sacamos el promedio facil.

---

### Ejercicio 12 — Campeón Regional 

Obtener el Pokémon con mayor poderCombate de toda la lista.

**Código implementado:**

```java
public class Ejercicio12 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(3L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(6L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false)
        );

        String campeon = pokemones.stream()
            .max((a, b) -> Double.compare(a.getPoderCombate(), b.getPoderCombate()))
            .map(p -> "Campeón: " + p.getNombre() + " con PC: " + p.getPoderCombate())
            .orElse(null);
        
        System.out.println(campeon);
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_12.png)

**Explicación:** Con el metodo `max()` comparamos el poder de combate para encontrar el mas fuerte y sacamos el mensaje formateado.

---

### Ejercicio 13 — Organizar por Tipo

Agrupar todos los Pokémon por su tipo y mostrar el listado por grupo.

**Código implementado:**

```java
public class Ejercicio13 {

    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(2L, "Psyduck", "Agua", 22, 245, "Kanto", false),
            new Pokemon(3L, "Charmander", "Fuego", 20, 215, "Kanto", false),
            new Pokemon(4L, "Vulpix", "Fuego", 21, 230, "Kanto", false),
            new Pokemon(5L, "Bulbasaur", "Planta/Veneno", 20, 218, "Kanto", false)
        );

        pokemones.stream()
            .collect(Collectors.groupingBy(Pokemon::getTipo))
            .forEach((a, b) -> {
                System.out.println(a + ":  " + b.stream().map(Pokemon::getNombre).toList());
            });
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_13.png)

**Explicación:** Se agrupan los pokemones usando `groupingBy()` por su tipo y despues imprimo la lista de nombres por cada tipo.

---

### Ejercicio 14 — Organizar por Región

Insertar Agrupar los Pokémon según su región de origen.     

**Código implementado:**

```java
public class Ejercicio14 {

    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Chikorita", "Planta", 18, 190, "Johto", false),
            new Pokemon(3L, "Torchic", "Fuego", 20, 210, "Hoenn", false),
            new Pokemon(4L, "Piplup", "Agua", 19, 205, "Sinnoh", false),
            new Pokemon(5L, "Charmander", "Fuego", 20, 215, "Kanto", false),
            new Pokemon(6L, "Totodile", "Agua", 19, 200, "Johto", false)
        );

        pokemones.stream()
            .collect(Collectors.groupingBy(Pokemon::getRegion))
            .forEach((a, b) -> {
                System.out.println(a + ":  " + b.stream().map(Pokemon::getNombre).toList());
            });
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_14.png)

**Explicación:** Igual al anterior pero esta vez usando `groupingBy()` para agruparlos segun la region a la que pertenecen.

---

### Ejercicio 15 — Maestro de Gimnasios

Dado un listado de entrenadores con sus medallas, encontrar el entrenador con más medallas.

**Código implementado:**

```java
public class Ejercicio15 {
    
    public static void main(String[] args) {
        
        List<Entrenador> entrenadores = List.of(
            new Entrenador(List.of(), 1L, 8, "Ash"),
            new Entrenador(List.of(), 2L, 5, "Misty"),
            new Entrenador(List.of(), 3L, 6, "Brock"),
            new Entrenador(List.of(), 4L, 10, "Gary")
        );

        Entrenador maestroDeGimnasios = entrenadores.stream()
            .max((a, b) -> Integer.compare(a.getMedallas(), b.getMedallas()))
            .orElse(null);
        
        System.out.println("Campeón de gimnasios: " + maestroDeGimnasios.getNombre());
        System.out.println("Medallas obtenidas: " + maestroDeGimnasios.getMedallas());
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_15.png)

**Explicación:** Usamos `max()` comparando la cantidad de medallas para saber cual es el entrenador que mas tiene.

---

### Ejercicio 16 — Entrenadores Experimentados

Mostrar únicamente los entrenadores que posean más de 5 medallas.

**Código implementado:**

```java
public class Ejercicio16 {
    
    public static void main(String[] args) {
        
        List<Entrenador> entrenadores = List.of(
            new Entrenador(List.of(), 1L, 8, "Ash"),
            new Entrenador(List.of(), 2L, 5, "Misty"),
            new Entrenador(List.of(), 3L, 6, "Brock"),
            new Entrenador(List.of(), 4L, 10, "Gary"),
            new Entrenador(List.of(), 5L, 3, "May"),
            new Entrenador(List.of(), 6L, 7, "Dawn")
        );

        List<String> entrenadoresConMasMedallas = entrenadores.stream()
            .filter(e -> e.getMedallas() > 5)
            .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
            .toList();

        System.out.println("Entrenadores con > 5 medallas:");
        System.out.println(entrenadoresConMasMedallas);
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_16.png)

**Explicación:** Se filtra con un `filter()` los entrenadores con mas de 5 medallas y armamos un string con su nombre y medallas.

---

### Ejercicio 17 — Equipo Más Poderoso

Calcular cuál entrenador tiene la suma total de poderCombate más alta entre todos sus Pokémon.

**Código implementado:**

```java
public class Ejercicio17 {
    
    public static void main(String[] args) {
        
        List<Pokemon> equipoAsh = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false),
            new Pokemon(3L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(4L, "Charmander", "Fuego", 20, 215, "Kanto", false),
            new Pokemon(5L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false)
        );

        List<Pokemon> equipoGary = List.of(
            new Pokemon(6L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(7L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(8L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false),
            new Pokemon(9L, "Blastoise", "Agua", 52, 520, "Kanto", false)
        );

        List<Pokemon> equipoBrock = List.of(
            new Pokemon(10L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(11L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false),
            new Pokemon(12L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(13L, "Onix", "Roca/Tierra", 22, 235, "Kanto", false),
            new Pokemon(14L, "Geodude", "Roca/Tierra", 19, 200, "Kanto", false)
        );

        List<Entrenador> entrenadores = List.of(
            new Entrenador(equipoAsh, 1L, 8, "Ash"),
            new Entrenador(equipoGary, 2L, 10, "Gary"),
            new Entrenador(equipoBrock, 3L, 6, "Brock")
        );

        Entrenador entrenadorMasPoderoso = entrenadores.stream()
            .max(Comparator.comparingDouble(e -> e.getEquipo()
                .stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum()))
            .orElse(null);

        System.out.println("Entrenador mas poderoso: " + entrenadorMasPoderoso.getNombre());
        System.out.println("Poder acumulado del equipo: " + entrenadorMasPoderoso.getEquipo()
            .stream().mapToDouble(Pokemon::getPoderCombate).sum());
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_17.png)

**Explicación:** Se calcula la suma del poder de todo el equipo de cada entrenador y sacamos el maximo con un `Comparator.comparingDouble()`.

---

### Ejercicio 18 — Top 5 Pokémon Más Fuertes

Generar un ranking de los cinco Pokémon con mayor poderCombate de toda la Pokédex.

**Código implementado:**

```java
public class Ejercicio18 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(4L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false),
            new Pokemon(1L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(9L, "Psyduck", "Agua", 22, 245, "Kanto", false),
            new Pokemon(3L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(6L, "Lucario", "Lucha/Acero", 50, 310, "Sinnoh", false),
            new Pokemon(5L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Rayquaza", "Dragón/Volador", 70, 200, "Hoenn", true),
            new Pokemon(10L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(7L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false),
            new Pokemon(8L, "Tyranitar", "Roca/Siniestro", 60, 220, "Johto", false)
        );

        List<Pokemon> topPokemones = pokemones.stream()
            .sorted(Comparator.comparing(Pokemon::getPoderCombate).reversed())
            .limit(5)
            .toList();

        IntStream.range(0, topPokemones.size())
            .forEach(i -> {
                Pokemon pokemon = topPokemones.get(i);
                System.out.println("#" + (i + 1) + " " 
                    + pokemon.getNombre() + " - PC: " + pokemon.getPoderCombate());
            });
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_18.png)

**Explicación:** Ordenamos con `sorted()` de mayor a menor poder de combate, nos quedamos con los primeros 5 usando `limit(5)` y los mostramos en lista.

---

## Retos Especiales
- [x] Reto Legendario — Method References
- [x] Reto Shiny — Buenas prácticas de commits
- [ ] Reto Mewtwo — Ejercicio propuesto
