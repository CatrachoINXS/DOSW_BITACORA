package main.dosw.semana_4.ejercicio_6;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private RecommendationAlgorithm strategy;
    private List<PreferenceObserver> subscribers;

    public User(RecommendationAlgorithm strategy) {
        this.strategy = strategy;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(PreferenceObserver observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(PreferenceObserver observer) {
        subscribers.remove(observer);
    }

    public void changePreferences(RecommendationAlgorithm preference) {
        this.strategy = preference;
        notifySubscribers();
    }

    private void notifySubscribers() {
        subscribers.stream().forEach(s -> s.onPreferenceChanged(this));
    }

    public RecommendationAlgorithm getRecommendationAlgorithm() {
        return this.strategy;
    }
}
