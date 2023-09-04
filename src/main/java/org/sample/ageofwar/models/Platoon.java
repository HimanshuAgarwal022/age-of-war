package org.sample.ageofwar.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Define Soldier class to represent platoons
public class Platoon {
  
    private String classType;
    private int numSoldiers;

    public Platoon(String classType, int numSoldiers) {
        this.classType = classType;
        this.numSoldiers = numSoldiers;
    }

    public String getClassType() {
        return classType;
    }

    public int getNumSoldiers() {
        return numSoldiers;
    }

    // Calculate advantage of one platoon over another
    public double calculateAdvantage(Platoon opponent) {
        Map<String, Set<String>> advantageMap = new HashMap<>();
        advantageMap.put("Militia", new HashSet<>(Arrays.asList("Spearmen", "LightCavalry")));
        advantageMap.put("Spearmen", new HashSet<>(Arrays.asList("LightCavalry", "HeavyCavalry")));
        advantageMap.put("LightCavalry", new HashSet<>(Arrays.asList("FootArcher", "CavalryArcher")));
        advantageMap.put("HeavyCavalry", new HashSet<>(Arrays.asList("Militia", "FootArcher", "LightCavalry")));
        advantageMap.put("CavalryArcher", new HashSet<>(Arrays.asList("Spearmen", "HeavyCavalry")));
        advantageMap.put("FootArcher", new HashSet<>(Arrays.asList("Militia", "CavalryArcher")));

        if (advantageMap.get(classType).contains(opponent.getClassType())) {
            return 2.0;
        } else if (advantageMap.get(opponent.getClassType()).contains(classType)) {
            return 0.5;
        } else {
            return 1.0;
        }
    }

    @Override
    public String toString() {
        return "{" +
            " classType='" + getClassType() + "'" +
            ", numSoldiers='" + getNumSoldiers() + "'" +
            "}";
    }
}