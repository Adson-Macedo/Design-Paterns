import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.AdaptedList;

public class AdaptedListTest {
    public List<String> umaLista;

    @BeforeEach
    public void setup() {
        Map<Integer, String> map = new HashMap<>();
        umaLista = new AdaptedList<>(map);
    }

    @Test
    public void verificaAdd() {
        umaLista.add("Uma String");
        umaLista.add("Outra String");

        assertEquals("Uma String", umaLista.get(0));
        assertEquals("Outra String", umaLista.get(1));
    }

    @Test
    public void verificaClear() {
        umaLista.add("Uma String");
        umaLista.add("Outra String");

        assertEquals("Uma String", umaLista.get(0));

        umaLista.clear();
        assertEquals(umaLista.size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            umaLista.get(0);
        });
    }

    @Test
    public void verificaContains() {
        umaLista.add("Uma String");
        umaLista.add("Outra String");

        assertTrue(umaLista.contains("Uma String"));
        assertTrue(umaLista.contains("Outra String"));
    }

    @Test
    public void verificaEquals() {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> outroMap = new HashMap<>();
        List<String> outraLista = new AdaptedList<>(map);
        List<String> maisUmaLista = new AdaptedList<>(outroMap);

        umaLista.add("Uma String");
        umaLista.add("Outra String");

        outraLista.add("Mais uma string");
        outraLista.add("Ultima string");

        maisUmaLista.add("Uma String");
        maisUmaLista.add("Outra String");

        assertEquals(umaLista, maisUmaLista);
        assertNotEquals(outraLista, maisUmaLista);
        assertNotEquals(outraLista, umaLista);
    }

    @Test
    public void verificaGet() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Uma string");
        map.put(7, "Outra string");

        List<String> outraLista = new AdaptedList<>(map);

        outraLista.add("Mais uma string");
        outraLista.add("Ultima string");

        assertEquals(null, outraLista.get(0));
        assertEquals("Uma string", outraLista.get(1));
        assertEquals(null, outraLista.get(2));
        assertEquals(null, outraLista.get(3));
        assertEquals(null, outraLista.get(4));
        assertEquals(null, outraLista.get(5));
        assertEquals(null, outraLista.get(6));
        assertEquals("Outra string", outraLista.get(7));
        assertEquals("Mais uma string", outraLista.get(8));
        assertEquals("Ultima string", outraLista.get(9));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            outraLista.get(10);
        });
    }

    @Test
    public void verificaIsEmpty() {
        assertTrue(umaLista.isEmpty());
        umaLista.add("Uma String");
        assertFalse(umaLista.isEmpty());
        umaLista.clear();
        assertTrue(umaLista.isEmpty());
    }

    @Test
    public void verificaIterator() {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 1.5);
        map.put(7, 2.5);

        List<Double> outraLista = new AdaptedList<>(map);

        java.util.Iterator<Double> it = outraLista.iterator();

        assertEquals(1.5, it.next());
        assertEquals(2.5, it.next());
    }

    @Test
    public void verificarRemoveByIndex() {
        umaLista.add("Uma String");
        umaLista.add("Outra String");

        assertEquals("Uma String", umaLista.remove(0));
        assertEquals("Outra String", umaLista.get(0));
    }

    @Test
    public void verificarRemoveByObject() {
        umaLista.add("Uma String");
        umaLista.add("Outra String");

        assertTrue(umaLista.remove("Uma String"));
        assertEquals("Outra String", umaLista.get(0));
        assertTrue(umaLista.remove("Outra String"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            umaLista.get(0);
        });
    }

    @Test
    public void verificarSize() {
        assertEquals(0, umaLista.size());
        umaLista.add("Uma String");
        umaLista.add("Outra String");
        assertEquals(2, umaLista.size());

        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 1.5);
        map.put(7, 2.5);
        List<Double> outraLista = new AdaptedList<>(map);

        assertEquals(8, outraLista.size());
        outraLista.add(5.5);
        assertEquals(9, outraLista.size());
    }

    @Test
    public void verificarToArray() {
        umaLista.add("Uma String");
        umaLista.add("Outra String");

        umaLista.add("Mais uma string");
        umaLista.add("Ultima string");

        Object[] strings = { "Uma String", "Outra String", "Mais uma string", "Ultima string" };

        assertArrayEquals(strings, umaLista.toArray());

    }
}
