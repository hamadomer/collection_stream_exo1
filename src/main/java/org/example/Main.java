package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            List<Purchase> list = new ArrayList<>();

            Purchase purchase1 = new Purchase(new Client("Dupond", "Jean", LocalDate.of(1990, 3, 12)), "Savon", 3, LocalDate.of(2024, 8, 1));
            Purchase purchase2 = new Purchase(new Client("Dupond", "Jean", LocalDate.of(1990, 3, 12)), "Serviette", 1, LocalDate.of(2024, 8, 1));
            Purchase purchase3 = new Purchase(new Client("Dupond", "Jean", LocalDate.of(1990, 3, 12)), "Baguette", 4, LocalDate.of(2024, 8, 1));
            Purchase purchase4 = new Purchase(new Client("Dupond", "Jean", LocalDate.of(1990, 3, 12)), "Baguette", 6, LocalDate.of(2024, 8, 4));
            Purchase purchase5 = new Purchase(new Client("Dupont", "Benoit", LocalDate.of(2001, 8, 31)), "Piles", 1, LocalDate.of(2024, 8, 4));
            Purchase purchase6 = new Purchase(new Client("Dupont", "Benoit", LocalDate.of(2001, 8, 31)), "Baguette", 3, LocalDate.of(2024, 8, 4));

            list.add(purchase1);
            list.add(purchase2);
            list.add(purchase3);
            list.add(purchase4);
            list.add(purchase5);
            list.add(purchase6);

            Map<Client, Map<String, Integer>> finalresualt = new HashMap<>();

            // Go through my list : foreach purchase i should :
            // 1- check if the client already exist, if it does check if the item already exist
            // if it does increment it, else add it to and set it to 1
            // if client does not exist create it and then do the other steps

            list.stream().forEach(purchase -> {
                    // if client isn't already key, create one
                    if(!finalresualt.containsKey(purchase.getClient())) {
                            finalresualt.put(purchase.getClient(), new HashMap<>());
                    }
                    // if client exists get his purchases values
                    Map<String, Integer> clientPurchases  = finalresualt.get(purchase.getClient());

                    // check if client has already this product in his inventory
                    if (clientPurchases.containsKey(purchase.getProduct())) {
                            // Increment the values by the new purchase values
                            clientPurchases.put(purchase.getProduct(), clientPurchases.get(purchase.getProduct()) + purchase.getQuantity());
                    } else {
                            clientPurchases.put(purchase.getProduct(), purchase.getQuantity());
                    }
            });

            finalresualt.entrySet().stream()
                    .forEach(entry -> {
                            Client client = entry.getKey();
                            Map<String, Integer> purchases = entry.getValue();
                            purchases.forEach((product, quantity) -> {
                                    System.out.println(client.toString() + " - " + product + " - " + quantity);
                            });
                    });
    }
}