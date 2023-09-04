package org.sample.ageofwar.functions;

import java.util.function.Consumer;

import org.sample.ageofwar.models.Platoon;

public class PlatoonPrinter implements Consumer<Platoon> {
    @Override
    public void accept(Platoon platoon) {
        System.out.print(platoon.getClassType() + "#" + platoon.getNumSoldiers() + ";");
    }
}
