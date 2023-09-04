package org.sample.ageofwar;

import org.junit.jupiter.api.Test;
import org.sample.ageofwar.models.Platoon;
import org.sample.ageofwar.service.PlatoonBattleService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class PlatoonBattleServiceTest {

    @Test
    public void testPlatoonArrangementWithValidCombinations() {
        // Test 1: A combination where you win 3 battles
        List<Platoon> yourPlatoons1 = new ArrayList<>();
        yourPlatoons1.add(new Platoon("Militia", 30));
        yourPlatoons1.add(new Platoon("FootArcher", 20));
        yourPlatoons1.add(new Platoon("Spearmen", 10));
        yourPlatoons1.add(new Platoon("LightCavalry", 1000));
        yourPlatoons1.add(new Platoon("CavalryArcher", 100));

        List<Platoon> opponentPlatoons1 = new ArrayList<>();
        opponentPlatoons1.add(new Platoon("Militia", 10));
        opponentPlatoons1.add(new Platoon("Spearmen", 10));
        opponentPlatoons1.add(new Platoon("FootArcher", 1000));
        opponentPlatoons1.add(new Platoon("LightCavalry", 120));
        opponentPlatoons1.add(new Platoon("CavalryArcher", 100));

        List<Platoon> result1 = PlatoonBattleService.findValidArrangement(yourPlatoons1, opponentPlatoons1);
        assertNotNull(result1);
        assertTrue(result1.size() == 5);

        // Test 2: A combination where you win 4 battles
        List<Platoon> yourPlatoons2 = new ArrayList<>();
        yourPlatoons2.add(new Platoon("Militia", 20));
        yourPlatoons2.add(new Platoon("FootArcher", 50));
        yourPlatoons2.add(new Platoon("Spearmen", 10));
        yourPlatoons2.add(new Platoon("LightCavalry", 200));
        yourPlatoons2.add(new Platoon("CavalryArcher", 150));

        List<Platoon> opponentPlatoons2 = new ArrayList<>();
        opponentPlatoons2.add(new Platoon("Militia", 10));
        opponentPlatoons2.add(new Platoon("Spearmen", 30));
        opponentPlatoons2.add(new Platoon("FootArcher", 500));
        opponentPlatoons2.add(new Platoon("LightCavalry", 50));
        opponentPlatoons2.add(new Platoon("CavalryArcher", 200));

        List<Platoon> result2 = PlatoonBattleService.findValidArrangement(yourPlatoons2, opponentPlatoons2);
        assertNotNull(result2);
        assertTrue(result2.size() == 5);
    }

    @Test
    public void testPlatoonArrangementWithNoValidCombination() {
        // Test 3: A combination where there is no valid arrangement to win 3 battles
        List<Platoon> yourPlatoons3 = new ArrayList<>();
        yourPlatoons3.add(new Platoon("Militia", 100));
        yourPlatoons3.add(new Platoon("FootArcher", 200));
        yourPlatoons3.add(new Platoon("Spearmen", 5));
        yourPlatoons3.add(new Platoon("LightCavalry", 30));
        yourPlatoons3.add(new Platoon("CavalryArcher", 10));

        List<Platoon> opponentPlatoons3 = new ArrayList<>();
        opponentPlatoons3.add(new Platoon("Militia", 15));
        opponentPlatoons3.add(new Platoon("Spearmen", 100));
        opponentPlatoons3.add(new Platoon("FootArcher", 200));
        opponentPlatoons3.add(new Platoon("LightCavalry", 50));
        opponentPlatoons3.add(new Platoon("CavalryArcher", 100));

        List<Platoon> result3 = PlatoonBattleService.findValidArrangement(yourPlatoons3, opponentPlatoons3);
        assertNull(result3);
    }
}
