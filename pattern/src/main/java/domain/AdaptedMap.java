package domain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Map adaptado com List
 */
public class AdaptedMap<K, V> implements Map<K, V> {

    private List<K> keys;
    private List<V> values;

    public AdaptedMap(List<K> keys, List<V> values) throws Exception {
        if (keys.size() != values.size()) {
            throw new Exception("Listas de tamanhos diferentes passadas para o construtor!!");
        }

        this.keys = keys;
        this.values = values;
    }

    @Override
    public void clear() {
        this.keys.clear();
        this.values.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.values.contains(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AdaptedMap)) {
            return false;
        }

        AdaptedMap<Object, Object> adaptedMap = (AdaptedMap<Object, Object>) obj;

        return this.keys.equals(adaptedMap.keys) && this.values.equals(adaptedMap.values);
    }

    @Override
    public V get(Object key) {
        int index = this.keys.indexOf(key);
        return index != -1 ? this.values.get(index) : null;
    }

    @Override
    public boolean isEmpty() {
        return this.keys.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        int index = this.keys.indexOf(key);

        if (index == -1) {
            this.keys.add(key);
            this.values.add(value);
        } else {
            this.values.set(index, value);
        }

        return null;
    }

    @Override
    public V remove(Object key) {
        int index = this.keys.indexOf(key);

        if (index == -1) {
            return null;
        } else {
            V value = this.values.get(index);

            this.values.remove(value);
            this.keys.remove(key);

            return value;
        }
    }

    @Override
    public int size() {
        return this.keys.size();
    }

    @Override
    public Collection<V> values() {
        return this.values;
    }

    /**
     * UNSUPORTED OPERATIONS
     * 
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }
}