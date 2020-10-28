import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.AdaptedList;
import domain.AdaptedMap;

public class Main {

    public static void main(String[] args) {
        try {
            List<Integer> keys = new ArrayList<Integer>();
            List<String> values = new ArrayList<String>();

            Map<Integer, String> adaptador1 = new AdaptedMap<>(keys, values);
            Map<String, Integer> adaptador2 = new AdaptedMap<>(new ArrayList<>(), new ArrayList<>());

            // put()
            adaptador1.put(10, "Geeks");
            adaptador1.put(15, "4");
            adaptador1.put(20, "Geeks");
            adaptador1.put(25, "Welcomes");
            adaptador1.put(30, "You");

            System.out.println(adaptador1.values());
            adaptador1.put(25, "atualizado");
            adaptador1.put(30, "atualizado");
            System.out.println(adaptador1.values());

            // containsKey()
            System.out.println("Contains key: " + adaptador1.containsKey(10));

            // containsValue()
            System.out.println("Contains value: " + adaptador1.containsValue("Geeks"));

            // equals()
            System.out.println("is equal? " + adaptador1.equals(adaptador1));
            System.out.println("is equal? " + adaptador1.equals(adaptador2));

            // values()
            System.out.println("Initial Mappings are: " + adaptador1.values());

            // get()
            System.out.println("The Value is: " + adaptador1.get(25));
            System.out.println("The Value is: " + adaptador1.get(10));
            System.out.println("The Value is: " + adaptador1.get(100));

            // remove()
            System.out.println("Removing " + adaptador1.remove(25));
            System.out.println("Element not exist: " + adaptador1.remove(25));

            // isEmpty()
            System.out.println("is empty? " + adaptador1.isEmpty());
            System.out.println("is empty? " + adaptador2.isEmpty());

            // size()
            System.out.println("Size: " + adaptador1.size());
            System.out.println("Size: " + adaptador2.size());

            // clear()
            adaptador1.clear();
            adaptador2.clear();

            System.out.println("After clear, size is: " + adaptador1.size());
            System.out.println("After clear, size is: " + adaptador2.size());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        System.out.println("*****************************************************");
        List<String> lista1 = new AdaptedList<>(new HashMap<Integer, String>());

        System.out.println("List size: " + lista1.size());
        lista1.add("Uma string");
        lista1.add("Outra string");
        lista1.add("Mais uma string");
        lista1.add("Penultima string");
        lista1.add("Ultima string");
        System.out.println("List size: " + lista1.size());
        System.out.println("lista1[0]: " + lista1.get(0));
        
        for (String string : lista1){
            System.out.print(string + ", ");
        }

        System.out.println();
        System.out.println(Arrays.toString(lista1.toArray()));

        lista1.clear();
        
        System.out.println("List size: " + lista1.size());
        System.out.println(Arrays.toString(lista1.toArray()));
    }

    
}