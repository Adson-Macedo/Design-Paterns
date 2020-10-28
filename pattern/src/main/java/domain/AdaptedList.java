package domain;

import java.util.Map.Entry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

public class AdaptedList<T> implements List<T> {
    private Map<Integer, T> map;

    public AdaptedList(Map<Integer, T> map) {
        this.map = map;
    }

    @Override
    public boolean add(T e) {
        this.map.put(this.size(), e);
        return true;
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.values().contains(o);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AdaptedList))
            return false;

        AdaptedList<Object> adaptedList = (AdaptedList<Object>) obj;

        return this.map.equals(adaptedList.map);
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size());
        return this.map.get(index);
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return this.map.values().iterator();
    }

    @Override
    public boolean remove(Object o) {
        Integer index = getIndex(o);

        if (index != null) {
            remove(index.intValue());
            return true;
        }

        return false;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size());

        T element = map.get(index);
        this.map.remove(index);

        Map<Integer, T> updates = new HashMap<>();

        this.map.entrySet().forEach(entry -> {
            if (entry.getKey() > index) {
                updates.put(entry.getKey(), entry.getValue());
            }
        });

        updates.entrySet().forEach(entry -> {
            map.remove(entry.getKey());
            map.put(entry.getKey() - 1, entry.getValue());
        });

        return element;
    }

    @Override
    public int size() {
        if (map.size() == 0)
            return 0;
        return Collections.max(this.map.keySet()) + 1;
    }

    @Override
    public Object[] toArray() {
        return this.map.values().toArray();
    }

    /**
     * Método auxiliar para retornar o key a partir de um value
     */
    private Integer getIndex(Object o) {
        for (Entry<Integer, T> entry : this.map.entrySet()) {
            if (entry.getValue().equals(o))
                return entry.getKey();
        }

        return null;
    }

    /**
     * UNSUPORTED OPERATIONS
     * 
     */
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}