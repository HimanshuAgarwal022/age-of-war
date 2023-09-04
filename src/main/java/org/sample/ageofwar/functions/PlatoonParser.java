package org.sample.ageofwar.functions;

import java.util.function.Function;

import org.sample.ageofwar.models.Platoon;

public class PlatoonParser implements Function<String, Platoon> {
    @Override
    public Platoon apply(String platoonInfo) {
        String[] parts = platoonInfo.split("#");
        String classType = parts[0];
        int numSoldiers = Integer.parseInt(parts[1]);
        return new Platoon(classType, numSoldiers);
    }
}
