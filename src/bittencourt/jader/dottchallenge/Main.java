package bittencourt.jader.dottchallenge;

import bittencourt.jader.dottchallenge.entity.Order;
import bittencourt.jader.dottchallenge.generator.Data;
import bittencourt.jader.dottchallenge.validator.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    private static LocalDateTime startDate;
    private static LocalDateTime endDate;

    public static void main(String... args) {
        // validates if the minimum number of parameters was provided
        if (areParametersIncorrect(args))
            return;

        // validates if the provided date are parseables
        if (areDatesIncorrect(args))
            return;

        List<Order> orders = Data.generateOrders();
        System.out.println("xxxxxxxxxxxxxxxxx");
        System.out.println("Total unfiltered orders: " + orders.size());

        List<Order> filteredOrders = filterOrdersByDate(orders);
        System.out.println("Total filtered orders: " + filteredOrders.size());
        System.out.println("Orders filtered based on: " + startDate.toString() + " and " + endDate.toString());
        System.out.println("xxxxxxxxxxxxxxxxx");

        calculateDefaultOrderGroups(filteredOrders);
        calculateCustomIntervals(filteredOrders, args);
    }

    private static void calculateDefaultOrderGroups(List<Order> filteredOrders) {
        System.out.println("DEFAULT GROUP FILTERS");
        calculateOrdersByInterval(filteredOrders, 1, 3);
        calculateOrdersByInterval(filteredOrders, 4, 6);
        calculateOrdersByInterval(filteredOrders, 7, 12);
        calculateOrdersByInterval(filteredOrders, ">", 12);
        calculateOrdersByInterval(filteredOrders, "<", 2);
        System.out.println("xxxxxxxxxxxxxxxxx");
    }

    private static void calculateCustomIntervals(List<Order> filteredOrders, String... args) {
        System.out.println("CUSTOM INTERVAL FILTERS");

        if (Validator.containsCorrectAdditionalArguments(args)) {
            for (int i = 2; i < args.length; i++) {
                if (args[i].contains("-")) {
                    String[] parameters = args[i].split("-");
                    calculateOrdersByInterval(filteredOrders, Long.parseLong(parameters[0]), Long.parseLong(parameters[1]));
                } else if (args[i].contains(">")) {
                    String[] parameters = args[i].split(">");
                    calculateOrdersByInterval(filteredOrders, ">", Long.parseLong(parameters[1]));
                } else if (args[i].contains("<")) {
                    String[] parameters = args[i].split("<");
                    calculateOrdersByInterval(filteredOrders, "<", Long.parseLong(parameters[1]));
                }
            }
        }
        System.out.println("xxxxxxxxxxxxxxxxx");
    }

    private static void calculateOrdersByInterval(List<Order> filteredOrders, long startingInterval, long endingInterval) {
        Long result = filteredOrders.stream()
                .filter(order -> Optional.ofNullable(order.getItems()).orElseGet(Collections::emptyList)
                        .stream()
                        .anyMatch(item ->
                                item.getProduct().getCreationDate().isBefore(LocalDateTime.now().minusMonths(startingInterval)) &&
                                        item.getProduct().getCreationDate().isAfter(LocalDateTime.now().minusMonths(endingInterval))
                        )
                ).count();

        System.out.println(startingInterval + " - " + endingInterval + " months: " + result);
    }

    private static void calculateOrdersByInterval(List<Order> filteredOrders, String comparator, long interval) {
        Long result = null;
        if (">".equals(comparator)) {
            result = filteredOrders.stream()
                    .filter(order -> Optional.ofNullable(order.getItems()).orElseGet(Collections::emptyList)
                            .stream()
                            .anyMatch(item ->
                                    item.getProduct().getCreationDate().isBefore(LocalDateTime.now().minusMonths(interval))
                            )
                    ).count();
        } else if ("<".equals(comparator)) {
            result = filteredOrders.stream()
                    .filter(order -> Optional.ofNullable(order.getItems()).orElseGet(Collections::emptyList)
                            .stream()
                            .anyMatch(item ->
                                    item.getProduct().getCreationDate().isAfter(LocalDateTime.now().minusMonths(interval))
                            )
                    ).count();
        }

        System.out.println(comparator +" "+ interval + " months: " + result);
    }

    private static boolean areParametersIncorrect(String... args) {
        if (args.length < 2) {
            System.out.println("Wrong parameters. \n" +
                    "You Must Provide at least startDate and endDate, using LocalDateTime formats as: YYYY-MM-DD HH:MM:SS");
            return true;
        }
        return false;
    }

    private static boolean areDatesIncorrect(String... args) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            startDate = LocalDateTime.parse(args[0], formatter);
            endDate = LocalDateTime.parse(args[1], formatter);
            return false;
        } catch (Exception e) {
            System.out.println("An error occured while trying to parse the provided dates. \n" +
                    "You Must Provide at least startDate and endDate, using LocalDateTime formats as: YYYY-MM-DD HH:MM:SS");
        }
        return true;
    }

    private static List<Order> filterOrdersByDate(List<Order> orders) {
        return Optional.ofNullable(orders)
                .orElseGet(Collections::emptyList).stream()
                .filter(order -> order.getPlacedOrderDate().isAfter(startDate))
                .filter(order -> order.getPlacedOrderDate().isBefore(endDate))
                .collect(Collectors.toList());
    }





}
