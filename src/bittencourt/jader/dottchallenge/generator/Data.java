package bittencourt.jader.dottchallenge.generator;

import bittencourt.jader.dottchallenge.entity.Item;
import bittencourt.jader.dottchallenge.entity.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private static BigDecimal calculateGrandTotal(List<Item> items) {
        return items.stream()
                .map(Item::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static List<Order> generateOrders() {
        List<Order> orders = new ArrayList<>();

        CustomerName.getNames().forEach(name -> {
            List<Item> items = Items.generateRandomItemsList();
            orders.add(new Order(
                    name,
                    name + "@gmail.com",
                    Addresses.getRandomAddress(),
                    calculateGrandTotal(items),
                    PlacedOrderDate.getRandomPlacedOrderDate(),
                    items));
        });

        return orders;
    }
}
