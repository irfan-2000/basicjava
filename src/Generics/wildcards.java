import java.util.*;

class Person {
    public String toString() { return "Person"; }
}

class Employee extends Person {
    public String toString() { return "Employee"; }
}

class Manager extends Employee {
    public String toString() { return "Manager"; }
}

public class WildcardExample {

    public static <T> void copyList(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);  // ✅ Allowed — we can add T items to super of T
        }

        // ❌ dest.add(src.get(0));  // Not allowed, because src.get(0) is ? extends T, not exactly T
        // ❌ src.add(null);         // Not allowed — can't add anything to extends list except null

        // ✅ You can read from src safely as T:
        T element = src.get(0);

        // ❌ You cannot assume the type when reading from dest:
        // T element2 = dest.get(0); // Compile error
    }

    public static void main(String[] args) {
        List<Manager> managers = Arrays.asList(new Manager(), new Manager());
        List<Employee> employees = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        // ✅ Valid combinations:
        copyList(managers, employees);  // Manager → Employee (extends/super ok)
        copyList(managers, persons);    // Manager → Person
        copyList(employees, persons);   // Employee → Person

        // ❌ Invalid combinations:
        // copyList(persons, employees); // X — Person not extends Employee
        // copyList(employees, managers); // X — Employee not extends Manager
    }
}
