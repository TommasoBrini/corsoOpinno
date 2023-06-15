import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultimappaGenerica<K, V> implements Iterable<MultimappaGenerica.Elemento<K,V>>{
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

    public <Z> MultimappaGenerica<K,Z> tranformToMultiMappa(BiFunction<K, V, Z> f){
        MultimappaGenerica<K,Z> res = new MultimappaGenerica<>();
        map.forEach((k,v) -> v.forEach(value -> res.put(k,f.apply(k,value))));
        return res;
    }

    public void mapEach(BiFunction<K,V,V> f){
        map.replaceAll((k,v) -> v.stream()
                .map(value -> f.apply(k,value))
                .collect(Collectors.toList()));
    }



    @Override
    public String toString() {
        return "map=" + map;
    }

    @Override
    public Iterator<Elemento<K, V>> iterator() {
        List<Elemento<K, V>> elements = new ArrayList<>();
        map.forEach((key, values) ->
                values.forEach(value -> elements.add(new Elemento<>(key, value))));
        return elements.iterator();
    }

    public class Elemento<K,V>{
        private final K key;
        private final V value;

        public Elemento(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


}
