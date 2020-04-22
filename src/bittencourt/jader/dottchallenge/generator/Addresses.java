package bittencourt.jader.dottchallenge.generator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Addresses {

    private static final List<String> addressList = Arrays.asList("Lisbon", "Porto", "Aveiro", "Beja", "Braga",
            "Bragança", "Castelo Branco", "Coimbra", "Évora", "Faro", "Funchal", "Guarda", "Leiria", "Ponta Delgada",
            "Portalegre", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu");

    public static String getRandomAddress() {
        return addressList.get(new Random().nextInt(addressList.size()));
    }
}
