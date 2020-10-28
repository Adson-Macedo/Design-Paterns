import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.AdaptedMap;

public class AdaptedMapTeste {

    Map<Integer, String> adaptedMap;
    Map<Integer, String> novoAdaptadorMap;

    @BeforeEach
    public void setUp() throws Exception {
        adaptedMap = new AdaptedMap<>(new ArrayList<Integer>(), new ArrayList<String>());
        novoAdaptadorMap = new AdaptedMap<>(new ArrayList<Integer>(), new ArrayList<String>());

        adaptedMap.put(10, "Thairam");
        adaptedMap.put(15, "Testes");
        adaptedMap.put(20, "Unidade");
    }

    @Test
    public void verificarConstrutor() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new AdaptedMap<>(new ArrayList<Integer>(Arrays.asList(1)), new ArrayList<String>());
        });
        assertEquals("Listas de tamanhos diferentes passadas para o construtor!!", exception.getMessage());
    }

    @Test
    public void verificarClear() {
        assertEquals(adaptedMap.size(), 3);
        adaptedMap.clear();
        assertEquals(adaptedMap.size(), 0);
    }

    @Test
    public void verificarContainsKey() {
        assertTrue(adaptedMap.containsKey(10));
        assertTrue(adaptedMap.containsKey(15));
        assertTrue(adaptedMap.containsKey(20));
        assertFalse(adaptedMap.containsKey(25));
    }

    @Test
    public void verificarContainsValue() {
        assertTrue(adaptedMap.containsValue("Testes"));
        assertTrue(adaptedMap.containsValue("Unidade"));
        assertTrue(adaptedMap.containsValue("Thairam"));
        assertFalse(adaptedMap.containsValue("Integração"));
    }

    @Test
    public void verificarEquals() throws Exception {
        novoAdaptadorMap.put(10, "Thairam");
        novoAdaptadorMap.put(15, "Testes");
        novoAdaptadorMap.put(20, "Unidade");

        assertTrue(adaptedMap.equals(adaptedMap));
        assertTrue(adaptedMap.equals(novoAdaptadorMap));

        novoAdaptadorMap.put(25, "Integração");

        assertFalse(adaptedMap.equals(novoAdaptadorMap));
        assertFalse(adaptedMap.equals(new AdaptedMap<>(new ArrayList<Boolean>(), new ArrayList<String>())));
        assertFalse(adaptedMap.equals(new Object()));
    }

    @Test
    public void verificarGet() {
        assertEquals(adaptedMap.get(20), "Unidade");
        assertEquals(adaptedMap.get(10), "Thairam");
        assertEquals(adaptedMap.get(15), "Testes");
        assertEquals(adaptedMap.get(25), null);
    }

    @Test
    public void verificarIsEmpty() {
        assertTrue(novoAdaptadorMap.isEmpty());
        assertFalse(adaptedMap.isEmpty());
    }

    @Test
    public void verificarPut() {
        assertEquals(adaptedMap.size(), 3);
        assertEquals(adaptedMap.get(15), "Testes");

        adaptedMap.put(15, "Testes Atualizado");
        assertEquals(adaptedMap.size(), 3);
        assertEquals(adaptedMap.get(15), "Testes Atualizado");
    }

    @Test
    public void verificarRemove() {
        assertEquals(adaptedMap.remove(1), null);
        assertEquals(adaptedMap.remove(10), "Thairam");
        assertEquals(adaptedMap.remove(20), "Unidade");
        assertEquals(adaptedMap.remove(15), "Testes");
    }

    @Test
    public void verificarSize() {
        assertEquals(adaptedMap.size(), 3);
        assertEquals(novoAdaptadorMap.size(), 0);
    }

    @Test
    public void verificarValues() {
        assertEquals(adaptedMap.values(), Arrays.asList("Thairam", "Testes", "Unidade"));
    }

    @Test
    public void verificarOperacoesNaoSuportadas() {
        assertThrows(UnsupportedOperationException.class, () -> {
            adaptedMap.entrySet();
        });

        assertThrows(UnsupportedOperationException.class, () -> {
            adaptedMap.putAll(novoAdaptadorMap);
        });

        assertThrows(UnsupportedOperationException.class, () -> {
            adaptedMap.keySet();
        });
    }
}