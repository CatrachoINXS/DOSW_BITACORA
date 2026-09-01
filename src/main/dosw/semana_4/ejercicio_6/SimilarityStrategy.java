package main.dosw.semana_4.ejercicio_6;

import java.util.List;

public class SimilarityStrategy implements RecommendationAlgorithm {

    @Override
    public List<Content> recommend(User user) {
        return List.of(
            new Content("Pelicula IronMan"),
            new Content("Pelicula IronMan II"));
    }
}