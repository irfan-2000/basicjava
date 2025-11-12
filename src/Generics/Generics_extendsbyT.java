package Generics;

import java.util.*;

// 🏪 JYXKART example classes
class Product {
    @Override
    public String toString() {
        return "Generic Product";
    }
}

class Electronics extends Product {
    @Override
    public String toString() {
        return "Electronics Item";
    }
}

class Mobile extends Electronics {
    @Override
    public String toString() {
        return "Mobile Phone";
    }
}

  class JyxKartGenericsDemo {

    // ✅ This method only READS (Producer)
    static void printProducts(List<? extends Product> products) {
        System.out.println("Printing products...");
        for (Product p : products) {
            System.out.println(" - " + p);
        }

        // ❌ X: Not allowed to add because list could be List<Mobile>, List<Electronics>, etc.
        // products.add(new Mobile());  // Compile error
    }

    // ✅ This method only WRITES (Consumer)
    static void addMobiles(List<? super Mobile> list) {
        System.out.println("\nAdding mobiles...");

        list.add(new Mobile());     // ✅ Allowed — we can always add a Mobile
        list.add(new Mobile());     // ✅ Another Mobile

        // ❌ X: Reading as Mobile is not safe; the list could be List<Product> or List<Object>
        // Mobile m = list.get(0);   // Compile error
        Object o = list.get(0);      // ✅ Only safe to read as Object
        System.out.println("Read as Object: " + o);
    }

    public static void main(String[] args) {

        List<Mobile> mobileList = new ArrayList<>();
        mobileList.add(new Mobile());
        mobileList.add(new Mobile());

        List<Electronics> electronicsList = new ArrayList<>();
        electronicsList.add(new Electronics());

        List<Product> productList = new ArrayList<>();
        productList.add(new Product());

        // -------------------------------
        // ✅ Scenario 1: Reading (extends)
        // -------------------------------
        System.out.println("=== Scenario 1: Reading ===");
        printProducts(mobileList);       // OK - List<Mobile>
        printProducts(electronicsList);  // OK - List<Electronics>
        printProducts(productList);      // OK - List<Product>

        // ❌ X: Can't write inside printProducts() because of '? extends Product'

        // -------------------------------
        // ✅ Scenario 2: Writing (super)
        // -------------------------------
        System.out.println("\n=== Scenario 2: Writing ===");
        addMobiles(mobileList);      // OK - exact type
        addMobiles(electronicsList); // OK - parent type
        addMobiles(productList);     // OK - even higher parent type

        // ❌ X: Can't read as Mobile inside addMobiles() because '? super Mobile' may be Product/Object list
    }
}
