package org.sample.ageofwar.service;

import java.util.ArrayList;
import java.util.List;

import org.sample.ageofwar.models.Platoon;

public class PlatoonBattleService {

    private static List<Platoon> validArrangement = null;

    public static List<Platoon> findValidArrangement(List<Platoon> yourPlatoons, List<Platoon> opponentPlatoons) {
        permuteAndEvaluate(yourPlatoons, opponentPlatoons, new ArrayList<>(), new boolean[yourPlatoons.size()]);
        return validArrangement;
    }

    private static boolean permuteAndEvaluate(List<Platoon> yourPlatoons, List<Platoon> opponentPlatoons,
                                           List<Platoon> currentArrangement, boolean[] used) {
        if (currentArrangement.size() == yourPlatoons.size()) {
            int totalWins = calculateTotalWins(currentArrangement, opponentPlatoons);
            if (totalWins >= 3) {
                validArrangement = new ArrayList<>(currentArrangement);
                return true;
            }
        }

        for (int i = 0; i < yourPlatoons.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                currentArrangement.add(yourPlatoons.get(i));
                if(permuteAndEvaluate(yourPlatoons, opponentPlatoons, currentArrangement, used)) return true;
                currentArrangement.remove(currentArrangement.size() - 1);
                used[i] = false;
            }
        }
        return false;
    }

    private static int calculateTotalWins(List<Platoon> yourPlatoons, List<Platoon> opponentPlatoons) {
        int totalWins = 0;
        for (int i = 0; i < 5; i++) {
            Platoon yourPlatoon = yourPlatoons.get(i);
            Platoon opponentPlatoon = opponentPlatoons.get(i);
            double advantage = yourPlatoon.calculateAdvantage(opponentPlatoon);

            if (yourPlatoon.getNumSoldiers() * advantage > opponentPlatoon.getNumSoldiers()) {
                totalWins++;
            }
        }
        return totalWins;
    }
}
