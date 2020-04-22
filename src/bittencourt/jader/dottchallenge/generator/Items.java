package bittencourt.jader.dottchallenge.generator;

import bittencourt.jader.dottchallenge.entity.Item;
import bittencourt.jader.dottchallenge.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Items {

    private static final List<Item> mockItems = new ArrayList<>();

    protected static void populateItems() {
        if (mockItems.size() < 15) {
            // 1 - 3 months
            Product product1 = new Product(
                    "butter",
                    "food",
                    0.5d,
                    BigDecimal.valueOf(2.0D),
                    LocalDateTime.of(
                            LocalDate.of(2020, Month.MARCH, 20),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product1));

            Product product2 = new Product(
                    "flour",
                    "food",
                    1.0d,
                    BigDecimal.valueOf(0.65D),
                    LocalDateTime.of(
                            LocalDate.of(2020, Month.FEBRUARY, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product2));

            Product product3 = new Product(
                    "sugar",
                    "food",
                    1.0d,
                    BigDecimal.valueOf(0.9D),
                    LocalDateTime.of(
                            LocalDate.of(2020, Month.JANUARY, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product3));

            // 4 - 6 months
            Product product4 = new Product(
                    "water",
                    "food",
                    1.0d,
                    BigDecimal.valueOf(0.45D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.DECEMBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product4));

            Product product5 = new Product(
                    "rice",
                    "food",
                    1.0d,
                    BigDecimal.valueOf(0.80D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.NOVEMBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product5));

            Product product6 = new Product(
                    "black beans",
                    "food",
                    1.0d,
                    BigDecimal.valueOf(1.25D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.OCTOBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product6));

            // 7 - 12 months
            Product product7 = new Product(
                    "shampoo",
                    "higene",
                    1.0d,
                    BigDecimal.valueOf(1.0D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.SEPTEMBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product7));

            Product product8 = new Product(
                    "toothpaste",
                    "higene",
                    0.3d,
                    BigDecimal.valueOf(0.9D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.AUGUST, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product8));

            Product product9 = new Product(
                    "soap",
                    "higene",
                    0.15d,
                    BigDecimal.valueOf(0.35D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.JULY, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product9));

            Product product10 = new Product(
                    "deodorant",
                    "higene",
                    0.35d,
                    BigDecimal.valueOf(2.4D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.JUNE, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product10));

            Product product11 = new Product(
                    "toothbrush",
                    "higene",
                    0.1d,
                    BigDecimal.valueOf(1.3D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.APRIL, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product11));


            Product product12 = new Product(
                    "hair gel",
                    "higene",
                    11.0d,
                    BigDecimal.valueOf(0.80D),
                    LocalDateTime.of(
                            LocalDate.of(2019, Month.MARCH, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product12));

            // > 12 months
            Product product13 = new Product(
                    "lcd television",
                    "electronics",
                    15.0d,
                    BigDecimal.valueOf(300.0D),
                    LocalDateTime.of(
                            LocalDate.of(2018, Month.DECEMBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product13));

            Product product14 = new Product(
                    "nintendo switch",
                    "electronics",
                    1.0d,
                    BigDecimal.valueOf(150.0D),
                    LocalDateTime.of(
                            LocalDate.of(2018, Month.NOVEMBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product14));

            Product product15 = new Product(
                    "Samsung Galaxy",
                    "electronics",
                    0.3d,
                    BigDecimal.valueOf(450.0D),
                    LocalDateTime.of(
                            LocalDate.of(2018, Month.OCTOBER, 01),
                            LocalTime.of(0, 0, 0)
                    )
            );
            mockItems.add(new Item(BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product15));
        }
    }

    public static List<Item> generateRandomItemsList() {
        populateItems();

        List<Item> itemList = new ArrayList<>();

        int listSize = new Random().nextInt(5) + 1;
        for (int i = 0; i < listSize; i++) {
            itemList.add(mockItems.get(new Random().nextInt(mockItems.size())));
        }
        return itemList;
    }

}
