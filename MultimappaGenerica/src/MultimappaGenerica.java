import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultimappaGenerica<K, V> {
    Map<K, List<V>> map;

    public MultimappaGenerica() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public void putAll(MultimappaGenerica<K, V> m) {
        m.map.forEach((k, v) -> map.computeIfAbsent(k, key -> new ArrayList<>()).addAll(v));
    }

    public void removeAll(MultimappaGenerica<K, V> m) {
        m.map.keySet().forEach(map::remove);
    }

    public List<V> get(K key) {
        return map.get(key);
    }

    public List<V> get(K key, Predicate<V> predicate) {
        return map.getOrDefault(key, Collections.emptyList()).stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<V> values() {
        return map.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public Set<V> valueSet() {
        return map.values().stream().flatMap(List::stream).collect(Collectors.toSet());
    }

    public <Z> MultimappaGenerica<K, Z> transformToMultiMappa(BiFunction<K, V, Z> f) {
        MultimappaGenerica<K, Z> transformedMultiMap = new MultimappaGenerica<>();
        map.forEach((key, values) -> values.forEach(value -> transformedMultiMap.put(key, f.apply(key, value))));
        return transformedMultiMap;
    }

    public void mapEach(BiFunction<K, V, V> function) {
        map.replaceAll((key, values) ->
                values.stream()
                        .map(value -> function.apply(key, value))
                        .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "map=" + map;
    }
}
