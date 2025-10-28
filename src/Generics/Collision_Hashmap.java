
package Generics;
import java.util.*;

class Key
{
    String name;

    Key(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 42;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key k = (Key) o;
        return Objects.equals(name, k.name);
    }

    @Override
    public String toString() {
        return name;
    }

}

public class Collision_Hashmap
{
    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();

        map.put(new Key("A1"), "Apple");
        map.put(new Key("A2"), "Banana");
        map.put(new Key("A3"), "Cherry");

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
